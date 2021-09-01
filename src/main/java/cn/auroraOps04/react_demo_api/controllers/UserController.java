package cn.auroraOps04.react_demo_api.controllers;

import cn.auroraOps04.react_demo_api.entity.User;
import cn.auroraOps04.react_demo_api.entity.request.LoginRequest;
import cn.auroraOps04.react_demo_api.entity.request.SaveUserRequest;
import cn.auroraOps04.react_demo_api.entity.response.ApiResponse;
import cn.auroraOps04.react_demo_api.service.IUserService;
import cn.auroraOps04.react_demo_api.utils.ApiResponseUtil;
import cn.auroraOps04.react_demo_api.utils.JWTUtils;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author AuroraOps04
 * @date 2021/8/30 20:51:13
 * @description 用户控制器
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户相关api")
public class UserController {
    @Resource
    private IUserService userService;


    @GetMapping("/{id:\\d+}")
    @ApiOperation(value = "通过id获取用户")
    public ApiResponse<User> getById(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        if (null == user) {
            return ApiResponseUtil.success(null, false);
        }
        return ApiResponseUtil.success(user);
    }

    @GetMapping("/")
    @ApiImplicitParam(name = "Authorization", required = true,paramType = "header",dataType = "String")
    public ApiResponse<List<User>> list() {
        return ApiResponseUtil.success(userService.listByCondition(null));
    }

    @PostMapping("/login")
    @ApiOperation("登录接口")
    public ApiResponse<Object> login(@RequestBody @Valid LoginRequest loginRequest) {
        //TODO: 验证码处理
        String password = encrypt(loginRequest.getPassword());
        String username = loginRequest.getName();
        User user = userService.selectByUsername(username);
        if (null == user || !StrUtil.equals(user.getPassword(), password)) {
            return ApiResponseUtil.badRequest("用户名密码错误");
        }
        // 存日志
        String token = JWTUtils.sign(username, password, user.getId());
        JSONObject data = new JSONObject();
        data.put("Authorization", token);
        return ApiResponseUtil.success(data, true);
    }

    @PostMapping
    @ApiOperation("注册接口")
    public ApiResponse<Object> save(@RequestBody @Valid SaveUserRequest saveUserRequest) {
        User user = userService.selectByUsername(saveUserRequest.getName());
        if (null != user) { // 校验用户名
            return ApiResponseUtil.badRequest("用户名已存在");
        } // 校验邮箱
        User saveUser = new User();
        BeanUtil.copyProperties(saveUserRequest, saveUser);
        saveUser.setPassword(encrypt(saveUser.getPassword()));
        boolean saved = userService.save(saveUser);
        if (saved) {
            return ApiResponseUtil.created();
        } else {
            return ApiResponseUtil.success(false, "保存用户失败");
        }
    }


    private String encrypt(String password) {
        return DigestUtil.sha256Hex(password);
    }
}

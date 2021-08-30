package cn.auroraOps04.react_demo_api.controllers;

import cn.auroraOps04.react_demo_api.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

/**
 * @author AuroraOps04
 * @date 2021/8/30 20:51:13
 * @description 用户控制器
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户相关api")
public class UserController {
    @GetMapping("/{id}")
    @ApiOperation(value = "通过id获取用户")
    public User getById(@PathVariable("id") @Valid  @NotEmpty Integer id){
        return new User();
    }
}

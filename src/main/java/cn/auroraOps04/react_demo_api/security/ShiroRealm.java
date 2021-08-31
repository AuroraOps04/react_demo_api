package cn.auroraOps04.react_demo_api.security;

import cn.auroraOps04.react_demo_api.core.Constant;
import cn.auroraOps04.react_demo_api.entity.Permission;
import cn.auroraOps04.react_demo_api.entity.Role;
import cn.auroraOps04.react_demo_api.entity.User;
import cn.auroraOps04.react_demo_api.service.IPermissionService;
import cn.auroraOps04.react_demo_api.service.IRoleService;
import cn.auroraOps04.react_demo_api.service.IUserService;
import cn.auroraOps04.react_demo_api.utils.RedisUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import cn.auroraOps04.react_demo_api.utils.JWTUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;
import java.util.stream.Collectors;

public class ShiroRealm extends AuthorizingRealm {


    private RedisUtil redisUtil;
//
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private HttpServletRequest request;
//
//    @Autowired
//    private ISysMenuService menuService;

    // 必须重写此方法，不然Shiro会报错
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法
     * 授权模块，获取用户角色和权限。
     * @param token token
     * @return AuthorizationInfo 权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
        Long userId = JWTUtils.getUserId(token.toString());

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

//         获取用户角色集
        Set<String> roleSet = roleService.selectByUserId(userId).stream().map(Role::getName).collect(Collectors.toSet());
        simpleAuthorizationInfo.setRoles(roleSet);

//         获取用户权限集
        Set<String> permissionSet = permissionService.selectPermissionByUserId(userId).stream().map(Permission::getPath).collect(Collectors.toSet());
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证:编写shiro判断逻辑，进行用户认证
     * @param authenticationToken 身份认证 token
     * @return AuthenticationInfo 身份认证信息
     * @throws AuthenticationException 认证相关异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 这里的 token是从 JWTFilter 的 executeLogin 方法传递过来的，已经经过了解密
        String token = (String) authenticationToken.getCredentials();
        String username = JWTUtils.getUsername(token); //从token中获取username
        Long userId = JWTUtils.getUserId(token);    //从token中获取userId

//        // 通过redis查看token是否过期
//        String ip = request.getRemoteAddr();
//        String TokenInRedis = redisUtil.get(Constant.RDA_TOKEN_CACHE + token + StringPool.UNDERSCORE + ip);
//        if (!token.equalsIgnoreCase(TokenInRedis)) {
//            throw new AuthenticationException("token已经过期");
//        }
//
//        // 如果找不到，说明已经失效
//        if (StringUtils.isBlank(TokenInRedis)) {
//            throw new AuthenticationException("token已经过期");
//        }

        if (StringUtils.isBlank(username)) {
            throw new AuthenticationException("token校验不通过");
        }

        // 通过用户id查询用户信息
        User user = userService.getById(userId);

        if (user == null) {
            throw new AuthenticationException("用户名或密码错误");
        }
        if (!JWTUtils.verify(token, username, user.getPassword())) {
            throw new AuthenticationException("token校验不通过");
        }
        return new SimpleAuthenticationInfo(token, token, "febs_shiro_realm");
    }
}
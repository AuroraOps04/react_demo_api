package cn.auroraOps04.react_demo_api.filter;

import cn.auroraOps04.react_demo_api.security.JWTToken;
import cn.hutool.json.JSONObject;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JWTFilter extends BasicHttpAuthenticationFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JWTFilter.class);

    private static final String TOKEN = "Authorization";

    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个 option请求，这里我们给 option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
    
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws UnauthorizedException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        UofferProperties UofferProperties = SpringContextUtil.getBean(UofferProperties.class);
        // 获取免认证接口 url 
        // 在application.yml中配置/adminApi/auth/doLogin/**,/adminApi/auth/register/**, ...
//        String[] anonUrl = StringUtils.splitByWholeSeparatorPreserveAllTokens(UofferProperties.getShiro().getAnonUrl(), ",");
        String[] anonUrl = new String[]{
                "/swagger-ui.html",
                "/swagger-resources/**",
                "/webjars/**",
                "/user/login",
                "/user",
                "/v2/api-docs/**"
        };
        boolean match = false;
        for (String u : anonUrl) {
            if (pathMatcher.match(u, httpServletRequest.getRequestURI())) {
                match = true;
            }
        }
        if (match) {
            return true;
        }

        if (isLoginAttempt(request, response)) {
            return executeLogin(request, response);
        }
        return false;
    }

    /**
     * 判断用户是否想要登入。
     * 检测header里面是否包含Authorization字段即可
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader(TOKEN);
        return token != null;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(TOKEN).replaceFirst("^Bear $", ""); //得到token
        JWTToken jwtToken = new JWTToken(token); // 解密token
        try {
            // 提交给realm进行登入，如果错误他会抛出异常并被捕获
            getSubject(request, response).login(jwtToken);
            // 如果没有抛出异常则代表登入成功，返回true
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    @Override
    protected boolean sendChallenge(ServletRequest request, ServletResponse response) {
        LOGGER.debug("Authentication required: sending 401 Authentication challenge response.");
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        httpResponse.setCharacterEncoding("utf-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        final String message = "未认证，请在前端系统进行认证";
        final Integer status = 401;
        try (PrintWriter out = httpResponse.getWriter()) {
            JSONObject responseJson = new JSONObject();
            responseJson.put("msg", message);
            responseJson.put("status", status);
            out.print(responseJson);
        } catch (IOException e) {
            LOGGER.error("sendChallenge error：", e);
        }
        return false;
    }



}
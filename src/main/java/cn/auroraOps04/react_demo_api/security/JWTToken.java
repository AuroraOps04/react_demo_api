package cn.auroraOps04.react_demo_api.security;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author AuroraOps04
 * @date 2021-08-31 09:16:42
 * @description JWTToken
 */

public class JWTToken implements AuthenticationToken {
    private static final long serialVersionUID = 1282057025599826155L;

    private final String token;

    private String exipreAt;

    public JWTToken(String token) {
        this.token = token;
    }

    public JWTToken(String token, String exipreAt) {
        this.token = token;
        this.exipreAt = exipreAt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

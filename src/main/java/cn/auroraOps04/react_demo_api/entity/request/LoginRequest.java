package cn.auroraOps04.react_demo_api.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author AuroraOps04
 * @date 2021-08-31 13:59:43
 * @description 登录参数
 */

@ApiModel("登录请求参数")
public class LoginRequest {
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
//    @Min(value = 6, message = "用户名最短为6位")
//    @Max(value = 16, message = "用户名最长为16位")
    private String username;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
//    @Min(value = 6, message = "密码最短为6位")
//    @Max(value = 16, message = "密码最长为16位")
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

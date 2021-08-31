package cn.auroraOps04.react_demo_api.entity.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @author AuroraOps04
 * @date 2021-08-31 15:25:12
 * @description
 */

public class SaveUserRequest {
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
//    @Min(value = 6, message = "用户名最短为6位")
//    @Max(value = 16, message = "用户名最长为16位")
    private String name;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
//    @Min(value = 6, message = "密码最短为6位")
//    @Max(value = 16, message = "密码最长为16位")
    private String password;

    public SaveUserRequest() {
    }

    public SaveUserRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "SaveUserRequest{" +
                "username='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

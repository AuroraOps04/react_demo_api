package cn.auroraOps04.react_demo_api.entity.vo;

import cn.auroraOps04.react_demo_api.entity.Permission;
import cn.auroraOps04.react_demo_api.entity.Role;
import cn.auroraOps04.react_demo_api.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * @author AuroraOps04
 * @date 2021-09-02 09:45:00
 * @description 用户列表接口Vo, 包含角色和权限
 */

@ApiModel
public class UserListVo extends User {
    @ApiModelProperty("用户角色列表")
    List<Role> roles;
    @ApiModelProperty("用户权限列表")
    List<Permission> permissions;

    public UserListVo() {
    }

    public UserListVo(Date createAt, Date updateAt, Long createBy, Long updateBy, Long id, String name, String password, Character sex, String email, String phone, String blog, String motto, String github, String qq, String avatar, String lastLoginIp, String lastLoginTime, Integer status, List<Role> roles, List<Permission> permissions) {
        super(createAt, updateAt, createBy, updateBy, id, name, password, sex, email, phone, blog, motto, github, qq, avatar, lastLoginIp, lastLoginTime, status);
        this.roles = roles;
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "UserListVo{" +
                "createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", blog='" + blog + '\'' +
                ", motto='" + motto + '\'' +
                ", github='" + github + '\'' +
                ", qq='" + qq + '\'' +
                ", avatar='" + avatar + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", status=" + status +
                ", roles=" + roles +
                ", permissions=" + permissions +
                '}';
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}

package cn.auroraOps04.react_demo_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author AuroraOps04
 * @date 2021-08-31 09:38:35
 * @description 角色实体类
 */

@TableName("role")
@ApiModel("角色实体")
public class Role extends BaseEntity{
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("角色id")
    private Long id;
    @ApiModelProperty("角色名字")
    private String name;

    public Role() {
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role(Date createAt, Date updateAt, Long createBy, Long updateBy, Long id, String name) {
        super(createAt, updateAt, createBy, updateBy);
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

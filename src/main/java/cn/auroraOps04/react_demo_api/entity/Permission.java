package cn.auroraOps04.react_demo_api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author AuroraOps04
 * @date 2021-08-31 10:20:23
 * @description 权限实体类
 */

@ApiModel("权限实体类")
@TableName("permission")
public class Permission  extends BaseEntity{
    @TableId("id")
    @ApiModelProperty("权限id")
    private Long id;
    @ApiModelProperty("权限描述")
    private String desc;
    @ApiModelProperty("资源路劲")
    private String path;

    public Permission() {
    }

    public Permission(Date createAt, Date updateAt, Long createBy, Long updateBy, Long id, String desc, String path) {
        super(createAt, updateAt, createBy, updateBy);
        this.id = id;
        this.desc = desc;
        this.path = path;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", id=" + id +
                ", desc='" + desc + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

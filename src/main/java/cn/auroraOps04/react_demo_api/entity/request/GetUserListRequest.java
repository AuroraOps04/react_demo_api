package cn.auroraOps04.react_demo_api.entity.request;

import cn.auroraOps04.react_demo_api.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author AuroraOps04
 * @date 2021-09-02 10:28:50
 * @description 获取用户列表筛选参数
 */

@ApiModel("获取用户列表筛选参数")
public class GetUserListRequest extends User {
    @ApiModelProperty("角色Id")
    private Long roleId;
    @ApiModelProperty("权限id")
    private Long permissionId;
}

package cn.auroraOps04.react_demo_api.service;

import cn.auroraOps04.react_demo_api.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author AuroraOps04
 * @date 2021-08-31 10:32:25
 * @description 权限服务接口
 */
public interface IPermissionService  extends IService<Permission> {
    List<Permission> selectPermissionByRoleId(Long roleId);
    List<Permission> selectPermissionByUserId(Long userId);
    List<Permission> selectPermissionByBatchRoleId(List<Long> roleIds);
}

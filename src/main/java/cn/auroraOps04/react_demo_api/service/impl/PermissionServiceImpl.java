package cn.auroraOps04.react_demo_api.service.impl;

import cn.auroraOps04.react_demo_api.entity.Permission;
import cn.auroraOps04.react_demo_api.mapper.PermissionMapper;
import cn.auroraOps04.react_demo_api.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AuroraOps04
 * @date 2021-08-31 10:33:54
 * @description 权限服务接口实现类
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
    @Override
    public List<Permission> selectPermissionByRoleId(Long roleId) {
        return baseMapper.selectByRoleId(roleId);
    }

    @Override
    public List<Permission> selectPermissionByUserId(Long userId) {
        return baseMapper.selectByUserId(userId);
    }

    @Override
    public List<Permission> selectPermissionByBatchRoleId(List<Long> roleIds) {
        return baseMapper.selectBatchByRoleId(roleIds);
    }
}

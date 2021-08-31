package cn.auroraOps04.react_demo_api.service.impl;

import cn.auroraOps04.react_demo_api.entity.Role;
import cn.auroraOps04.react_demo_api.mapper.RoleMapper;
import cn.auroraOps04.react_demo_api.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AuroraOps04
 * @date 2021-08-31 10:32:54
 * @description 角色服务实现类
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Override
    public List<Role> selectByUserId(Long userId) {
        return baseMapper.selectByUserId(userId);
    }
}

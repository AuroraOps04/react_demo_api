package cn.auroraOps04.react_demo_api.mapper;

import cn.auroraOps04.react_demo_api.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author AuroraOps04
 * @date 2021-08-31 10:31:18
 * @description 权限 Mapper
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Permission> selectByRoleId(Long roleId);
    List<Permission> selectByUserId(Long userId);
    List<Permission> selectBatchByRoleId(List<Long> roleIds);
}

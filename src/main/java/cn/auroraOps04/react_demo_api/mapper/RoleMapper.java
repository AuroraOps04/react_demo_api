package cn.auroraOps04.react_demo_api.mapper;

import cn.auroraOps04.react_demo_api.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author AuroraOps04
 * @date 2021-08-31 10:30:09
 * @description 角色 Mapper
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> selectByUserId(Long id);
}

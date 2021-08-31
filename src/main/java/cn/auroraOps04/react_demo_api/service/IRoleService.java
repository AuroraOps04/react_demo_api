package cn.auroraOps04.react_demo_api.service;

import cn.auroraOps04.react_demo_api.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author AuroraOps04
 * @date 2021-08-31 10:31:51
 * @description 角色服务接口
 */
public interface IRoleService extends IService<Role> {
    List<Role> selectByUserId(Long userId);
}

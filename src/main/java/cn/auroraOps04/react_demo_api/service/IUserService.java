package cn.auroraOps04.react_demo_api.service;

import cn.auroraOps04.react_demo_api.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author AuroraOps04
 * @date 2021-08-31 09:23:36
 * @description 用户服务接口
 */
public interface IUserService extends IService<User> {
    User selectByUsername(String username);
}

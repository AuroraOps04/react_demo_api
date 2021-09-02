package cn.auroraOps04.react_demo_api.service;

import cn.auroraOps04.react_demo_api.entity.User;
import cn.auroraOps04.react_demo_api.entity.request.GetUserListRequest;
import cn.auroraOps04.react_demo_api.entity.vo.UserListVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author AuroraOps04
 * @date 2021-08-31 09:23:36
 * @description 用户服务接口
 */
public interface IUserService extends IService<User> {
    User selectByUsername(String username);

    List<UserListVo> listByCondition(GetUserListRequest condition);
}

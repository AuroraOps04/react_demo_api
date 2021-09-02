package cn.auroraOps04.react_demo_api.service.impl;

import cn.auroraOps04.react_demo_api.entity.User;
import cn.auroraOps04.react_demo_api.entity.request.GetUserListRequest;
import cn.auroraOps04.react_demo_api.entity.vo.UserListVo;
import cn.auroraOps04.react_demo_api.mapper.UserMapper;
import cn.auroraOps04.react_demo_api.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AuroraOps04
 * @date 2021-08-31 09:24:26
 * @description 用户服务接口实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public User selectByUsername(String username) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(User::getName, username);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<UserListVo> listByCondition(GetUserListRequest condition) {
        return baseMapper.listByCondition(condition);
    }
}

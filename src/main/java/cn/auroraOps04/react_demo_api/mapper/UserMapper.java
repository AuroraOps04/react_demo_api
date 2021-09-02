package cn.auroraOps04.react_demo_api.mapper;

import cn.auroraOps04.react_demo_api.entity.User;
import cn.auroraOps04.react_demo_api.entity.request.GetUserListRequest;
import cn.auroraOps04.react_demo_api.entity.vo.UserListVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author AuroraOps04
 * @date 2021-08-31 09:22:48
 * @description 用戶 mapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<UserListVo> listByCondition(GetUserListRequest condition);
}

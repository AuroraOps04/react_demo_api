package cn.auroraOps04.react_demo_api.mapper;

import cn.auroraOps04.react_demo_api.entity.vo.UserListVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author AuroraOps04
 * @date 2021-09-02 11:32:40
 * @description
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testListByCondition(){
        List<UserListVo> userListVos = userMapper.listByCondition(null);
        userListVos.forEach(System.out::println);
    }
}

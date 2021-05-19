package com.mapper;

import com.User;
import com.UserDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
    int updateuser(User user);
    int Deluser(Integer id);
    int Delzero(Integer id);
//    User selectByState(Integer state);
}

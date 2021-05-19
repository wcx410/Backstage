package com.impl;

import com.User;
import com.UserDto;
import com.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    public int updateuser(User user) {
        return userMapper.updateuser(user);

    }

    public int Deluser(Integer id) {
        return userMapper.Deluser(id);
    }

    public int Delzero(Integer id) {
        return userMapper.Delzero(id);
    }
//    public User selectByState(Integer state){
//        return userMapper.selectByState(state);
//    }
}

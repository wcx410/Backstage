package com;

import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {
    int updateuser(User user);
    int Deluser(Integer id);
    int Delzero(Integer id);
//    User selectByState(Integer state);
}

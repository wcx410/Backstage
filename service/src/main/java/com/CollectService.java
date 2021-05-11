package com;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CollectService extends IService<Collect> {
    public List<Commodity> queryCollection(Integer uid);
}

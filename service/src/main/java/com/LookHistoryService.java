package com;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface LookHistoryService extends IService<LookHistory> {
    public List<Commodity> queryFoot(Integer id);
}

package com;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface LookHistoryService extends IService<LookHistory> {
    public List<LookHistory> queryFoot(Integer id);
}

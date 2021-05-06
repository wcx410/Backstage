package com.impl;

import com.LookHistory;
import com.LookHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.LookHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LookHistoryServiceImpl extends ServiceImpl<LookHistoryMapper, LookHistory> implements LookHistoryService {
    @Autowired
    LookHistoryMapper lookHistoryMapper;
    public List<LookHistory> queryFoot(Integer id) {
        return lookHistoryMapper.queryFoot(id);
    }
}

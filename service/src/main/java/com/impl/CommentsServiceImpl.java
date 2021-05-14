package com.impl;

import com.CommentsAndCommodity;
import com.CommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.CommentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {
    @Autowired
    CommentsMapper commentsMapper;
    @Override
    public List<CommentsAndCommodity> getComments(Integer uid) {
        return commentsMapper.getComments(uid);
    }
}

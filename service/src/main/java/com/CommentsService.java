package com;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CommentsService extends IService<Comments> {
    public List<CommentsAndCommodity> getComments(Integer uid);
}

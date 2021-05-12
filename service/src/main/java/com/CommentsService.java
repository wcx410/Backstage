package com;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CommentsService extends IService<ComMents> {
    public List<CommentsAndCommodity> getComments(Integer uid);
}

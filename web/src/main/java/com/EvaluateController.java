package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

//我的收藏
@RestController
@CrossOrigin
@RequestMapping("/evaluate")
public class EvaluateController {
    @Autowired(required = false)
    CommentsService commentsService;
//根据用户编号,商品编号,未删除的,评价时间列进行排序来查询评论表和商品表
    @RequestMapping("/getComments")
    public List<CommentsAndCommodity> getComments(Integer uid){
        return commentsService.getComments(uid);
    }

//添加收藏
    @RequestMapping("/add")
    public String add(Comments comments){
        comments.setComtime(new Date());
        return  commentsService.save(comments)?"添加成功":"添加失败";
    }
}

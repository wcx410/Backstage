package com;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface PaisongyuanService extends IService<PaiSongYuan> {
    //查询所有派送员
    public List<PaiSongYuan> queryAll();

    //修改派送员状态
    int updatestate(String state,String peisongyuanid);
}

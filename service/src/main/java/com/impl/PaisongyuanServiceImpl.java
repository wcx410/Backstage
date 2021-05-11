package com.impl;



import com.PaiSongYuan;
import com.PaisongyuanService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.PaisongyuanMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisongyuanServiceImpl  extends ServiceImpl<PaisongyuanMapper, PaiSongYuan> implements PaisongyuanService {
    public List<PaiSongYuan> queryAll() {
        QueryWrapper<PaiSongYuan> queryWrapper=new QueryWrapper<PaiSongYuan>();
        List<PaiSongYuan> paiSongYuans =this.list(queryWrapper);
        return paiSongYuans;
    }
}

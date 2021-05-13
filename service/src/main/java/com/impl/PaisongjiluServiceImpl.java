package com.impl;

import com.PaiSongJiLu;
import com.PaisongjiluService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.PaisongjiluMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisongjiluServiceImpl extends ServiceImpl<PaisongjiluMapper, PaiSongJiLu> implements PaisongjiluService {
    @Autowired
    private PaisongjiluMapper paisongjiluMapper;

    @Override
    public int updatepaisongjilu(Integer did) {
        return paisongjiluMapper.updatepaisongjilu(did);
    }
}

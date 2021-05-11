package com.impl;


import com.Sys_codes;
import com.Sys_codesExample;
import com.Sys_codesService;
import com.mapper.Sys_codesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Sys_codesServiceImpl implements Sys_codesService {

    @Autowired
    private Sys_codesMapper sys_codesMapper;

    public Sys_codes getByID(String str) {
        Sys_codesExample example = new Sys_codesExample();
        Sys_codesExample.Criteria criteria = example.createCriteria();
        criteria.andCODE_IDEqualTo(str);
        List<Sys_codes> sys_codes = sys_codesMapper.selectByExample(example);
        if(sys_codes.size()!=0){
            return sys_codes.get(0);
        }
        return null;
    }


    public void commitByID(String str,Integer num) {
        Sys_codesExample example = new Sys_codesExample();
        Sys_codesExample.Criteria criteria = example.createCriteria();
        criteria.andCODE_IDEqualTo(str);
        List<Sys_codes> sysCodes = sys_codesMapper.selectByExample(example);
        if(sysCodes.size()!=0){
            Sys_codes codes = sysCodes.get(0);
            Sys_codesExample example1 = new Sys_codesExample();
            Sys_codesExample.Criteria criteria1 = example.createCriteria();
            codes.setDEF_VALUE(num.toString());
            sys_codesMapper.updateByExample(codes,example);
        }
    }
}

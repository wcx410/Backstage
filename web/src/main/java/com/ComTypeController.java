package com;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/comType")
@RestController
public class ComTypeController {
    @Autowired
    private ComTypeService comTypeService;

    @RequestMapping("/queryHot")
    public List<ComType> queryHot(){
        IPage<ComType> page = comTypeService.page(new Page<ComType>(1, 10));
        return page.getRecords();
    }


}

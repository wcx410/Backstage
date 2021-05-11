package com;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
//申请商户
@RestController
@CrossOrigin
@RequestMapping("/apply")
public class MerchantsApplyController {
    MerchantsApplyService merchantsApplyService;
    @RequestMapping("/addApply")
    public String addApply(MerchantsApply apply){
        apply.setApplyTime(new Date());
        apply.setState(0);
        return merchantsApplyService.save(apply)?"添加成功":"添加失败";
    }
}

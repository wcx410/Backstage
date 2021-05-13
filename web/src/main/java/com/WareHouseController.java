package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/warehouse")
public class WareHouseController {
    @Autowired
    private WareHouseService wareHouseService;
    @Autowired
    private WareHouseStorageService storageService;

    //分页模糊查询所有
    @RequestMapping("/queryWarehouseAll")
    public IPage<WareHouse> queryWarehouseAll(String warname,
                                              @RequestParam(value = "page", defaultValue = "1") int page,
                                              @RequestParam(value = "rows", defaultValue = "5") int rows) {
        QueryWrapper<WareHouse> wrapper = new QueryWrapper<WareHouse>();
        if(!StringUtil.isEmpty(warname)){
            wrapper.like("warname",warname);
        }
        IPage<WareHouse> page1 = wareHouseService.page(new Page<WareHouse>(page, rows), wrapper);
        //PageVo<Warehouse> l = wareHouseService.querycountWarehousebyCond(warname,page,rows);
        return page1;
    }

    //添加仓库
    @RequestMapping("/addWarehouse")
    public Message addWarehouse(WareHouse wareHouse) {
        Message message = new Message();
        boolean save = wareHouseService.save(wareHouse);
//        int row = wareHouseService.addWarehouse(warname,wartype,warcapacity,waraddress);

        if (save) {
            message.flag = true;
            message.msg = "添加成功√";
            return message;
        }
        message.flag = false;
        message.msg = "添加失败×";
        return message;
    }

    //修改仓库信息
    @RequestMapping("/updateWarehouse")
    public Message updateWarehouse(WareHouse wareHouse) {
        Message message = new Message();
        //根据仓库id 查询仓库存储表是否有数据 没有就返回 仓库不为空 不能执行修改
        QueryWrapper<WareHouseStorage> wrapper = new QueryWrapper<WareHouseStorage>();
        wrapper.eq("warid",wareHouse.getWarid());
        int count = storageService.count(wrapper);
        if (count!=0){
            message.flag = false;
            message.msg = "仓库不为空 不能执行修改";
            return message;
        }
        UpdateWrapper<WareHouse> updateWrapper = new UpdateWrapper<WareHouse>();
        boolean b = wareHouseService.updateById(wareHouse);
        if (b) {
            message.flag = true;
            message.msg = "修改成功√";
            return message;
        }
        message.flag = false;
        message.msg = "修改失败×";
        return message;
    }

    //删除仓库
    @RequestMapping("/deleteWarehouse")
    public Message deleteWarehouse(String warid) {
        Message message = new Message();
        //判断仓库里有没有商品 有就不能执行操作
        //根据仓库id 查询仓库存储表是否有数据 没有就返回 仓库不为空 不能执行删除
        QueryWrapper<WareHouseStorage> wrapper = new QueryWrapper<WareHouseStorage>();
        wrapper.eq("warid",warid);
        int count = storageService.count(wrapper);
        if (count!=0){
            message.flag = false;
            message.msg = "仓库不为空 不能执行删除";
            return message;
        }
        boolean b = wareHouseService.removeById(warid);
        if (b) {
            message.flag = true;
            message.msg = "删除成功√";
            return message;
        }else {
            message.flag = false;
            message.msg = "删除失败×";
            return message;
        }

    }

    //根据仓库id查询所有仓库存储商品
    @RequestMapping("/queryWareHouseStorageAll")
    public List<WareHouseStorage> queryWareHouseStorageAll(String id) {
        System.out.println(id);
        List<WareHouseStorage> wareHouseStorages = storageService.queryWareHouseStorageAll(id);
        return wareHouseStorages;
    }

    //根据仓库id 和 传过来的状态 修改仓库状态
    @RequestMapping("/donjieOrjiedon")
    public Message donjieOrjiedon(WareHouse wareHouse){
        Message message = new Message();

        if (wareHouse.getWarstate().equals(0)){
            wareHouseService.updateById(wareHouse);
            message.flag = true;
            message.msg = "冻结成功√";
            return message;
        }else {
            wareHouseService.updateById(wareHouse);
            message.flag = true;
            message.msg = "解冻成功√";
            return message;
        }

    }
}

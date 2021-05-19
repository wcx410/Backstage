package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 采购控制层
 */
@RestController
@CrossOrigin
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private PurchaseOrderService orderService;
    @Autowired
    private PurchaseLinShiService linShiService;
    @Autowired
    private WareHouseService wareHouseService;

    //查询所有临时采购表的数据
    @RequestMapping("/queryPurchaseLinShiAll")
    public List<PurchaseLinShi> PurchaseLinShiAll() {
        //System.out.println(purchaseService.PurchaseLinShiAll());
//        return purchaseService.PurchaseLinShiAll();
        return linShiService.PurchaseLinShiAll();
    }

    //审核部分-------------
    //查询所有未审核订单信息
    @RequestMapping("/querypurchaseorderAll")
    public List<PurchaseOrder> querypurchaseorderAll() {
        return orderService.querypurchaseorderAll();
    }

    //根据订单id 查询所有采购商品
    @RequestMapping("/querycaigouAll")
    public List<Purchase> querycaigouAll(String orderid) {
        //没网，有待测试确认
        //System.out.println(orderid);
        return purchaseService.querycaigouAll(orderid);
    }

    //提交审核
    @RequestMapping("/shenHe")
    public Message shenHe(PurchaseOrder purchaseOrder,HttpServletRequest request) {
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        //purchaseOrder.setApplicant(employee.getId().toString());
        purchaseOrder.setApprovedby(employee.getId());
        Message message = new Message();
        //修改订单状态  1是采购中
        orderService.updatepurchaseorder(purchaseOrder);
        message.flag = true;
        message.msg = "审核成功√";
        return message;
    }

    //清除所有临时采购表的数据
    @RequestMapping("/cleanPurchaseLinShi")
    public Message cleanPurchaseLinShi() {
        Message message = new Message();
        int row = linShiService.deletePurchaseLinShi();
        if (row > 0) {
            message.flag = true;
            message.msg = "清除成功√";
            return message;
        }else {
            message.flag = false;
            message.msg = "清除失败×";
            return message;
        }
    }

    //查询所有不是未审核订单信息
    @RequestMapping("/purchaseorderAllnowei")
    public List<PurchaseOrder> purchaseorderAllnowei() {
        return orderService.purchaseorderAllnowei();
    }

    //根据商品id 和 采购数量 向临时采购表添加数据
    @RequestMapping("/addLinShiPurchase")
    public Message addLinShiPurchase(String commodityid,String caigousum) {
        Message message = new Message();

        //判断临时采购表里 是否有这个商品 如果有 就添加数量
        //根据商品id 查询临时采购表是否有这个商品
        QueryWrapper<PurchaseLinShi> linShiQueryWrapper = new QueryWrapper<PurchaseLinShi>();
        linShiQueryWrapper.eq("id",commodityid);
        int count = linShiService.count(linShiQueryWrapper);
        //int jie = purchaseService.queryPurchaseLinShiBycommodityid(commodityid);
        if (count>0){
            //根据商品id 添加数量
            int row = linShiService.updatePurchaseLinShicommoditysum(commodityid,caigousum);
            //int row=purchaseService.updatePurchaseLinShicommoditysum(commodityid,caigousum);

            if (row > 0) {
                message.flag = true;
                message.msg = "添加采购成功√";
                return message;
            }else {
                message.flag = false;
                message.msg = "添加采购失败×";
                return message;
            }
        }else {
            //添加记录
            int row=linShiService.addLinShiPurchase(commodityid,caigousum);
            //int row=purchaseService.addLinShiPurchase(commodityid,caigousum);

            if (row > 0) {
                message.flag = true;
                message.msg = "添加采购成功√";
                return message;
            }else {
                message.flag = false;
                message.msg = "添加采购失败×";
                return message;
            }
        }


    }

    //计算所有临时采购表里的商品的总价
    @RequestMapping("/getLinShiPurchaseShopZon")
    public Float getLinShiPurchaseShopZon() {
        //System.out.println(purchaseService.PurchaseLinShiAll());

        List<PurchaseLinShi> arr=linShiService.PurchaseLinShiAll();

        Float sumprice=0f;
        //计算临时采购表里的商品的总价
        for (int i=0;i<arr.size();i++){
            sumprice+=arr.get(i).getPrice()*arr.get(i).getCaigousum();
        }
        //System.out.println("sumprice : " + sumprice);
        return sumprice;
    }

    //获取所有临时采购表的数据  生成采购订单 生成采购单
    @RequestMapping("/addCaiGou")
    public Message addCaiGou(
            //员工id
            String applicant,
            //申请人备注
            String applicantremarks, HttpServletRequest request) {
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        applicant = employee.getId().toString();
        Message message = new Message();
        //生成订单详情表 未审核记录
        //参数：当前采购的员工id  申请人备注（就是仓库）
        orderService.addPurchaseOrder(applicant,applicantremarks);
        //查询所有临时订单表的数据
        //System.out.println(purchaseService.PurchaseLinShiAll());
        List<PurchaseLinShi> arr = linShiService.PurchaseLinShiAll();
        //List<PurchaseLinShi> arr=  purchaseService.PurchaseLinShiAll();
        //将临时订单表数据添加到  采购表  订单id 商品id 商品数量
        //查询订单详情表的最大订单号
        int orderid = orderService.queryorderidBig();
        //int orderid = purchaseService.queryorderidBig();
        for (int i=0;i<arr.size();i++){
            //purchaseService.addPurchase(orderid,arr.get(i).getId().toString(),arr.get(i).getCaigousum().toString());
            Purchase purchase = new Purchase();
            purchase.setOrderid(orderid);
            purchase.setCommodityid(arr.get(i).getId());
            purchase.setCommoditysum(arr.get(i).getCaigousum());
            purchaseService.save(purchase);
        }
        message.flag = true;
        message.msg = "提交采购申请成功√";
        return message;
    }

    //模拟采购流程 计时30秒后执行修改订单状态为采购成功
    //根据订单id 修改订单状态为2
    @RequestMapping("/caigouwancheng")
    public Message caigouwancheng(PurchaseOrder order,HttpServletRequest request) {
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        order.setApprovedby(employee.getId());
        Message message = new Message();
        //根据订单id 修改订单状态为2 采购完成
        order.setState(2);
        orderService.updatepurchaseorder(order);
//        purchaseService.updatepurchaseorder(orderid,approvedby,"2",approvedbyremarks);
        message.flag = true;
        message.msg = "采购完成√";
        return message;
    }

    //入库
    @RequestMapping("/ruku")
    public Message ruku(
            //获取仓库id
            String warehouseid,
            //获取订单id
            String orderid) {
        Message message = new Message();

        //根据订单id 获取改订单所有商品
        List<Purchase> arr = purchaseService.querycaigouAll(orderid);

        //根据商品id 仓库id 执行入库
        for (int i=0;i<arr.size();i++) {
            //判断要转入的仓库有没有相同的商品 如果有相同的商品就加数量  没有才添加
            //根据转入仓库id 商品id 查询是否有结果 1是有 0是没有
            Integer jie = wareHouseService.queryshop(arr.get(i).getCommodityid().toString(), warehouseid);
            //如果有
            if (jie > 0) {
                //执行添加数量操作  根据商品id和转入仓库id添加数量
                wareHouseService.addshopnumber(arr.get(i).getCommodityid().toString(), warehouseid, arr.get(i).getCommoditysum().toString());
                //根据转入仓库id 修改转入仓库的容量
                //计算这个商品的容量
                Float shopron = Float.parseFloat(arr.get(i).getCommoditysum().toString()) * Float.parseFloat(arr.get(i).getSpecification());
                wareHouseService.updateWareHouseRon1(warehouseid, shopron.toString());
            } else {
                //如果没有
                //添加一个新的记录 else
                wareHouseService.addwarehousestorageshop(arr.get(i).getCommodityid().toString(), warehouseid, arr.get(i).getCommoditysum().toString());
                //修改转入仓库的容量
                //计算这个商品的容量
                Float shopron = Float.parseFloat(arr.get(i).getCommoditysum().toString()) * Float.parseFloat(arr.get(i).getSpecification());
                wareHouseService.updateWareHouseRon1(warehouseid, shopron.toString());
            }
        }
        //修改订单状态为已入库  3
        orderService.rukuUpdateOrderstate(Integer.parseInt(orderid));
        //purchaseService.rukuUpdateOrderstate(Integer.parseInt(orderid));
        message.flag = true;
        message.msg = "入库完成√";
        return message;
    }
}

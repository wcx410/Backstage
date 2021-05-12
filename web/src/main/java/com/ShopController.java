package com;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.shop.MerchantsApplyDto;
import com.shop.MerchantsDto;
import com.shop.OrderDto;
import com.shop.ShopCarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/shop")
@RestController
@CrossOrigin
public class ShopController {
    @Autowired
    private ShopCarService shopCarService;

    @Autowired(required = false)
    ComOrderService comOrderService;

    @Autowired
    private MerchantsService merchantsService;

    @Autowired
    private MerchantsApplyService merchantsApplyService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PickupMerchantsService pickupMerchantsService;

    @Autowired
    private UserService userService;

    //商户查询订单状态为正在派送的订单信息
    @RequestMapping("/queryshouhuo.action")
    public PageUtil<MyShop> queryshouhuo(ShopCarDto dto, @RequestParam(value="page",defaultValue = "1")Integer pageNo, @RequestParam(value="rows",defaultValue = "5") Integer pageSize){
        PageUtil<MyShop> pageUtil = this.shopCarService.queryshouhuo(pageNo, pageSize, dto);
        return pageUtil;
    }

    //商户查询订单状态为待提货的订单信息
    @RequestMapping("/querytihuo.action")
    public PageUtil<MyShop> querytihuo(ShopCarDto dto, @RequestParam(value="page",defaultValue = "1")Integer pageNo, @RequestParam(value="rows",defaultValue = "5") Integer pageSize){
        PageUtil<MyShop> pageUtil = this.shopCarService.querytihuo(pageNo, pageSize, dto);
        return pageUtil;
    }

    //查询所有商户信息
    @RequestMapping("/querymerchants.action")
    public PageUtil<Merchants> querymerchants(MerchantsDto dto, @RequestParam(value="page",defaultValue = "1")Integer pageNo, @RequestParam(value="rows",defaultValue = "5") Integer pageSize){
        PageUtil<Merchants> pageUtil = null;
        if(dto!=null ){
            if(dto.getSearch_shstate().equals("-2")){
                dto.setSearch_shstate("");
            }
            pageUtil = this.merchantsService.querymerchants(pageNo, pageSize, dto);
        }
        return pageUtil;
    }

    //根据id查询商户信息
    @RequestMapping("/querymerchantsbyid.action")
    public Merchants querymerchantsbyid(int id){
        Merchants merchants = merchantsService.getById(id);
        return merchants;
    }

    //根据id修改商户信息
    @RequestMapping("/updatemerchantsbyid.action")
    public boolean updatemerchantsbyid(Merchants merchants){
        boolean res = merchantsService.updateById(merchants);
        return res;
    }

    //根据id删除商户信息
    @RequestMapping("/deletemerchantsbyid.action")
    public boolean deletemerchantsbyid(int id){
        Merchants merchants = new Merchants();
        merchants.setId(id);
        merchants.setState(-1);
        boolean res = merchantsService.updateById(merchants);
        return res;
    }

    //查询商户申请为未审核状态的商户
    @RequestMapping("/querymerchantsstatu.action")
    public PageUtil<MyMerchantsApply> querymerchantsstatu(MerchantsApplyDto dto, @RequestParam(value="page",defaultValue = "1")Integer pageNo, @RequestParam(value="rows",defaultValue = "5") Integer pageSize){
        PageUtil<MyMerchantsApply> pageUtil = this.merchantsApplyService.querymerchantsstatu(pageNo, pageSize, dto);
        return pageUtil;
    }

    //审批商户
    @RequestMapping("/updatemerchantapply.action")
    public boolean updatemerchantapply(int id,String system_message,int state){
        MerchantsApply merchantsApply = new MerchantsApply();
        merchantsApply.setId(id);
        merchantsApply.setSystemMessage(system_message);
        merchantsApply.setState(state);
        boolean b = merchantsApplyService.updateById(merchantsApply);
        return b;
    }

    //审批商户同意后向商户表中插入数据并修改用户表中的商户id
    @RequestMapping("/insertmerchants.action")
    public boolean insertmerchants(Merchants merchants,int userId){
        merchantsService.save(merchants);
        Integer id = merchants.getId();
        User user = new User();
        user.setId(userId);
        user.setMerid(id);
        boolean b = userService.updateById(user);
        return b;
    }

    //查询订单信息
    @RequestMapping("/querycomorder.action")
    public PageUtil<MyOrder> querycomorder(OrderDto dto, @RequestParam(value="page",defaultValue = "1")Integer pageNo, @RequestParam(value="rows",defaultValue = "5") Integer pageSize){
        PageUtil<MyOrder> pageUtil = null;
        if(dto!=null ){
            if(dto.getSearch_ordstate().equals("-1")){
                dto.setSearch_ordstate("");
            }
            pageUtil = this.orderService.querycomorder(pageNo, pageSize, dto);
        }
        return pageUtil;
    }

    //修改订单状态为待提货（ordstate=2）
    @RequestMapping("/updatepshopcars.action")
    public boolean updatepshopcars(@RequestBody List<Integer> ids){
        List<ComOrder> orderlist = new ArrayList<ComOrder>();
        ComOrder comOrder = null;
        for (int i =0;i<ids.size();i++){
            comOrder = new ComOrder();
            comOrder.setId(ids.get(i));
            comOrder.setOrdstate(2);
            comOrder.setDeliveryTime(new Date());
            orderlist.add(comOrder);
        }
        boolean b = comOrderService.updateBatchById(orderlist);
        return b;
    }

    //修改订单状态为已提货（ordstate=3）
    @RequestMapping("/updatepshopcar.action")
    public boolean updatepshopcar(@RequestBody List<Integer> ids){
        List<ComOrder> orderlist = new ArrayList<ComOrder>();
        ComOrder comOrder = null;
        for (int i =0;i<ids.size();i++){
            comOrder = new ComOrder();
            comOrder.setId(ids.get(i));
            comOrder.setOrdstate(3);
            comOrder.setPickUpTime(new Date());
            orderlist.add(comOrder);
        }
        boolean b = comOrderService.updateBatchById(orderlist);
        return b;
    }

    //向收货门店表插入数据
    @RequestMapping("/insertpickupmerchants.action")
    public boolean insertpickupmerchants(@RequestBody List<MyShop> myShopList){
        List<PickupMerchants> pickupMerchantsList = new ArrayList<PickupMerchants>();
        PickupMerchants pickupMerchants = null;
        for (int i =0;i<myShopList.size();i++){
            pickupMerchants = new PickupMerchants();
            pickupMerchants.setUser(myShopList.get(i).getUid());
            pickupMerchants.setMerchant(myShopList.get(i).getMid());
            pickupMerchants.setCreateTime(new Date());
            pickupMerchants.setRemark("商品名称："+myShopList.get(i).getName()+",商品数量："+myShopList.get(i).getNumber());
            pickupMerchantsList.add(pickupMerchants);
        }
        boolean b = pickupMerchantsService.saveBatch(pickupMerchantsList);
        return b;
    }
}

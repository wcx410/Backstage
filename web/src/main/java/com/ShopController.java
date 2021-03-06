package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.shop.MerchantsApplyDto;
import com.shop.MerchantsDto;
import com.shop.OrderDto;
import com.shop.ShopCarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/shop")
@RestController
@CrossOrigin
public class ShopController {
    @Autowired
    private ShopCarService shopCarService;

    @Autowired
    private ComOrderService comOrderService;

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

    @Autowired
    private PaisongjiluService paisongjiluService;

    @Autowired
    private PaisongyuanService paisongyuanService;

    @Autowired
    private CarService carService;

    //商户查询订单状态为正在派送的订单信息
    @RequestMapping("/queryshouhuo.action")
    public PageUtil<MyShop> queryshouhuo(HttpServletRequest request, ShopCarDto dto, @RequestParam(value="page",defaultValue = "1")Integer pageNo, @RequestParam(value="rows",defaultValue = "5") Integer pageSize){
        User user = (User) request.getSession().getAttribute("user");
        dto.setS_merid(user.getMerid());
        System.out.println(user.getMerid());
        PageUtil<MyShop> pageUtil = this.shopCarService.queryshouhuo(pageNo, pageSize, dto);
        return pageUtil;
    }

    //商户查询订单状态为待提货的订单信息
    @RequestMapping("/querytihuo.action")
    public PageUtil<MyShop> querytihuo(HttpServletRequest request, ShopCarDto dto, @RequestParam(value="page",defaultValue = "1")Integer pageNo, @RequestParam(value="rows",defaultValue = "5") Integer pageSize){
        User user = (User) request.getSession().getAttribute("user");
        dto.setS_merid(user.getMerid());
        System.out.println(user.getMerid());
        PageUtil<MyShop> pageUtil = this.shopCarService.querytihuo(pageNo, pageSize, dto);
        return pageUtil;
    }
    //商户查询总收入
    @RequestMapping("/queryzsr")
    public Integer queryshouhuo(HttpServletRequest request){
//        QueryWrapper<ShopCar> shopCarQueryWrapper = new QueryWrapper<ShopCar>();
        User user= (User) request.getSession().getAttribute("user");
//        shopCarQueryWrapper.eq("uid",id);
        //获取购物车的ID
//        ShopCar one = shopCarService.getOne(shopCarQueryWrapper);
        QueryWrapper<ComOrder> comOrderQueryWrapper = new QueryWrapper<ComOrder>();
        comOrderQueryWrapper.ne("ordstate",4).ne("ordstate",5);
        comOrderQueryWrapper.eq("isdelete",0);
        comOrderQueryWrapper.eq("merId",user.getMerid());
        List<ComOrder> list = comOrderService.list(comOrderQueryWrapper);
        Integer prices = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer j = list.get(i).getTotlemoney();
            prices+=j;
        }
        return prices;
    }
//    //商户查询昨日收入
    @RequestMapping("/queryztsr")
    public Integer queryzsr(HttpServletRequest request){
//        QueryWrapper<ShopCar> shopCarQueryWrapper = new QueryWrapper<ShopCar>();
//        shopCarQueryWrapper.eq("uid",id);
//        ShopCar one = shopCarService.getOne(shopCarQueryWrapper);
        QueryWrapper<ComOrder> comOrderQueryWrapper = new QueryWrapper<ComOrder>();
        //Date date = new Date();
        //int day = date.getDay()-1;
        Calendar calendar =Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        Date date = new Date(calendar.getTimeInMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        comOrderQueryWrapper.ne("ordstate",4).ne( "ordstate",5);
        User user= (User) request.getSession().getAttribute("user");
//        comOrderQueryWrapper.eq("pickUpTime",simpleDateFormat.format(date));
        comOrderQueryWrapper.between("pick_up_time",simpleDateFormat.format(date),new Date());
        comOrderQueryWrapper.eq("isdelete",0);
        comOrderQueryWrapper.eq("merId",user.getMerid());
        List<ComOrder> list = comOrderService.list(comOrderQueryWrapper);
        Integer prices = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer j = list.get(i).getTotlemoney();
            prices+=j;
        }
        return prices;
    }
    //统计图
    @RequestMapping("/queryTu")
    public List<MyshopCom> myshopComs(HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("user");
        List<MyshopCom> myshopComs = shopCarService.queryTu(user.getId());
        return myshopComs;
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
    public PageUtil<MyOrder> querycomorder(HttpServletRequest request, OrderDto dto, @RequestParam(value="page",defaultValue = "1")Integer pageNo, @RequestParam(value="rows",defaultValue = "5") Integer pageSize){
        PageUtil<MyOrder> pageUtil = null;
        if(dto!=null ){
            if(dto.getSearch_ordstate().equals("-1")){
                dto.setSearch_ordstate("");
                User user = (User) request.getSession().getAttribute("user");
                dto.setS_merid(user.getMerid());
                System.out.println(user.getMerid());
            }
            pageUtil = this.orderService.querycomorder(pageNo, pageSize, dto);
        }
        return pageUtil;
    }

    //修改订单状态为待提货（ordstate=2）
    @RequestMapping("/updatepshopcars.action")
    public boolean updatepshopcars(@RequestBody List<Integer> ids){
        List<ComOrder> orderlist = new ArrayList<ComOrder>();
        List<PaiSongJiLu> paiSongJiLuList = new ArrayList<PaiSongJiLu>();
        List<PaiSongYuan> paiSongYuanList = new ArrayList<PaiSongYuan>();
        ComOrder comOrder = null;
        PaiSongYuan paiSongYuan = null;
        PaiSongJiLu paiSongJiLu = null;
        Car car = null;
        for (int i =0;i<ids.size();i++){
            comOrder = new ComOrder();
            comOrder.setId(ids.get(i));
            comOrder.setOrdstate(2);
            comOrder.setDeliveryTime(new Date());
            orderlist.add(comOrder);
            //修改 配送记录表状态为（已派送完2），派送员表状态为（闲置0），车辆表状态为（闲置0）
            paisongjiluService.updatepaisongjilu(ids.get(i));
            QueryWrapper<PaiSongJiLu> paiSongJiLuQueryWrapper = new QueryWrapper<PaiSongJiLu>();
            paiSongJiLuQueryWrapper.eq("ddid",ids.get(i));
            paiSongJiLu = paisongjiluService.getOne(paiSongJiLuQueryWrapper);
            paiSongJiLuList.add(paiSongJiLu);
        }
        for (int i = 0; i <paiSongJiLuList.size() ; i++) {
            paiSongYuan = new PaiSongYuan();
            car = new Car();
            car.setId(paiSongJiLuList.get(i).getCarid());
            car.setState(0);
            paiSongYuan.setId(paiSongJiLuList.get(i).getPid());
            paiSongYuan.setState(0);
            paiSongYuanList.add(paiSongYuan);
        }
        paisongyuanService.updateBatchById(paiSongYuanList);
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

    //根据商户id查询订单信息,判断该商户有没有订单
    @RequestMapping("/querybymerid.action")
    public boolean querybymerid(int mid){
        QueryWrapper<ComOrder> comOrderQueryWrapper = new QueryWrapper<ComOrder>();
        comOrderQueryWrapper.eq("merid", mid);
        List<ComOrder> list = comOrderService.list(comOrderQueryWrapper);
        if(list.size()>0){
            return true;
        }else {
            return false;
        }
    }
}

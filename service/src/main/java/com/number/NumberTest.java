package com.number;


import com.Sys_codesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class NumberTest {
    @Autowired(required = false)
    private Sys_codesService service;
    //产品编号
    private static Integer CP_ID;
    //物料设计单编号流水号
    private static Integer WLSJ_ID;
    //工序设计单编号流水号
    private static Integer GXSJ_ID;
    //生产计划编号流水号
    private static Integer SCJH_ID;
    //生产编号流水号
    private static Integer SCBH_ID;
    //库存编号流水号
    private static Integer KC_ID;
    //入库单编号流水号
    private static Integer RKD_ID;
    //出库单编号流水号
    private static Integer CKD_ID;

    private void init(){
        CP_ID = Integer.parseInt(service.getByID("CP_ID").getDEF_VALUE());
        WLSJ_ID = Integer.parseInt(service.getByID("WLSJ_ID").getDEF_VALUE());
        GXSJ_ID = Integer.parseInt(service.getByID("GXSJ_ID").getDEF_VALUE());
        SCJH_ID = Integer.parseInt(service.getByID("SCJH_ID").getDEF_VALUE());
        SCBH_ID = Integer.parseInt(service.getByID("SCBH_ID").getDEF_VALUE());
        KC_ID = Integer.parseInt(service.getByID("KC_ID").getDEF_VALUE());
        RKD_ID = Integer.parseInt(service.getByID("RKD_ID").getDEF_VALUE());
        CKD_ID = Integer.parseInt(service.getByID("CKD_ID").getDEF_VALUE());
    }
    //获取当前时间的日期格式字符串
    private String getTime(){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MMdd");
        String time = format.format(now);
        return PdDate(time);
    }
    //获取非产品编号
    public String getID(String firstNo){
        init();
        StringBuffer sb = new StringBuffer(firstNo);
        sb.append(getTime());
        switch (firstNo){
            case "200": WLSJ_ID++;sb.append(fullNumber(WLSJ_ID));break;
            case "201": GXSJ_ID++;sb.append(fullNumber(GXSJ_ID));break;
            case "300": SCJH_ID++;sb.append(fullNumber(SCJH_ID));break;
            case "301": SCBH_ID++;sb.append(fullNumber(SCBH_ID));break;
            case "400": KC_ID++;sb.append(fullNumber(KC_ID));break;
            case "401": RKD_ID++;sb.append(fullNumber(RKD_ID));break;
            case "402": CKD_ID++;sb.append(fullNumber(CKD_ID));break;
        }
        commit();
        return sb.toString();
    }

    //获取产品编号流水号
    public String getCPID(String num1,String num2,String num3){
        init();
        StringBuffer buffer = new StringBuffer(100);
        buffer.append(num1);
        buffer.append(num2);
        buffer.append(num3);
        ++CP_ID;
        switch (CP_ID.toString().length()){
            case 1:buffer.append(00000);break;
            case 2:buffer.append(0000);break;
            case 3:buffer.append(000);break;
            case 4:buffer.append(00);break;
            case 5:buffer.append(0);break;
        }
        buffer.append(CP_ID);
        commit();
        return buffer.toString();
    }

    //填充流水号
    private String fullNumber(Integer num){
        int length = num.toString().length();
        StringBuffer buffer = new StringBuffer();
        switch (length){
            case 1:buffer.append("000");break;
            case 2:buffer.append("00");break;
            case 3:buffer.append("0");break;
        }
        buffer.append(num);
        return buffer.toString();
    }

    //判定当前日期，如到一号重置流水号
    private String PdDate(String time){
        if(time.substring(2).equals("01")){
            WLSJ_ID=0;
            GXSJ_ID=0;
            SCJH_ID=0;
            SCBH_ID=0;
            KC_ID=0;
            RKD_ID=0;
            CKD_ID=0;
        }
        return time;
    }

    //提交流水号
    private void commit(){
        service.commitByID("CP_ID",CP_ID);
        service.commitByID("WLSJ_ID",WLSJ_ID);
        service.commitByID("GXSJ_ID",GXSJ_ID);
        service.commitByID("SCJH_ID",SCJH_ID);
        service.commitByID("SCBH_ID",SCBH_ID);
        service.commitByID("KC_ID",KC_ID);
        service.commitByID("RKD_ID",RKD_ID);
        service.commitByID("CKD_ID",CKD_ID);
    }

}

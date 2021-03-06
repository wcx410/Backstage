package com;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("Merchants")
public class Merchants {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private String address;

    private String phone;

    private Float longitude;

    private Float latitude;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date openTimeFrom;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date openTimeTo;

    private String remark;

    private Integer state;

    private String photos;

    private String idcardimagezheng;

    private String idcardimagefan;

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getIdcardimagezheng() {
        return idcardimagezheng;
    }

    public void setIdcardimagezheng(String idcardimagezheng) {
        this.idcardimagezheng = idcardimagezheng;
    }

    public String getIdcardimagefan() {
        return idcardimagefan;
    }

    public void setIdcardimagefan(String idcardimagefan) {
        this.idcardimagefan = idcardimagefan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Date getOpenTimeFrom() {
        return openTimeFrom;
    }

    public void setOpenTimeFrom(Date openTimeFrom) {
        this.openTimeFrom = openTimeFrom;
    }

    public Date getOpenTimeTo() {
        return openTimeTo;
    }

    public void setOpenTimeTo(Date openTimeTo) {
        this.openTimeTo = openTimeTo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
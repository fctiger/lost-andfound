package com.tiger.lostandfound.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Aaron_Kitty
 * @Date 2020/4/10 22:29
 */
public class Uploads {
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    String openId;
    String detail;
    String jiandao;
    String imageUrl;
    String name;
    String contactWay;
    String phone;
    String classify;
    String baseClassify;
    Date createTime;

    public String getJiandao() {
        return jiandao;
    }

    public void setJiandao(String jiandao) {
        this.jiandao = jiandao;
    }

    public String getCreateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime1 = dateFormat.format(createTime);
        return createTime1;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBaseClassify() {
        return baseClassify;
    }

    public void setBaseClassify(String baseClassify) {
        this.baseClassify = baseClassify;
    }



    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Uploads{" +
                "openId='" + openId + '\'' +
                ", detail='" + detail + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", contactWay='" + contactWay + '\'' +
                ", phone='" + phone + '\'' +
                ", classify='" + classify + '\'' +
                ", baseClassify='" + baseClassify + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

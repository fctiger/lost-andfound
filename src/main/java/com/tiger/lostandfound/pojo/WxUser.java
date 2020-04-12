package com.tiger.lostandfound.pojo;

import lombok.*;

import java.util.Date;

/**
 * @author Aaron_Kitty
 * @Date 2020/4/9 16:25
 */

@NoArgsConstructor
@AllArgsConstructor
public class WxUser {
    private String openId;
    Date createTime;
    Date lastVisitTime;
    String sessionKey;
    String city;
    String province;
    String country;
    String avatarUrl;
    Integer gender;
    String nickName;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastVisitTime() {
        return lastVisitTime;
    }

    public void setLastVisitTime(Date lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "WxUser{" +
                "openId='" + openId + '\'' +
                ", createTime=" + createTime +
                ", lastVisitTime=" + lastVisitTime +
                ", sessionKey='" + sessionKey + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender=" + gender +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

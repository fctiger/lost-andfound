package com.tiger.lostandfound.controller;/*
package com.tiger.lostandfound.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tiger.lostandfound.pojo.WxUser;
import com.tiger.lostandfound.until.WxUntil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
*/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tiger.lostandfound.config.ResultGenerator;
import com.tiger.lostandfound.pojo.Result;
import com.tiger.lostandfound.pojo.WxUser;
import com.tiger.lostandfound.service.impl.WxUserServiceImpl;
import com.tiger.lostandfound.until.WxUntil;
import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Aaron_Kitty
 * @Date 2020/4/9 16:27
 */
@RestController
public class WxController {
    @Autowired
    private WxUserServiceImpl wxUserService;

    @GetMapping("wx/login")
    public Result user_login(@RequestParam(value = "code", required = false) String code,
                             @RequestParam(value = "rawData", required = false) String rawData,
                             @RequestParam(value = "signature", required = false) String signature,
                             @RequestParam(value = "encrypteData", required = false) String encrypteData,
                             @RequestParam(value = "iv", required = false) String iv) {
        // 用户非敏感信息：rawData
        // 签名：signature
        JSONObject rawDataJson = JSON.parseObject(rawData);
        // 1.接收小程序发送的code
        // 2.开发者服务器 登录凭证校验接口 appi + appsecret + code
        JSONObject SessionKeyOpenId = WxUntil.getSessionKeyOrOpenId(code);
        // 3.接收微信接口服务 获取返回的参数
        String openid = SessionKeyOpenId.getString("openid");
        String sessionKey = SessionKeyOpenId.getString("session_key");
        // 4.校验签名 小程序发送的签名signature与服务器端生成的签名signature2 = sha1(rawData + sessionKey)
        String signature2 = DigestUtils.sha1Hex(rawData + sessionKey);
        if (!signature.equals(signature2)) {
            return ResultGenerator.genFailResult("错误");
        }
        // 5.根据返回的User实体类，判断用户是否是新用户，是的话，将用户信息存到数据库；不是的话，更新最新登录时间
        WxUser user = (WxUser) wxUserService.findById(openid);
        ;
        System.out.println(user);
        if (user == null) {
            // 用户信息入库
            String nickName = rawDataJson.getString("nickName");
            nickName = EmojiParser.removeAllEmojis(nickName);
            String avatarUrl = rawDataJson.getString("avatarUrl");
            String gender = rawDataJson.getString("gender");
            String city = rawDataJson.getString("city");
            String country = rawDataJson.getString("country");
            String province = rawDataJson.getString("province");
            WxUser wxUser = new WxUser();
            wxUser.setOpenId(openid);
            wxUser.setCreateTime(new Date());
            wxUser.setLastVisitTime(new Date());
            wxUser.setSessionKey(sessionKey);
            wxUser.setCity(city);
            wxUser.setProvince(province);
            wxUser.setCountry(country);
            wxUser.setAvatarUrl(avatarUrl);
            wxUser.setGender(Integer.parseInt(gender));
            wxUser.setNickName(nickName);
            wxUserService.insert(wxUser);

        } else {
            String nickName = rawDataJson.getString("nickName");
            nickName = EmojiParser.removeAllEmojis(nickName);
            System.out.println("NICKNAME" + nickName);
            user.setLastVisitTime(new Date());
            user.setNickName(nickName);
            System.out.println(user);
            wxUserService.update(user);
        }
        System.out.println("----------------------------------------");
        System.out.println(user);
        return ResultGenerator.genSuccessResult(openid);
    }
}

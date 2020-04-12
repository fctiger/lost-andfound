package com.tiger.lostandfound.controller;

import com.tiger.lostandfound.config.ResultGenerator;
import com.tiger.lostandfound.mapper.SwiperMapper;
import com.tiger.lostandfound.pojo.Swiper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aaron_Kitty
 * @Date 2020/4/9 12:00
 */
@RestController
public class HelloController {
    @Autowired
    private SwiperMapper swiperMapper;

    @GetMapping("/hello")
    public Object hello() {
        System.out.println("ok");
        List<Swiper> all = swiperMapper.findAll();
        Object listResult = ResultGenerator.genSuccessResult(all);
        return listResult;
    }

}

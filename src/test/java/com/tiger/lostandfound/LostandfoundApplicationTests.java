package com.tiger.lostandfound;


import com.tiger.lostandfound.service.impl.WxUserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LostandfoundApplicationTests {
    @Autowired
    private WxUserServiceImpl wxUserService;
    @Test
    void contextLoads() {
        wxUserService.findById("oFjV55Ikf-vSF-1iIiNkkgfY0geA");
    }

}

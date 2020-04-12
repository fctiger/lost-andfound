package com.tiger.lostandfound.controller;

import com.tiger.lostandfound.config.ResultGenerator;
import com.tiger.lostandfound.pojo.Uploads;
import com.tiger.lostandfound.service.impl.UploadsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aaron_Kitty
 * @Date 2020/4/11 15:57
 */
@RestController
public class GetclassifyController {
    @Autowired
    private UploadsServiceImpl uploadsService;

    @PostMapping("/getClassify")
    public Object getClassiy(@RequestBody Uploads uploads) {
        System.out.println(uploads);
        List<Uploads> res = uploadsService.selectByPojo(uploads);
        return ResultGenerator.genSuccessResult(res);
    }
}

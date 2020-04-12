package com.tiger.lostandfound.controller;

import com.tiger.lostandfound.config.ResultGenerator;
import com.tiger.lostandfound.config.UploadsConfig;
import com.tiger.lostandfound.pojo.ImagesUrl;
import com.tiger.lostandfound.pojo.Uploads;
import com.tiger.lostandfound.service.impl.UploadsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * @author Aaron_Kitty
 * @Date 2020/4/10 16:01
 */
@RestController
public class UploadsController {
    @Autowired
    private UploadsServiceImpl uploadsService;
    @RequestMapping("/uploads")
    public  @ResponseBody
    Object UploadsImg(HttpServletRequest request, @RequestParam MultipartFile upload) throws Exception {
        System.out.println("上传照片执行");
        System.out.println(request);
        System.out.println(upload);
        UploadsConfig uploadsConfig = new UploadsConfig();
        ImagesUrl url = uploadsConfig.fileuoload2(request, upload);
        System.out.println(url);
        Object stringResult = ResultGenerator.genSuccessResult(url);
        return  stringResult;
    }
    @PostMapping("/public")
    public com.tiger.lostandfound.pojo.Result publicAll(@RequestBody Uploads uploads){
        uploads.setCreateTime(new Date());
        uploadsService.insert(uploads);
        return  ResultGenerator.genSuccessResult();
    }
    @GetMapping("/selectById")
    public Object selectById(@RequestParam(value ="id") String integer){
        System.out.println("chenggggg");
        Integer id = Integer.valueOf(integer);
        Uploads uploads = uploadsService.findById(id);
        return ResultGenerator.genSuccessResult(uploads);
    }
}

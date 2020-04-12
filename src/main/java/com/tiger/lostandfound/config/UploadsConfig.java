package com.tiger.lostandfound.config;

import com.tiger.lostandfound.pojo.ImagesUrl;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @author Aaron_Kitty
 * @Date 2020/3/30 11:36
 */
public class UploadsConfig {
    public void copyFile(String src, String destDir, String fileName) throws IOException {
        FileInputStream in = new FileInputStream(src);
        File fileDir = new File(destDir);
        if (!fileDir.isDirectory()) {
            fileDir.mkdirs();
        }
        File file = new File(fileDir, fileName);

        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file);
        int c;
        byte buffer[] = new byte[1024];
        while ((c = in.read(buffer)) != -1) {
            for (int i = 0; i < c; i++) {
                out.write(buffer[i]);
            }

        }
        in.close();
        out.close();
    }

    public ImagesUrl fileuoload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传...");
        File targetFile = null;
        // 使用fileupload组件完成文件上传
        // 上传的位置

        String path = request.getSession().getServletContext().getRealPath("/uploads");
        System.out.println(path);
        // 判断，该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            // 创建该文件夹
            file.mkdirs();
        }
        System.out.println(path);
        // 说明上传文件项
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        System.out.println(filename);
        String fileSuffix = filename.substring(filename.lastIndexOf("."), filename.length());
        filename = System.currentTimeMillis() + "_" + new Random().nextInt(1000) + fileSuffix;
        String url = "/uploads/" + filename;
        // 完成文件上传
        ImagesUrl imagesUrl = new ImagesUrl();
        imagesUrl.setUrl(url);
        upload.transferTo(new File(path, filename));
        String projectPath = System.getProperty("user.dir");
        //文件复制
        String src = path + File.separator + filename;
        //根据自己系统的resource 目录所在位置进行自行配置
        String destDir = projectPath + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "uploads" + File.separator;
        copyFile(src, destDir, filename);
        System.out.println(url);
        return imagesUrl;

    }
}

package com.xwl.controller;

import com.xwl.pojo.Result;
import com.xwl.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/upload")
public class UploadController {
    /**
     * 本地连接
     */
//    @PostMapping
//    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
//        log.info("文件上传，{}，{}，{}",username,age,image);
//        String originalFilename = image.getOriginalFilename();
//        int index = originalFilename.lastIndexOf(".");
//        String endName = originalFilename.substring(index);
//        image.transferTo(new File("B:\\学习资料\\"+ UUID.randomUUID()+endName));
//        return Result.success();
//    }

    /**
     * 云连接
     */
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping
    public Result upload(MultipartFile image) throws IOException {

        log.info("文件上传，文件名：{}",image.getOriginalFilename());
        String uploadUrl = aliOSSUtils.upload(image);

        log.info("文件上传成功文件地址为：{}",uploadUrl);
        return Result.success(uploadUrl);
    }
}

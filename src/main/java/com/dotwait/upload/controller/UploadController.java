package com.dotwait.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class UploadController {
    /**
     * 上传多个文件的页面
     * @return
     */
    @RequestMapping("/uploadBatch")
    public String multipleFiles() {
        return "/uploadBatch";
    }

    /**
     * 上传多个文件
     * @param files
     * @return
     * @throws IOException
     */
    @RequestMapping("upload")
    public String upload(@RequestParam("files") MultipartFile[] files) throws IOException {
        System.out.println("文件个数："+ files.length);
        for (MultipartFile file : files) {
            String contentType = file.getContentType();
            String name = file.getName();
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();
            System.out.println("contentType:" +contentType );
            System.out.println("name:"+name);
            System.out.println("originalFilename:"+originalFilename);
            System.out.println("size:"+size);
            /*使用inputStream避免占用内存*/
            InputStream inputStream = file.getInputStream();
            /*此方法会获取文件的字节，占用大量内存，可能导致oom*/
            byte[] bytes = file.getBytes();
            //TODO 处理文件
        }
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "success";
    }
}

package com.jason.mycors.controller;

import com.jason.mycors.entity.RespBean;
import com.jason.mycors.entity.User;
import com.jason.mycors.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/user")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/userc")
    public List<User> findAllUsersWithCORS() {
        return userService.findAllUsers();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public RespBean upload(@RequestParam("file") MultipartFile[] files) {
        if (files == null || files.length == 0) {
            return RespBean.error("files are null");
        }
        for (MultipartFile fileUpload : files) {
            // 判断文件是否为空
            if (fileUpload == null || fileUpload.isEmpty()) {
                return RespBean.error("file is null");
            }

            // 获取文件名
            String fileName = fileUpload.getOriginalFilename();

            // 获取文件后缀名
//            String suffixName = fileName.substring(fileName.lastIndexOf("."));

            // 重新生成文件名
//        fileName = UUID.randomUUID() + suffixName;

            // 指定存储路径
            String filePath = ClassUtils.getDefaultClassLoader().getResource("").getPath().substring(1) + "upload/" + fileName;

            // 创建文件对象
            File newFile = new File(filePath);

            // 判断文件是否已经存在
            if (newFile.exists()) {
                return RespBean.error("file is exist");
            }

            // 判断文件父目录是否存在
            if (!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdir();
            }

            try {
                // 保存文件
                fileUpload.transferTo(newFile);
//                return RespBean.ok("success to upload");
            } catch (Exception e) {
                e.printStackTrace();
                return RespBean.error("fail to upload");
            }
        }
        return RespBean.ok("success to upload");
    }


}

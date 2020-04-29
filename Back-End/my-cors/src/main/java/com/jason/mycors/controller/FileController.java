package com.jason.mycors.controller;

import com.jason.mycors.entity.RespBean;
import com.jason.mycors.util.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;

@Slf4j
@RestController
public class FileController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/upload")
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
            String filePath = CommonUtils.getFilePath() + fileName;
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
//                e.printStackTrace();
                log.info("Exception:{}",e);
                return RespBean.error("fail to upload");
            }
        }
        return RespBean.ok("success to upload");
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/dl/{filename:.+}")
    public ResponseEntity<?> downloadFile(@PathVariable String filename) {
        String filePath = CommonUtils.getFilePath();
        String path = Paths.get(filePath + filename).toString();
        // 创建文件对象
        File newFile = new File(path);
        // 判断文件是否已经存在
        if (!newFile.exists()) {
            System.out.println("file not existed");
//            return ResponseEntity.status(HttpStatus.OK).body(RespBean.error("file not existed"));
//            return ResponseEntity.ok(RespBean.error("file not existed"));
            return ResponseEntity.status(500).body(RespBean.error("file not existed"));
        }
        Resource resource = resourceLoader.getResource("file:" + path);
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
	
//  	response.setCharacterEncoding("UTF-8");
//  	response.setHeader("content-type", "application/octet-stream;charset=utf-8");// application/vnd.ms-excel
//  	response.setContentType("application/octet-stream;charset=utf-8");// application/vnd.ms-excel
//  	response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("报表" + System.currentTimeMillis() + ".xls", "UTF-8"));
//  	try {
//  		OutputStream outputStream = response.getOutputStream();// itemResult.getData()  itemResult.getData()
//  		InputStream inputStream = new ByteArrayInputStream(mybuffer);
//  		byte[] buff = new byte[1024];
//  		int num = inputStream.read(buff);
//  		while (num != -1) {
//  			System.out.println("buff -->  " + Arrays.toString(buff));
//  			outputStream.write(buff, 0, num);
//  			outputStream.flush();
//  			num = inputStream.read(buff);
//  		}
//  	} catch (Exception e) {
//  		e.printStackTrace();
//  	}
}

package com.jason.mycors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Paths;

@RestController
public class FileController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping(value = "/down/{filename:.+}")
    public ResponseEntity<?> downloadFile(@PathVariable String filename) {
        String filePath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "upload/";

        String path = Paths.get(filePath.substring(1) + filename).toString();

        Resource resource = resourceLoader.getResource("file:" + path);
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
}

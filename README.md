
基于Spring Boot
 - **跨域**
   - 后端`@CrossOrigin(origins =  "*")`
   - 前端 \config\index.js `proxyTable`
 - **上传**
   - 后端 `MultipartFile`
   - 前端 `<input type="file" multiple />`
 - **下载**
      ```
      return ResponseEntity
          .ok()
          .contentType(MediaType.parseMediaType("application/octet-stream"))
          .body(resource);
      ```
```
# 设置文件上传下载大小限制
spring.servlet.multipart.max-file-size=-1
spring.servlet.multipart.max-request-size=-1
```

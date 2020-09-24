package com.qixi.security.demo.controller;

import com.qixi.security.demo.entity.dto.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhengNC
 * @date 2020/6/22 15:42
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.success("hello");
    }

    @GetMapping("admin/hello")
    public ResponseEntity<String> adminHello(){
        return ResponseEntity.success("admin");
    }

    @GetMapping("user/hello")
    public ResponseEntity<String> userHello(){
        return ResponseEntity.success("user");
    }
}

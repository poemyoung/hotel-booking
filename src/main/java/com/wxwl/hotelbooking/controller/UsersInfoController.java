package com.wxwl.hotelbooking.controller;


import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上载
 */
@RestController
public class UsersInfoController {

    @PutMapping("/users")
    public void load(@RequestParam("avatar") MultipartFile avatar

                     ) {
            //...
        }
    }


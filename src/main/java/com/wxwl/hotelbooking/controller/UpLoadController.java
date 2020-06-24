package com.wxwl.hotelbooking.controller;


import com.fasterxml.jackson.databind.util.ClassUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 图片上载
 */
@RestController
public class UpLoadController {

    private  final String RESOURCES = "/Users/xzp/Desktop/hotel-booking/src/main/resources";

    @PutMapping("/users")
    public void load(@RequestParam("avatar") MultipartFile avatar) {
        String path = RESOURCES + "/static";
        File file = new File(path+"/test1.jpg");
        try{
            avatar.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

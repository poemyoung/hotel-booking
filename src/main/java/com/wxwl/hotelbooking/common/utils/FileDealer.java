package com.wxwl.hotelbooking.common.utils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件处理类，crud文件
 */
@Service
public class FileDealer {

    private final String STATIC_PATH = "/Users/xzp/Desktop/hotel-booking/src/main/resources/static/";

    public String addFile(MultipartFile file,String fileName){
        File aFile = new File(STATIC_PATH+fileName);
        try{
            file.transferTo(aFile);
        } catch (IOException e) {
            return null;
        }
        return fileName;
    }

    public String findFile(String fileName){
        File aFile = new File(STATIC_PATH+fileName);
        if(!aFile.exists()){
            return null;
        }
        return STATIC_PATH+fileName;
    }

    public boolean deleteFile(String fileName){
        File aFile = new File(STATIC_PATH+fileName);
        return aFile.delete();
    }
}

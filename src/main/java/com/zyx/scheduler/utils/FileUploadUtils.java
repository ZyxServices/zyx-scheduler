package com.zyx.scheduler.utils;

import com.zyx.scheduler.constants.Constants;
import com.zyx.scheduler.file.FastDFSClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wms on 2016/11/23.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/23
 */
public class FileUploadUtils {
    //图片最大上传大小
    public static int IMAGES_MAX_BYTE = 20 * 1024 * 1024;


    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    public static String uploadFile(MultipartFile file) {
        String allFileName = file.getOriginalFilename();
        String fileName = getFileExtension(allFileName);
        fileName = fileName.toLowerCase();
        //"gif", "jpeg", "jpg", "bmp", "png"
        String[] strings = new String[]{"png", "gif", "jpeg", "jpg", "bmp"};//所有文件格式
        List<String> list = Arrays.asList(strings);
        try {
            if (list.contains(fileName)) {
                byte[] tempFile = file.getBytes();
                String[] images = new String[]{"png", "gif", "jpeg", "jpg", "bmp"};//可上传图片格式
                List<String> imagesList = Arrays.asList(images);
                Arrays.binarySearch(images, fileName);
                if (imagesList.contains(fileName) && tempFile.length > IMAGES_MAX_BYTE) {
                    return Constants.AUTH_ERROR_901 + "";
                }

                String uploadFile = FastDFSClient.uploadFiles(tempFile, allFileName);
                if (uploadFile != null) {
                    return uploadFile;
                } else {
                    return Constants.AUTH_ERROR_902 + "";
                }
            } else {
                return Constants.AUTH_ERROR_903 + "";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Constants.ERROR + "";
        }
    }

    public static String deleteFile(String fileUri) {
        try {
            return FastDFSClient.deleteFile(fileUri) + "";
        } catch (Exception e) {
            return Constants.ERROR_MSG;
        }
    }

    public static String getFileExtension(String fullName) {
        FileUploadUtils.checkNotNull(fullName);
        String fileName = (new File(fullName)).getName();
        int dotIndex = fileName.lastIndexOf(46);
        return dotIndex == -1 ? "" : fileName.substring(dotIndex + 1);
    }

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        } else {
            return reference;
        }
    }
}

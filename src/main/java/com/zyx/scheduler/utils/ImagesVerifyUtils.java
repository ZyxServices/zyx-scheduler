package com.zyx.scheduler.utils;


import com.zyx.scheduler.constants.Constants;

import java.util.Map;

/**
 * Created by wms on 2016/11/23.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/23
 */
public class ImagesVerifyUtils {

    public static Map<String, Object> verify(String uploadFile) {

        if (uploadFile == null || uploadFile.equals(Constants.AUTH_ERROR_902 + "")) {
            return MapUtils.buildErrorMap(Constants.AUTH_ERROR_902, "图片上传失败,请重试");
        }

        if (uploadFile.equals(Constants.AUTH_ERROR_903 + "")) {
            return MapUtils.buildErrorMap(Constants.AUTH_ERROR_903, "文件格式错误");
        }

        if (uploadFile.equals(Constants.AUTH_ERROR_901 + "")) {
            return MapUtils.buildErrorMap(Constants.AUTH_ERROR_901, "图片大小不能超过20MB");
        }
        return null;
    }
}

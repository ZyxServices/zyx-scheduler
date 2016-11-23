package com.zyx.scheduler.utils;


import com.zyx.scheduler.constants.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wms on 2016/11/23.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/23
 */
public final class MapUtils {

    public static Map<String, Object> buildSuccessMap() {
        return buildSuccessMap(null);
    }

    public static Map<String, Object> buildSuccessMap(String msg) {
        return buildSuccessMap(Constants.SUCCESS, msg, null);
    }

    public static Map<String, Object> buildSuccessMap(Object data) {
        return buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, data);
    }

    public static Map<String, Object> buildSuccessMap(int state, String msg, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put(Constants.STATE, state);
        map.put(Constants.SUCCESS_MSG, msg);
        if (data != null) {
            map.put(Constants.DATA, data);
        }
        return map;
    }

    public static Map<String, Object> buildErrorMap(int state, String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put(Constants.STATE, state);
        map.put(Constants.ERROR_MSG, msg);
        return map;
    }

    public static Map<String, Object> buildSuccessMap(int state, String msg, Object data, Map<String, Object> customParams) {
        Map<String, Object> map = new HashMap<>();
        map.put(Constants.STATE, state);
        map.put(Constants.SUCCESS_MSG, msg);
        map.put(Constants.DATA, data);
        map.putAll(customParams);
        return map;
    }

}

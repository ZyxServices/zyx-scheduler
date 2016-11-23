package com.zyx.scheduler.constants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by SubDong on 16-6-23.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title Constants
 * @package com.zyx.scheduler.constants
 * @update 16-6-23 下午4:39
 */
public interface Constants {
    //浏览量
    String REDIS_PAGE_VIEWS = "pageViews";

    ////////////// 系统标识符 开始//////////////////
    /**
     * 状态 标志
     */
    String STATE = "state";
    /**
     * 状态 标志
     */
    String DATA = "data";
    /**
     * 错误消息 标志
     */
    String ERROR_MSG = "errmsg";

    /**
     * 成功消息 标志
     */
    String SUCCESS_MSG = "successmsg";

    ////////////// 系统标识符 结束//////////////////

    /**
     * 请求失败
     */
    int ERROR = 100;

    /**
     * 请求成功
     */
    int SUCCESS = 200;
    /**
     * 成功
     */
    String MSG_SUCCESS = "success";

    /**
     * 参数缺失
     */
    int PARAM_MISS = 301;
    String MSG_PARAM_MISS = "missing paraams";

    /**
     * 服务器错误
     */
    int ERROR_500 = 500;
    /**
     * 错误
     */
    String MSG_ERROR = "error";

    /**
     * 图片上传文件大于5MB
     */
    int AUTH_ERROR_901 = 901;
    /**
     * 文件上传失败
     */
    int AUTH_ERROR_902 = 902;
    /**
     * 文件格式错误
     */
    int AUTH_ERROR_903 = 903;

    /**
     * 参数缺失
     */
    Map<String, Object> MAP_PARAM_MISS = new ConcurrentHashMap() {{
        put(Constants.STATE, Constants.PARAM_MISS);
        put(Constants.ERROR_MSG, Constants.MSG_PARAM_MISS);
    }};

    /**
     * 系统错误
     */
    Map<String, Object> MAP_500 = new ConcurrentHashMap() {{
        put(Constants.STATE, Constants.ERROR_500);
        put(Constants.ERROR_MSG, Constants.MSG_ERROR);
    }};
}

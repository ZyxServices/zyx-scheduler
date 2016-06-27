package com.zyx.sheduler.quartz;

import com.zyx.sheduler.constants.Constants;
import com.zyx.sheduler.dao.PageViewsDao;
import com.zyx.sheduler.entity.PageViews;
import com.zyx.sheduler.utils.JRedisUtils;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

/**
 * Created by SubDong on 16-6-20.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title PageViewsScheduler
 * @package com.zyx.sheduler
 * @update 16-6-20 下午2:15
 */
public class PageViewsScheduler {
    protected static transient Logger log = LoggerFactory.getLogger(PageViewsScheduler.class);

    @Autowired
    private PageViewsDao pageViewsDao;

    public boolean execute() throws Exception {
        Jedis jc = null;
        try {
            jc = JRedisUtils.get();
            int[] section = new int[]{0, 1, 2, 3, 4};
            for (int i : section) {
                if (jc.get(Constants.REDIS_PAGE_VIEWS + i) != null) {
                    String pageKey = jc.get(Constants.REDIS_PAGE_VIEWS + i);
                    String[] key = pageKey.split(",");
                    for (String s : key) {
                        String s1 = jc.get(s);
                        jc.set(s, "0");
                        PageViews views = new PageViews();
                        String[] keys = pageKey.split("_");
                        views.setTypeId(Integer.valueOf(keys[0]));
                        views.setTypes(Integer.valueOf(keys[1]));
                        views.setPageviews(s1 == null ? 0 : Integer.valueOf(s1));
                        PageViews queryPageView = pageViewsDao.queryPageView(views);
                        if (queryPageView != null) {
                            pageViewsDao.updatePageViews(views);
                        } else {
                            pageViewsDao.insertPageView(views);
                        }
                    }
                }
            }
        } finally {
            if (jc != null) jc.close();
        }
        return true;
    }

    public void start() throws JobExecutionException {
        try {
            execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

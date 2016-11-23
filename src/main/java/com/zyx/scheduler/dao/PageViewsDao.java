package com.zyx.scheduler.dao;

import com.zyx.scheduler.entity.PageViews;

/**
 * Created by SubDong on 16-6-23.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title PageViewsDao
 * @package com.zyx.scheduler.dao
 * @update 16-6-23 下午4:18
 */
public interface PageViewsDao {

    /**
     * 查询对应浏览量
     *
     * @param pageViews
     * @return
     */
    PageViews queryPageView(PageViews pageViews);

    /**
     * 更新对应浏览量
     *
     * @param pageViews
     * @return
     */
    int updatePageViews(PageViews pageViews);

    /**
     * 插入对应浏览量
     * @param pageViews
     * @return
     */
    void insertPageView(PageViews pageViews);
}

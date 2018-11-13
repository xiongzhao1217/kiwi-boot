package com.kiwiboot.kiwisso.dao;

import com.kiwiboot.kiwisso.model.Apps;
import com.kiwiframework.easycoding.base.BaseMapper;

import java.util.List;

public interface AppsMapper extends BaseMapper<Apps> {

    /**
     * 条件查询
     * @param query
     * @return
     */
    List<Apps> queryList (Apps query);
}
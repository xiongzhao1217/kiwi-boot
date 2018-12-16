package com.kiwiboot.kiwisso.service;

import com.kiwiboot.kiwisso.model.Apps;
import com.kiwiboot.kiwisso.model.User;
import com.kiwiframework.easycoding.base.BaseService;

import java.util.List;

/**
 * Created on 2018/11/11.
 * @author xiongzhao.
 */
public interface AppsService extends BaseService<Apps> {

    /**
     * 新增应用
     * @return
     */
    int save (Apps apps, User ssoUser);

    /**
     * 条件查询
     * @param query
     * @return
     */
    List<Apps> queryList (Apps query);

    /**
     * 根据appId查询应用信息
     * @param appId
     * @return
     */
    Apps selectByAppId(String appId);
}
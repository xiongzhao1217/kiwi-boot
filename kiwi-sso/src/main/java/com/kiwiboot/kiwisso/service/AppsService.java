package com.kiwiboot.kiwisso.service;

import com.kiwiboot.kiwisso.model.Apps;
import com.kiwiboot.kiwisso.model.User;
import com.kiwiframework.easycoding.base.BaseService;
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
}
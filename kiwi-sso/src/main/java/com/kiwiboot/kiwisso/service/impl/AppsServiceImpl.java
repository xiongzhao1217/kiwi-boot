package com.kiwiboot.kiwisso.service.impl;

import com.kiwiboot.kiwisso.dao.AppsMapper;
import com.kiwiboot.kiwisso.enums.AppStatusEnum;
import com.kiwiboot.kiwisso.model.Apps;
import com.kiwiboot.kiwisso.model.User;
import com.kiwiboot.kiwisso.service.AppsService;
import com.kiwiframework.core.utils.CodeGenerateor;
import com.kiwiframework.easycoding.base.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created on 2018/11/11.
 * @author xiongzhao.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AppsServiceImpl extends AbstractService<Apps> implements AppsService {
    @Resource
    private AppsMapper appsMapper;

    @Override
    public int save(Apps apps, User ssoUser) {
        Date now = new Date();
        // 生成8位随机码
        apps.setAppId(CodeGenerateor.random(12));
        apps.setAppSecret(CodeGenerateor.uuid());
        apps.setStatus(AppStatusEnum.VALID.code());
        apps.setCreateTime(now);
        apps.setCreator(ssoUser.getId());
        apps.setUpdateTime(now);
        apps.setUpdator(ssoUser.getId());
        return insertSelective(apps);
    }

    @Override
    public List<Apps> queryList(Apps query) {
        return appsMapper.queryList(query);
    }

    @Override
    public Apps selectByAppId(String appId) {
        return this.selectBy("appId", appId);
    }
}

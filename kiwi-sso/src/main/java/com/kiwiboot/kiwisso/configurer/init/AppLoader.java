package com.kiwiboot.kiwisso.configurer.init;


import com.kiwiboot.kiwisso.model.Access;
import com.kiwiboot.kiwisso.model.Apps;
import com.kiwiboot.kiwisso.model.vo.AccessVO;
import com.kiwiboot.kiwisso.service.AccessService;
import com.kiwiboot.kiwisso.service.AppsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * 应用数据初始化方法
 * @author xiongzhao
 * @date 18/12/6
 */
@Slf4j
public class AppLoader {

    @Value("${kiwi.sso.appId}")
    private String appId;

    @Resource
    private AccessService accessService;

    @Resource
    private AppsService appsService;

    /**
     * 存放应用权限的map
     * 分布式情况下改为redis存放
     */
    public static Map<String, Set<Long>> CACHE_ACCESS = null;

    private void initApplication() {
        log.info("------kiwi-sso------ 开始初始化应用数据...");
        // 加载应用权限资源
        log.info("------kiwi-sso------ 加载应用权限资源中...");
        loadAccess(appId);
        log.info("------kiwi-sso------ 应用初始化完成");
    }

    /**
     * 加载应用的所有权限资源,当权限变更时,重新加载资源
     */
    public void loadAccess(String appId) {
        CACHE_ACCESS = new HashMap<>();
        // 应用信息
        Apps apps = appsService.selectByAppId(appId);
        // 获取应用所有角色对应的权限
        List<AccessVO> accessList = accessService.findAllRoleAccess(apps.getId());
        accessList.forEach(access -> {
            Set<Long> roleIds = Optional
                    .ofNullable(CACHE_ACCESS.get(access.getUrl()))
                    .orElse(new HashSet<>(accessList.size()));
            roleIds.add(access.getRoleId());
            CACHE_ACCESS.put(access.getUrl(), roleIds);
        });
    }
}

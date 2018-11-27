package com.kiwiboot.kiwisso.service.impl;

import com.kiwiboot.kiwisso.dao.MenuMapper;
import com.kiwiboot.kiwisso.model.Menu;
import com.kiwiboot.kiwisso.model.vo.MenuVO;
import com.kiwiboot.kiwisso.service.MenuService;
import com.kiwiframework.easycoding.base.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created on 2018/11/25.
 * @author xiongzhao.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl extends AbstractService<Menu> implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<MenuVO> findByRoleId(Long appsId, Long roleId) {
        return menuMapper.findByRoleId(appsId, roleId);
    }

    @Override
    public List<Menu> findByUser(Long userId, Long appsId) {
        MenuVO query = new MenuVO();
        query.setUserId(userId);
        query.setAppsId(appsId);
        return menuMapper.findByUser(query);
    }
}

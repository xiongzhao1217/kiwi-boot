package com.kiwiboot.kiwisso.service.impl;

import com.kiwiboot.kiwisso.dao.AccessMapper;
import com.kiwiboot.kiwisso.model.Access;
import com.kiwiboot.kiwisso.model.vo.AccessVO;
import com.kiwiboot.kiwisso.service.AccessService;
import com.kiwiframework.easycoding.base.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created on 2018/12/04.
 * @author xiongzhao.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AccessServiceImpl extends AbstractService<Access> implements AccessService {
    @Resource
    private AccessMapper accessMapper;

    @Override
    public List<AccessVO> findByRole(Long appsId, Long roleId) {
        return accessMapper.findByRole(appsId, roleId);
    }
}

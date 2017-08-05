package cn.bdqn.tangcco.service.impl;

import cn.bdqn.tangcco.dao.TbuserMapper;
import cn.bdqn.tangcco.entity.RoleUser;
import cn.bdqn.tangcco.entity.TbUser;
import cn.bdqn.tangcco.service.TbuserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by jf on 2017/8/5.
 */
@Service
public class TbuserServiceImpl implements TbuserService {

    @Inject
    private TbuserMapper tbuserMapper;


    @Override
    public RoleUser login(TbUser tbuser) {
        return tbuserMapper.queryUserByUsernameAndPassword(tbuser);
    }
}

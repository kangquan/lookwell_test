package cn.bdqn.tangcco.service;

import cn.bdqn.tangcco.entity.RoleUser;
import cn.bdqn.tangcco.entity.TbUser;

/**
 * Created by jf on 2017/8/5.
 */
public interface TbuserService {

    RoleUser login(TbUser tbuser);
}

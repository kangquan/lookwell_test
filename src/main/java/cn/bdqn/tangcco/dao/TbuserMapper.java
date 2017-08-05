package cn.bdqn.tangcco.dao;

import cn.bdqn.tangcco.entity.RoleUser;
import cn.bdqn.tangcco.entity.TbUser;

/**
 * Created by Clown on 2017/07/25.
 */
public interface TbuserMapper {

    RoleUser queryUserByUsernameAndPassword(TbUser tbuser);
}

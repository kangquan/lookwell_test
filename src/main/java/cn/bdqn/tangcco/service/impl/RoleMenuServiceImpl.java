package cn.bdqn.tangcco.service.impl;


import cn.bdqn.tangcco.dao.RoleMenuMapper;
import cn.bdqn.tangcco.entity.Menu;
import cn.bdqn.tangcco.service.RoleMenuService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jf on 2017/8/5.
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Inject
    private RoleMenuMapper roleMenuMapper;
    @Override
    public List<Menu> queryMenuByRoleId(Integer roleId) {
        return roleMenuMapper.queryMenuByRoleId(roleId);
    }

    @Override
    public List<Menu> queryMenuByParentId(Integer parentId, Integer roleId) {
        return roleMenuMapper.queryMenuByParentId(parentId,roleId);
    }
}

package cn.bdqn.tangcco.service;

import cn.bdqn.tangcco.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jf on 2017/8/5.
 */
public interface RoleMenuService {

    List<Menu> queryMenuByRoleId(Integer roleId);

    List<Menu> queryMenuByParentId(@Param("parentId") Integer parentId,
                                   @Param("id") Integer roleId);
}

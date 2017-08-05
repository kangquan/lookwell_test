package cn.bdqn.tangcco.dao;

import cn.bdqn.tangcco.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMenuMapper {
    List<Menu> queryMenuByRoleId(Integer roleId);
    List<Menu> queryMenuByParentId(@Param("parentId") Integer parentId,
                                   @Param("roleId") Integer roleId);
}

package cn.bdqn.tangcco.Test;

import cn.bdqn.tangcco.entity.Menu;
import cn.bdqn.tangcco.entity.RoleUser;
import cn.bdqn.tangcco.entity.TbUser;
import cn.bdqn.tangcco.service.RoleMenuService;
import cn.bdqn.tangcco.service.TbuserService;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 */

public class TestLogin extends Base {
    @Inject
    private TbuserService tbuserService;
    @Inject
    private RoleMenuService roleMenuService;

    @Test
    public void testLogin() {
        RoleUser roleUser=tbuserService.login(new TbUser("admin", "1234"));
        System.out.println(roleUser);
    }

    @Test
    public void testQureryMenu() {
        List<Menu> menus = roleMenuService.queryMenuByRoleId(1);
        for (Menu menu1 : menus) {
            System.out.println(menu1+"...........");
        }
        List<Menu> menus1 = roleMenuService.queryMenuByParentId(1, 1);
        for (Menu menu : menus1) {
            System.out.println(menu);
        }


    }
}

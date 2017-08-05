package cn.bdqn.tangcco.entity;

/**
 * Created by Administrator on 2017/8/4.
 */

import java.util.Date;

/**
 * @Author: Mc
 * @Description: 角色-菜单表
 * @Date: 2017/08/04 15:11
 */

public class RoleMenu {

    /**
     * rolmen_idint(11) NOT NULL角色菜单ID
     * role_idint(11) NULL角色ID
     * menu_idint(11) NULL菜单ID
     * rolmen_descvarchar(30) NULL角色菜单描述
     * create_timedatetime NULL创建时间
     * update_timedatetime NULL修改时间
     */

    private Integer rolemenId;
    private Role role;
    private Menu menu;
    private String rolmenDesc;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "RoleMenu{" +
                "rolemenId=" + rolemenId +
                ", role=" + role +
                ", menu=" + menu +
                ", rolmenDesc='" + rolmenDesc + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public RoleMenu() {
    }

    public Integer getRolemenId() {
        return rolemenId;
    }

    public void setRolemenId(Integer rolemenId) {
        this.rolemenId = rolemenId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getRolmenDesc() {
        return rolmenDesc;
    }

    public void setRolmenDesc(String rolmenDesc) {
        this.rolmenDesc = rolmenDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

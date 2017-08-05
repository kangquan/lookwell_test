package cn.bdqn.tangcco.entity;

/**
 * Created by Administrator on 2017/8/4.
 */

import java.util.Date;

/**
 * @Author: Mc
 * @Description: 角色表
 * @Date: 2017/08/04 15:11
 */

public class Role {

    /**
     * role_idint(11) NOT NULL角色ID
     * role_namevarchar(20) NULL角色名称
     * role_levelint(11) NULL角色等级
     * role_statusint(11) NULL角色状态
     * create_timedatetime NULL创建时间
     * update_timedatetime NULL修改时间
     */

    private Integer roleId;
    private String roleName;
    private Integer roleLevel;
    private Integer roleStatus;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleLevel=" + roleLevel +
                ", roleStatus=" + roleStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Role() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
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

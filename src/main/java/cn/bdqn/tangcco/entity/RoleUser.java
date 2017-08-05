package cn.bdqn.tangcco.entity;

/**
 * Created by Administrator on 2017/8/4.
 */

import java.util.Date;

/**
 * @Author: Mc
 * @Description: 角色-用户表
 * @Date: 2017/08/04 15:11
 */

public class RoleUser {

    /**
     * roluse_idint(11) NOT NULL角色用户ID
     * user_idint(11) NULL用户ID
     * role_idint(11) NULL角色ID
     * roluse_descvarchar(30) NULL角色用户描述
     * create_timedatetime NULL创建时间
     * update_timedatetime NULL修改时间
     */

    private Integer roluseId;
    private TbUser tbuser;
    private Role role;
    private String roluseDesc;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "RoleUser{" +
                "roluseId=" + roluseId +
                ", tbuser=" + tbuser +
                ", role=" + role +
                ", roluseDesc='" + roluseDesc + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public RoleUser() {
    }

    public Integer getRoluseId() {
        return roluseId;
    }

    public void setRoluseId(Integer roluseId) {
        this.roluseId = roluseId;
    }

    public TbUser getTbuser() {
        return tbuser;
    }

    public void setTbuser(TbUser tbuser) {
        this.tbuser = tbuser;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getRoluseDesc() {
        return roluseDesc;
    }

    public void setRoluseDesc(String roluseDesc) {
        this.roluseDesc = roluseDesc;
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

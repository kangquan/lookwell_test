package cn.bdqn.tangcco.entity;

/**
 * Created by Administrator on 2017/8/4.
 */

import java.util.Date;

/**
 * @Author: Mc
 * @Description: 用户表
 * @Date: 2017/08/04 15:11
 */

public class TbUser {

    /**
     * user_idint(11) NOT NULL用户ID
     * usernamevarchar(30) NULL用户名称
     * passwordvarchar(15) NULL用户密码
     * last_logindatetime NULL最近登录的时间
     * create_timedatetime NULL创建时间
     * update_timedatetime NULL修改时间
     */

    private Integer userId;
    private String userName;
    private String passWord;
    private Date lastLogin;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "TbUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", lastLogin=" + lastLogin +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public TbUser() {
    }

    public TbUser(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
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

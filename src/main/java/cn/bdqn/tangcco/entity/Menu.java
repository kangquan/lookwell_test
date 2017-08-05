package cn.bdqn.tangcco.entity;

/**
 * Created by Administrator on 2017/8/4.
 */

import java.util.Date;

/**
 * @Author: Mc
 * @Description: 菜单表
 * @Date: 2017/08/04 15:11
 */
public class Menu {

    /**
     * menu_idint(11) NOT NULL菜单ID
     * menu_namevarchar(20) NULL菜单名称
     * menu_urlvarchar(50) NULL菜单url
     * parent_idint(11) NULL父ID
     * create_timedatetime NULL创建时间
     * update_timedatetime NULL修改时间
     */

    private Integer menuId;
    private String text;
    private String menuUrl;
    private Integer parentId;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", text='" + text + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", parentId=" + parentId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Menu() {
    }

    public Menu(Integer menuId, String text, String menuUrl, Integer parentId, Date createTime, Date updateTime) {
        this.menuId = menuId;
        this.text = text;
        this.menuUrl = menuUrl;
        this.parentId = parentId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

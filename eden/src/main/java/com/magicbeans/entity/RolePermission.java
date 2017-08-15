package com.magicbeans.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
public class RolePermission extends Model<RolePermission> {

    private static final long serialVersionUID = 1L;

//    @Column(length = 36)
    protected String id;

    @TableField(ignore = FieldIgnore.INSERT)
    protected Date createtime;

    @TableField(ignore = FieldIgnore.INSERT_UPDATE)
    protected Date updatetime;

    private String roleId;

    private Permission permission;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id='" + id + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", roleId='" + roleId + '\'' +
                ", permission=" + permission +
                '}';
    }
}

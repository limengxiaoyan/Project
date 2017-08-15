package com.magicbeans.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

//    @Column(length = 36)
    protected String id;

    @TableField(ignore = FieldIgnore.INSERT)
    protected Date createtime;

    @TableField(ignore = FieldIgnore.INSERT_UPDATE)
    protected Date updatetime;

    private String descriprion;

    private String url;

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

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", descriprion='" + descriprion + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

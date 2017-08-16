package com.magicbeans.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldIgnore;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author magic-beans
 * @since 2017-08-16
 */
@TableName("image_file")
public class ImageFile extends Model<ImageFile> {

    private static final long serialVersionUID = 1L;

	private String id;

	@TableField(ignore = FieldIgnore.INSERT)
	protected Date createtime;

	@TableField(ignore = FieldIgnore.INSERT_UPDATE)
	protected Date updatetime;

	@TableField("img_url")
	private String imgUrl;

	private String fromId;

	private Integer type;

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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ImageFile{" +
			"id=" + id +
			", createtime=" + createtime +
			", updatetime=" + updatetime +
			", imgUrl=" + imgUrl +
			", fromId=" + fromId +
			", type=" + type +
			"}";
	}
}

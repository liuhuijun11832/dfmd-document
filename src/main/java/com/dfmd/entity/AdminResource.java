package com.dfmd.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "admin_resource")
public class AdminResource implements Serializable {
    /**
     * 主键
     */
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源描述
     */
    private String description;

    /**
     * 资源访问的url
     */
    private String url;

    /**
     * 父资源ID，0-无父资源
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 启用状态 0-未启用 1-启用
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 资源类型 0-未知类型 1-菜单 2-按钮 3-图片
     */
    private Integer type;

    /**
     * 资源标识代码
     */
    private String code;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取资源名称
     *
     * @return name - 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资源名称
     *
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取资源描述
     *
     * @return description - 资源描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置资源描述
     *
     * @param description 资源描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取资源访问的url
     *
     * @return url - 资源访问的url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置资源访问的url
     *
     * @param url 资源访问的url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取父资源ID，0-无父资源
     *
     * @return parent_id - 父资源ID，0-无父资源
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父资源ID，0-无父资源
     *
     * @param parentId 父资源ID，0-无父资源
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取启用状态 0-未启用 1-启用
     *
     * @return status - 启用状态 0-未启用 1-启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置启用状态 0-未启用 1-启用
     *
     * @param status 启用状态 0-未启用 1-启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取资源类型 0-未知类型 1-菜单 2-按钮 3-图片
     *
     * @return type - 资源类型 0-未知类型 1-菜单 2-按钮 3-图片
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置资源类型 0-未知类型 1-菜单 2-按钮 3-图片
     *
     * @param type 资源类型 0-未知类型 1-菜单 2-按钮 3-图片
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取资源标识代码
     *
     * @return code - 资源标识代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置资源标识代码
     *
     * @param code 资源标识代码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AdminResource other = (AdminResource) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", url=").append(url);
        sb.append(", parentId=").append(parentId);
        sb.append(", status=").append(status);
        sb.append(", sort=").append(sort);
        sb.append(", type=").append(type);
        sb.append(", code=").append(code);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
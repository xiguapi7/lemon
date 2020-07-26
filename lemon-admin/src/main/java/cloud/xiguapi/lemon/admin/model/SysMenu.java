package cloud.xiguapi.lemon.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 菜单管理
 *
 * @author adanz
 */
@ApiModel(value = "cloud-xiguapi-lemon-model-SysMenu")
public class SysMenu {
	/**
	 * 编号
	 */
	@ApiModelProperty(value = "编号")
	private Long id;

	/**
	 * 菜单名称
	 */
	@ApiModelProperty(value = "菜单名称")
	private String name;

	/**
	 * 父菜单，一级菜单为0
	 */
	@ApiModelProperty(value = "父菜单，一级菜单为0")
	private Long parentId;

	/**
	 * 菜单URL，类型： 1.普通页面（如用户管理，/sys/user）
	 * 2.嵌套完整外部页面，以http(s)开头的链接
	 * 3. 嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控，iframe:/druid/login.html)
	 */
	@ApiModelProperty(value = "菜单URL，类型： 1.普通页面（如用户管理，/sys/user）,                                    2.嵌套完整外部页面，以http(s)开头的链接,                                    3. 嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控，iframe:/druid/login.html)")
	private String url;

	/**
	 * 授权(多个逗号分隔,如sys:user:add,sys:user:edit)
	 */
	@ApiModelProperty(value = "授权(多个逗号分隔,如sys:user:add,sys:user:edit)")
	private String perms;

	/**
	 * 类型： 0.目录， 1.菜单， 2.按钮
	 */
	@ApiModelProperty(value = "类型： 0.目录， 1.菜单， 2.按钮")
	private Integer type;

	/**
	 * 菜单图标
	 */
	@ApiModelProperty(value = "菜单图标")
	private String icon;

	/**
	 * 排序
	 */
	@ApiModelProperty(value = "排序")
	private Integer orderNum;

	/**
	 * 创建人
	 */
	@ApiModelProperty(value = "创建人")
	private String createBy;

	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	/**
	 * 更新人
	 */
	@ApiModelProperty(value = "更新人")
	private String lastUpdateBy;

	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	private Date lastUpdateTime;

	/**
	 * 是否删除: -1 删除, 0 正常
	 */
	@ApiModelProperty(value = "是否删除: -1 删除, 0 正常")
	private Byte delFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms == null ? null : perms.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Byte getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() +
				" [" +
				"Hash = " + hashCode() +
				", id=" + id +
				", name=" + name +
				", parentId=" + parentId +
				", url=" + url +
				", perms=" + perms +
				", type=" + type +
				", icon=" + icon +
				", orderNum=" + orderNum +
				", createBy=" + createBy +
				", createTime=" + createTime +
				", lastUpdateBy=" + lastUpdateBy +
				", lastUpdateTime=" + lastUpdateTime +
				", delFlag=" + delFlag +
				"]";
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
		SysMenu other = (SysMenu) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
				&& (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
				&& (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
				&& (this.getPerms() == null ? other.getPerms() == null : this.getPerms().equals(other.getPerms()))
				&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
				&& (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
				&& (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
				&& (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
				&& (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
				&& (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
		result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
		result = prime * result + ((getPerms() == null) ? 0 : getPerms().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
		result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
		result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
		result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
		result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
		return result;
	}
}
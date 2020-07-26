package cloud.xiguapi.lemon.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 字典表
 */
@ApiModel(value = "cloud-xiguapi-lemon-model-SysDict")
public class SysDict {
	/**
	 * 编号
	 */
	@ApiModelProperty(value = "编号")
	private Long id;

	/**
	 * 数据值
	 */
	@ApiModelProperty(value = "数据值")
	private String value;

	/**
	 * 标签名
	 */
	@ApiModelProperty(value = "标签名")
	private String label;

	/**
	 * 类型
	 */
	@ApiModelProperty(value = "类型")
	private String type;

	/**
	 * 描述
	 */
	@ApiModelProperty(value = "描述")
	private String description;

	/**
	 * 排序(升序)
	 */
	@ApiModelProperty(value = "排序(升序)")
	private Long sort;

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
	 * 备注信息
	 */
	@ApiModelProperty(value = "备注信息")
	private String remarks;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value == null ? null : value.trim();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label == null ? null : label.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	public Byte getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		String sb = getClass().getSimpleName() +
				" [" +
				"Hash = " + hashCode() +
				", id=" + id +
				", value=" + value +
				", label=" + label +
				", type=" + type +
				", description=" + description +
				", sort=" + sort +
				", createBy=" + createBy +
				", createTime=" + createTime +
				", lastUpdateBy=" + lastUpdateBy +
				", lastUpdateTime=" + lastUpdateTime +
				", remarks=" + remarks +
				", delFlag=" + delFlag +
				"]";
		return sb;
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
		SysDict other = (SysDict) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
				&& (this.getLabel() == null ? other.getLabel() == null : this.getLabel().equals(other.getLabel()))
				&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
				&& (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
				&& (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
				&& (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
				&& (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
				&& (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
				&& (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
		result = prime * result + ((getLabel() == null) ? 0 : getLabel().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
		result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
		result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
		result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
		result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
		result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
		return result;
	}
}
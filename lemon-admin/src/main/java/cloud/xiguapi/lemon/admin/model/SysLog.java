package cloud.xiguapi.lemon.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 系统操作日志
 */
@ApiModel(value = "cloud-xiguapi-lemon-model-SysLog")
public class SysLog {
	/**
	 * 编号
	 */
	@ApiModelProperty(value = "编号")
	private Long id;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
	private String userName;

	/**
	 * 用户操作
	 */
	@ApiModelProperty(value = "用户操作")
	private String operation;

	/**
	 * 请求方法
	 */
	@ApiModelProperty(value = "请求方法")
	private String method;

	/**
	 * 请求参数
	 */
	@ApiModelProperty(value = "请求参数")
	private String params;

	/**
	 * 执行时长
	 */
	@ApiModelProperty(value = "执行时长")
	private Long time;

	/**
	 * IP地址
	 */
	@ApiModelProperty(value = "IP地址")
	private String ip;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation == null ? null : operation.trim();
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method == null ? null : method.trim();
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params == null ? null : params.trim();
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", userName=").append(userName);
		sb.append(", operation=").append(operation);
		sb.append(", method=").append(method);
		sb.append(", params=").append(params);
		sb.append(", time=").append(time);
		sb.append(", ip=").append(ip);
		sb.append(", createBy=").append(createBy);
		sb.append(", createTime=").append(createTime);
		sb.append(", lastUpdateBy=").append(lastUpdateBy);
		sb.append(", lastUpdateTime=").append(lastUpdateTime);
		sb.append("]");
		return sb.toString();
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
		SysLog other = (SysLog) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
				&& (this.getOperation() == null ? other.getOperation() == null : this.getOperation().equals(other.getOperation()))
				&& (this.getMethod() == null ? other.getMethod() == null : this.getMethod().equals(other.getMethod()))
				&& (this.getParams() == null ? other.getParams() == null : this.getParams().equals(other.getParams()))
				&& (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
				&& (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
				&& (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
				&& (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
		result = prime * result + ((getOperation() == null) ? 0 : getOperation().hashCode());
		result = prime * result + ((getMethod() == null) ? 0 : getMethod().hashCode());
		result = prime * result + ((getParams() == null) ? 0 : getParams().hashCode());
		result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
		result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
		result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
		result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
		return result;
	}
}
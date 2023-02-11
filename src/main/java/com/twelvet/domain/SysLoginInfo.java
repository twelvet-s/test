package com.twelvet.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 系统访问记录表 sys_login_info
 */
public class SysLoginInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 用户账号
	 */
	private String userName;

	/**
	 * 状态 0成功 1失败
	 */
	private String status;

	/**
	 * 地址
	 */
	private String ipaddr;

	/**
	 * 描述
	 */
	private String msg;

	/**
	 * 访问时间
	 */
	private Date accessTime;

	/**
	 * 部门ID
	 */
	private Long deptId;

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long infoId) {
		this.id = infoId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}

	@Override
	public String toString() {
		return "SysLoginInfo{" + "id=" + id + ", userName='" + userName + '\'' + ", status=" + status
				+ ", ipaddr='" + ipaddr + '\'' + ", msg='" + msg + '\'' + ", accessTime=" + accessTime + ", deptId='"
				+ deptId + '\'' + '}';
	}

}

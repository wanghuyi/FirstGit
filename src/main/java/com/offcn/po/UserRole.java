package com.offcn.po;

import java.io.Serializable;

public class UserRole implements Serializable{
	 /**
     * ��id
     */
    private Long id;

    /**
     * �û�id
     */
    private Long userId;

    /**
     * ��ɫid
     */
    private Long roleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
    
}

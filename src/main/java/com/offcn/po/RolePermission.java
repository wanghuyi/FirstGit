package com.offcn.po;

import java.io.Serializable;

public class RolePermission implements Serializable{
	 /**
     * ��id
     */
    private Long id;

    /**
     * ��ɫid
     */
    private Long roleId;

    /**
     * Ȩ��id
     */
    private Long permissionId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}
    
    
}

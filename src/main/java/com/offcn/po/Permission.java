package com.offcn.po;

import java.io.Serializable;

public class Permission implements Serializable{
	 /**
     * Ȩ��id
     */
    private Long id;

    /**
     * ����url,��/user/add.action
     */
    private String url;

    /**
     * Ȩ����
     */
    private String permissionName;

    /**
     * Ȩ�ޱ�ʶ,�������ж�ʹ��,��"user:create"
     */
    private String permissionSign;

    /**
     * Ȩ������,UI������ʾʹ��
     */
    private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionSign() {
		return permissionSign;
	}

	public void setPermissionSign(String permissionSign) {
		this.permissionSign = permissionSign;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}

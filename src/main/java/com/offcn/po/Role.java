package com.offcn.po;

import java.io.Serializable;

public class Role implements Serializable {
	/**
     * ��ɫid
     */
    private Long id;

    /**
     * ��ɫ��
     */
    private String roleName;

    /**
     * ��ɫ��ʶ,�������ж�ʹ��,��"admin"
     */
    private String roleSign;

    /**
     * ��ɫ����,UI������ʾʹ��
     */
private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleSign() {
		return roleSign;
	}

	public void setRoleSign(String roleSign) {
		this.roleSign = roleSign;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}

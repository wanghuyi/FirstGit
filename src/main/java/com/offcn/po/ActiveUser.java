package com.offcn.po;

import java.io.Serializable;
import java.util.List;

public class ActiveUser implements Serializable{
	private String userid;//�û�id
	private String usercode;// �û��˺�	
	private List<Permission> permissions;// Ȩ��
	private List<Role> roles;//��ɫ   
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}

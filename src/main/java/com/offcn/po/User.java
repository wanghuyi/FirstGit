package com.offcn.po;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	/**
     * �û�id
     */
    private Long id;

    /**
     * �û���
     */
    private String username;

    /**
     * ����
     */
    private String password;

    /**
     * ״̬
     */
    private String state;

    /**
     * ����ʱ��
     */
private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}

package com.mayfarm.security.vo;

import lombok.Data;

@Data
public class UserVO {
	private String id;
	private String passwd;
	private String name;
	private String auth;
	private int enabled;
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", passwd=" + passwd + ", name=" + name + ", auth=" + auth + ", enabled="
				+ enabled + "]";
	}
}

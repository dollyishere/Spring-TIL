package com.dolly.spring.todouser.vo;

public class TodoUserVO {
	private String userId;
	private String userPwd;
	private String userName;
//	private String pwdHash;
//	private String pwdSalt;
	
	// 기본 생성자
	public TodoUserVO() {

	} // 기본 생성자 END
	
	// 생성자
	public TodoUserVO(String userId, String userPwd, String userName) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	} // 생성자 END

	// getter & setter
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*
	 * public String getPwdHash() { return pwdHash; }
	 * 
	 * public void setPwdHash(String pwdHash) { this.pwdHash = pwdHash; }
	 * 
	 * public String getPwdSalt() { return pwdSalt; }
	 * 
	 * public void setPwdSalt(String pwdSalt) { this.pwdSalt = pwdSalt; }
	 */
	// getter & setter END

	// toString() override
	@Override
	public String toString() {
		return "TodoUserVO [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName 
//				+ ", pwdHash=" + pwdHash + ", pwdSalt=" + pwdSalt 
				+ "]";
	} // toString() END
}

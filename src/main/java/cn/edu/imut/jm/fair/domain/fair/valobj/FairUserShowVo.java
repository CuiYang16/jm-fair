package cn.edu.imut.jm.fair.domain.fair.valobj;

public class FairUserShowVo {

	private Integer userId;

	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户电话
	 */
	private String userPhone;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public FairUserShowVo() {
		super();
	}

	public FairUserShowVo(Integer userId, String userName, String userPhone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
	}

}

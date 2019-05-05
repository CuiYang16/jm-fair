package cn.edu.imut.jm.fair.domain.fair.valobj;

import cn.edu.imut.jm.fair.domain.fair.entity.FairUser;

public class FairUserVo extends FairUser {

	private FairUserShowVo joinUser;

	public FairUserShowVo getJoinUser() {
		return joinUser;
	}

	public void setJoinUser(FairUserShowVo joinUser) {
		this.joinUser = joinUser;
	}

}

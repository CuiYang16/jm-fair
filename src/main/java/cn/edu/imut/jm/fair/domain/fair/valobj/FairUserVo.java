package cn.edu.imut.jm.fair.domain.fair.valobj;

import java.util.List;

import cn.edu.imut.jm.fair.domain.fair.entity.FairUser;

public class FairUserVo extends FairUser {

	private List<FairUserShowVo> users;

	public List<FairUserShowVo> getUsers() {
		return users;
	}

	public void setUsers(List<FairUserShowVo> users) {
		this.users = users;
	}

}

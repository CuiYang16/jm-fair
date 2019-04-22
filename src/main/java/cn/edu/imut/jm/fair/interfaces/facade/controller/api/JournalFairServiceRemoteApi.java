package cn.edu.imut.jm.fair.interfaces.facade.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.imut.jm.fair.domain.fair.valobj.FairUserShowVo;
import cn.edu.imut.jm.fair.domain.fair.valobj.ResponseVo;

@RequestMapping("/journal-fair")
public interface JournalFairServiceRemoteApi {

	@RequestMapping(value = "/fairinfos", method = RequestMethod.GET)
	ResponseVo<FairUserShowVo> selectFairInformations(@RequestParam("pageNum") Integer pageNum,
			@RequestParam("pageSize") Integer pageSize);
}

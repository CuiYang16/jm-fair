package cn.edu.imut.jm.fair.interfaces.facade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.imut.jm.fair.domain.fair.service.JournalFairService;
import cn.edu.imut.jm.fair.domain.fair.valobj.FairUserShowVo;
import cn.edu.imut.jm.fair.domain.fair.valobj.ResponseVo;
import cn.edu.imut.jm.fair.interfaces.facade.controller.api.JournalFairServiceRemoteApi;

@RestController
public class JournalFairController implements JournalFairServiceRemoteApi {

	@Autowired
	private JournalFairService journalFairService;

	@Override
	public ResponseVo<FairUserShowVo> selectFairInformations(@RequestParam("pageNum") Integer pageNum,
			@RequestParam("pageSize") Integer pageSize) {

		return new ResponseVo<>(journalFairService.selectFairInformations(pageNum, pageSize));
	}

}

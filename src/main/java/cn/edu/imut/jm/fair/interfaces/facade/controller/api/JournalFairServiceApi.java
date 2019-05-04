package cn.edu.imut.jm.fair.interfaces.facade.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.imut.jm.fair.domain.fair.valobj.FairUserShowVo;
import cn.edu.imut.jm.fair.domain.fair.valobj.ResponseVo;
import cn.edu.imut.jm.journal.domain.journal.valobj.JournalDetailVo;

@RequestMapping("/journal-fair")
public interface JournalFairServiceApi {

	@RequestMapping(value = "/fairinfos", method = RequestMethod.GET)
	ResponseVo<FairUserShowVo> selectFairInformations(@RequestParam("pageNum") Integer pageNum,
			@RequestParam("pageSize") Integer pageSize, @RequestParam("isDelete") Integer isDelete,
			@RequestParam("overdue") Integer overdue);

	@RequestMapping(value = "/fair-journals", method = RequestMethod.GET)
	ResponseVo<JournalDetailVo> getJournals();

	@RequestMapping(value = "/insert/fair-info", method = RequestMethod.POST)
	ResponseVo insertFairInfo(@RequestBody String json);

	@RequestMapping(value = "/upload/fairimg", method = { RequestMethod.POST, RequestMethod.GET })
	ResponseVo insertJouranlImgs(@RequestParam("fairInformationId") Integer fairInformationId,
			@RequestParam("file") MultipartFile fairImage);

	@RequestMapping(value = "/update-fair", method = RequestMethod.PUT)
	ResponseVo updateFairInfo(@RequestBody String json);

	@RequestMapping(value = "/update/fairimg", method = { RequestMethod.POST, RequestMethod.GET })
	ResponseVo updateJouranlImgs(@RequestParam("fairInformationId") Integer fairInformationId,
			@RequestParam("file") MultipartFile fairImage);

	@RequestMapping(value = "/del-fair", method = RequestMethod.DELETE)
	ResponseVo DelJournalFair(@RequestBody String json);

//	前端请求
	@RequestMapping(value = "/get/fairs", method = RequestMethod.GET)
	List<FairUserShowVo> selectFairInfos();

	@RequestMapping(value = "/insert/fair-user", method = RequestMethod.POST)
	Integer insertFairUser(@RequestBody String json);
}

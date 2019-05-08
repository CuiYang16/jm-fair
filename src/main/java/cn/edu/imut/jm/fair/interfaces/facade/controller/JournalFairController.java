package cn.edu.imut.jm.fair.interfaces.facade.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import cn.edu.imut.infrastructrue.util.JwtTokenUtil;
import cn.edu.imut.jm.fair.domain.fair.entity.FairInformation;
import cn.edu.imut.jm.fair.domain.fair.entity.FairUser;
import cn.edu.imut.jm.fair.domain.fair.facade.FairFacade;
import cn.edu.imut.jm.fair.domain.fair.service.JournalFairService;
import cn.edu.imut.jm.fair.domain.fair.valobj.FairUserShowVo;
import cn.edu.imut.jm.fair.domain.fair.valobj.JournalFairShowVo;
import cn.edu.imut.jm.fair.domain.fair.valobj.ResponseVo;
import cn.edu.imut.jm.fair.interfaces.facade.controller.api.JournalFairServiceApi;
import cn.edu.imut.jm.journal.domain.journal.valobj.JournalDetailVo;

@RestController
public class JournalFairController implements JournalFairServiceApi {

	private static final String FAIR_IMG_FILE_PATH = "F:/MyWorkSpace/bishe-vue/journal-door/static/fair-img/";

	@Autowired
	private JournalFairService journalFairService;
	@Autowired
	private FairFacade fairFacade;

	@Override
	public ResponseVo<FairUserShowVo> selectFairInformations(@RequestParam("pageNum") Integer pageNum,
			@RequestParam("pageSize") Integer pageSize, @RequestParam("isDelete") Integer isDelete,
			@RequestParam("overdue") Integer overdue) {
		if (isDelete == 2) {
			isDelete = null;
		}
		if (overdue == 2) {
			overdue = null;
		}
		return new ResponseVo<>(journalFairService.selectFairInformations(pageNum, pageSize, isDelete, overdue));
	}

	@Override
	public ResponseVo insertFairInfo(@RequestBody String json) {
		FairInformation fairInformation = JSON.toJavaObject(JSON.parseObject(json).getJSONObject("fairInformation"),
				FairInformation.class);
		String token = JSON.parseObject(json).getString("token");
		Integer userId = JwtTokenUtil.getUserId(token);
		fairInformation.setUserId(userId);
		;
		Integer insertFairInfo = journalFairService.insertFairInfo(fairInformation);

		return new ResponseVo<>(insertFairInfo, fairInformation.getFairInformationId().toString());
	}

	@Override
	public ResponseVo<JournalDetailVo> getJournals() {

		return new ResponseVo<JournalDetailVo>(fairFacade.getAllJournal());
	}

	@Override
	public ResponseVo insertJouranlImgs(@RequestParam("fairInformationId") Integer fairInformationId,
			@RequestParam("file") MultipartFile fairImage) {
		if (fairImage == null || fairImage.isEmpty()) {
			return new ResponseVo<>(0, "文件为空");
		}
		String fileName = System.currentTimeMillis() + "-journal-fair"
				+ fairImage.getOriginalFilename().substring(fairImage.getOriginalFilename().lastIndexOf("."));
		String filePath = FAIR_IMG_FILE_PATH + fileName;
		File file = new File(filePath);
		if (!file.getParentFile().exists()) { // 判断文件父目录是否存在
			file.getParentFile().mkdir();
		}
		if (fairImage.getOriginalFilename().endsWith(".jpg") || fairImage.getOriginalFilename().endsWith(".jpeg")
				|| fairImage.getOriginalFilename().endsWith(".png")) {
			try {
				fairImage.transferTo(file);
				return new ResponseVo<>(journalFairService.updateFairImage(fairInformationId, fileName), fileName);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return new ResponseVo(0, "上传失败，请重试");
			}
		} else {
			return new ResponseVo(0, "上传失败，只允许上传.jpg/.jpeg/.png图片");
		}
	}

	@Override
	public ResponseVo updateFairInfo(@RequestBody String json) {
		FairInformation fairInformation = JSON.toJavaObject(JSON.parseObject(json).getJSONObject("fairInformation"),
				FairInformation.class);
		return new ResponseVo<>(journalFairService.updateFairInfo(fairInformation));
	}

	@Override
	public ResponseVo updateJouranlImgs(@RequestParam("fairInformationId") Integer fairInformationId,
			@RequestParam("file") MultipartFile fairImage) {

		JournalFairShowVo fairInfoById = journalFairService.selectFairInfoById(fairInformationId);
		File delFile = new File(fairInfoById.getFairImg());
		if (delFile.exists() && delFile.isFile()) {
			if (!delFile.delete()) {
				return new ResponseVo<>(0, "图片操作失败");
			}

		}
		if (fairImage == null || fairImage.isEmpty()) {
			return new ResponseVo<>(0, "文件为空");
		}
		String fileName = System.currentTimeMillis() + "-journal-fair"
				+ fairImage.getOriginalFilename().substring(fairImage.getOriginalFilename().lastIndexOf("."));
		String filePath = FAIR_IMG_FILE_PATH + fileName;
		File file = new File(filePath);
		if (!file.getParentFile().exists()) { // 判断文件父目录是否存在
			file.getParentFile().mkdir();
		}
		if (fairImage.getOriginalFilename().endsWith(".jpg") || fairImage.getOriginalFilename().endsWith(".jpeg")
				|| fairImage.getOriginalFilename().endsWith(".png")) {
			try {
				fairImage.transferTo(file);
				return new ResponseVo<>(journalFairService.updateFairImage(fairInformationId, fileName), fileName);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return new ResponseVo(0, "上传失败，请重试");
			}
		} else {
			return new ResponseVo(0, "上传失败，只允许上传.jpg/.jpeg/.png图片");
		}
	}

	@Override
	public ResponseVo DelJournalFair(@RequestBody String json) {
		Integer fairInformationId = JSON.parseObject(json).getInteger("fairInformationId");
		Integer delType = JSON.parseObject(json).getInteger("delType");
		List<Integer> ids = JSON.parseArray(JSON.toJSONString(JSON.parseObject(json).getJSONArray("delIds")),
				Integer.class);
		if (delType == 1) {
			return new ResponseVo<>(journalFairService.updateJournalFairDel(fairInformationId));
		}
		if (delType == 2) {
			return new ResponseVo<>(journalFairService.deleteJournalFair(fairInformationId));

		}
		if (delType == 3) {
			return new ResponseVo<>(journalFairService.updateMultipleJournalFairDel(ids));
		}
		if (delType == 4) {
			return new ResponseVo<>(journalFairService.deleteMultipleJournal(ids));
		}
		return new ResponseVo<>(0);
	}

	@Override
	public PageInfo<FairUserShowVo> selectFairInfos(@RequestParam("pageNum") Integer pageNum,
			@RequestParam("pageSize") Integer pageSize) {

		return journalFairService.selectFairInfos(pageNum, pageSize);
	}

	@Override
	public Integer insertFairUser(@RequestBody String json) {
		Integer fairInformationId = JSON.parseObject(json).getInteger("fairInformationId");
		String token = JSON.parseObject(json).getString("token");
		Integer userId = JwtTokenUtil.getUserId(token);
		FairUser fairUser = new FairUser();
		fairUser.setFairInformationId(fairInformationId);
		fairUser.setUserId(userId);
		return journalFairService.insertFairUser(fairUser);
	}

	@Override
	public PageInfo<FairInformation> selectUserFairInfos(@RequestParam("pageNum") Integer pageNum,
			@RequestParam("pageSize") Integer pageSize, @RequestParam("token") String token) {
		Integer userId = JwtTokenUtil.getUserId(token);
		List<Integer> selectFairIdByUserId = journalFairService.selectFairIdByUserId(userId);
		if (selectFairIdByUserId != null && selectFairIdByUserId.size() > 0) {
			return journalFairService.selectFairById(selectFairIdByUserId, pageNum, pageSize);
		}
		return null;
	}

}

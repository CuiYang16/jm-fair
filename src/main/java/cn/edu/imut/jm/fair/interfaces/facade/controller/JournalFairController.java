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

/**
 * @Package cn.edu.imut.jm.fair.interfaces.facade.controller
 * @ClassName: JournalFairController
 * @Description: 书展controller
 * @author cuiyang
 */
@RestController
public class JournalFairController implements JournalFairServiceApi {

	// private static final String FAIR_IMG_FILE_PATH =
	// "C:/Users/Administrator/Desktop/journal-door/static/fair-img/";
	private static final String FAIR_IMG_FILE_PATH = "F:/MyWorkSpace/bishe-vue/journal-door/static/fair-img/";
	@Autowired
	private JournalFairService journalFairService;
	@Autowired
	private FairFacade fairFacade;

	/**
	 * 
	 * @Title: selectFairInformations
	 * @Description: 分页条件查询书展
	 * @override @see
	 *           cn.edu.imut.jm.fair.interfaces.facade.controller.api.JournalFairServiceApi#selectFairInformations(java.lang.Integer,
	 *           java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
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

	/**
	 * 
	 * @Title: insertFairInfo
	 * @Description: 新增书展信息
	 * @override @see
	 *           cn.edu.imut.jm.fair.interfaces.facade.controller.api.JournalFairServiceApi#insertFairInfo(java.lang.String)
	 */
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

	/**
	 * 
	 * @Title: insertJouranlImgs
	 * @Description: 插入书展图片
	 * @override @see
	 *           cn.edu.imut.jm.fair.interfaces.facade.controller.api.JournalFairServiceApi#insertJouranlImgs(java.lang.Integer,
	 *           org.springframework.web.multipart.MultipartFile)
	 */
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

	/**
	 * 
	 * @Title: updateFairInfo
	 * @Description: 编辑书展信息
	 * @override @see
	 *           cn.edu.imut.jm.fair.interfaces.facade.controller.api.JournalFairServiceApi#updateFairInfo(java.lang.String)
	 */
	@Override
	public ResponseVo updateFairInfo(@RequestBody String json) {
		FairInformation fairInformation = JSON.toJavaObject(JSON.parseObject(json).getJSONObject("fairInformation"),
				FairInformation.class);
		return new ResponseVo<>(journalFairService.updateFairInfo(fairInformation));
	}

	/**
	 * 
	 * @Title: updateJouranlImgs
	 * @Description: 更新书展图片
	 * @override @see
	 *           cn.edu.imut.jm.fair.interfaces.facade.controller.api.JournalFairServiceApi#updateJouranlImgs(java.lang.Integer,
	 *           org.springframework.web.multipart.MultipartFile)
	 */
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

	/**
	 * 
	 * @Title: fairChart
	 * @Description: 书展统计，包括总数和未过期数
	 * @override @see
	 *           cn.edu.imut.jm.fair.interfaces.facade.controller.api.JournalFairServiceApi#fairChart()
	 */
	@Override
	public ResponseVo fairChart() {

		return new ResponseVo<>(journalFairService.fairChart());
	}

	/**
	 * 
	 * @Title: DelJournalFair
	 * @Description: 删除书展
	 * @override @see
	 *           cn.edu.imut.jm.fair.interfaces.facade.controller.api.JournalFairServiceApi#DelJournalFair(java.lang.String)
	 */
	@Override
	public ResponseVo DelJournalFair(@RequestBody String json) {
		Integer fairInformationId = JSON.parseObject(json).getInteger("fairInformationId");
		Integer delType = JSON.parseObject(json).getInteger("delType");
		List<Integer> ids = JSON.parseArray(JSON.toJSONString(JSON.parseObject(json).getJSONArray("delIds")),
				Integer.class);
//		去激活
		if (delType == 1) {
			return new ResponseVo<>(journalFairService.updateJournalFairDel(fairInformationId));
		}
//		彻底删除
		if (delType == 2) {
			return new ResponseVo<>(journalFairService.deleteJournalFair(fairInformationId));

		}
//		批量去激活
		if (delType == 3) {
			return new ResponseVo<>(journalFairService.updateMultipleJournalFairDel(ids));
		}
//		批量删除
		if (delType == 4) {
			return new ResponseVo<>(journalFairService.deleteMultipleJournal(ids));
		}
		return new ResponseVo<>(0);
	}

	/**
	 * 
	 * @Title: selectFairInfos
	 * @Description: 分页查询未过期书展信息
	 * @override @see
	 *           cn.edu.imut.jm.fair.interfaces.facade.controller.api.JournalFairServiceApi#selectFairInfos(java.lang.Integer,
	 *           java.lang.Integer)
	 */
	@Override
	public PageInfo<FairUserShowVo> selectFairInfos(@RequestParam("pageNum") Integer pageNum,
			@RequestParam("pageSize") Integer pageSize) {

		return journalFairService.selectFairInfos(pageNum, pageSize);
	}

	/**
	 * 
	 * @Title: insertFairUser
	 * @Description: 报名参加书展
	 * @override @see
	 *           cn.edu.imut.jm.fair.interfaces.facade.controller.api.JournalFairServiceApi#insertFairUser(java.lang.String)
	 */
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

	/**
	 * 
	 * @Title: selectUserFairInfos
	 * @Description:查询用户已参加书展
	 * @override @see
	 *           cn.edu.imut.jm.fair.interfaces.facade.controller.api.JournalFairServiceApi#selectUserFairInfos(java.lang.Integer,
	 *           java.lang.Integer, java.lang.String)
	 */
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

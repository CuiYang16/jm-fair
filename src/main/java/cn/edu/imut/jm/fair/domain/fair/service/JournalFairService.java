package cn.edu.imut.jm.fair.domain.fair.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import cn.edu.imut.jm.fair.domain.fair.entity.FairInformation;
import cn.edu.imut.jm.fair.domain.fair.entity.FairUser;
import cn.edu.imut.jm.fair.domain.fair.valobj.FairUserShowVo;
import cn.edu.imut.jm.fair.domain.fair.valobj.JournalFairShowVo;

public interface JournalFairService {

	PageInfo<FairUserShowVo> selectFairInformations(Integer pageNum, Integer pageSize, Integer isDelete,
			Integer overdue);

	JournalFairShowVo selectFairInfoById(Integer fairInformationId);

	Integer insertFairInfo(FairInformation fairInformation);

	Integer updateFairImage(Integer fairInformationId, String fairImg);

	Integer updateFairInfo(FairInformation fairInformation);

	Integer updateJournalFairDel(Integer fairInformationId);

	Integer deleteJournalFair(Integer fairInformationId);

	Integer updateMultipleJournalFairDel(List<Integer> ids);

	Integer deleteMultipleJournal(List<Integer> ids);

	PageInfo<FairUserShowVo> selectFairInfos(Integer pageNum, Integer pageSize);

	String fairChart();

//	前端请求
	Integer insertFairUser(FairUser fairUser);

	List<Integer> selectFairIdByUserId(Integer userId);

	PageInfo<FairInformation> selectFairById(List<Integer> ids, Integer pageNum, Integer pageSize);
}

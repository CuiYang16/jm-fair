package cn.edu.imut.jm.fair.domain.fair.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.imut.jm.fair.domain.fair.dao.JournalFairDao;
import cn.edu.imut.jm.fair.domain.fair.entity.FairInformation;
import cn.edu.imut.jm.fair.domain.fair.service.JournalFairService;
import cn.edu.imut.jm.fair.domain.fair.valobj.FairUserShowVo;
import cn.edu.imut.jm.fair.domain.fair.valobj.JournalFairShowVo;

@Service
public class JournalFairServiceImpl implements JournalFairService {

	@Autowired
	private JournalFairDao journalFairDao;

	@Override
	public PageInfo<FairUserShowVo> selectFairInformations(Integer pageNum, Integer pageSize, Integer isDelete,
			Integer overdue) {

		PageHelper.startPage(pageNum, pageSize);

		List<FairUserShowVo> fairInformations = journalFairDao.selectFairInformations(isDelete, overdue);
		PageInfo<FairUserShowVo> pageInfo = new PageInfo<FairUserShowVo>(fairInformations);
		pageInfo.setPageNum(pageNum);
		pageInfo.setPageSize(pageSize);
		return pageInfo;
	}

	@Override
	public JournalFairShowVo selectFairInfoById(Integer fairInformationId) {
		if (fairInformationId != null && fairInformationId != 0) {
			return journalFairDao.selectFairInfoById(fairInformationId);
		}
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer insertFairInfo(FairInformation fairInformation) {
		if (fairInformation != null) {
			Integer insertFairInfo = journalFairDao.insertFairInfo(fairInformation);
			return insertFairInfo;
		}
		return null;
	}

	@Override
	public Integer updateFairImage(Integer fairInformationId, String fairImg) {
		if (fairInformationId != null && fairInformationId != 0 && fairImg != null && !fairImg.isEmpty()) {
			return journalFairDao.updateFairImage(fairInformationId, fairImg);
		}
		return null;
	}

	@Override
	public Integer updateFairInfo(FairInformation fairInformation) {
		if (fairInformation != null) {
			return journalFairDao.updateFairInfo(fairInformation);
		}
		return null;
	}

	@Override
	public Integer updateJournalFairDel(Integer fairInformationId) {
		if (fairInformationId != null && fairInformationId != 0) {
			return journalFairDao.updateJournalFairDel(fairInformationId);
		}
		return null;
	}

	@Override
	public Integer deleteJournalFair(Integer fairInformationId) {
		if (fairInformationId != null && fairInformationId != 0) {
			return journalFairDao.deleteJournalFair(fairInformationId);
		}
		return null;
	}

	@Override
	public Integer updateMultipleJournalFairDel(List<Integer> ids) {
		if (ids != null && ids.size() > 0) {
			return journalFairDao.updateMultipleJournalFairDel(ids);
		}
		return null;
	}

	@Override
	public Integer deleteMultipleJournal(List<Integer> ids) {
		if (ids != null && ids.size() > 0) {
			return journalFairDao.deleteMultipleJournal(ids);
		}
		return null;
	}

//	前端请求
	@Override
	public List<FairUserShowVo> selectFairInfos() {

		return journalFairDao.selectFairInfos();

	}

}

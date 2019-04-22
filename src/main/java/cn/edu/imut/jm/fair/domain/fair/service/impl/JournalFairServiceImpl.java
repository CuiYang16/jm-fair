package cn.edu.imut.jm.fair.domain.fair.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.imut.jm.fair.domain.fair.dao.JournalFairDao;
import cn.edu.imut.jm.fair.domain.fair.service.JournalFairService;
import cn.edu.imut.jm.fair.domain.fair.valobj.FairUserShowVo;

@Service
public class JournalFairServiceImpl implements JournalFairService {

	@Autowired
	private JournalFairDao journalFairDao;

	@Override
	public PageInfo<FairUserShowVo> selectFairInformations(Integer pageNum, Integer pageSize) {

		PageHelper.startPage(pageNum, pageSize);
		List<FairUserShowVo> fairInformations = journalFairDao.selectFairInformations();
		PageInfo<FairUserShowVo> pageInfo = new PageInfo<FairUserShowVo>(fairInformations);
		pageInfo.setPageNum(pageNum);
		pageInfo.setPageSize(pageSize);
		return pageInfo;
	}

}

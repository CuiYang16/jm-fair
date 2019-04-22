package cn.edu.imut.jm.fair.domain.fair.service;

import com.github.pagehelper.PageInfo;

import cn.edu.imut.jm.fair.domain.fair.valobj.FairUserShowVo;

public interface JournalFairService {

	PageInfo<FairUserShowVo> selectFairInformations(Integer pageNum, Integer pageSize);
}

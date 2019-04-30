package cn.edu.imut.jm.fair.domain.fair.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.edu.imut.jm.fair.domain.fair.entity.FairInformation;
import cn.edu.imut.jm.fair.domain.fair.valobj.FairUserShowVo;
import cn.edu.imut.jm.fair.domain.fair.valobj.JournalFairShowVo;

@Mapper
public interface JournalFairDao {

	List<FairUserShowVo> selectFairInformations(@Param("isDelete") Integer isDelete, @Param("overdue") Integer overdue);

	JournalFairShowVo selectFairInfoById(Integer fairInformationId);

	Integer insertFairInfo(FairInformation fairInformation);

	Integer updateFairImage(@Param("fairInformationId") Integer fairInformationId, @Param("fairImg") String fairImg);

	Integer updateFairInfo(FairInformation fairInformation);

	Integer updateJournalFairDel(Integer fairInformationId);

	Integer deleteJournalFair(Integer fairInformationId);

	Integer updateMultipleJournalFairDel(List<Integer> ids);

	Integer deleteMultipleJournal(List<Integer> ids);

//	前端请求接口
	List<FairUserShowVo> selectFairInfos();
}

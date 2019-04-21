package cn.edu.imut.jm.fair.domain.fair.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.edu.imut.jm.fair.domain.fair.entity.FairInformation;

@Mapper
public interface JournalFairDao {

	List<FairInformation> selectFairInformations();
}

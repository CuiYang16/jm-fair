package cn.edu.imut.jm.fair.domain.fair.valobj;

import java.util.Date;

public class JournalFairShowVo {

	/**
	 * 书展信息
	 */
	private Integer fairInformationId;

	/**
	 * 书展名称
	 */
	private String fairName;

	/**
	 * 书展主题
	 */
	private String fairTheme;

	/**
	 * 书展地点
	 */
	private String fairSite;

	/**
	 * 书展开始时间
	 */
	private Date fairStartTime;

	/**
	 * 书展结束时间
	 */
	private Date fairEndTime;

	/**
	 * 主办方
	 */
	private String fairHost;

	/**
	 * 赞助商
	 */
	private String sponsor;

	/**
	 * 承办者
	 */
	private String organizer;

	/**
	 * 是否已删除
	 */
	private Boolean isDelete;

	/**
	 * 用户外键（创建人）
	 */
	private Integer userId;

	/**
	 * 书展介绍
	 */
	private String fairDescribe;

}

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

	private FairUserShowVo fairUserShow;

	public Integer getFairInformationId() {
		return fairInformationId;
	}

	public void setFairInformationId(Integer fairInformationId) {
		this.fairInformationId = fairInformationId;
	}

	public String getFairName() {
		return fairName;
	}

	public void setFairName(String fairName) {
		this.fairName = fairName;
	}

	public String getFairTheme() {
		return fairTheme;
	}

	public void setFairTheme(String fairTheme) {
		this.fairTheme = fairTheme;
	}

	public String getFairSite() {
		return fairSite;
	}

	public void setFairSite(String fairSite) {
		this.fairSite = fairSite;
	}

	public Date getFairStartTime() {
		return fairStartTime;
	}

	public void setFairStartTime(Date fairStartTime) {
		this.fairStartTime = fairStartTime;
	}

	public Date getFairEndTime() {
		return fairEndTime;
	}

	public void setFairEndTime(Date fairEndTime) {
		this.fairEndTime = fairEndTime;
	}

	public String getFairHost() {
		return fairHost;
	}

	public void setFairHost(String fairHost) {
		this.fairHost = fairHost;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFairDescribe() {
		return fairDescribe;
	}

	public void setFairDescribe(String fairDescribe) {
		this.fairDescribe = fairDescribe;
	}

	public FairUserShowVo getFairUserShow() {
		return fairUserShow;
	}

	public void setFairUserShow(FairUserShowVo fairUserShow) {
		this.fairUserShow = fairUserShow;
	}

	public JournalFairShowVo() {
		super();
	}

}

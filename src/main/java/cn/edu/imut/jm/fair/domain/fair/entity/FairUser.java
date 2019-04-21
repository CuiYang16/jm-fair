package cn.edu.imut.jm.fair.domain.fair.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FairUser {
    /**
     * 书展用户
     */
    private Integer fairUserId;

    /**
     * 书展外键
     */
    private Integer fairInformationId;

    /**
     * 参加用户外键
     */
    private Integer userId;

    public Integer getFairUserId() {
        return fairUserId;
    }

    public void setFairUserId(Integer fairUserId) {
        this.fairUserId = fairUserId;
    }

    public Integer getFairInformationId() {
        return fairInformationId;
    }

    public void setFairInformationId(Integer fairInformationId) {
        this.fairInformationId = fairInformationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
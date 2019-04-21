package cn.edu.imut.jm.fair.domain.fair.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FairJournal {
    /**
     * 书展_资料
     */
    private Integer fairJournalId;

    /**
     * 书展外键
     */
    private Integer fairInformationId;

    /**
     * 资料外键
     */
    private Integer journalId;

    public Integer getFairJournalId() {
        return fairJournalId;
    }

    public void setFairJournalId(Integer fairJournalId) {
        this.fairJournalId = fairJournalId;
    }

    public Integer getFairInformationId() {
        return fairInformationId;
    }

    public void setFairInformationId(Integer fairInformationId) {
        this.fairInformationId = fairInformationId;
    }

    public Integer getJournalId() {
        return journalId;
    }

    public void setJournalId(Integer journalId) {
        this.journalId = journalId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
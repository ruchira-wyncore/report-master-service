package com.wyncore.mysql.rest.api.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * As repost_master table has  composite key UUID and report name , this is an ID class which is used
 * by JPA whenever the tables use composite keys.This class defines the composite key.
 */
public  class ReportMasterId implements Serializable {

    private UUID reportId;
    private String reportName;

    public ReportMasterId() {
    }

    public ReportMasterId(UUID reportId, String reportName) {
        this.reportId = reportId;
        this.reportName = reportName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportMasterId that = (ReportMasterId) o;
        return Objects.equals(reportId, that.reportId) &&
                Objects.equals(reportName, that.reportName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, reportName);
    }

    public UUID getReportId() {
        return reportId;
    }

    public void setReportId(UUID reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }
}


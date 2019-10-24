package com.wyncore.mysql.rest.api.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;
import java.util.UUID;

@Entity
@IdClass(ReportMasterId.class)
@Table(name = "report_master")
public class ReportMaster implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "report_id", columnDefinition = "BINARY(16)")
    private UUID reportId;

    @Id
    @Column(name = "report_name")
    @NotEmpty(message = "report_name can not be empty.")
    @Size(max = 250, message = "report_name can not be more than 250 characters.")
    private String reportName;

    @Column(name = "execution")
    @NotEmpty(message = "execution can not be empty.")
    @Size(max = 250, message = "execution can not be more than 250 characters.")
    private String execution;

    @Column(name = "server")
    @NotEmpty(message = "server can not be empty.")
    @Size(max = 250, message = "server can not be more than 250 characters.")
    private String server;

    @Column(name = "interval_time")
    @NotNull(message = "interval_time can not be empty.")
    private Time intervalTime;

    @Column(name = "interactive")
    @NotNull(message = "interactive can not be empty.")
    private Boolean isInteractive;


    public ReportMaster(UUID reportId, @NotBlank String reportName, @NotBlank String execution,
                        @NotBlank String server, @NotBlank Time intervalTime,
                        @NotBlank Boolean interactive) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.execution = execution;
        this.server = server;
        this.intervalTime = intervalTime;
        this.isInteractive = interactive;
    }

    public ReportMaster() {
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

    public String getExecution() {
        return execution;
    }

    public void setExecution(String execution) {
        this.execution = execution;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Time getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(Time intervalTime) {
        this.intervalTime = intervalTime;
    }

    public Boolean getInteractive() {
        return isInteractive;
    }

    public void setInteractive(Boolean interactive) {
        this.isInteractive = interactive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportMaster that = (ReportMaster) o;
        return Objects.equals(reportId, that.reportId) &&
                Objects.equals(reportName, that.reportName) &&
                Objects.equals(execution, that.execution) &&
                Objects.equals(server, that.server) &&
                Objects.equals(intervalTime, that.intervalTime) &&
                Objects.equals(isInteractive, that.isInteractive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, reportName, execution, server, intervalTime, isInteractive);
    }

}

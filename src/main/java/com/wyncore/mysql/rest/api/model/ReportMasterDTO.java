package com.wyncore.mysql.rest.api.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
/**
 * This is the json class which  is used to pass the report master object as json objects over the API calls
 */
public class ReportMasterDTO {

    /* used to send  database id */
    private UUID id;

    @JsonProperty("reportname")
    private String reportName;

    @JsonProperty("execution")
    private String execution;

    @JsonProperty("server")
    private String server;

    @JsonProperty("intervaltime")
    private String intervalTime;

    @JsonProperty("interactive")
    private String isInteractive;

    @JsonProperty("starttime")
    private String startTime;

    @JsonProperty("endtime")
    private String endTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(String intervalTime) {
        this.intervalTime = intervalTime;
    }

    public String getIsInteractive() {
        return isInteractive;
    }

    public void setIsInteractive(String isInteractive) {
        this.isInteractive = isInteractive;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
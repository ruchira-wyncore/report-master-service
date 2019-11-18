package com.wyncore.mysql.rest.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 * This is the json class which  is used to pass the report master object as json objects over the API calls.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
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

    /**
     * Getter for UUID.
     * @return :- UUID
     */
    public UUID getId() {
        return id;
    }

    /**
     * Setter for UUID.
     * @param id :- UUID
     */
    public void setId(final UUID id) {
        this.id = id;
    }

    /**
     * Getter for report name.
     * @return :- Report name
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * Setter for report name.
     * @param reportName :- report name
     */
    public void setReportName(final String reportName) {
        this.reportName = reportName;
    }

    /**
     * Getter for execution type.
     * @return :- execution type.
     */
    public String getExecution() {
        return execution;
    }

    /**
     *  Setter for execution type.
     * @param execution :- Execution type.
     */
    public void setExecution(final String execution) {
        this.execution = execution;
    }

    /**
     * Getter for server name.
     * @return :- server name.
     */
    public String getServer() {
        return server;
    }

    /**
     * Setter for server name.
     * @param server :- server name.
     */
    public void setServer(final String server) {
        this.server = server;
    }

    /**
     * Getter for interval time.
     * @return :- interval time.
     */
    public String getIntervalTime() {
        return intervalTime;
    }

    /**
     * Setter for interval time.
     * @param intervalTime :- interval time.
     */
    public void setIntervalTime(final String intervalTime) {
        this.intervalTime = intervalTime;
    }

    /**
     * Getter for interactive.
     * @return :- interactive property.
     */
    public String getIsInteractive() {
        return isInteractive;
    }

    /**
     * Setter for interactive property.
     * @param isInteractive :- interactive value.
     */
    public void setIsInteractive(final String isInteractive) {
        this.isInteractive = isInteractive;
    }

    /**
     * Getter for  start time.
     * @return :- strat time value
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Setter for start time.
     * @param startTime :- start time.
     */
    public void setStartTime(final String startTime) {
        this.startTime = startTime;
    }

    /**
     * Getter for end time.
     * @return :- end time.
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Setter for end time.
     * @param endTime :- end time.
     */
    public void setEndTime(final String endTime) {
        this.endTime = endTime;
    }
}

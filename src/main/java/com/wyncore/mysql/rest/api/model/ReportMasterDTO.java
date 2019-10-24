package com.wyncore.mysql.rest.api.model;

import java.util.UUID;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ReportMasterDTO {
/* used to send database id */

        /* used to send  database id */
        private UUID id;

        @JsonProperty("report_name")
        private String reportName;

        @JsonProperty("execution")
        private String execution;

        @JsonProperty("server")
        private String server;

        @JsonProperty("interval_time")
        private String intervalTime;

        @JsonProperty("interactive")
        private String isInteractive;

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

    public ReportMasterDTO( String reportName, String execution, String server, String intervalTime, String isInteractive) {
        this.reportName = reportName;
        this.execution = execution;
        this.server = server;
        this.intervalTime = intervalTime;
        this.isInteractive = isInteractive;
    }

    public ReportMasterDTO() {
    }
}
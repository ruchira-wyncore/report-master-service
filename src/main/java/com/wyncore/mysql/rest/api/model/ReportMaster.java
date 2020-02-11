package com.wyncore.mysql.rest.api.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This is a POJO class for report-master fields in the mysql table. Each field is mapped to the one
 * in the report_master table
 */
@Entity
@IdClass(ReportMasterId.class)
@Table(name = "report_master")
public class ReportMaster implements Serializable {

  private static final int MAX_STRING_LENGTH = 250;
  private static final int MAX_ID_LENGTH =  150;

  @Id
  @Column(name = "report_id")
  @NotEmpty(message = "reportId can not be empty.")
  @Size(max = MAX_ID_LENGTH, message = "reportId can not be more than 150 characters.")
  private String reportId;

  @Id
  @Column(name = "reportname")
  @NotEmpty(message = "reportName can not be empty.")
  @Size(max = MAX_STRING_LENGTH, message = "reportName can not be more than 250 characters.")
  private String reportName;

  @Column(name = "execution")
  @NotEmpty(message = "execution can not be empty.")
  @Size(max = MAX_STRING_LENGTH, message = "execution can not be more than 250 characters.")
  private String execution;

  @Column(name = "server")
  @NotEmpty(message = "server can not be empty.")
  @Size(max = MAX_STRING_LENGTH, message = "server can not be more than 250 characters.")
  private String server;

  @Column(name = "intervaltime")
  @NotNull(message = "intervalTime can not be empty.")
  private int intervalTime;

  @Column(name = "interactive")
  @NotNull(message = "interactive can not be empty.")
  private Boolean isInteractive;

  @Column(name = "starttime")
  @NotNull(message = "startTime can not be empty.")
  private Time startTime;

  @Column(name = "endtime")
  @NotNull(message = "endTime can not be empty.")
  private Time endTime;

  /**
   * Constructor for report master.
   *
   * @param reportId     :- report id.
   * @param reportName   :- report name.
   * @param execution    :- execution type.
   * @param server       :- server name.
   * @param intervalTime :- interval time.
   * @param interactive  :- interactive property.
   * @param startTime    :- start time.
   * @param endTime      :- end time.
   */
  public ReportMaster(final String reportId, final @NotBlank String reportName,
      final @NotBlank String execution,
      final @NotBlank String server,
      final @NotBlank int intervalTime,
      final @NotBlank Boolean interactive,
      final @NotBlank Time startTime,
      final @NotBlank Time endTime) {
    this.reportId = reportId;
    this.reportName = reportName;
    this.execution = execution;
    this.server = server;
    this.intervalTime = intervalTime;
    this.isInteractive = interactive;
    this.startTime = startTime;
    this.endTime = endTime;

  }

  /**
   * Default constructor.
   */
  public ReportMaster() {
  }

  /**
   * Getter for the report ID.
   *
   * @return report ID
   */
  public String getReportId() {
    return reportId;
  }

  /**
   * Setter  for the report ID.
   *
   * @param reportId : Report ID of the report.
   */
  public void setReportId(final String reportId) {
    this.reportId = reportId;
  }

  /**
   * Getter for Report Name.
   *
   * @return : Report for the name.
   */
  public String getReportName() {
    return reportName;
  }

  /**
   * Setter for the report name.
   *
   * @param reportName : Report name
   */
  public void setReportName(final String reportName) {
    this.reportName = reportName;
  }

  /**
   * Getter for the execution.
   *
   * @return :- Getter for execution
   */
  public String getExecution() {
    return execution;
  }

  /**
   * Setter for the execution.
   *
   * @param execution :- execution type
   */
  public void setExecution(final String execution) {
    this.execution = execution;
  }

  /**
   * Getter for the server.
   *
   * @return : server name
   */
  public String getServer() {
    return server;
  }

  /**
   * Setter for server.
   *
   * @param server : Name of the server
   */
  public void setServer(final String server) {
    this.server = server;
  }

  /**
   * Getter for the interval time.
   *
   * @return interval time.
   */
  public int getIntervalTime() {
    return intervalTime;
  }

  /**
   * Setter for the interval time.
   *
   * @param intervalTime : interval time
   */
  public void setIntervalTime(final int intervalTime) {
    this.intervalTime = intervalTime;
  }

  /**
   * Getter for interactive.
   *
   * @return :- interactive property.
   */
  public Boolean getInteractive() {
    return isInteractive;
  }

  /**
   * Setter for interactive property.
   *
   * @param interactive :- interactive
   */
  public void setInteractive(final Boolean interactive) {
    this.isInteractive = interactive;
  }

  /**
   * Getter for start time.
   *
   * @return :- returns start time
   */
  public Time getStartTime() {
    return startTime;
  }

  /**
   * Setter for start time.
   *
   * @param startTime :- start time
   */
  public void setStartTime(final Time startTime) {
    this.startTime = startTime;
  }

  /**
   * Getter for end time.
   *
   * @return : end time
   */
  public Time getEndTime() {
    return endTime;
  }

  /**
   * Setter for end time.
   *
   * @param endTime : end time
   */
  public void setEndTime(final Time endTime) {
    this.endTime = endTime;
  }

    /**
   * comparison of objects.
   *
   * @param o :- object to be compared.
   * @return :- true or false.
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReportMaster that = (ReportMaster) o;
    return Objects.equals(reportId, that.reportId)
        && Objects.equals(reportName, that.reportName)
        && Objects.equals(execution, that.execution)
        && Objects.equals(server, that.server)
        && Objects.equals(intervalTime, that.intervalTime)
        && Objects.equals(startTime, that.startTime)
        && Objects.equals(endTime, that.endTime)
        && Objects.equals(isInteractive, that.isInteractive);
  }

  /**
   * Generates hash code.
   *
   * @return :- generated hash code.
   */
  @Override
  public int hashCode() {
    return Objects.hash(reportId, reportName, execution, server,
         intervalTime, isInteractive, startTime, endTime);
  }

}

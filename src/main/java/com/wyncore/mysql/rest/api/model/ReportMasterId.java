package com.wyncore.mysql.rest.api.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * As report_master table has  composite key UUID and report name , this is an ID class which is
 * used by JPA whenever the tables use composite keys.This class defines the composite key.
 */
public class ReportMasterId implements Serializable {

  private UUID reportId;
  private String reportName;

  /**
   * Default constructor.
   */
  public ReportMasterId() {
  }

  /**
   * Parametrized constructor.
   *
   * @param reportId   :- UUID of the report.
   * @param reportName :- Report Name.
   */
  public ReportMasterId(final UUID reportId, final String reportName) {
    this.reportId = reportId;
    this.reportName = reportName;
  }

  /**
   * This is an override for equals.
   *
   * @param o
   * @return :- true or false depending on the comparison.
   */
  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReportMasterId that = (ReportMasterId) o;
    return Objects.equals(reportId, that.reportId)
        && Objects.equals(reportName, that.reportName);
  }

  /**
   * This is for hash code.
   *
   * @return the generated hash code.
   */
  @Override
  public int hashCode() {
    return Objects.hash(reportId, reportName);
  }

  /**
   * Getter for report id.
   *
   * @return :- generated report id.
   */
  public UUID getReportId() {
    return reportId;
  }

  /**
   * Setter for report ID.
   *
   * @param reportId :- generated UUID.
   */
  public void setReportId(final UUID reportId) {
    this.reportId = reportId;
  }

  /**
   * Getter for report name.
   *
   * @return :- Report Name
   */
  public String getReportName() {
    return reportName;
  }

  /**
   * Setter for report Name.
   *
   * @param reportName :- Report Name.
   */
  public void setReportName(final String reportName) {
    this.reportName = reportName;
  }
}


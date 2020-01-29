package com.wyncore.mysql.rest.api.repository;

import com.wyncore.mysql.rest.api.model.ReportMaster;
import com.wyncore.mysql.rest.api.model.ReportMasterId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is the repository class used by JPA to connect to DB.
 */
@Repository
public interface ReportMasterRepository extends JpaRepository<ReportMaster, ReportMasterId> {

  /**
   * Find all records based on a given report name.
   *
   * @param reportName :- Report Name
   * @return :- List of records.
   */
  List<ReportMaster> findAllRecordsByReportName(String reportName);

  /**
   * Find a record based on report name.
   *
   * @param reportName :- Report Name
   * @return :- Record with the given report name.
   */
  ReportMaster findRecordByReportName(String reportName);


}

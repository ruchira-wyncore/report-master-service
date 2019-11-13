package com.wyncore.mysql.rest.api.repository;

import com.wyncore.mysql.rest.api.model.ReportMaster;
import com.wyncore.mysql.rest.api.model.ReportMasterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
/**
 * This is the repository class used by JPA to connect to DB
 */
public interface ReportMasterRepository extends JpaRepository<ReportMaster, ReportMasterId> {

    List<ReportMaster> findAllRecordsByReportName(String reportName);
    ReportMaster findRecordByReportName(String reportName);


}

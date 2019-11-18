package com.wyncore.mysql.rest.api.service;

import com.wyncore.mysql.rest.api.model.ReportMaster;
import com.wyncore.mysql.rest.api.model.ReportMasterDTO;
import com.wyncore.mysql.rest.api.repository.ReportMasterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This is the service class which is used to save the record in report master table.
 */
@Service
public class ReportMasterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportMasterService.class);

    @Autowired
    private ReportMasterRepository reportMasterRepository;


    /**
     * This method adds a report entry in the report_master table.
     * @param reportMasterDTO :- Object to be added
     * @return :- The added object
     */
    public ReportMasterDTO addReport(final ReportMasterDTO reportMasterDTO) {
        ReportMaster reportMasterObject = new ReportMaster();
        reportMasterObject.setExecution(reportMasterDTO.getExecution());
        reportMasterObject.setInteractive(Boolean.parseBoolean(reportMasterDTO.getIsInteractive()));
        reportMasterObject.setReportName(reportMasterDTO.getReportName());
        reportMasterObject.setServer(reportMasterDTO.getServer());
        reportMasterObject.setIntervalTime(Integer.parseInt(reportMasterDTO.getIntervalTime()));
        reportMasterObject.setStartTime(java.sql.Time.valueOf(reportMasterDTO.getStartTime()));
        reportMasterObject.setEndTime(java.sql.Time.valueOf(reportMasterDTO.getEndTime()));
        reportMasterRepository.save(reportMasterObject);
        reportMasterDTO.setId(reportMasterObject.getReportId());
        return reportMasterDTO;
    }

    /**
     * This method gets all the records from report_master table.
     * @return :- List of all the records in the table.
     */
    public List<ReportMaster> viewReports() {
       return  reportMasterRepository.findAll();
    }

    /**
     * This method deletes the record from report_master table based on the name of the report.
     * @param reportName :- Report Name
     */
    public void deleteReportByName(final String reportName) {
        List<ReportMaster> records = reportMasterRepository.findAllRecordsByReportName(reportName);
        reportMasterRepository.deleteAll(records);
    }

    /**
     * This method updates a record based on report name by using PUT.
     * @param reportName : Name of the report.
     * @param reportMasterDTO :- The JSON representation of the data to be updated.
     * @return :- The updated record.
     */
    public ResponseEntity<?> updateReportByName(final String reportName, final ReportMasterDTO reportMasterDTO) {
        ReportMaster reportMasterRecord =  reportMasterRepository.findRecordByReportName(reportName);

        if (reportMasterRecord == null) {
            LOGGER.error("Unable to update. Record with report name {} not found.", reportName);
            return new ResponseEntity("Unable to update. Record with report name " + reportName, HttpStatus.NOT_FOUND);
        }
        reportMasterRecord.setServer(reportMasterDTO.getServer());
        reportMasterRecord.setIntervalTime(Integer.parseInt(reportMasterDTO.getIntervalTime()));
        reportMasterRecord.setStartTime(java.sql.Time.valueOf(reportMasterDTO.getStartTime()));
        reportMasterRecord.setEndTime(java.sql.Time.valueOf(reportMasterDTO.getEndTime()));
        reportMasterRepository.save(reportMasterRecord);
        return new ResponseEntity<>(reportMasterRecord, HttpStatus.OK);
    }
}

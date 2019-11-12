package com.wyncore.mysql.rest.api.service;

import com.wyncore.mysql.rest.api.model.ReportMaster;
import com.wyncore.mysql.rest.api.model.ReportMasterDTO;
import com.wyncore.mysql.rest.api.repository.ReportMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
/**
 * This is the service class which is used to save the record in report master table.
 */
public class ReportMasterService {

    @Autowired
    private ReportMasterRepository reportMasterRepository;

    /**
     * This method adds a report entry in the report_master table.
     * @param reportMasterDTO:- Object to be added
     * @return :- The added object
     */
    public ReportMasterDTO addReport(ReportMasterDTO reportMasterDTO){

        System.out.println("report master DTO");
        System.out.println(reportMasterDTO.getServer());

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
        //System.out.println("report id is");
        //System.out.println((reportMasterObject.getReportId()));
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
     * @param reportName
     */
    public void deleteReportByName(String reportName) {
        List<ReportMaster> records = reportMasterRepository.findByReportName(reportName);
        reportMasterRepository.deleteAll(records);
    }
}

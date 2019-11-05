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

    public ReportMasterDTO addReport(ReportMasterDTO reportMasterDTO){
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

    public List<ReportMaster> viewReports() {
       return  reportMasterRepository.findAll();
    }
}

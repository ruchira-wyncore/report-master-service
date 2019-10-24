package com.wyncore.mysql.rest.api.service;

import com.wyncore.mysql.rest.api.model.ReportMaster;
import com.wyncore.mysql.rest.api.model.ReportMasterDTO;
import com.wyncore.mysql.rest.api.repository.ReportMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class ReportMasterService {

    @Autowired
    private ReportMasterRepository reportMasterRepository;

    public ReportMasterDTO addReport(ReportMasterDTO reportMasterDTO){
        ReportMaster reportMasterObject = new ReportMaster();
        reportMasterObject.setExecution(reportMasterDTO.getExecution());
        reportMasterObject.setInteractive(Boolean.parseBoolean(reportMasterDTO.getIsInteractive()));
        reportMasterObject.setReportName(reportMasterDTO.getReportName());
        reportMasterObject.setServer(reportMasterDTO.getServer());
        reportMasterObject.setIntervalTime(java.sql.Time.valueOf(reportMasterDTO.getIntervalTime()));
        reportMasterRepository.save(reportMasterObject);
        reportMasterDTO.setId(reportMasterObject.getReportId());
        System.out.println("report id is");
        System.out.println(reportMasterObject.getReportId());
        return reportMasterDTO;
    }
}

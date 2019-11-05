package com.wyncore.mysql.rest.api.controller;

import com.wyncore.mysql.rest.api.model.ReportMaster;
import com.wyncore.mysql.rest.api.model.ReportMasterDTO;
import com.wyncore.mysql.rest.api.service.ReportMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/report/master")
/**
 * This is a restful controller which accepts the API calls.
 */
public class ReportMasterController {

    @Autowired
    private ReportMasterService reportMasterService;

    //Add a new report in report_master table using post
    @RequestMapping(
            value = "/add",
            produces = "application/json",
            method = {RequestMethod.GET, RequestMethod.POST})
    @Transactional
    public ResponseEntity<ReportMasterDTO> createReport(@Valid @RequestBody ReportMasterDTO reportMasterDTO){
        return ResponseEntity.ok(reportMasterService.addReport(reportMasterDTO));
    }

    //Get all the records  in report_master table using get
    @RequestMapping(
            value = "/get/all",
            produces = "application/json",
            method = {RequestMethod.GET})
    @Transactional
    public ResponseEntity<List<ReportMaster>> viewAllReports(){
        return ResponseEntity.ok(reportMasterService.viewReports());
    }

}

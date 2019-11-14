package com.wyncore.mysql.rest.api.controller;

import com.wyncore.mysql.rest.api.model.ReportMaster;
import com.wyncore.mysql.rest.api.model.ReportMasterDTO;
import com.wyncore.mysql.rest.api.service.ReportMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/report/master")
/**
 * This is a restful controller which accepts the API calls for adding, updating, deleting and viewing the records
 * from the report_master table.
 */
public class ReportMasterController {
    private static final Logger logger = LoggerFactory.getLogger(ReportMasterController.class);

    @Autowired
    private ReportMasterService reportMasterService;

    //Add a new report in report_master table using post
    @RequestMapping(
            value = "/add",
            produces = "application/json",
            method = {RequestMethod.GET, RequestMethod.POST})
    @Transactional
    public ResponseEntity<ReportMasterDTO> createReport(@Valid @RequestBody ReportMasterDTO reportMasterDTO){
        logger.info("Post API being called to add record");
        return ResponseEntity.ok(reportMasterService.addReport(reportMasterDTO));
    }

    //Get all the records  in report_master table using get
    @RequestMapping(
            value = "/get/all",
            produces = "application/json",
            method = {RequestMethod.GET})
    @Transactional
    public ResponseEntity<List<ReportMaster>> viewAllReports(){
        logger.info("Get API being called to view all records");
        return ResponseEntity.ok(reportMasterService.viewReports());
    }

    //Delete the record in report_master based on report name.
    @RequestMapping(
            value = "/delete/{id}",
            produces = "application/json",
            method = {RequestMethod.DELETE})
    @Transactional
    public void deleteReport(@PathVariable("id") String id){
        logger.info("Delete API is called to delete the record based on report name {} ", id);
        reportMasterService.deleteReportByName(id);
    }

    //Update an existing record in report_master based on report name.
    @RequestMapping(
            value = "/update/{id}",
            produces = "application/json",
            method = {RequestMethod.PUT})
    @Transactional
    public ResponseEntity<?> updateRecord(@PathVariable("id") String id, @RequestBody ReportMasterDTO reportMasterDTO) {
        logger.info("PUT API is called to update an existing record in the database table for the report name {}", id);
        return ResponseEntity.ok(reportMasterService.updateReportByName(id, reportMasterDTO));
    }

}

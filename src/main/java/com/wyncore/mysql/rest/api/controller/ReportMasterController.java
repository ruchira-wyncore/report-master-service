package com.wyncore.mysql.rest.api.controller;

import com.wyncore.mysql.rest.api.exception.DbException;
import com.wyncore.mysql.rest.api.model.ReportMaster;
import com.wyncore.mysql.rest.api.model.ReportMasterDTO;
import com.wyncore.mysql.rest.api.service.ReportMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.validation.Valid;
import java.util.List;

/**
 * This is a restful controller which accepts the API calls for adding,
 * updating, deleting and viewing the records
 * from the report_master table.
 */
@RestController
@RequestMapping("/api/report/master")
public class ReportMasterController {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(ReportMasterController.class);

    @Autowired
    private ReportMasterService reportMasterService;
    /**
     *  Add a new report in report_master table using POST.
     * @param reportMasterDTO :- The record to be added in JSON format
     * @return :- successfully added record.
     */
    @RequestMapping(
            value = "/add",
            produces = "application/json",
            method = {RequestMethod.GET, RequestMethod.POST})
    @Transactional
    public ResponseEntity<?> createReport(
            @Valid @RequestBody final ReportMasterDTO reportMasterDTO) {
        LOGGER.info("Post API being called to add record");
        try {
            return ResponseEntity.ok(reportMasterService.addReport(reportMasterDTO));
        } catch (DbException e) {
            return new ResponseEntity("Unable to add the new record due to the following error  " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get all the records  in report_master table using GET.
     * @return : all the existing records in report_master table;
     */
    @RequestMapping(
            value = "/get/all",
            produces = "application/json",
            method = {RequestMethod.GET})
    @Transactional
    public ResponseEntity<List<ReportMaster>> viewAllReports() {
        LOGGER.info("Get API being called to view all records");
        return ResponseEntity.ok(reportMasterService.viewReports());
    }


    /**
     * Deletes a record in report_master based on report name.
     * @param id : Name of the report to be deleted.
     */
    @RequestMapping(
            value = "/delete/{id}",
            produces = "application/json",
            method = {RequestMethod.DELETE})
    @CrossOrigin(origins = "http://localhost:4200")
    @Transactional
    public void deleteReport(@PathVariable("id") final String id) {
        LOGGER.info("Delete API is called to delete the record based on report name {} ", id);
        reportMasterService.deleteReportByName(id);
    }

    /**
     * Updates an existing record in report_master based on report name.
     * @param id : Name of the report to be updated
     * @param reportMasterDTO : The data to be updated in JSON format.
     * @return :- Return the updated record in JSON format.
     */
    @RequestMapping(
            value = "/update/{id}",
            produces = "application/json",
            method = {RequestMethod.PUT})
    @Transactional
    public ResponseEntity<?> updateRecord(@PathVariable("id")
                                          final String id,
                                          @RequestBody final ReportMasterDTO reportMasterDTO) {
        LOGGER.info("PUT API is called to update an existing record in the database table"
                    + " for the report name {}", id);
        try {
            return reportMasterService.updateReportByName(id, reportMasterDTO);
        } catch (DbException e) {
             return new ResponseEntity("Unable to update. Record with report name " + id, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}

package com.wyncore.mysql.rest.api.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.wyncore.mysql.rest.api.exception.DbException;
import com.wyncore.mysql.rest.api.model.ReportMaster;
import com.wyncore.mysql.rest.api.model.ReportMasterDTO;
import com.wyncore.mysql.rest.api.service.ReportMasterService;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)
class ReportMasterControllerTest {

  @Mock
  private ReportMasterService reportMasterService;

  @InjectMocks
  private ReportMasterController reportMasterController;

  private ReportMaster report1 = new ReportMaster();
  private ReportMaster report2 = new ReportMaster();
  private ReportMasterDTO reportMasterDTO = new ReportMasterDTO();


  @BeforeEach
  public void setup() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

    report1.setExecution("execution");
    report1.setReportId("c81d4e2e-bcf2-11e6-869b-7df92533d2db");
    report1.setIntervalTime(1234);
    report1.setInteractive(false);
    report1.setServer("IBM");
    report1.setReportName("warehouse1");
    report1.setStartTime(Time.valueOf("01:00:00"));
    report1.setEndTime(Time.valueOf("02:00:00"));
    report1.setExecution("execution");

    report2.setReportId("c81d4e2e-bcf2-11e6-869b-7df92533d2db");
    report2.setIntervalTime(1234);
    report2.setInteractive(false);
    report2.setServer("IBM");
    report2.setReportName("warehouse2");
    report2.setStartTime(Time.valueOf("01:00:00"));
    report2.setEndTime(Time.valueOf("02:00:00"));

    reportMasterDTO.setExecution("execution");
    reportMasterDTO.setId("c81d4e2e-bcf2-11e6-869b-7df92533d2db");
    reportMasterDTO.setIntervalTime("08");
    reportMasterDTO.setIsInteractive("false");
    reportMasterDTO.setServer("IBM");
    reportMasterDTO.setReportName("warehouse1");
    reportMasterDTO.setStartTime("08:00:00");
    reportMasterDTO.setEndTime("09:00:00");
  }

  @Test
  public void testPost() throws DbException {
    when(reportMasterService.addReport(any(ReportMasterDTO.class))).thenReturn(reportMasterDTO);
    ResponseEntity<?> responseEntity = reportMasterController.createReport(reportMasterDTO);
    assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    assertThat(responseEntity.getBody().toString().contains("warehouse1"));
  }

  @Test
  public void testGetAll() {
    List<ReportMaster> list = new ArrayList<>();
    list.add(report1);
    list.add(report2);
    when(reportMasterService.viewReports()).thenReturn(list);
    ResponseEntity<List<ReportMaster>> responseEntity = reportMasterController.viewAllReports();
    assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    assertThat(responseEntity.getBody().size()).isEqualTo(2);
  }

  @Test
  public void testDeleteByReportName() {
    reportMasterController.deleteReport("abc");
  }

  @Test
  public void testUpdateByReportName() throws DbException {
    when(reportMasterService.updateReportByName(any(String.class), any(ReportMasterDTO.class)))
        .thenReturn(new ResponseEntity(report1, HttpStatus.OK));
    ResponseEntity<?> responseEntity = reportMasterController
        .updateRecord("warehouse1", reportMasterDTO);
    assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
  }

  @Test
  public void testUpdateByReportNameFails() throws DbException {
    when(reportMasterService.updateReportByName(any(String.class), any(ReportMasterDTO.class)))
        .thenThrow(new DbException());
    ResponseEntity<?> responseEntity = reportMasterController
        .updateRecord("warehouse9", reportMasterDTO);
    assertTrue(
        responseEntity.getBody().toString().contains("Unable to update. Record with report name"));
  }

  @Test
  public void testPostFailure() throws DbException {
    when(reportMasterService.addReport(any(ReportMasterDTO.class))).thenThrow(new DbException());
    ResponseEntity<?> responseEntity = reportMasterController.createReport(reportMasterDTO);
    assertTrue(responseEntity.getBody().toString()
        .contains("Unable to add the new record due to the following error "));
  }

  @Test
  public void testGetServerUrlSuccess() throws DbException {
    when(reportMasterService.getServerUrlByReportId(anyString())).thenReturn("as400");
    String server = reportMasterController.getServerUrl("id");
    assertEquals("as400", server);
  }

  @Test
  public void testGetServerUrlFailure() throws DbException {
   when(reportMasterService.getServerUrlByReportId(anyString())).thenThrow(new DbException("record not found"));
    String server = reportMasterController.getServerUrl("id");
    assertEquals("URL not found", server);
  }
}
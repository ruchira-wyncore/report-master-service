package com.wyncore.mysql.rest.api.controller;


import com.wyncore.mysql.rest.api.model.ReportMaster;
import com.wyncore.mysql.rest.api.model.ReportMasterDTO;
import com.wyncore.mysql.rest.api.service.ReportMasterService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportMasterControllerTest {

    @Mock
    private ReportMasterService reportMasterService;

    @InjectMocks
    private ReportMasterController reportMasterController;

    @Test
    public void testPost(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ReportMasterDTO reportMasterDTO = new ReportMasterDTO();
        reportMasterDTO.setExecution("execution");
        reportMasterDTO.setId(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"));
        reportMasterDTO.setIntervalTime("08");
        reportMasterDTO.setIsInteractive("false");
        reportMasterDTO.setServer("IBM");
        reportMasterDTO.setReportName("warehouse1");
        reportMasterDTO.setStartTime("08:00:00");
        reportMasterDTO.setEndTime("09:00:00");
        when(reportMasterService.addReport(any(ReportMasterDTO.class))).thenReturn(reportMasterDTO);
        ResponseEntity<ReportMasterDTO> responseEntity = reportMasterController.createReport(reportMasterDTO);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().getReportName().equals("warehouse1"));
    }

    @Test
    public void testGetAll(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ReportMaster report1 = new ReportMaster();
        ReportMaster report2 = new ReportMaster();
        report1.setExecution("execution");
        report1.setReportId(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"));
        report1.setIntervalTime(1234);
        report1.setInteractive(false);
        report1.setServer("IBM");
        report1.setReportName("warehouse1");
        report1.setStartTime(Time.valueOf("01:00:00"));
        report1.setEndTime(Time.valueOf("02:00:00"));
        report1.setExecution("execution");
        report2.setReportId(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"));
        report2.setIntervalTime(1234);
        report2.setInteractive(false);
        report2.setServer("IBM");
        report2.setReportName("warehouse2");
        report2.setStartTime(Time.valueOf("01:00:00"));
        report2.setEndTime(Time.valueOf("02:00:00"));
        List <ReportMaster> list = new ArrayList<>();
        list.add(report1);
        list.add(report2);
        when(reportMasterService.viewReports()).thenReturn(list);
        ResponseEntity<List<ReportMaster>> responseEntity = reportMasterController.viewAllReports();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().size()).isEqualTo(2);
    }

    @Test
    public void testDeleteByReportName() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
      //  doNothing().when((reportMasterService.deleteReportByName(any(String.class))));
        reportMasterController.deleteReport("abc");
    }
}
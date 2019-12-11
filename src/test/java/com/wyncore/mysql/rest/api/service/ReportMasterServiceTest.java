package com.wyncore.mysql.rest.api.service;

import com.wyncore.mysql.rest.api.exception.DbException;
import com.wyncore.mysql.rest.api.model.ReportMaster;
import com.wyncore.mysql.rest.api.model.ReportMasterDTO;
import com.wyncore.mysql.rest.api.repository.ReportMasterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportMasterServiceTest {

    @Mock
    private ReportMasterRepository reportMasterRepository;

    @InjectMocks
    private ReportMasterService reportMasterService;

    private ReportMasterDTO reportMasterDTO = new ReportMasterDTO();
    private ReportMasterDTO reportMasterDTOResult = new ReportMasterDTO();
    private ResponseEntity<?> responseEntity ;
    private ReportMaster report1 = new ReportMaster();

    @BeforeEach
    public void setup(){
        reportMasterDTO.setExecution("execution");
        reportMasterDTO.setId(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"));
        reportMasterDTO.setIntervalTime("08");
        reportMasterDTO.setIsInteractive("false");
        reportMasterDTO.setServer("IBM");
        reportMasterDTO.setReportName("warehouse1");
        reportMasterDTO.setStartTime("08:00:00");
        reportMasterDTO.setEndTime("09:00:00");

        report1.setExecution("execution");
        report1.setReportId(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"));
        report1.setIntervalTime(1234);
        report1.setInteractive(false);
        report1.setServer("IBM");
        report1.setReportName("warehouse1");
        report1.setStartTime(Time.valueOf("01:00:00"));
        report1.setEndTime(Time.valueOf("02:00:00"));
        report1.setExecution("execution");
    }

    @Test
    public void testPostServiceSuccessful() throws DbException {
        when(reportMasterRepository.save(any())).thenReturn(report1);
        reportMasterDTOResult = reportMasterService.addReport(reportMasterDTO);
        assertEquals("execution", reportMasterDTOResult.getExecution());
        assertEquals("false", reportMasterDTOResult.getIsInteractive());
        assertEquals("IBM", reportMasterDTOResult.getServer());
        assertEquals("false", reportMasterDTOResult.getIsInteractive());
        assertEquals("08", reportMasterDTOResult.getIntervalTime());
        assertEquals("warehouse1", reportMasterDTOResult.getReportName());
        assertEquals("08:00:00", reportMasterDTOResult.getStartTime());
        assertEquals("09:00:00", reportMasterDTOResult.getEndTime());
    }

    @Test
    public void testGetService(){
        List<ReportMaster> reportList = reportMasterService.viewReports();
        assertNotNull(reportList);
    }

    @Test
    // This test is purely for the purpose of coverage.It doesn't verify any thing.
    public void testDeleteService(){
        reportMasterService.deleteReportByName("abc");
    }

    @Test
    public void testUpdateSuccess() throws DbException {
        when(reportMasterRepository.findRecordByReportName(any(String.class))).thenReturn(report1);
        when(reportMasterRepository.save(any())).thenReturn(report1);
        responseEntity = reportMasterService.updateReportByName("warehouse1",reportMasterDTO);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testUpdateFailureDueToSaveFailure() {
        when(reportMasterRepository.findRecordByReportName(any(String.class))).thenReturn(report1);
        assertThrows(DbException.class, () -> {
        responseEntity = reportMasterService.updateReportByName("warehouse1",reportMasterDTO);
        });
    }

    @Test
    public void testUpdateFailureDueToRecordNotFound()  {
        assertThrows(DbException.class, () -> {
            responseEntity = reportMasterService.updateReportByName("warehouse9",reportMasterDTO);
        });
    }

    @Test
    public void testPostFailureDueToSaveFailure()  {
        assertThrows(DbException.class, () -> {
            ReportMasterDTO addedDTO = reportMasterService.addReport(reportMasterDTO);
        });
    }

}
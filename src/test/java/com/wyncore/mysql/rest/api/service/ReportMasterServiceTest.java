package com.wyncore.mysql.rest.api.service;

import com.wyncore.mysql.rest.api.model.ReportMaster;
import com.wyncore.mysql.rest.api.model.ReportMasterDTO;
import com.wyncore.mysql.rest.api.repository.ReportMasterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ReportMasterServiceTest {

    @Mock
    private ReportMasterRepository reportMasterRepository;

    @InjectMocks
    private ReportMasterService reportMasterService;

    @Test
    public void testPostService(){
        ReportMasterDTO reportMasterDTO = new ReportMasterDTO();
        ReportMasterDTO reportMasterDTOResult = new ReportMasterDTO();

        reportMasterDTO.setExecution("execution");
        reportMasterDTO.setId(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"));
        reportMasterDTO.setIntervalTime("08");
        reportMasterDTO.setIsInteractive("false");
        reportMasterDTO.setServer("IBM");
        reportMasterDTO.setReportName("warehouse1");
        reportMasterDTO.setStartTime("08:00:00");
        reportMasterDTO.setEndTime("09:00:00");
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

}
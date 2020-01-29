package com.wyncore.mysql.rest.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ReportMasterDTOTest {

  @Test
  public void testReportMasterDTO() {

    ReportMasterDTO reportMasterDTO = new ReportMasterDTO();
    reportMasterDTO.setExecution("execution");
    reportMasterDTO.setId(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"));
    reportMasterDTO.setIntervalTime("08");
    reportMasterDTO.setIsInteractive("false");
    reportMasterDTO.setServer("IBM");
    reportMasterDTO.setReportName("warehouse1");
    reportMasterDTO.setStartTime("08:00:00");
    reportMasterDTO.setEndTime("09:00:00");
    assertEquals("execution", reportMasterDTO.getExecution());
    assertEquals(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"), reportMasterDTO.getId());
    assertEquals("false", reportMasterDTO.getIsInteractive());
    assertEquals("IBM", reportMasterDTO.getServer());
    assertEquals("false", reportMasterDTO.getIsInteractive());
    assertEquals("08", reportMasterDTO.getIntervalTime());
    assertEquals("warehouse1", reportMasterDTO.getReportName());
    assertEquals("08:00:00", reportMasterDTO.getStartTime());
    assertEquals("09:00:00", reportMasterDTO.getEndTime());
  }

}
package com.wyncore.mysql.rest.api.model;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Time;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReportMasterTest {

    public void testReportMater(){
        ReportMaster reportMaster = new ReportMaster();
        reportMaster.setExecution("execution");
        reportMaster.setReportId(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"));
        reportMaster.setIntervalTime(1234);
        reportMaster.setInteractive(false);
        reportMaster.setServer("IBM");
        reportMaster.setReportName("warehouse1");
        reportMaster.setStartTime(Time.valueOf("01:00:00"));
        reportMaster.setEndTime(Time.valueOf("02:00:00"));
        assertEquals("execution", reportMaster.getExecution());
        assertEquals(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"), reportMaster.getReportId());
        assertEquals(false, reportMaster.getInteractive());
        assertEquals("IBM", reportMaster.getServer());
        assertEquals("08:00:00", reportMaster.getIntervalTime());
        assertEquals("warehouse1", reportMaster.getReportName());
        assertEquals(1234, reportMaster.getIntervalTime());
        assertEquals(Time.valueOf("01:00:00"), reportMaster.getStartTime());
        assertEquals(Time.valueOf("02:00:00"), reportMaster.getEndTime());




    }

}
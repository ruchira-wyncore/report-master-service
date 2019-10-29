package com.wyncore.mysql.rest.api.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Time;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReportMasterTest {

    @Test
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
        assertEquals("warehouse1", reportMaster.getReportName());
        assertEquals(1234, reportMaster.getIntervalTime());
        assertEquals(Time.valueOf("01:00:00"), reportMaster.getStartTime());
        assertEquals(Time.valueOf("02:00:00"), reportMaster.getEndTime());
    }

    @Test
    public void testEquals_Hash() {
        ReportMaster x = new ReportMaster(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"), "warehouse1","execution","IBM",1234, false,Time.valueOf("01:00:00"),Time.valueOf("01:00:00"));
        ReportMaster y = new ReportMaster(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"), "warehouse1","execution","IBM",1234, false,Time.valueOf("01:00:00"),Time.valueOf("01:00:00"));
        Assert.assertTrue(x.equals(y) && y.equals(x));
        Assert.assertTrue(x.hashCode() == y.hashCode());
    }


}
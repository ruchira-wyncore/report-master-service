package com.wyncore.mysql.rest.api.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ReportMasterIdTest {

    @Test
    public void testReportMasterID(){

        ReportMasterId reportMasterId= new ReportMasterId();
        reportMasterId.setReportId(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"));
        reportMasterId.setReportName("warehouse1");
        assertEquals(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"), reportMasterId.getReportId());
        assertEquals("warehouse1", reportMasterId.getReportName());
        ReportMasterId reportMasterId1 = new ReportMasterId(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"), "warehouse1");
        assertEquals(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"), reportMasterId.getReportId());
        assertEquals("warehouse1", reportMasterId.getReportName());
    }

    @Test
    public void testEquals_Hash() {
        ReportMasterId x = new ReportMasterId(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"), "warehouse1");
        ReportMasterId y = new ReportMasterId(UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db"), "warehouse1");
        Assert.assertTrue(x.equals(y) && y.equals(x));
        Assert.assertTrue(x.hashCode() == y.hashCode());
    }

}
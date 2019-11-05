package com.wyncore.mysql.rest.api.controller;


import com.wyncore.mysql.rest.api.model.ReportMasterDTO;
import com.wyncore.mysql.rest.api.service.ReportMasterService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportMasterControllerTest {

    @Mock
    private ReportMasterService reportMasterService;

    @InjectMocks
    private ReportMasterController reportMasterController;

    // This test is purely for coverage.
    @Test
    public void testController(){
        reportMasterController.createReport(new ReportMasterDTO());
        reportMasterController.viewAllReports();

    }

}
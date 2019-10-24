package com.wyncore.mysql.rest.api.repository;

import com.wyncore.mysql.rest.api.model.ReportMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReportMasterRepository extends JpaRepository<ReportMaster, String> {
}

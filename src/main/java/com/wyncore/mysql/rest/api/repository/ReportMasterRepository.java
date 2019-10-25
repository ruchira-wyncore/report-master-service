package com.wyncore.mysql.rest.api.repository;

import com.wyncore.mysql.rest.api.model.ReportMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
/**
 * This is the repository class used by JPA to connect to DB
 */
public interface ReportMasterRepository extends JpaRepository<ReportMaster, String> {
}

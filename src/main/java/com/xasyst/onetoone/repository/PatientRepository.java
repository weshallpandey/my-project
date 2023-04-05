package com.xasyst.onetoone.repository;

import com.xasyst.onetoone.entity.PatientEntity;
import com.xasyst.onetoone.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
//    List<PersonEntity> findByActiveTrue();

    @Override
    @Query(value = "UPDATE PatientEntity a SET a.deleted = true WHERE a.patientId = ?1")
    @Modifying
    void deleteById(Long patientId);
}

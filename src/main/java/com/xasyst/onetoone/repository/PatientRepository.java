package com.xasyst.onetoone.repository;

import com.xasyst.onetoone.entity.PatientEntity;
import com.xasyst.onetoone.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    Optional<PatientEntity> findByPatientIdAndDeletedFalse(Long patientId);

    @Override

//    @Query("UPDATE PatientEntity a JOIN PersonEntity b ON a.patientId = b.patientId SET a.deleted = true, b.active = false WHERE a.patientId = ?1")
@Query("UPDATE PatientEntity a SET a.deleted = true WHERE a.patientId = ?1")
    @Modifying
    void deleteById(Long patientId);



}


//    List<PatientEntity> findByActiveTrue();




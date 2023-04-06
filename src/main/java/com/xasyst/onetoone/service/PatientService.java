package com.xasyst.onetoone.service;


import com.xasyst.onetoone.entity.PatientEntity;
import com.xasyst.onetoone.entity.PersonEntity;
import com.xasyst.onetoone.mapper.PatientMapper;
import com.xasyst.onetoone.model.Patient;
import com.xasyst.onetoone.model.PatientResponse;
import com.xasyst.onetoone.model.Person;
import com.xasyst.onetoone.repository.PatientRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Log4j2
@Service
public class PatientService {
    private PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }


    public PatientResponse createPatient(Patient patient) {
        log.info(patient);
        PatientEntity patientEntity = patientMapper.toEntity(patient);
        patientRepository.save(patientEntity);
        log.info("patient entity save successfully{}", patientEntity);
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setPatientId(patientEntity.getPatientId());
        return patientResponse;
    }

    public Patient getPatientById(Long patientId) {
        log.info("Finding Person By Given Id");
        Optional<PatientEntity> patientEntity = patientRepository.findByPatientIdAndDeletedFalse(patientId);
        Patient getPatient = new Patient();
        if (patientEntity.isPresent()) {
            getPatient = patientMapper.toModel(patientEntity.get());
            log.info("Patient got successfully.");
        }
        return getPatient;
    }

//        public List<Patient> getAllPatients() {
//        log.info("Fetching all Patients.");
//        List<PatientEntity> patientEntities = patientRepository.findByDeletedFalse();
//        List<Patient> getAllPatients = patientMapper.entityToModel(patientEntities);
//        return getAllPatients();
//    }
    public void deleteById(Long patientId) {
        patientRepository.deleteById(patientId);
        log.info("patient deleted succesfully");
    }

    public void updatePerson(Long patientId, Patient patient) {
        log.info("fetching persons");
        Optional<PatientEntity> patientEntity = patientRepository.findById(patientId);

        if (patientEntity.isPresent()) {
            PatientEntity patientEntity1 = patientMapper.toEntity(patient);
            patientEntity1.setPatientId(patientEntity.get().getPatientId());
            patientRepository.save(patientEntity1);
            log.info("Person updated successfully.");
        }
    }

}


package com.xasyst.onetoone.service;


import com.xasyst.onetoone.entity.PatientEntity;
import com.xasyst.onetoone.mapper.PatientMapper;
import com.xasyst.onetoone.model.Patient;
import com.xasyst.onetoone.model.PatientResponse;
import com.xasyst.onetoone.repository.PatientRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


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
        log.info("patient entity save successfully{}",patientEntity);
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setPatientId(patientEntity.getPatientId());
        return patientResponse;
    }

    public void deleteById(Long patientId) {
        patientRepository.deleteById(patientId);
        log.info("patient deleted succesfully");
    }
}


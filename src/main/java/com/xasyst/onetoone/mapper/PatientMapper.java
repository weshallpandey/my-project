package com.xasyst.onetoone.mapper;

import com.xasyst.onetoone.entity.PatientEntity;
import com.xasyst.onetoone.entity.PersonEntity;
import com.xasyst.onetoone.model.Patient;
import com.xasyst.onetoone.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientEntity toEntity(Patient patient);

    List<Patient> entityToModel(List<PatientEntity> patientEntities);

    Patient toModel(PatientEntity patientEntity);
}

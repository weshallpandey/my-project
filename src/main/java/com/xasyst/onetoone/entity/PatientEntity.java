package com.xasyst.onetoone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private Long patientId;
    private Boolean deleted= Boolean.FALSE;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private PersonEntity personEntity;
}

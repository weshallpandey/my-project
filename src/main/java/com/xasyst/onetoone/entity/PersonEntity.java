package com.xasyst.onetoone.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "preferred_name")
    private String preferredName;
    @Column(name = "birth_date")
    private Integer birthDate;
    private String gender;
    @Column(name = "birth_sex")
    private String birthSex;
    @Column(name = "marital_status")
    private String maritalStatus;
    @Column(name = "photo_url")
    private String photoUrl;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "phone_no")
    private Integer phoneNo;
    private boolean expired = Boolean.FALSE;
    @Column(name = "expiredDate")
    private Integer expired_date;
    private boolean active = Boolean.TRUE;

    @OneToOne( fetch =FetchType.LAZY,mappedBy = "personEntity")
    private PatientEntity patientEntity;
}

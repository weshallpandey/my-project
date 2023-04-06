package com.xasyst.onetoone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Size(max = 100, message = "First name maximum 100 character")
    private String firstName;
    @Size(max = 50, message = "Middle name maximum 50 character")
    private String middleName;
    @Size(max = 50, message = "Last name maximum 50 character")
    private String lastName;
    @Size(max = 50, message = "Preferred name maximum 50 character")
    private String preferredName;
    private Integer birthDate;
    @Size(max = 15, message = "Gender maximum 15 character")
    private String gender;
    @Size(max = 15, message = "Birth Sex maximum 15 character")
    private String birthSex;
    private String maritalStatus;
    @Size(max = 255, message = "Email Id maximum 255 character")
    private String emailId;
    private Integer phoneNo;
    private boolean active;
    @Size(max = 255, message = "Photo URL maximum 255 character")
    private String photoUrl;
    private boolean expired;
    private Integer expired_date;
}

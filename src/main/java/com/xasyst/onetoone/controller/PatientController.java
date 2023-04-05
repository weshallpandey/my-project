package com.xasyst.onetoone.controller;


import com.xasyst.onetoone.model.Patient;
import com.xasyst.onetoone.model.PatientResponse;
import com.xasyst.onetoone.service.PatientService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PatientController {
    @Autowired
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping(value="/patients",produces =MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponse> createPatient(@RequestBody Patient patient){
        PatientResponse patientResponse = patientService.createPatient(patient);
        return new ResponseEntity<>(patientResponse, HttpStatus.CREATED);
    }
//    @GetMapping(value ="/persons/{personId}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Patient> getPersonById(@PathVariable Long personId){
//        Patient patient = patientService.getPersonById(personId);
//        return new ResponseEntity<>(patient,HttpStatus.FOUND);
//    }


//    @GetMapping("/persons")
//    public List<Patient>getAllPersons(){
//        return patientService.getAllPersons();
//    }
//    @PutMapping(value = "/person/{personId}")
//    public ResponseEntity<Patient> updatePerson(@PathVariable Long personId, @RequestBody Patient patient){
//        Patient personRequests = patientService.updatePerson(personId, patient);
//        return new ResponseEntity<>(personRequests,HttpStatus.ACCEPTED);
//    }
//
//

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @DeleteMapping(path = "/patients/{patientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<String> deleteById(@PathVariable Long patientId) {
        patientService.deleteById(patientId);
        return new ResponseEntity<>("remove patient successfully", HttpStatus.OK);
    }
}
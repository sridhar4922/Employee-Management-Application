package com.employeemanagement.employeemanagement.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "ARStaffDetails")          //For MONGO ENTITY
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffEntity {

    @Id
    private int employeeId;

    private String firstName;
    private String lastName;
    private String employeeEmail;
    private String jobLocation;
    private String department;
    private String address;

    //GETTER and Setter, Constructor, toString() handled by LOMBOK



}


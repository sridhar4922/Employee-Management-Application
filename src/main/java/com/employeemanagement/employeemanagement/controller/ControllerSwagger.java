package com.employeemanagement.employeemanagement.controller;


import com.employeemanagement.employeemanagement.entity.StaffEntity;
import com.employeemanagement.employeemanagement.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ControllerSwagger {

    @Autowired
    private StaffService staffService;

    //Method to save Staff using SwaggerUI
    @PostMapping("/saveNewStaff")
    public StaffEntity saveStaff(@RequestBody StaffEntity staff){
        return staffService.saveEmployee(staff);
    }

    //Method to display all Staff using Swagger UI
    @GetMapping("/allStaff")
    public List<StaffEntity> getAllStaffs(){
        return  staffService.getAllStaff();
    }

    //Method to get staffById using Swagger UI
    @GetMapping("/staffById/{employeeId}")
    public Optional<StaffEntity> getStaffById(@RequestParam int employeeId){
        return staffService.findByStaffId(employeeId);
    }

    //Method to Update Staff using SwaggerUI
    @PutMapping("/updateStaff/{employeeId}")
    public StaffEntity updateStaffById(@PathVariable int employeeId,@RequestBody StaffEntity staff){
        return staffService.updateStaffById(employeeId,staff);
    }

    //Method to Delete Staff using SwaggerUI
    @DeleteMapping("/deleteStaff/{employeeId}")
    public void deleteStaff(@RequestParam int employeeId){
        staffService.deleteStaff(employeeId);
    }
}

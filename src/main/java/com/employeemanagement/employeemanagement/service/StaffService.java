package com.employeemanagement.employeemanagement.service;

import com.employeemanagement.employeemanagement.entity.StaffEntity;
import com.employeemanagement.employeemanagement.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    //to add employee
    public StaffEntity saveEmployee(StaffEntity staffEntity){
        return  staffRepository.save(staffEntity);
    }

    //Method to Display Product From Database
    public List<StaffEntity> getAllStaff(){
        return staffRepository.findAll();
    }

    //Method to find Employee by ID
    public Optional<StaffEntity> findByStaffId(int employeeId){
        return staffRepository.findById(employeeId);
    }

    //Method to Update Employee
    public StaffEntity updateStaff(StaffEntity updateRequest) {
        Optional<StaffEntity> existingStaffOptional = staffRepository.findById(updateRequest.getEmployeeId());

        if (existingStaffOptional.isPresent()) {

            StaffEntity existingStaff = existingStaffOptional.get();
            existingStaff.setFirstName(updateRequest.getFirstName());
            existingStaff.setLastName(updateRequest.getLastName());
            existingStaff.setEmployeeEmail(updateRequest.getEmployeeEmail());
            existingStaff.setJobLocation(updateRequest.getJobLocation());
            existingStaff.setDepartment(updateRequest.getDepartment());
            existingStaff.setAddress(updateRequest.getAddress());

            return staffRepository.save(existingStaff);
        } else {
            throw new RuntimeException("Employee not found with ID: " + updateRequest.getEmployeeId());
        }
    }

    //Method to Update StaffById
    public StaffEntity updateStaffById(int employeeId, StaffEntity staff){

        Optional<StaffEntity> staffOptional=staffRepository.findById(employeeId);
        StaffEntity entity=staffOptional.get();
        entity.setFirstName(staff.getFirstName());
        entity.setLastName(staff.getLastName());
        entity.setEmployeeEmail(staff.getEmployeeEmail());
        entity.setJobLocation(staff.getJobLocation());
        entity.setDepartment(staff.getDepartment());
        entity.setAddress(staff.getAddress());

        return staffRepository.save(entity);
    }

    //Method to Delete for Thymeleaf
    public String deleteEmployee(int employeeId){
         staffRepository.deleteById(employeeId);
         return employeeId+ "Successfully Deleted";
    }

    //Method to delete for Swagger UI
    public void deleteStaff(int employeeId){
        staffRepository.deleteById(employeeId);

    }

}


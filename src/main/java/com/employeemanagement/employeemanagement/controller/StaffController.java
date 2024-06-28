package com.employeemanagement.employeemanagement.controller;

import com.employeemanagement.employeemanagement.entity.StaffEntity;
import com.employeemanagement.employeemanagement.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    //to show employee register form
    @GetMapping("/addStaff")
    public String staffRegister(){
        return "addStaff";
    }

    //addEmployeeDetails
    @PostMapping(value = "/save")
    public String saveStaff(@ModelAttribute StaffEntity employee){
        staffService.saveEmployee(employee);
        return "redirect:/";
    }

    //Method to Display All the Staff Details
    @GetMapping(value ="/displayStaffDetails")
    public String getAllStaffDetails(Model model){
        List<StaffEntity> staffList=staffService.getAllStaff();
        model.addAttribute("staff",staffList );
        return "showEmployee";
    }


    // Method to display the employee search form
    @GetMapping("/findStaffById")
    public String findEmployeePage() {
        return "findEmpById";
    }

    // Method to handle the employee search request by ID
    @GetMapping("/findEmpById")
    public String findStaffById(@RequestParam int employeeId, Model model) {
        Optional<StaffEntity> staffList = staffService.findByStaffId(employeeId);
        if(staffList.isEmpty()){
            model.addAttribute("error","Employee Credential NOT FOUND!");
            return "error";

        }else{
            model.addAttribute("staff",staffList.get());
            return "showEmployee";
        }
    }

    //Method to show updateForm
    @GetMapping("updateStaffById")
    public String updatePage(@RequestParam int employeeId, Model model) {
        Optional<StaffEntity> staff = staffService.findByStaffId(employeeId);
        if (staff.isPresent()) {
            model.addAttribute("staff", staff.get());
            return "updateEmpById";
        } else {
            model.addAttribute("error", "Employee Credential Not Found, Unable to Update!!!");
            return "error";
        }
    }

    //Method for Update employee
    @PutMapping(value = "/saveUpdate")
    public String updateStaffById(@ModelAttribute StaffEntity staff, Model model) {
        try {
            StaffEntity updatedStaff = staffService.updateStaff(staff);
            model.addAttribute("staff", updatedStaff);
            return "showEmployee";
        } catch (RuntimeException e) {
            model.addAttribute("error", "Employee Credential Not Found, Unable to Update!!!");
            return "error";
        }
    }

    // Method to delete employee
    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId, Model model){
        try {
            staffService.deleteEmployee(employeeId);
            return "delete";
        } catch (Exception e) {
            model.addAttribute("error", "Error deleting employee");
            return "errorPage";
        }
    }


}

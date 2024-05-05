package com.example.springbootdocker.controller;

import com.example.springbootdocker.model.StaffModel;
import com.example.springbootdocker.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/addStaff")
    public String addStaff(@RequestBody StaffModel staffModel) {
        staffService.addStaff(staffModel);
        return "success add staff";
    }
    @GetMapping("/getAllStaff")
    public List<StaffModel> getAllStaff() {
        return staffService.findAll();
    }
}

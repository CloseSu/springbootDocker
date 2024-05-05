package com.example.springbootdocker.service;

import com.example.springbootdocker.dao.StaffRepository;
import com.example.springbootdocker.model.StaffModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<StaffModel> findAll() {
        List<StaffModel> result = new ArrayList<>();
        for (StaffModel str : staffRepository.findAll()) {
            result.add(str);
        }
        return result;
    }

    @Transactional
    public void addStaff(StaffModel staffModel) {
        staffRepository.save(staffModel);
    }
}

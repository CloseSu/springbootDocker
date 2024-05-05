package com.example.springbootdocker.dao;

import com.example.springbootdocker.model.StaffModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends CrudRepository<StaffModel, Integer> {
}

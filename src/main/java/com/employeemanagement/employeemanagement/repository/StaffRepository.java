package com.employeemanagement.employeemanagement.repository;


import com.employeemanagement.employeemanagement.entity.StaffEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface StaffRepository extends MongoRepository<StaffEntity,Integer> {

    //Method for findById
    Optional<StaffEntity> findById(int employeeId);
}


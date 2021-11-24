package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Admin;
import com.model.Employee;
@Repository
public interface AdminRepository extends JpaRepository<Employee, Integer> {

}

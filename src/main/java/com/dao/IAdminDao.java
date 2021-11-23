package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Admin;
import com.model.DonationDistribution;
import com.model.Employee;

@Repository
public interface IAdminDao extends JpaRepository<Employee,Integer>{
	public int createEmployee(Employee employee) throws SQLException;

	public Employee updateEmployee(Employee employee) throws SQLException;

	public boolean deleteEmployee(int employeeId) throws SQLException;

	public Employee readEmployeeById(int employeeId) throws SQLException;

	public List<Employee> readEmployeeByName(String name) throws SQLException;

	public List<Employee> readAllEmployees() throws SQLException;

	public boolean approveDonation(DonationDistribution distribution);

	

}

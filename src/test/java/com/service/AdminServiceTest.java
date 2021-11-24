package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dao.EmployeeDao;
import com.dao.IAdminDao;
import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.Employee;

@SpringBootTest
class AdminServiceTest {

	@Autowired
	AdminServiceImpl adminService;

	@MockBean
	EmployeeDao empDao;
	
	@MockBean
	IAdminDao adminDao;
	@Test
	void testAddEmployee() {
		Employee e=new Employee();
		e.setEmployeeId(1);
		e.setEmployeeName("sreelakshmi");
		e.setPhone("987654321");
		e.setEmail("sree@gmail.com");
		e.setUsername("SREELAK");
		e.setPassword("abc123");
		
		Mockito.when(empDao.save(e)).thenReturn(e);
		assertThat(adminService.addEmployee(e)).isEqualTo(e);
	}
	
//	@Test
//	void testGetEmployees() {
//		Employee employee=new Employee();
//		employee.setEmployeeName("sreelakshmi");
//		employee.setEmail("sree@gmail.com");
//		employee.setPhone("987654321");
//		employee.setUsername("SREELAK");
//		employee.setPassword("abc123");
//		
//		Employee employee2=new Employee();
//		employee2.setEmployeeName("varsha");
//		employee2.setEmail("varsha@gmail.com");
//		employee2.setPhone("967654321");
//		employee.setUsername("VARSHANAMRATHA");
//		employee.setPassword("abc456");
//
//		 List<Employee> empList=new ArrayList<>();
//		 empList.add(employee);
//		 empList.add(employee2);
//		 
//		 Mockito.when(empDao.findAll()).thenReturn(empList);
//		 assertThat(adminService.getEmployees()).isEqualTo(empList);
//	}
//
//	@Test
//	void testFindEmployeeById() throws Throwable {
//		Employee e=new Employee();
//		e.setEmployeeId(1);
//		e.setEmployeeName("sreelakshmi");
//		e.setEmail("sree@gmail.com");
//		e.setPhone("987654321");
//		e.setUsername("SREELAK");
//		e.setPassword("abc123");
//		Optional<Employee> c2=Optional.of(e);
//		Mockito.when(empDao.findById(1)).thenReturn(c2);
//		assertThat(adminService.findEmployeeById(1)).isEqualTo(e);
//	}
//	@Test
//	void testRemoveEmployee() {
//		Employee employee=new Employee();
//		employee.setEmployeeId(1);
//		employee.setEmployeeName("sreelakshmi");
//		employee.setEmail("sree@gmail.com");
//		employee.setPhone("987654321");
//		employee.setUsername("SREELAK");
//		employee.setPassword("abc123");
//		Optional<Employee> c2=Optional.of(employee);
//		Mockito.when(empDao.findById(1)).thenReturn(c2);
//		Mockito.when(empDao.existsById(employee.getEmployeeId())).thenReturn(false);
//		assertFalse(empDao.existsById(employee.getEmployeeId()));
//	}
}

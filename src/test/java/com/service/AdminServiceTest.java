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
import com.dao.IAdminDao;
import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.Employee;

@SpringBootTest
class AdminServiceTest {

	@Autowired
	AdminServiceImpl adminService;

	@MockBean
	IAdminDao adminDao;
	
	@Test
	void testAddEmployee() throws  SQLException, NoSuchEmployeeException {
		Employee employee=new Employee();
		employee.setEmployeeName("sreelakshmi");
		employee.setPhone("987654321");
		employee.setEmail("sree@gmail.com");
		employee.setUsername("SREELAK");
		employee.setPassword("abc123");
		
		Mockito.when(adminDao.save(employee)).thenReturn(employee);
		assertThat(adminService.addEmployee(employee)).isEqualTo(employee);
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
//		 Mockito.when(adminDao.findAll()).thenReturn(empList);
//		 assertThat(adminService.getEmployees()).isEqualTo(empList);
//	}
//
//	@Test
//	void testFindEmployeeById() throws Throwable {
//		Employee employee=new Employee();
//		employee.setEmployeeId(1);
//		employee.setEmployeeName("sreelakshmi");
//		employee.setEmail("sree@gmail.com");
//		employee.setPhone("987654321");
//		employee.setUsername("SREELAK");
//		employee.setPassword("abc123");
//		Optional<Employee> c2=Optional.of(employee);
//		Mockito.when(adminDao.findById(1)).thenReturn(c2);
//		assertThat(adminService.findEmployeeById(1)).isEqualTo(employee);
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
//		Mockito.when(adminDao.findById(1)).thenReturn(c2);
//		Mockito.when(adminDao.existsById(employee.getEmployeeId())).thenReturn(false);
//		assertFalse(adminDao.existsById(employee.getEmployeeId()));
//	}
}

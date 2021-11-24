package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dao.EmployeeRepository;
import com.dao.NeedyPeopleRepository;
import com.model.Address;
import com.model.NeedyPeople;

@SpringBootTest
public class EmployeeServiceTest {
	@MockBean
	EmployeeRepository empRepository;

	@MockBean
	NeedyPeopleRepository needyPeopleRepo;

	@Autowired
	IEmployeeService empService;

	@Autowired
	INeedyPeopleService needyService;
	
	@Test
	void testAddNeedyPerson() {
		NeedyPeople p=new NeedyPeople();
		p.setNeedyPersonId(1);
		p.setNeedyPersonName("Rakesh");
		p.setPhone("9999999999");
		p.setFamilyIncome(5000.0);
		Address a=new Address();
		a.setAddressId(1);
		a.setCity("Noida");
		a.setState("Delhi");
		a.setLandmark("");
		a.setPin("121002");
		p.setAddress(a);
		Mockito.when(needyPeopleRepo.save(p)).thenReturn(p);
		assertThat(empService.addNeedyPerson(p)).isEqualTo(p);
	}

	@Test
	void testRemoveNeedyPerson() {

		NeedyPeople p=new NeedyPeople();
		p.setNeedyPersonId(1);
		p.setNeedyPersonName("Rakesh");
		p.setPhone("9999999999");
		p.setFamilyIncome(5000.0);
		Address a=new Address();
		a.setAddressId(1);
		a.setCity("Noida");
		a.setState("Delhi");
		a.setLandmark("");
		a.setPin("121002");
		p.setAddress(a);
		Optional<NeedyPeople> p1=Optional.of(p);
		Mockito.when(needyPeopleRepo.findById(1)).thenReturn(p1);
		Mockito.when(needyPeopleRepo.existsById(p.getNeedyPersonId())).thenReturn(false);
		assertFalse(needyPeopleRepo.existsById(p.getNeedyPersonId()));
	}

	@Test
	void testFindNeedyPeopleById() {
		NeedyPeople p=new NeedyPeople();
		p.setNeedyPersonId(1);
		p.setNeedyPersonName("Rakesh");
		p.setPhone("9999999999");
		p.setFamilyIncome(5000.0);
		Address a=new Address();
		a.setAddressId(1);
		a.setCity("Noida");
		a.setState("Delhi");
		a.setLandmark("");
		a.setPin("121002");
		p.setAddress(a);
		Optional<NeedyPeople> p1=Optional.of(p);
		Mockito.when(needyPeopleRepo.findById(1)).thenReturn(p1);
		assertThat(empService.findNeedyPeopleById(1)).isEqualTo(p);
	}

}

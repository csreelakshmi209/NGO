package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.NeedyPeople;

@Repository
public interface NeedyPeopleRepository extends JpaRepository<NeedyPeople, Integer> {

}

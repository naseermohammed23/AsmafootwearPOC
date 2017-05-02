package com.aa.poc.nno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aa.poc.nno.entity.CustomerHistory;

public interface CustomerHistoryRepository extends JpaRepository<CustomerHistory, Long>{

}

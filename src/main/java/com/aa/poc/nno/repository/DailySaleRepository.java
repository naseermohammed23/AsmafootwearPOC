package com.aa.poc.nno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aa.poc.nno.entity.SaleSummary;

public interface DailySaleRepository extends JpaRepository<SaleSummary, Long>{

}

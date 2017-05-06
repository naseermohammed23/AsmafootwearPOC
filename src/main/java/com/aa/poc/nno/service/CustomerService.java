package com.aa.poc.nno.service;

import java.util.List;

import com.aa.poc.nno.entity.Customer;
import com.aa.poc.nno.service.dto.CustomerDto;

public interface CustomerService {
	
	CustomerDto save(CustomerDto customerDto);

	List<CustomerDto> findAll();

    /**
     * Get the Open Discrepancy based on {@code id}
     *
     * @param id the id of the open discrepancy
     * @return open discrepancy if found {@code null} otherwise
     */
	CustomerDto find(Long id);
	
	Customer findCustomer(Long id);
	
}

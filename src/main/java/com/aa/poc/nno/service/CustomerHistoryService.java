package com.aa.poc.nno.service;

import java.util.List;

import com.aa.poc.nno.service.dto.CustomerHistoryDto;

public interface CustomerHistoryService {

	CustomerHistoryDto save(CustomerHistoryDto customerHistoryDto);

	List<CustomerHistoryDto> findAll();

    /**
     * Get the Open Discrepancy based on {@code id}
     *
     * @param id the id of the open discrepancy
     * @return open discrepancy if found {@code null} otherwise
     */
	CustomerHistoryDto find(Long id);
	
}

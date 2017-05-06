package com.aa.poc.nno.service;

import java.util.List;

import com.aa.poc.nno.service.dto.DailySalesDto;

public interface DailySaleService {

	DailySalesDto save(DailySalesDto customerDto);

	List<DailySalesDto> findAll();

    /**
     * Get the Open Discrepancy based on {@code id}
     *
     * @param id the id of the open discrepancy
     * @return open discrepancy if found {@code null} otherwise
     */
	DailySalesDto find(Long id);
}

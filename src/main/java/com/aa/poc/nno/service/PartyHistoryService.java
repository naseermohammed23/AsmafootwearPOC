package com.aa.poc.nno.service;

import java.util.List;

import com.aa.poc.nno.service.dto.PartyHistoryDto;

public interface PartyHistoryService {

	PartyHistoryDto save(PartyHistoryDto partyHistoryDto);

	List<PartyHistoryDto> findAll();

    /**
     * Get the Open Discrepancy based on {@code id}
     *
     * @param id the id of the open discrepancy
     * @return open discrepancy if found {@code null} otherwise
     */
	PartyHistoryDto find(Long id);
}

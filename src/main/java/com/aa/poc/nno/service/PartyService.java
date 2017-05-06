package com.aa.poc.nno.service;

import java.util.List;

import com.aa.poc.nno.entity.Party;
import com.aa.poc.nno.service.dto.PartyDto;;

public interface PartyService {

	PartyDto save(PartyDto partyDto);

	List<PartyDto> findAll();

	/**
	 * Get the Open Discrepancy based on {@code id}
	 *
	 * @param id the id of the open discrepancy
	 * @return open discrepancy if found {@code null} otherwise
	 */
	PartyDto find(Long id);

	Party findParty(Long id);
}

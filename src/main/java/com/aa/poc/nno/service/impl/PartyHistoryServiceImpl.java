package com.aa.poc.nno.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.poc.nno.entity.PartyHistory;
import com.aa.poc.nno.repository.PartyHistoryRepository;
import com.aa.poc.nno.service.PartyHistoryService;
import com.aa.poc.nno.service.dto.PartyHistoryDto;
import com.aa.poc.nno.service.mapper.PartyHistoryMapper;

@Service
@Transactional
public class PartyHistoryServiceImpl implements PartyHistoryService {

	private static final Logger log = LoggerFactory.getLogger(PartyHistoryServiceImpl.class);
	
	private PartyHistoryRepository partyHistoryRepository;
	
	@Autowired
	private PartyHistoryMapper partyHistoryMapper;
	
	
	@Autowired
	public PartyHistoryServiceImpl(PartyHistoryRepository partyHistoryRepository,PartyHistoryMapper partyHistoryMapper) {
		
		this.partyHistoryRepository = partyHistoryRepository;
		this.partyHistoryMapper = partyHistoryMapper;
	}
	
	
	
	public void setPartyHistoryRepository(
			PartyHistoryRepository partyHistoryRepository) {
		this.partyHistoryRepository = partyHistoryRepository;
	}



	public void setPartyHistoryMapper(PartyHistoryMapper partyHistoryMapper) {
		this.partyHistoryMapper = partyHistoryMapper;
	}



	@Override
	public PartyHistoryDto save(PartyHistoryDto partyHistoryDto) {
		 log.debug("Request to save party History {} ", partyHistoryDto);

	        PartyHistory partyHistory = partyHistoryMapper.convertDtoToEntity(partyHistoryDto);
	        partyHistory = partyHistoryRepository.save(partyHistory);
	        PartyHistoryDto result = partyHistoryMapper.converEntityToDto(partyHistory);

	        return result;
	}

	@Override
	public List<PartyHistoryDto> findAll() {
		log.debug("Request to get all the Parties History");

        List<PartyHistoryDto> result = partyHistoryRepository.findAll().stream()
                .map(partyHistoryMapper::converEntityToDto)
                .collect(Collectors.toCollection(LinkedList::new));

        return result;
	}

	@Override
	public PartyHistoryDto find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

package com.aa.poc.nno.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.poc.nno.entity.Party;
import com.aa.poc.nno.repository.PartyRepository;
import com.aa.poc.nno.service.PartyService;
import com.aa.poc.nno.service.dto.PartyDto;
import com.aa.poc.nno.service.mapper.PartyMapper;

@Service
@Transactional
public class PartyServiceImpl implements PartyService {
	
	private static final Logger log = LoggerFactory.getLogger(PartyServiceImpl.class);

	 private PartyRepository partyRepository;

	    @Autowired
	    private PartyMapper partyMapper;
	    
	    @Autowired
	    public PartyServiceImpl(PartyRepository partyRepository, PartyMapper
	    		partyMapper) {
	        this.partyRepository = partyRepository;
	        this.partyMapper = partyMapper;
	    }

	@Override
	public PartyDto save(PartyDto partyDto) {

		 	log.debug("Request to save open discrepancy {} ", partyDto);

	        Party party = partyMapper.convertDtoToEntity(partyDto);
	        party = partyRepository.save(party);
	        PartyDto result = partyMapper.converEntityToDto(party);

	        return result;
	        
	}

	public void setPartyRepository(PartyRepository partyRepository) {
		this.partyRepository = partyRepository;
	}

	public void setPartyMapper(PartyMapper partyMapper) {
		this.partyMapper = partyMapper;
	}

	@Override
	public List<PartyDto> findAll() {
		log.debug("Request to get all the parties");

        List<PartyDto> result = partyRepository.findAll().stream()
                .map(partyMapper::converEntityToDto)
                .collect(Collectors.toCollection(LinkedList::new));

        return result;
	}

	@Override
	public PartyDto find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Party findParty(Long id) {
		
		return partyRepository.findOne(id);
	}

}

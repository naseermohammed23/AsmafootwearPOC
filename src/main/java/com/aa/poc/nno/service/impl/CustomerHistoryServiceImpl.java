package com.aa.poc.nno.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.poc.nno.entity.CustomerHistory;
import com.aa.poc.nno.repository.CustomerHistoryRepository;
import com.aa.poc.nno.service.CustomerHistoryService;
import com.aa.poc.nno.service.dto.CustomerHistoryDto;
import com.aa.poc.nno.service.mapper.CustomerHistoryMapper;

@Service
@Transactional
public class CustomerHistoryServiceImpl implements  CustomerHistoryService{

	private static final Logger log = LoggerFactory.getLogger(CustomerHistoryServiceImpl.class);
	
	private CustomerHistoryRepository customerHistoryRepository;
	
	@Autowired
	private CustomerHistoryMapper customerHistoryMapper;
	
	
	@Autowired
	public CustomerHistoryServiceImpl(CustomerHistoryRepository customerHistoryRepository,CustomerHistoryMapper customerHistoryMapper) {
		
		this.customerHistoryRepository = customerHistoryRepository;
		this.customerHistoryMapper = customerHistoryMapper;
	}
	
	

	public void setCustomerHistoryRepository(
			CustomerHistoryRepository customerHistoryRepository) {
		this.customerHistoryRepository = customerHistoryRepository;
	}



	public void setCustomerHistoryMapper(CustomerHistoryMapper customerHistoryMapper) {
		this.customerHistoryMapper = customerHistoryMapper;
	}



	@Override
	public CustomerHistoryDto save(CustomerHistoryDto customerHistoryDto) {
		 log.debug("Request to save customer History {} ", customerHistoryDto);
		 
	        CustomerHistory customerHistory = customerHistoryMapper.convertDtoToEntity(customerHistoryDto);
	        customerHistory = customerHistoryRepository.save(customerHistory);
	        CustomerHistoryDto result = customerHistoryMapper.converEntityToDto(customerHistory);

	        return result;
	}

	@Override
	public List<CustomerHistoryDto> findAll() {
		log.debug("Request to get all the Customers History");

        List<CustomerHistoryDto> result = customerHistoryRepository.findAll().stream()
                .map(customerHistoryMapper::converEntityToDto)
                .collect(Collectors.toCollection(LinkedList::new));

        return result;
	}

	@Override
	public CustomerHistoryDto find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}

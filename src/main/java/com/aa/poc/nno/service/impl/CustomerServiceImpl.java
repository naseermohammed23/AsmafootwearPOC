/**
 * 
 */
package com.aa.poc.nno.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.poc.nno.entity.Customer;
import com.aa.poc.nno.repository.CustomerRepository;
import com.aa.poc.nno.service.CustomerService;
import com.aa.poc.nno.service.dto.CustomerDto;
import com.aa.poc.nno.service.dto.OpenDiscrepancyDto;
import com.aa.poc.nno.service.mapper.CustomerMapper;

/**
 * @author 842018
 *
 */

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper
    		customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }
	

	@Override
	public CustomerDto save(CustomerDto customerDto) {
        log.debug("Request to save open discrepancy {} ", customerDto);

        Customer customer = customerMapper.convertDtoToEntity(customerDto);
        customer = customerRepository.save(customer);
        CustomerDto result = customerMapper.converEntityToDto(customer);

        return result;
	}

	@Override
	public List<CustomerDto> findAll() {
		log.debug("Request to get all the Customers");

        List<CustomerDto> result = customerRepository.findAll().stream()
                .map(customerMapper::converEntityToDto)
                .collect(Collectors.toCollection(LinkedList::new));

        return result;
		
	}

	@Override
	public CustomerDto find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}


	public void setCustomerMapper(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}

	
}

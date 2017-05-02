package com.aa.poc.nno.service.mapper;

import org.mapstruct.Mapper;

import com.aa.poc.nno.entity.Customer;
import com.aa.poc.nno.service.dto.CustomerDto;

@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper {

	CustomerDto converEntityToDto(Customer customer);
	
	Customer convertDtoToEntity(CustomerDto customerDto);
	
}

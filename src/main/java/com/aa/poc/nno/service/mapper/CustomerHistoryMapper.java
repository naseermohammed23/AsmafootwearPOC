package com.aa.poc.nno.service.mapper;

import org.mapstruct.Mapper;

import com.aa.poc.nno.entity.CustomerHistory;
import com.aa.poc.nno.service.dto.CustomerHistoryDto;

@Mapper(componentModel = "spring", uses = {})
public interface CustomerHistoryMapper {

	CustomerHistoryDto converEntityToDto(CustomerHistory customerHistory);
	
	CustomerHistory convertDtoToEntity(CustomerHistoryDto customerHistoryDto);	
}

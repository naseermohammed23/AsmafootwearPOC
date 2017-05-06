package com.aa.poc.nno.service.mapper;

import org.mapstruct.Mapper;

import com.aa.poc.nno.entity.SaleSummary;
import com.aa.poc.nno.service.dto.DailySalesDto;

@Mapper(componentModel = "spring", uses = {})
public interface DailySaleMapper {
	DailySalesDto converEntityToDto(SaleSummary customer);
	
	SaleSummary convertDtoToEntity(DailySalesDto customerDto);
}

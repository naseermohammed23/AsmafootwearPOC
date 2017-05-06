package com.aa.poc.nno.service.mapper;

import org.mapstruct.Mapper;

import com.aa.poc.nno.entity.PartyHistory;
import com.aa.poc.nno.service.dto.PartyHistoryDto;

@Mapper(componentModel = "spring", uses = {})
public interface PartyHistoryMapper {
	
PartyHistoryDto converEntityToDto(PartyHistory customerHistory);
	
PartyHistory convertDtoToEntity(PartyHistoryDto customerHistoryDto);	
}

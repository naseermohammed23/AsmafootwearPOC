package com.aa.poc.nno.service.mapper;

import org.mapstruct.Mapper;

import com.aa.poc.nno.entity.Party;
import com.aa.poc.nno.service.dto.PartyDto;

@Mapper(componentModel = "spring", uses = {})
public interface PartyMapper {

PartyDto converEntityToDto(Party customer);
	
Party convertDtoToEntity(PartyDto customerDto);
}

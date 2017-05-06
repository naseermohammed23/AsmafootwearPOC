package com.aa.poc.nno.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.poc.nno.entity.SaleSummary;
import com.aa.poc.nno.repository.DailySaleRepository;
import com.aa.poc.nno.service.DailySaleService;
import com.aa.poc.nno.service.dto.DailySalesDto;
import com.aa.poc.nno.service.mapper.DailySaleMapper;

@Service
@Transactional
public class DailySaleServiceImpl implements DailySaleService{

	private static final Logger log = LoggerFactory.getLogger(DailySaleServiceImpl.class);

	@Autowired
	private DailySaleRepository dailySaleRepository;
	@Autowired
	private DailySaleMapper dailySaleMapper;


	public void setDailySaleRepository(DailySaleRepository dailySaleRepository) {
		this.dailySaleRepository = dailySaleRepository;
	}

	public void setDailySaleMapper(DailySaleMapper dailySaleMapper) {
		this.dailySaleMapper = dailySaleMapper;
	}

	@Override
	public DailySalesDto save(DailySalesDto dailySaleDto) {
		log.debug("Request to save daily sale {} ", dailySaleDto);
		SaleSummary saleSummary = dailySaleMapper.convertDtoToEntity(dailySaleDto);
		saleSummary = dailySaleRepository.save(saleSummary);
		DailySalesDto result = dailySaleMapper.converEntityToDto(saleSummary);

		return result;
	}

	@Override
	public List<DailySalesDto> findAll() {
		log.debug("Request to get all sale history");

		List<DailySalesDto> result = dailySaleRepository.findAll().stream()
				.map(dailySaleMapper::converEntityToDto)
				.collect(Collectors.toCollection(LinkedList::new));

		return result;
	}

	@Override
	public DailySalesDto find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

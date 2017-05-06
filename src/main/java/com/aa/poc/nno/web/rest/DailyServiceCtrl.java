package com.aa.poc.nno.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aa.poc.nno.service.DailySaleService;
import com.aa.poc.nno.service.dto.DailySalesDto;
import com.aa.poc.nno.web.util.HeaderUtil;

@RestController
@RequestMapping("/afwDailySale")
public class DailyServiceCtrl {

	private static final Logger log = LoggerFactory.getLogger(DailyServiceCtrl.class);

	@Autowired
	private DailySaleService dailySaleService;

	@CrossOrigin
	@PostMapping("/dailySale")
	public ResponseEntity<DailySalesDto> createDailySale(@RequestBody DailySalesDto
			dailySaleDto) throws URISyntaxException {
		
		log.debug("REST request to save Customer : {}", dailySaleDto);
		dailySaleDto.setDate(new Timestamp(System.currentTimeMillis()));
		ResponseEntity<DailySalesDto> response = null;

		if (dailySaleDto.getId() != null) {
			response = ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert
					("Daily Sale", "id exists", "A new Daily Sale History cannot have an id.")).body(null);
		} else {
			
			DailySalesDto result = dailySaleService.save(dailySaleDto);

			response = ResponseEntity.created(new URI("/afwDailySale/dailySale/" + result.getId()))
					.headers(HeaderUtil.createEntityCreationAlert("Daily Sale", result.getId().toString()))
					.body(result);
		}

		return response;
	}
	@CrossOrigin
	@GetMapping("/dailySale")
	public List<DailySalesDto> getAllDailySales() {
		log.debug("Request to fetch all Daily Sales");
		return dailySaleService.findAll();
	}

}

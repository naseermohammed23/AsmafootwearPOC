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

import com.aa.poc.nno.service.PartyHistoryService;
import com.aa.poc.nno.service.PartyService;
import com.aa.poc.nno.service.dto.PartyHistoryDto;
import com.aa.poc.nno.web.util.HeaderUtil;

@RestController
@RequestMapping("/afwPartyHistory")
public class PartyHistoryCrtl {

	private static final Logger log = LoggerFactory.getLogger(PartyHistoryCrtl.class);

	private PartyHistoryService partyHistoryService;

	private PartyService partyService;

	@Autowired
	public PartyHistoryCrtl(PartyHistoryService partyHistoryService,
			PartyService partyService) {

		this.partyHistoryService = partyHistoryService;
		this.partyService = partyService;
	}

	@CrossOrigin
	@PostMapping("/partyHistory")
	public ResponseEntity<PartyHistoryDto> createPartyHistory(@RequestBody PartyHistoryDto
			partyHistoryDto) throws URISyntaxException {
		log.debug("REST request to save party History : {}", partyHistoryDto);
		partyHistoryDto.setLastUpdated(new Timestamp(System.currentTimeMillis()));
		ResponseEntity<PartyHistoryDto> response = null;
		partyHistoryDto.setParty(partyService.findParty(partyHistoryDto.getHistoryId()));
		partyHistoryDto.setHistoryId(0);
		if (partyHistoryDto.getHistoryId() != 0) {
			response = ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert
					("Party History", "id exists", "A new Party History cannot have an id.")).body(null);
		} else {
			PartyHistoryDto result = partyHistoryService.save(partyHistoryDto);

			response = ResponseEntity.created(new URI("/afwPartyHistory/partyHistory/" + result.getHistoryId()))
					.headers(HeaderUtil.createEntityCreationAlert("partyHistory", result.getParty().getId().toString()))
					.body(result);
		}

		return response;
	}

	@CrossOrigin
	@GetMapping("/partyHistory")
	public List<PartyHistoryDto> getAllParties() {
		log.debug("Request to fetch all parties");
		return partyHistoryService.findAll();
	}
}

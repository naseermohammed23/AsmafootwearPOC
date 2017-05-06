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

import com.aa.poc.nno.service.PartyService;
import com.aa.poc.nno.service.dto.PartyDto;
import com.aa.poc.nno.web.util.HeaderUtil;

@RestController
@RequestMapping("/afwParty")
public class PartyController {
	private static final Logger log = LoggerFactory.getLogger(CustomerCtrl.class);

    private PartyService partyService;
    @Autowired
    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }
    
    @CrossOrigin
    @PostMapping("/party")
    public ResponseEntity<PartyDto> createParty(@RequestBody PartyDto
        partyDto) throws URISyntaxException {
        log.debug("REST request to save party : {}", partyDto);
        partyDto.setLastUpdated(new Timestamp(System.currentTimeMillis()));
        ResponseEntity<PartyDto> response = null;

        if (partyDto.getId() != null) {
            response = ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert
                ("Party", "id exists", "A new party cannot have an id.")).body(null);
        } else {
        	PartyDto result = partyService.save(partyDto);

            response = ResponseEntity.created(new URI("/afwParty/party/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("party", result.getId().toString()))
                .body(result);
        }

        return response;
    }
    @CrossOrigin
    @GetMapping("/party")
    public List<PartyDto> getAllParties() {
        log.debug("Request to fetch all customers");
        return partyService.findAll();
    }

}

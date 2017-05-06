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

import com.aa.poc.nno.service.CustomerService;
import com.aa.poc.nno.service.dto.CustomerDto;
import com.aa.poc.nno.web.util.HeaderUtil;

/**
 * REST controller for getting Fleet Maintenance data. This will include aircraft, its associated maintenance and
 * part numbers.
 * <p>
 * Created by Neelabh Tripathi on 2/23/2017.
 */
@RestController
@RequestMapping("/afwCustomer")
public class CustomerCtrl {
	
	 private static final Logger log = LoggerFactory.getLogger(CustomerCtrl.class);

	    private CustomerService customerService;

	    @Autowired
	    public CustomerCtrl(CustomerService customerService) {
	        this.customerService = customerService;
	    }
	    
	    @CrossOrigin
	    @PostMapping("/customer")
	    public ResponseEntity<CustomerDto> createCutomer(@RequestBody CustomerDto
	        customerDto) throws URISyntaxException {
	        log.debug("REST request to save Customer : {}", customerDto);
	        customerDto.setLastUpdated(new Timestamp(System.currentTimeMillis()));
	        ResponseEntity<CustomerDto> response = null;

	        if (customerDto.getId() != null) {
	            response = ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert
	                ("Customer", "id exists", "A new Customer cannot have an id.")).body(null);
	        } else {
	        	CustomerDto result = customerService.save(customerDto);

	            response = ResponseEntity.created(new URI("/afwCustomer/customer/" + result.getId()))
	                .headers(HeaderUtil.createEntityCreationAlert("customer", result.getId().toString()))
	                .body(result);
	        }

	        return response;
	    }
	    
	    @CrossOrigin
	    @GetMapping("/customer")
	    public List<CustomerDto> getAllCustomers() {
	        log.debug("Request to fetch all customers");
	        return customerService.findAll();
	    }
	    
	    
	
}

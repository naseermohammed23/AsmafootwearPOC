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

import com.aa.poc.nno.service.CustomerHistoryService;
import com.aa.poc.nno.service.CustomerService;
import com.aa.poc.nno.service.dto.CustomerHistoryDto;
import com.aa.poc.nno.web.util.HeaderUtil;

@RestController
@RequestMapping("/afwCustomerHistory")
public class CustomerHistoryCtrl {

	private static final Logger log = LoggerFactory.getLogger(CustomerHistoryCtrl.class);

	private CustomerHistoryService customerHistoryService;

	private CustomerService customerService;


	@Autowired
	public CustomerHistoryCtrl(CustomerHistoryService customerHistoryService,CustomerService customerService) {

		this.customerHistoryService = customerHistoryService;
		this.customerService = customerService;
	}
	@CrossOrigin
	@PostMapping("/customerHistory")
	public ResponseEntity<CustomerHistoryDto> createCutomerHistory(@RequestBody CustomerHistoryDto
			customerHistoryDto) throws URISyntaxException {
		log.debug("REST request to save Customer History : {}", customerHistoryDto);
		customerHistoryDto.setLastUpdated(new Timestamp(System.currentTimeMillis()));
		ResponseEntity<CustomerHistoryDto> response = null;
		customerHistoryDto.setCustomer(customerService.findCustomer(customerHistoryDto.getHistoryId()));
		customerHistoryDto.setHistoryId(0);
		if (customerHistoryDto.getHistoryId() != 0) {
			response = ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert
					("Customer History", "id exists", "A new Customer History cannot have an id.")).body(null);
		} else {
			CustomerHistoryDto result = customerHistoryService.save(customerHistoryDto);

			response = ResponseEntity.created(new URI("/afwCustomerHistory/customerHistory/" + result.getHistoryId()))
					.headers(HeaderUtil.createEntityCreationAlert("customerHistory", result.getCustomer().getId().toString()))
					.body(result);
		}

		return response;
	}

	@CrossOrigin
	@GetMapping("/customerHistory")
	public List<CustomerHistoryDto> getAllCustomers() {
		log.debug("Request to fetch all customers");
		return customerHistoryService.findAll();
	}
}

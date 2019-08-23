package com.walmart.fastrun.ctrl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walmart.fastrun.model.DispensedOrderVO;
import com.walmart.fastrun.service.QPService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mock")
public class RestCtrl {
	
	//@Autowired private WebClientConfig webClientConfig;
	
	private static final Logger log = LoggerFactory.getLogger(RestCtrl.class);
	
	@Autowired 
	private QPService qpService;

	@GetMapping("/getDispensedOrder/{orderId}")
	private Mono<DispensedOrderVO> getDispensedOrder(@PathVariable String orderId) {
		
		return qpService.getDispensedOrderFromString();
		
	}
}

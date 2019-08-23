package com.walmart.fastrun.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.fastrun.model.DispensedOrderVO;
import com.walmart.fastrun.service.QPService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/wm")
public class RestCtrl {
	
	//@Autowired private WebClientConfig webClientConfig;
	
	private static final Logger log = LoggerFactory.getLogger(RestCtrl.class);
	
	@Autowired 
	private QPService qpService;

	@GetMapping("/mock/getDispensedOrder/{orderId}")
	private Mono<DispensedOrderVO> getDispensedOrder(@PathVariable String orderId) {
		
		return qpService.getDispensedOrderFromString();
		
	}
	
	@GetMapping("/simpleTest")
	private Mono<String> simpleTest() {
		
		return Mono.just("HIT /wm/simpleTest");
	}
}

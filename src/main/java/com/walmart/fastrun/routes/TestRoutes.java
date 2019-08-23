package com.walmart.fastrun.routes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.walmart.fastrun.ctrl.RouteCtrl;

@Configuration
public class TestRoutes {
	
	private final Logger logger = LoggerFactory.getLogger(TestRoutes.class);
	
	@Bean
	public RouterFunction<ServerResponse> getDispensedOrderPayload(RouteCtrl controller){
		return RouterFunctions.route(RequestPredicates.GET("/route/getDispensedOrder"), controller::getDispensedOrder)
		.andRoute(RequestPredicates.GET("/route/get10sResponse"), controller::get10sResponse);
	}
}

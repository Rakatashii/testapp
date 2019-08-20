package com.walmart.test.routes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class TestRoutes {
	
	private final Logger logger = LoggerFactory.getLogger(TestRoutes.class);
	
	/** General Structure
    @Bean
    public RouterFunction<ServerResponse> routeTransactionAudit(Controller controller){
        return RouterFunctions.route(RequestPredicates.GET(GET_X), Controller::getX)
                .andRoute(RequestPredicates.POST(POST_X), controller::processX);
    } */
}

package com.walmart.fastrun.ctrl;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.walmart.fastrun.model.DispensedOrderVO;
import com.walmart.fastrun.service.QPService;
import com.walmart.fastrun.support.ResponseHandler;

import reactor.core.publisher.Mono;

@Component
public class RouteCtrl {
	
	private static final Logger log = LoggerFactory.getLogger(RouteCtrl.class);

    @Autowired
    private ResponseHandler responseHandler;
    
    @Autowired 
    private QPService qpService;
    
    /** GET EX
    public Mono<ServerResponse> getStatus(ServerRequest request) {

        Instant startTime = Instant.now();
        return this.processor.getX(request.queryParam(QUERY_PARAM), Integer.parseInt(request.pathVariable(PATH_VAR)))
                .flatMap(responseHandler::getServerResponse)
                .onErrorResume(responseHandler::getFailureServerResponse)
                .doAfterSuccessOrError((resp, error) -> reqTracker.trackRequest(resp, error, AuditConstants.GET_X, startTime, AuditConstants.GET));
    } */
    
    /** POST EX
	public Mono<ServerResponse> postX(ServerRequest request) {

		Instant startTime = Instant.now();
		return request.bodyToMono(X.class)
				.flatMap(auditTransactions -> txProcessor.processX(xxx,
						Integer.parseInt(request.pathVariable(PATH_VAR))))
				.flatMap(responseHandler::getServerResponse).onErrorResume(responseHandler::getFailureServerResponse)
				.doAfterSuccessOrError((resp, error) -> reqTracker.trackRequest(resp, error,
						AuditConstants.POST_X, startTime, AuditConstants.POST));
	} */
    
    public Mono<ServerResponse> getDispensedOrder(ServerRequest request){

    	return qpService.getDispensedOrderFromString().flatMap(responseHandler::get505Response)
    		.doAfterSuccessOrError((succ, err) -> {
    		if (err == null) {
    			log.info("success - {}", succ);
    		} else {
    			log.error("err - ", err);
    		}
    	});
    }
    
    public Mono<ServerResponse> get10sResponse(ServerRequest request){

    	return Mono.delay(Duration.ofSeconds(10))
    		.flatMap(l -> qpService.getDispensedOrderFromString())
    		.flatMap(responseHandler::getServerResponse)
    		.doAfterSuccessOrError((succ, err) -> {
    		if (err == null) {
    			log.info("success - {}", succ);
    		} else {
    			log.error("err - ", err);
    		}
    	});
    }
    
    
}

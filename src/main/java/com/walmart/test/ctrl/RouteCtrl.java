package com.walmart.test.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.walmart.test.support.ResponseHandler;

@Component
public class RouteCtrl {

    @Autowired
    private ResponseHandler responseHandler;
    
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
    
    
    
}

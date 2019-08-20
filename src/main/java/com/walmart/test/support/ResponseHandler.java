package com.walmart.test.support;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class ResponseHandler {

    @SuppressWarnings("rawtypes")
	private ServiceResponse successServiceResp = new ServiceResponse();

    public Mono<ServerResponse> getServerResponse(){
        return ServerResponse.ok().body(Mono.just(successServiceResp), ServiceResponse.class);
    }

    public <T> Mono<ServerResponse> getServerResponse(T respPayload){
        return ServerResponse.ok().body(Mono.just(new ServiceResponse<T>(respPayload)), ServiceResponse.class);
    }

    public <T> Mono<ServerResponse> getFailureServerResponse(Throwable failure){
        return ServerResponse.ok().body(Mono.just(new ServiceResponse<T>(failure.getMessage())), ServiceResponse.class);
    }
    
}
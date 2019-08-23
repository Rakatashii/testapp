package com.walmart.fastrun.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.TelemetryConfiguration;

@Configuration
public class AppInsightsConfig {

    @Value("${appinsights.inst.key}")
    private String telemetryKey;

    @Bean("TelemetryConfig")
    public String telemetryConfig() {
        if (telemetryKey != null) {
            TelemetryConfiguration.getActive().setInstrumentationKey(telemetryKey);
        }
        return telemetryKey;
    }
    
	@Bean
	@DependsOn("TelemetryConfig")
	public TelemetryClient telemetryClient(){
		return new TelemetryClient(TelemetryConfiguration.getActive());
	}

    /**
     * Programmatically registers a FilterRegistrationBean to register WebRequestTrackingFilter
     * @param webRequestTrackingFilter
     * @return Bean of type {@link FilterRegistrationBean}
     */
	
	/*@Bean
    public FilterRegistrationBean<Filter> webRequestTrackingFilterRegistrationBean(WebRequestTrackingFilter webRequestTrackingFilter) {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE + 10);
        registration.setFilter(webRequestTrackingFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }*/
	/*@Bean
    public ServletListenerRegistrationBean<ApplicationInsightsServletContextListener> getServletListenerRegistrationBean() {
        appInsightLogger.info("Initializing AI to ServletListenerRegistration");
        ServletListenerRegistrationBean<ApplicationInsightsServletContextListener> listenerRegistration = 
        		new ServletListenerRegistrationBean<ApplicationInsightsServletContextListener>();
        listenerRegistration.setListener(new ApplicationInsightsServletContextListener());
        appInsightLogger.info("Initializing AI to ServletListenerRegistration complete");
        return listenerRegistration;
    }*/

    /**
     * Creates bean of type WebRequestTrackingFilter for request tracking
     * @param applicationName Name of the application to bind filter to
     * @return {@link Bean} of type {@link WebRequestTrackingFilter}
     */
	
	/*@Bean
    @ConditionalOnMissingBean
    public WebRequestTrackingFilter webRequestTrackingFilter(@Value("${spring.application.name:application}") String applicationName) {
        return new WebRequestTrackingFilter(applicationName);
    }*/
}

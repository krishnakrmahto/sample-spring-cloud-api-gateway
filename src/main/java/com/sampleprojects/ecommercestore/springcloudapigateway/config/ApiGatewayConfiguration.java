package com.sampleprojects.ecommercestore.springcloudapigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

  @Bean
  public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
    return routeLocatorBuilder.routes()
        .route(predicateSpec -> predicateSpec.path("/get")
            .filters(gatewayFilterSpec -> gatewayFilterSpec.addRequestHeader("MyCustomHeader", "KrishnaHeaderLord")
                .addRequestParameter("MyCustomRequestParam", "KrishnaRequestParamLord"))
            .uri("http://httpbin.org:80"))
        .build();
  }

}

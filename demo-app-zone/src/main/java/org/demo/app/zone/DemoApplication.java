package org.demo.app.zone;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.apache.log4j.Logger;
import org.demo.common.util.Constants;
import org.demo.common.util.DemoUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.google.common.base.Predicate;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
//@Import({RestTemplateConfiguration.class, OAuthInterceptorConfig.class, SwarmService.class, VersionCheckConfiguration.class})
@ComponentScan({"org.demo.common"})
public class DemoApplication {
	
	private static final Logger LOG = Logger.getLogger(DemoApplication.class);
	
	public static void main(String[] args) {
	    System.setProperty(Constants.HOSTNAME, DemoUtil.getHostname());
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo")
                .apiInfo(apiInfo())
                .select()
                .paths(paths())  
                .build();
    }
     
    private ApiInfo apiInfo() {
    	return new ApiInfoBuilder()
                .title("Demo System")
                .description("Demo Microservice")
                .license("Apache License Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0")
                .build();
    }
    
    private Predicate<String> paths() {
        return or(
                regex("/demo.*")
        );
    }
    

}

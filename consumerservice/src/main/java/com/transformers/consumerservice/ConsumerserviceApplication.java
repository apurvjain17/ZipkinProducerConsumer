package com.transformers.consumerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin2.ZipkinRestTemplateCustomizer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerserviceApplication.class, args);
	}

//    ZipkinRestTemplateCustomizer myCustomizer() {
//        return new ZipkinRestTemplateCustomizer() {
//            @Override
//            void customize(RestTemplate restTemplate) {
//                // customize the RestTemplate
//            }
//        };
//    }

}

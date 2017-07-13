package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * http://blog.didispace.com/spring-cloud-starter-dalston-2-2/
 * ribbon 负载均衡控制器（让多个相同的client依次被调用）
 *
 */

@EnableEurekaClient
@SpringBootApplication
public class TestEurekaClientConsumerRibbonApplication {

	@Bean
	/*
	 * @LoadBalanced注释 Spring Cloud Ribbon有一个拦截器
	 * 它能够在这里进行实际调用的时候，自动的去选取服务实例
	 * 并将实际要请求的IP地址和端口替换这里的服务名，从而完成服务接口的调用
	 *
	 * 例如 test-eureka-client-consumer 中需要注入 LoadBalancerClient
	 * 这里 @LoadBalanced 注释 帮助我们注入
	 */
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(TestEurekaClientConsumerRibbonApplication.class, args);
	}
}

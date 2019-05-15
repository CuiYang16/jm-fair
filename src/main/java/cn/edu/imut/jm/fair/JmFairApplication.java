package cn.edu.imut.jm.fair;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ServletComponentScan
@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@EnableDiscoveryClient

@EnableFeignClients(basePackages = { "cn.edu.imut.jm.fair.domain.journal.service" })

@MapperScan("cn.edu.imut.jm.fair.*.repo.dao.**")
public class JmFairApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmFairApplication.class, args);
	}

}

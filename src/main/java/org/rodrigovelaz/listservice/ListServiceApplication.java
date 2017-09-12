package org.rodrigovelaz.listservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories
@EnableSwagger2
@ComponentScan
@EntityScan(basePackageClasses = {Jsr310JpaConverters.class}, basePackages = {"org.rodrigovelaz" })
public class ListServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListServiceApplication.class, args);
	}

}

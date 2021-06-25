package com.anies.training.menage;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EntityScan("com.anies.training.core.entity.menage")
public class MenageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenageApplication.class, args);
	}

	@Bean
	public Hibernate5Module dataTypeHibernateModule(){
		Hibernate5Module module= new Hibernate5Module();
		module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
		module.enable(Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
		return  module;
	}

	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate(){
		return  new RestTemplate();
	}
}

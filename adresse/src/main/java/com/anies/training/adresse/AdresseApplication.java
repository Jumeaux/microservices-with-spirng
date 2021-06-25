package com.anies.training.adresse;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("com.anies.training.core.entity.adresse")
public class AdresseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdresseApplication.class, args);
	}


	/*
	    Hibernate5Module
		mettre tous les proxys à null
		ex: la relation Menage-Adresse
		lorqu'on retourne un menage le proxy adresse serai null
	 */
	@Bean
	public Hibernate5Module dataTypeHibernateModule(){
		Hibernate5Module module= new Hibernate5Module();
		module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
		/*
			retouner un proxy pour en faire des objets au lieu de retouner un proxy null
			ex: proxyAdresse-->Adresse
		*/
		module.enable(Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);

		return  module;
	}
}

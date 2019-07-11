package com.sopra.spring.ejemplo10springrestjpa.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sopra.spring.ejemplo10springrestjpa.model.AlmacenDeArmas;
import com.sopra.spring.ejemplo10springrestjpa.model.entities.Arma;

@Configuration
public class SpringConfiguration {


	@Bean
	public CommandLineRunner iniciarBaseDeDatos(AlmacenDeArmas almacen) {
		return args -> {
			almacen.save(new Arma("AK-47",".30"));
			almacen.save(new Arma("Desert Eagle",".44"));
			almacen.save(new Arma("Magnum","De chocolate"));
			
		};
	}
}

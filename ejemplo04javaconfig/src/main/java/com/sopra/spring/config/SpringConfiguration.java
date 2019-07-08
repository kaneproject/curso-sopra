package com.sopra.spring.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.sopra.spring.model.dao.ExpedienteDao;
import com.sopra.spring.model.entities.Examen;
import com.sopra.spring.model.entities.Expediente;

@Configuration
public class SpringConfiguration {
	// <bean id="examen" class="Examen" scope="prototype"/>
	@Bean("examen")
	@Scope("prototype")
	public Examen getExamen() {
		return new Examen();
	}
	// <bean class="Expediente"><property ref="examen"/></bean>
	@Bean
	@Scope("prototype")
	public Expediente getExpediente(
			@Qualifier("examen") 
			Examen examen
			) {
		Expediente expediente = new Expediente();
		expediente.setExamen(examen);
		return expediente;
	}
	@Bean("expedientes")
	public List<Expediente> listaDeExpedientes(){
		return new ArrayList<Expediente>();
	}
	@Bean("dao")
	public ExpedienteDao miDao(
			@Qualifier("expedientes")
			List<Expediente> misExpedientes
			) {
		ExpedienteDao dao = new ExpedienteDao();
		dao.setExpedientes(misExpedientes);
		return dao;
	}
}

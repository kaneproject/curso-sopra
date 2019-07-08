package com.sopra.spring.anotaciones;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sopra.spring.anotaciones.model.business.GestionFacturas;
import com.sopra.spring.anotaciones.model.entities.Factura;

public class LanzadorAnotaciones {
	
	private static ApplicationContext context;
	
	static {
		context = 
				new ClassPathXmlApplicationContext("beans.xml");
	}
	
	public static void main(String[] args) {
		Factura factura = context.getBean(Factura.class);
		factura.setCodigoFactura("BAC_F000012");
		factura.setValorTotal(new BigDecimal(1000));
		GestionFacturas gestor = context.getBean(GestionFacturas.class);
		gestor.guardarFactura(factura);
		System.out.println(gestor.dameTodasLasFacturas());

	}

}

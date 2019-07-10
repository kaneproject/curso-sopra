package com.sopra.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EjemploPruebastTest {

	private static EjemploPruebas ejemplo;
	
	@Before
	public void inicializar() {
		System.out.println("Inicializando pruebas -------------");
		ejemplo = new EjemploPruebas();
	}
	@Test
	public void devuelveMayusculasSiEnvioMayusculas() {
		String string = ejemplo.devuelveMayusculas("UN TEXTO");
		assertTrue(
				"Comprobando que los textos coinciden", 
				"UN TEXTO".equals(string));
	}
	@Test
	public void devuelveMayusculasSiEnvioMinusculas() {
		String string = ejemplo.devuelveMayusculas("un texto");
		assertTrue(
				"Comprobando que los textos coinciden si envio minusculas", 
				"UN TEXTO".equals(string));
	}
	
	@After
	public void terminar() {
		System.out.println("Finalizando pruebas ---------------");
		ejemplo = null;
	}

}

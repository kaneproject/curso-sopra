package com.sopra.java.patterns;

import java.util.Arrays;
import java.util.List;

import com.sopra.java.patterns.model.business.GestionAulas;
import com.sopra.java.patterns.model.entities.Aula;

public class Lanzador {
	public static void main(String[] args) {
		
			GestionAulas gestionAulas = new GestionAulas();
			gestionAulas.crearAula("Kepler", true, true, 16);
			
			List<Aula> aulas = gestionAulas.dameAulas(Arrays.asList("Kepler","Galileo"));
			System.out.println(aulas);
	}
}


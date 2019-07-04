package com.sopra.java.patterns.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.sopra.java.patterns.model.entities.Aula;

public class MemoryMapDAO implements IDao<Aula>{

	private Map<String, Aula> miMapaDeAulas;
	
	public MemoryMapDAO(Map<String, Aula> miMapaDeAulas) {
		super();
		this.miMapaDeAulas = miMapaDeAulas;
	}

	@Override
	public void insert(Aula aula) {
		miMapaDeAulas.putIfAbsent(aula.getNombre(), aula);
		
	}

	@Override
	public Aula update(Aula aula) {
		miMapaDeAulas.replace(aula.getNombre(), aula);
		return aula;
	}

	@Override
	public void delete(Aula aula) {
		miMapaDeAulas.remove(aula.getNombre());
		
	}

	@Override
	public Collection<Aula> list() {
		
		return miMapaDeAulas.values();
	}

	@Override
	public Aula searchByName(Aula aula) {
		return miMapaDeAulas.get(aula.getNombre());
	}

}

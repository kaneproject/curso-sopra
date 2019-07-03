package com.sopra.java.patterns.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.sopra.java.patterns.model.entities.Persona;

public class MemoryMapPersonaDao implements IMultipleDao<Persona, String> {

	private Map<String,Persona> almacenDePersonas;
	
	public MemoryMapPersonaDao(Map<String, Persona> almacenDePersonas) {
		super();
		this.almacenDePersonas = almacenDePersonas;
	}

	@Override
	public void insert(Persona elemento) {
		almacenDePersonas.putIfAbsent(elemento.getDni(), elemento);
		
	}

	@Override
	public Persona update(Persona elemento) {
		if(almacenDePersonas.replace(elemento.getDni(), elemento) != null) {
			return elemento;
		}
		return null;
	}

	@Override
	public void delete(Persona elemento) {
		almacenDePersonas.remove(elemento.getDni());
		
	}

	@Override
	public Collection<Persona> list() {
		
		return almacenDePersonas.values();
	}

	@Override
	public List<Persona> searchByName(String name) {
		List<Persona> lista = new ArrayList<>();
		for(Persona persona :almacenDePersonas.values()) {
			if(persona.getNombre().equals(name)) {
				lista.add(persona);
			}
		}
		return lista;
	}

	@Override
	public Persona searchById(String id) {
		
		return almacenDePersonas.get(id);
	}

	

}

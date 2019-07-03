package com.sopra.java.patterns.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sopra.java.patterns.model.entities.Aula;

public class MemoryListAulaDAO implements IDao<Aula>{

	private List<Aula> miListaDeAulas;
	
	@Override
	public void insert(Aula aula) {
		if(!miListaDeAulas.contains(aula)) {
			miListaDeAulas.add(aula);
		}
	}

	@Override
	public Aula update(Aula aula) {
		if(miListaDeAulas.remove(aula)) {
			miListaDeAulas.add(aula);
			return aula;
		}
		return null;
	}

	@Override
	public void delete(Aula aula) {
		
		miListaDeAulas.remove(aula);
	}

	@Override
	public Collection<Aula> list() {
		
		return miListaDeAulas;
	}

	@Override
	public Aula searchByName(Aula aula) {
		if(miListaDeAulas.contains(aula)) {
			int indexOf = miListaDeAulas.indexOf(aula);
			return miListaDeAulas.get(indexOf);
		}
		return null;
	}

}

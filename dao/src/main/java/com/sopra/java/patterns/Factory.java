package com.sopra.java.patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.sopra.java.patterns.model.dao.IDao;
import com.sopra.java.patterns.model.dao.IMultipleDao;
import com.sopra.java.patterns.model.dao.MemoryListLogDAO;
import com.sopra.java.patterns.model.dao.MemoryMapDAO;
import com.sopra.java.patterns.model.dao.MemoryMapPersonaDao;
import com.sopra.java.patterns.model.entities.Aula;
import com.sopra.java.patterns.model.entities.LineaDeLog;
import com.sopra.java.patterns.model.entities.Persona;

public class Factory {
	private static IDao<Aula> miAulaDao;
	private static IMultipleDao<LineaDeLog, Integer>  miLogDao;
	private static IMultipleDao<Persona, String> miPersonaDao;

	public static IDao<Aula> getDaoDeAula(){
		if(miAulaDao == null) {
			miAulaDao = new MemoryMapDAO(new HashMap<String, Aula>());
		}
		return miAulaDao;
	}
	public static IMultipleDao<LineaDeLog,Integer> getDaoDeLog(){
		if(miLogDao == null) {
			miLogDao = new MemoryListLogDAO(new ArrayList<>());
		}
		return miLogDao;
	}
	public static IMultipleDao<Persona, String> getPersonaDAO(){
		if(miPersonaDao == null) {
			miPersonaDao = new MemoryMapPersonaDao(new LinkedHashMap<String, Persona>());
		}
		return miPersonaDao;
	}

}

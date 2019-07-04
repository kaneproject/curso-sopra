package com.sopra.java.patterns.model.business;

import java.util.ArrayList;
import java.util.List;

import com.sopra.java.patterns.Factory;
import com.sopra.java.patterns.model.dao.IMultipleDao;
import com.sopra.java.patterns.model.entities.LineaDeLog;

public class GestionLogs {
	private IMultipleDao<LineaDeLog, Integer> logDao;
	public GestionLogs() {
		logDao = Factory.getDaoDeLog();
	}
	public List<LineaDeLog> getLog(){
		
		return new ArrayList<LineaDeLog>(logDao.list());
	}
	
}

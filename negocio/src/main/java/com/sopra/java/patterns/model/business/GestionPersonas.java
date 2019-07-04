package com.sopra.java.patterns.model.business;

import java.util.HashSet;
import java.util.Set;

import com.sopra.java.patterns.Factory;
import com.sopra.java.patterns.model.dao.IMultipleDao;
import com.sopra.java.patterns.model.entities.Alumno;
import com.sopra.java.patterns.model.entities.Persona;
import com.sopra.java.patterns.model.entities.Profesor;

public class GestionPersonas {
	private IMultipleDao<Persona, String> personaDao;
	
	public GestionPersonas() {
		this.personaDao = Factory.getPersonaDAO();
	}
	public void crearAlumno(String dni,String nombre) {
		personaDao.insert(new Alumno(nombre, dni));
	}
	public void crearProfesor(String dni,String nombre) {
		personaDao.insert(new Profesor(nombre, dni));
	}
	public Set<Persona> listarPersonas(){
		return new HashSet<Persona>(personaDao.list());
	}
	public Set<Profesor> listaProfesores(){
		Set<Profesor> profesores = new HashSet<>();
		for(Persona persona : personaDao.list()) {
			if(persona instanceof Profesor) {
				Profesor profesor = (Profesor)persona;
				profesores.add(profesor);
			}
			
		}
		return profesores;
	}
	public Set<Alumno> listaAlumnos(){
		Set<Alumno> alumnos = new HashSet<>();
		for(Persona persona : personaDao.list()) {
			if(persona instanceof Alumno) {
				Alumno alumno = (Alumno)persona;
				alumnos.add(alumno);
			}
			
		}
		return alumnos;
	}
}


package com.sopra.java.patterns.model.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sopra.java.patterns.model.entities.Alumno;
import com.sopra.java.patterns.model.entities.Aula;
import com.sopra.java.patterns.model.entities.Profesor;
import com.sopra.java.patterns.model.entities.Puesto;

public class GestorDeCursos {
	private GestionAulas gestorDeAulas;
	private GestionLogs gestorDeLogs;
	private GestionPersonas gestorDePersonas;
	
	public GestorDeCursos() {
		gestorDeAulas = new GestionAulas();
		gestorDeLogs = new GestionLogs();
		gestorDePersonas = new GestionPersonas();
	}
	public void crearCurso(
			String nombre, Boolean proyector, 
			Boolean pizarra,Map<String,String> alumnos,
			String nombreProfesor, String dniProfesor) throws Exception {
		
		gestorDeAulas.crearAula(nombre, proyector, pizarra, alumnos.size());
		gestorDePersonas.crearProfesor(dniProfesor, nombreProfesor);

		Collection<Alumno> alumnosGuardados = almacenarAlumnosDesdeElGestoDeAlumnos(alumnos);
		List<Aula> aulas = gestorDeAulas.dameAulas(Arrays.asList(nombre));
		
		if(aulas.size()==1) {
			Aula aula = aulas.get(0);
			Iterator<Alumno> recorreAlumnos = alumnosGuardados.iterator();
			Iterator<Puesto> recorrePuestos = aula.getPuestosDeAlumnos().iterator();
			while(recorreAlumnos.hasNext() && recorrePuestos.hasNext()) {
				Puesto puesto = recorrePuestos.next();
				puesto.setPersona(recorreAlumnos.next());
			}
			Set<Profesor> listaProfesores = gestorDePersonas.listaProfesores();
			Profesor profesorQueBusco = new Profesor(null,dniProfesor);
			for(Profesor profe: listaProfesores) {
				if(profe.equals(profesorQueBusco)) {
					aula.getPuestoDeProfesor().setPersona(profe);
				}
			}
			
		}else {
			throw new Exception("No existe el aula");
		}
		
	}
	private Collection<Alumno> almacenarAlumnosDesdeElGestoDeAlumnos(
			Map<String, String> alumnos) {
		for(String dni: alumnos.keySet()) {
			gestorDePersonas.crearAlumno(dni, alumnos.get(dni));
		}
		Collection<Alumno> misAlumnos = new HashSet<Alumno>();
		
		Set<Alumno> listaAlumnos = gestorDePersonas.listaAlumnos();
		for(Alumno alumno : listaAlumnos) {
			if(alumnos.containsKey(alumno.getDni())) {
				misAlumnos.add(alumno);
			}
		}
		return misAlumnos;
	}

}

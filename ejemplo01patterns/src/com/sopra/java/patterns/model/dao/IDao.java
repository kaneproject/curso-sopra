package com.sopra.java.patterns.model.dao;

import com.sopra.java.patterns.model.entities.Aula;

public interface IDao<T> extends IGenericDao<T> {
	T searchByName(T elemento);
}

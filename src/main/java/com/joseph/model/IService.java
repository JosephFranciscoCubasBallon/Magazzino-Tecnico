package com.joseph.model;

import java.util.List;

import com.joseph.entities.Entity;
import com.joseph.entities.Ricambio;
import com.joseph.entities.Tecnico;

public interface IService {
	
	//CRUD - create, retrieve, update, delete
	
	//entity può essere sia ricambio che tecnico
	List<Ricambio> getAllRicambi();
	List<Tecnico> getAllTecnici();
	void setEntity(Entity entity);
	
	Entity getEntity(int id,String entity);
	Entity getRicambio(String code);
	
	boolean updateEntity(int id, String entity);
	
	boolean deleteEntity(int id,String entity);
	
}

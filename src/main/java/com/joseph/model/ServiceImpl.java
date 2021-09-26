package com.joseph.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseph.entities.Entity;
import com.joseph.entities.Ricambio;
import com.joseph.entities.Tecnico;
import com.joseph.repository.IRepository;

@Service("serviceImpl")
public class ServiceImpl implements IService {
	
	@Autowired
	IRepository repository;
	
	public ServiceImpl() {}
	
	public ServiceImpl(IRepository repository) {
		this.repository=repository;
	}

	public void setEntity(Entity entity) {
		repository.setEntity(entity);
	}

	public Entity getEntity(int id,String entity) {
		return repository.getEntity(id, entity);
	}

	public Entity getRicambio(String code) {
		return repository.getRicambio(code);
	}

	public boolean updateEntity(int id,String entity) {
		return repository.updateEntity(id, entity);
	}

	public boolean deleteEntity(int id,String entity) {
		return repository.deleteEntity(id, entity);
	}

	@Override
	public List<Ricambio> getAllRicambi() {
		return repository.getAllRicambi();
	}

	@Override
	public List<Tecnico> getAllTecnici() {
		return repository.getAllTecnici();
	}
	

}

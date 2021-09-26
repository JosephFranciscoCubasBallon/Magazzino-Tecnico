package com.joseph.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.joseph.entities.Entity;
import com.joseph.entities.Ricambio;
import com.joseph.entities.Tecnico;

@Repository("repositoryImpl")
public class RepositoryImpl implements IRepository{
	
	static List<Ricambio> ricambi = new ArrayList<Ricambio>();
	static List<Tecnico> tecnici = new ArrayList<Tecnico>();
	static List<Entity> entities = new ArrayList<Entity>();
	
	public RepositoryImpl() {}
	
	public List<Ricambio> getAllRicambi() {
		return ricambi;
	}

	public List<Tecnico> getAllTecnici() {
		return tecnici;
	}

	public void setEntity(Entity entity) {
		if(entity!=null && entity.getClass().equals(Ricambio.class))
			if(ricambi.size()==0) {
				entity.setId(1);
				ricambi.add((Ricambio)entity);
			}
			else if(ricambi.size()>=1){
				entity.setId(ricambi.size()+1);
				ricambi.add((Ricambio)entity);
			}
				
		else if(entity!=null && entity.getClass().equals(Tecnico.class))
			if(tecnici.size()==0) {
				entity.setId(1);
				tecnici.add((Tecnico)entity);
			}
			else {
				entity.setId(tecnici.size()+1);
				tecnici.add((Tecnico)entity);
			}
		else if(entity!=null)
			if(entities.size()==0)
				entity.setId(1);
			else {
				entity.setId(entities.size()+1);
				entities.add(entity);
			}
		else
			System.out.println("entity non può essere null : " + entity.getClass().toString());
	}

	public Entity getEntity(int id,String entity) {
		switch(entity.toUpperCase()) {
			case "TECNICO":
				for(Tecnico t:tecnici)
					if(t.getId()==id)
						return t;
			case "RICAMBIO":
				for(Ricambio r:ricambi)
					if(r.getId()==id)
						return r;
			case  "ENTITY":
				return entities.get(id);
			default:
				return null;
		}
		
	}

	public Entity getRicambio(String code) {
		for(Ricambio r:ricambi)
			if(r.getCode().equals(code))
				return r;
		return null;
	}

	public boolean updateEntity(int id,String entity) {
		Entity e= getEntity(id,entity);
		Scanner keyboard=new Scanner(System.in);
		System.out.println(e.toString());
		if(e.getClass().equals(Ricambio.class)) {
			Ricambio r= (Ricambio)e;
			System.out.println("new name: ");
			r.setName(keyboard.nextLine());
			System.out.println("new code: ");
			r.setCode(keyboard.nextLine());
			System.out.println("buyPrice(must be double): ");
			r.setBuyPrice(Double.parseDouble(keyboard.nextLine()));
			System.out.println("sellPrice(must be double): ");
			r.setSellPrice(Double.parseDouble(keyboard.nextLine()));
			setEntity(r);
			return true;
		}
		else if(e.getClass().equals(Tecnico.class)) {
			Tecnico t= (Tecnico)e;
			System.out.println("new username: ");
			t.setUsername(keyboard.nextLine());
			System.out.println("new password: ");
			t.setPassword(keyboard.nextLine());
			return true;
		}
		return false;
	}

	public boolean deleteEntity(int id,String entity) {
		switch(entity.toUpperCase()) {
		case "TECNICO":
			for(Tecnico t:tecnici)
				if(t.getId()==id)
					tecnici.remove(t);
			return true;
		case "RICAMBIO":
			for(Ricambio r:ricambi)
				if(r.getId()==id)
					ricambi.remove(r);
			return true;
		case  "ENTITY":
			entities.remove(id);
			return true;
		default:
			return false;
		}
	}
}

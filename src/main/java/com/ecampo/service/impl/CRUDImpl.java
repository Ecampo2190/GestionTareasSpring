package com.ecampo.service.impl;

import java.util.List;

import com.ecampo.repo.IGenericRepo;
import com.ecampo.service.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID>{
	
	protected abstract IGenericRepo<T, ID> getRepo(); 
	
	@Override
	public T save(T t) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().save(t);
	}

	@Override
	public T update(T t, ID id) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().save(t);
	}

	@Override
	public List<T> readAll() throws Exception {
		// TODO Auto-generated method stub
		return getRepo().findAll();
	}

	@Override
	public T readById(ID id) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().findById(id)
				.orElse(null);
	}

	@Override
	public void delete(ID id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}

package com.ecampo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecampo.model.User;
import com.ecampo.repo.IGenericRepo;
import com.ecampo.repo.ITaskRepo;
import com.ecampo.repo.IUserRepo;
import com.ecampo.service.IUserService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl< User, Integer> implements IUserService{
	
	private final IUserRepo repo;
	
	@Override
	public User save(User user) throws Exception {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public User update(User user, Integer id) throws Exception {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public List<User> readAll() throws Exception {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User readById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	@Override
	protected IGenericRepo<User, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}
	
	

}

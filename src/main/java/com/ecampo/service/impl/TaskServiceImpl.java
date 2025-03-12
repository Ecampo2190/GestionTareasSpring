package com.ecampo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecampo.dto.TaskDTO;
import com.ecampo.model.Task;
import com.ecampo.model.User;
import com.ecampo.repo.IGenericRepo;
import com.ecampo.repo.ITaskRepo;
import com.ecampo.service.ITaskService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl extends CRUDImpl<Task, Integer> implements ITaskService{
	
	private final ITaskRepo repo;
	
	@Override
	public Task save(Task tarea) throws Exception {
		// TODO Auto-generated method stub
		return repo.save(tarea);
	}

	@Override
	public Task update(Task tarea, Integer idTarea) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> readAll() throws Exception {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Task readById(Integer idTarea) throws Exception {
		// TODO Auto-generated method stub
		return repo.findById(idTarea).orElseThrow(()->new Exception("Tarea no encontrada con id "+idTarea));
	}

	@Override
	public void delete(Integer idTarea) throws Exception {
		// TODO Auto-generated method stub
		repo.deleteById(idTarea);
		
	}

	@Override
	protected IGenericRepo<Task, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	@Override
	public TaskDTO createTaskByUser(Integer idUsuario, TaskDTO dto) {
		// TODO Auto-generated method stub
		//User usuario=repo.findById(idUsuario).stream().;
		return new TaskDTO();
	}

	@Override
	public List<Task> tareaPorUsuario(Integer id) {
		// TODO Auto-generated method stub
		return repo.getTaskByUser(id);
	}
	
	
}

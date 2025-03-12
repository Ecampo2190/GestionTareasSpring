package com.ecampo.service;

import java.util.List;

import com.ecampo.dto.TaskDTO;
import com.ecampo.model.Task;

public interface ITaskService extends ICRUD<Task, Integer>{
	
	public TaskDTO createTaskByUser(Integer idUsuario, TaskDTO dto);
	
	public List<Task>tareaPorUsuario(Integer id);
}

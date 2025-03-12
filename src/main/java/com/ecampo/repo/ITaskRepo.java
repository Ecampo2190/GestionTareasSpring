package com.ecampo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecampo.model.Task;

public interface ITaskRepo extends IGenericRepo<Task, Integer>{
	
	//GET /users/{userId}/tasks: Obtener todas las tareas de un usuario.
	@Query("SELECT t FROM Task t WHERE t.user.id=:userid")
	List<Task> getTaskByUser(@Param("userid")Integer idUsuario);

}

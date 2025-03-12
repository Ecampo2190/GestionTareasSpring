package com.ecampo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecampo.dto.TaskDTO;
import com.ecampo.model.Task;
import com.ecampo.service.ITaskService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/task")
//@RequiredArgsConstructor
public class TaskController {
	
	private final ITaskService task;
	
	@Qualifier("taskMapper")
	private final ModelMapper maper;
	
	public TaskController(ITaskService task, @Qualifier("taskMapper") ModelMapper maper) {
		this.maper=maper;
		this.task=task;
	}
	
	@PostMapping("/users/{userId}/tasks")
	public ResponseEntity<TaskDTO>createTaskByUser(@Valid @RequestBody TaskDTO dto)throws Exception{
		Task tarea=task.save(convertirEntity(dto));
		return new ResponseEntity<>(convertirDTO(tarea), HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}/tasks")
	public ResponseEntity<List<TaskDTO>>readTaskByUser(@PathVariable("userId") Integer idUsuario)throws Exception{
		 List<TaskDTO> listaTareasDTO=task.readAll().stream()
				 				.filter(task->task.getUser().getId().equals(idUsuario))
				 				.map(this::convertirDTO)
								.collect(Collectors.toList());
		 
		 return ResponseEntity.ok(listaTareasDTO);
	}
	
	@GetMapping("/tasks/{id}")
	public ResponseEntity<TaskDTO> readAllById(@PathVariable("id")Integer id) throws Exception{
		//List<TaskDTO> list = task.readAll().stream().map(this::convertirDTO).toList();
		Task tarea=task.readById(id);
		return new ResponseEntity<>(convertirDTO(tarea), HttpStatus.OK);
	}
	
	@PutMapping("/tasks/{id}")
	public ResponseEntity<TaskDTO>updateTask(@Valid @RequestBody TaskDTO dto,@PathVariable("Id")Integer id)throws Exception{
		Task obj= task.update(convertirEntity(dto), id);
		
		return new ResponseEntity<>(convertirDTO(obj), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<Void>delete(@PathVariable("id")Integer id)throws Exception{
		task.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	private TaskDTO convertirDTO(Task obj) {
		return maper.map(obj, TaskDTO.class);
	}
	
	private Task convertirEntity(TaskDTO obj) {
		return maper.map(obj, Task.class);
	}
}

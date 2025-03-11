package com.ecampo.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecampo.dto.TaskDTO;
import com.ecampo.dto.UserDTO;
import com.ecampo.model.Task;
import com.ecampo.model.User;

@Configuration
public class MapperConfig {
	
	@Bean("taskMapper")
	public ModelMapper taskMapper() {
		ModelMapper mapper = new ModelMapper();
		TypeMap<Task, TaskDTO> task1= mapper.createTypeMap(Task.class, TaskDTO.class);
		task1.addMapping(Task::getDescription, (dest, v)->dest.setDescription((String)v));
		
		TypeMap<TaskDTO, Task> task2= mapper.createTypeMap(TaskDTO.class,Task.class);
		task2.addMapping(TaskDTO::getDescription, (dest, v)->dest.setDescription((String)v));
		
		return mapper;
	}
	
	@Bean("userMapper")
	public ModelMapper userMapper() {
		ModelMapper mapper = new ModelMapper();
		TypeMap<User, UserDTO> user1=mapper.createTypeMap(User.class, UserDTO.class);
		user1.addMapping(User::getUsername, (dest, v)->dest.setUsername((String)v));
		
		TypeMap<UserDTO, User> user2=mapper.createTypeMap(UserDTO.class,User.class);
		user2.addMapping(UserDTO::getUsername, (dest, v)->dest.setUsername((String)v));
		
		return mapper;
	}
	
}

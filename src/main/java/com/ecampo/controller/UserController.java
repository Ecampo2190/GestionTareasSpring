package com.ecampo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecampo.dto.TaskDTO;
import com.ecampo.dto.UserDTO;
import com.ecampo.model.Task;
import com.ecampo.model.User;
import com.ecampo.service.IUserService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("users_app")
//@RequiredArgsConstructor
public class UserController {
	
	private final IUserService usuario;
	@Qualifier("userMapper")
	private final ModelMapper maper;
	
	public UserController(IUserService usuario, @Qualifier("userMapper") ModelMapper maper) {
		this.usuario=usuario;
		this.maper=maper;
	}
	
	 // POST /users: Crear un usuario.
	@PostMapping("/users")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO dto)throws Exception {
		//TODO: process POST request
		User obj = usuario.save(convertirEntity(dto)); 
		
		return new ResponseEntity<>(convertirDTO(obj), HttpStatus.CREATED);
	}
	
	//GET /users: Obtener todos los usuarios.
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getUser() throws Exception{
		List<UserDTO> usr= usuario.readAll().stream().map(this::convertirDTO).toList();
		return new ResponseEntity<>(usr, HttpStatus.OK);
	}
	
	//GET /users/{id}: Obtener un usuario por su ID.
	@GetMapping("/users/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathParam("IdUsuario") Integer idUsuario)throws Exception{
		
		User obj=usuario.readById(idUsuario);
		
		return new ResponseEntity<>(convertirDTO(obj), HttpStatus.OK);
	}
	
	//PUT /users/{id}: Actualizar un usuario.
	@PutMapping("/users/{id}")
	public ResponseEntity<UserDTO> updateUserById(@Valid @RequestBody UserDTO dto
												, @PathParam("id") Integer idUsuario )throws Exception{
		
		User obj=usuario.update(convertirEntity(dto), idUsuario);
		
		return new ResponseEntity<>(convertirDTO(obj), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteUser(@PathParam("id")Integer idUsuario)throws Exception{
		usuario.delete(idUsuario);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	 /*

		DELETE /users/{id}: Eliminar un usuario.
	 */
	private UserDTO convertirDTO(User obj) {
		return maper.map(obj, UserDTO.class);
	}
	
	private User convertirEntity(UserDTO obj) {
		return maper.map(obj, User.class);
	}
}

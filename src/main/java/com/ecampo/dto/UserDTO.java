package com.ecampo.dto;

import java.security.Timestamp;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
	
	private Integer id;
	@NotNull
	@NotEmpty
	private String username;
	@NotNull
	@NotEmpty
	@Email(message="Debe ingresar un correo valido")
	private String email;
	@NotNull
	@NotEmpty
	private String password;
	private LocalDateTime created_at;
}

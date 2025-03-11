package com.ecampo.dto;

import java.security.Timestamp;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDTO {
	
	private Integer id;
	@NotNull
	@NotEmpty
	private String title;
	@NotNull
	@NotEmpty
	private String description;
	@NotNull
	@NotEmpty
	private String status;
	private LocalDateTime created_at;
}

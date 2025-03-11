package com.ecampo.exception;

import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Data;

public record CustomErrorResponse (
		LocalDateTime dateTime,
		String message,
		String path
){

}

package com.crud.salareunioes.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
	
	private Integer Status;
	
	private String msg;

	private Long timestamp;
	
	
}

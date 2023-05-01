package com.essam.employeecrudapi.exceptionhandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EntityErrorResponse {
	private Integer Status;
	private String message;
	private Long timestamp;
}

package com.HAH.mapping.model.dto;

import lombok.Data;

@Data
public class Result {

	private Status status;
	private String message;

	public enum Status {
		Success, Warning, Error
	}

	public Result() {

	}

	public Result(Status status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

}

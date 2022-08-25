package com.offer1.Housing.exception;

public class HousingException extends RuntimeException {

	private final Integer code;
	private final String message;

	public HousingException(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public HousingException(HousingExceptionEnum exceptionEnum) {
		this(exceptionEnum.getCode(), exceptionEnum.getMsg());
	}

	public Integer getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
}
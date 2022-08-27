package com.offer1.Housing.exception;

public enum HousingExceptionEnum {
	
	LISTING_NOT_FOUND(100, "no listing found"),
	HOME_NOT_FOUND(101, "no home found"),
	LISTING_CREATED_FAILED(102, "listing created failed"),
	OFFER_CREATED_FAILED(103, "offer created failed"),
	OFFER_NOT_FOUND(104, "offer not found"),
	PROPERTY_NOT_FOUND(105, "property not found");

	Integer code;
	String msg;

	HousingExceptionEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

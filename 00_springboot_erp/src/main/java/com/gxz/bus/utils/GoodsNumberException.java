package com.gxz.bus.utils;

public class GoodsNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public GoodsNumberException() {
		super();
	}

	public GoodsNumberException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

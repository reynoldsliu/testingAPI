package com.example.demo;

public class DemoVO {
	private String msg;
	private String amount;
	public DemoVO(String msg,String amount) {
		this.msg = msg;
		this.amount = amount;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getAmout() {
		return amount;
	}
	public void setAmout(String amount) {
		this.amount = amount;
	}
}

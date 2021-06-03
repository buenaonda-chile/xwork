package com.denso.common.vo;

public class AjaxResult {

	public static final String SUCCESS_CODE = "0";
	public static final String FAIL_CODE = "1";

	private String code;
	private Object result;
	private String msg;
	
	private String returnPath;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getReturnPath() {
		return returnPath;
	}
	public void setReturnPath(String returnPath) {
		this.returnPath = returnPath;
	}
}

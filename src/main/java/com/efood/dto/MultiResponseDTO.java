package com.efood.dto;

public class MultiResponseDTO<T1, T2> {
	private T1 data;
	private T2 file;
	private String errorMessage;
	public T1 getData() {
		return data;
	}
	public void setData(T1 data) {
		this.data = data;
	}
	public T2 getFile() {
		return file;
	}
	public void setFile(T2 file) {
		this.file = file;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}

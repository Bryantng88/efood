package com.efood.dto;

public class MultiFileResponseDTO<T, D> {
	private T fileData;
	private D jsonData;
	private String message;
	public T getFileData() {
		return fileData;
	}
	public void setFileData(T fileData) {
		this.fileData = fileData;
	}
	public D getJsonData() {
		return jsonData;
	}
	public void setJsonData(D jsonData) {
		this.jsonData = jsonData;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}

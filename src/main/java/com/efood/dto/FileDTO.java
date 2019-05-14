package com.efood.dto;

import com.efood.model.DBFile;

public class FileDTO {
	private String id;
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String fileName;
    private String fileType;
    private long size;

    public FileDTO(String fileName, String fileType, long size) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.size = size;
    }
    
    public void copyFrom(DBFile dbFile) {
    	this.setId(dbFile.getId());
    	this.setFileName(dbFile.getFileName());
    	this.setFileType(dbFile.getFileType());
    	this.setSize(dbFile.getSize());
    }

    public FileDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}


package com.efood.dto;


public class FileDTO {
	@Override
	public String toString() {
		return "FileDTO [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", size=" + size + ", path="
				+ path + ", fileDownloadUri=" + fileDownloadUri + "]";
	}


	private String id;
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	private String fileName;
    private String fileType;
    public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}


	private long size;
    private String path;
    private String fileDownloadUri;

    public FileDTO(String fileName, String fileType, long size, String path, String fileDownloadUri) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.size = size;
        this.path = path;
        this.fileDownloadUri = fileDownloadUri;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}


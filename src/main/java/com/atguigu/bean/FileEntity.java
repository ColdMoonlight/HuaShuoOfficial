package com.atguigu.bean;

public class FileEntity {
	
    private Integer fileId;
    
    /*****
     * 原文件名
     ***/
    
    private String titleOrig;
 
    /*****
     * 修改后文件名
     ***/
    
    private String titleAlter;
 
    /*****
     * 文件大小
     ***/
    
    private String size;
 
    /*****
     * 文件类型
     ***/
    
    private String type;
 
    /*****
     * 文件保存路径 
     ****/
    
    private String path;
 
    /*****
     * 文件上传时间
     ***/
    
    private String uploadTime;

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getTitleOrig() {
		return titleOrig;
	}

	public void setTitleOrig(String titleOrig) {
		this.titleOrig = titleOrig;
	}

	public String getTitleAlter() {
		return titleAlter;
	}

	public void setTitleAlter(String titleAlter) {
		this.titleAlter = titleAlter;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
    
}

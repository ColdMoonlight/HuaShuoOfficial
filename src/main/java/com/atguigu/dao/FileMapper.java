package com.atguigu.dao;

import com.atguigu.bean.FileEntity;

public interface FileMapper {
	
	void saveFile(FileEntity entity);
	
	
	FileEntity findByid(long id);
}

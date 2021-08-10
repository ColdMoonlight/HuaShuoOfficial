package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.FileEntity;
import com.atguigu.dao.FileMapper;

@Service
public class FileService {
	@Autowired
	private FileMapper fileMapper;
	
	public void saveFile(FileEntity entity) {
		fileMapper.saveFile(entity);
	}
	
	public FileEntity findByid(long id) {
		return fileMapper.findByid(id);
		
	}

}

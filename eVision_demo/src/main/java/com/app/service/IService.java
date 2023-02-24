package com.app.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Image;

public interface IService {

	void storeImage(MultipartFile cImage, MultipartFile pImage, String result);
	byte[] getImageById(int id);
	void updateImageById(int id, MultipartFile cImage, MultipartFile pImage, String result);
	void deleteImageById(int id);
	public Image getImage(@PathVariable("id") int id);
}

package com.app.service;

import java.io.IOException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Image;
import com.app.repo.ImageRepo;

import antlr.collections.List;

@Service
@Transactional
public class IServiceImpl implements IService {

	@Autowired
	ImageRepo imagerepo ;
	
	@Override
	public void storeImage(MultipartFile cImage, MultipartFile pImage, String result) {
		Image image = new Image();
		try {
			image.setcImage(cImage.getBytes());
			image.setpImage(pImage.getBytes());
			image.setResult(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		imagerepo.save(image);
	}

	
	@Override
	public byte[] getImageById(@PathVariable("id") int id) {
		Optional<Image> imageData = imagerepo.findById(id);
		return imageData.get().getcImage();
	}
	
	
	@Override
	public Image getImage(@PathVariable("id") int id) {
		Image image = new Image();
		image = imagerepo.getById(id);
		image.getcImage();
		image.getpImage();
		return image;
	}
	
	@Override
	public void deleteImageById(int id) {
		imagerepo.deleteById(id);

	}

	@Override
	public void updateImageById(int id, MultipartFile cImage, MultipartFile pImage, String result) {
		Image image = new Image();
		image = imagerepo.getById(id);
		try {
			image.setcImage(cImage.getBytes());
			image.setpImage(pImage.getBytes());
			image.setResult(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		imagerepo.save(image);
	}

}

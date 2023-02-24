package com.app.controller;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.util.BytesHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.util.ArrayUtils;

import com.app.entity.Image;
import com.app.repo.ImageRepo;
import com.app.service.IService;


@RestController
@RequestMapping("/image")
public class ImageController {

	@Autowired
	IService iservice;
	@Autowired
	ImageRepo imagerepo;
	
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("cImage") MultipartFile cImage, @RequestParam("pImage") MultipartFile pImage, @RequestParam("result") String result) {
		iservice.storeImage(cImage, pImage, result);
	}
	
	@GetMapping(value = "/download/{id}", produces = {MediaType.IMAGE_PNG_VALUE ,MediaType.IMAGE_PNG_VALUE})
	public ResponseEntity<byte[]>  downloadImage(@PathVariable("id") int id) {
//		List<byte[]> list1 = imagerepo.getImages(id);
//		List<byte[]> list2 = imagerepo.getImage(id);
////		return list;
//		List<byte[]> list = new ArrayList<>();
//		list.addAll(list1);
//		list.addAll(list2);
// //[B@5d20c3 // [B@1cc984fb  //[B@6161e023
//		System.out.println("displayed");
//		return ResponseEntity.status(HttpStatus.OK).body(list);
		
		List<byte[]> list = imagerepo.getImage(id);
		System.out.println(list.get(0));
		return ResponseEntity.status(HttpStatus.OK).body(list.get(0));
		
//		static Object[] convertToObjectArray(Object array) {
//		    Class ofArray = array.getClass().getComponentType();
//		    if (ofArray.isPrimitive()) {
//		        List ar = new ArrayList();
//		        int length = Array.getLength(array);
//		        for (int i = 0; i < length; i++) {
//		            ar.add(Array.get(array, i));
//		        }
//		        return ar.toArray();
//		    }
//		    else {
//		        return (Object[]) array;
//		    }
//		}
	}
	
//	@GetMapping("/download/{id}")
//	public ResponseEntity<Image> downloadImage(@PathVariable("id") int id) {
//		Image image = iservice.getImage(id);
//		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
//	}
	
	@PutMapping("/update/{id}")
	public void updateImage(@PathVariable("id") int id, @RequestBody MultipartFile cImage, @RequestBody MultipartFile pImage, String result) {
		iservice.updateImageById(id, cImage, pImage, result);
	}
	
	@DeleteMapping("/remove/{id}")
	public void deleteImage(@PathVariable("id") int id) {
		iservice.deleteImageById(id);
	}
}

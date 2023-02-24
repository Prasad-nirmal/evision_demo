package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entity.Image;

public interface ImageRepo extends JpaRepository<Image, Integer>{

//	@Query (value = "select c_image from data where image_id=?1" , nativeQuery= true)
//	public List<byte[]>  getImages(@RequestParam("id") int id);
//	
//	@Query (value = "select p_image from data where image_id=?1" , nativeQuery= true)
//	public List<byte[]>  getImage(@RequestParam("id") int id);
	
	@Query (value = "select c_image,p_image from data where image_id=?1" , nativeQuery= true)
	public List<byte[]>  getImage(@RequestParam("id") int id);
}

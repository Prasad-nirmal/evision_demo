package com.app.entity;

import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "data")
public class Image {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "Image_Id")
	private int imgId;
	
	@Lob
	@Column (name = "cImage")
	@JsonManagedReference
	private byte[] cImage;
	
	@Lob
	@Column (name = "pImage")
	@JsonManagedReference
	private byte[] pImage;
	
	@CreationTimestamp
	@Column (name = "TimeStamp")
	private Timestamp createdDate;
	
	@Column (name = "result")
	private String result;

	public int getImgId() {
		return imgId;
	}

	public byte[] getcImage() {
		return cImage;
	}

	public void setcImage(byte[] cImage) {
		this.cImage = cImage;
	}

	public byte[] getpImage() {
		return pImage;
	}

	public void setpImage(byte[] pImage) {
		this.pImage = pImage;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Image(int imgId, byte[] cImage, byte[] pImage, Timestamp createdDate, String result) {
		super();
		this.imgId = imgId;
		this.cImage = cImage;
		this.pImage = pImage;
		this.createdDate = createdDate;
		this.result = result;
	}

	@Override
	public String toString() {
		return "Image [imgId=" + imgId + ", cImage=" + Arrays.toString(cImage) + ", pImage=" + Arrays.toString(pImage)
				+ ", createdDate=" + createdDate + ", result=" + result + "]";
	}
	
	
	
}

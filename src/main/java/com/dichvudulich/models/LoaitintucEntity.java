package com.dichvudulich.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "loaitintuc")
public class LoaitintucEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max = 10)
	private String maloaitintuc;
	@Size(max = 50)
	private String tenloaitintuc;
	private Boolean trangthai;

	public LoaitintucEntity() {
		super();
	}

	public LoaitintucEntity(@Size(max = 10) String maloaitintuc, @Size(max = 255) String tenloaitintuc,
			Boolean trangthai) {
		super();
		this.maloaitintuc = maloaitintuc;
		this.tenloaitintuc = tenloaitintuc;
		this.trangthai = trangthai;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaloaitintuc() {
		return maloaitintuc;
	}

	public void setMaloaitintuc(String maloaitintuc) {
		this.maloaitintuc = maloaitintuc;
	}

	public String getTenloaitintuc() {
		return tenloaitintuc;
	}

	public void setTenloaitintuc(String tenloaitintuc) {
		this.tenloaitintuc = tenloaitintuc;
	}

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

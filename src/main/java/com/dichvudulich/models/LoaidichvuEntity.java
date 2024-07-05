package com.dichvudulich.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "loaidichvu")
public class LoaidichvuEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max = 10)
	private String maloaidichvu;
	@Size(max = 50)
	private String tenloaidichvu;
	private Boolean trangthai;

	public LoaidichvuEntity() {
		super();
	}

	public LoaidichvuEntity(Long id, @Size(max = 10) String maloaidichvu, @Size(max = 50) String tenloaidichvu,
			Boolean trangthai) {
		super();
		this.id = id;
		this.maloaidichvu = maloaidichvu;
		this.tenloaidichvu = tenloaidichvu;
		this.trangthai = trangthai;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaloaidichvu() {
		return maloaidichvu;
	}

	public void setMaloaidichvu(String maloaidichvu) {
		this.maloaidichvu = maloaidichvu;
	}

	public String getTenloaidichvu() {
		return tenloaidichvu;
	}

	public void setTenloaidichvu(String tenloaidichvu) {
		this.tenloaidichvu = tenloaidichvu;
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

package com.dichvudulich.models;

public class OrderDTO {
	private Integer id;
	private String maloaitour;
	private String tenloaitour;
	private String diadiem;
	private Boolean trangthai;

	// Constructors, getters, and setters
	public OrderDTO(Integer id, String maloaitour, String tenloaitour, String diadiem, Boolean trangthai) {
		this.id = id;
		this.maloaitour = maloaitour;
		this.tenloaitour = tenloaitour;
		this.diadiem = diadiem;
		this.trangthai = trangthai;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaloaitour() {
		return maloaitour;
	}

	public void setMaloaitour(String maloaitour) {
		this.maloaitour = maloaitour;
	}

	public String getTenloaitour() {
		return tenloaitour;
	}

	public void setTenloaitour(String tenloaitour) {
		this.tenloaitour = tenloaitour;
	}

	public String getDiadiem() {
		return diadiem;
	}

	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}

	// Getters and setters (omitted for brevity)

}

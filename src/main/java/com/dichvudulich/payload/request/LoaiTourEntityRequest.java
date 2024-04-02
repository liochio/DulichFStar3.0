package com.dichvudulich.payload.request;

import jakarta.validation.constraints.Size;

public class LoaiTourEntityRequest {

	@Size(max = 10)
	private String maloaitour;
	@Size(max = 50)
	private String tenloaitour;
	private Boolean trangthai;

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

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(boolean b) {
		this.trangthai = b;
	}

}

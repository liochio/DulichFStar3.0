package com.dichvudulich.payload.request;

import jakarta.validation.constraints.Size;

public class LoaiTintucEntityRequest {

	@Size(max = 10)
	private String maloaitintuc;
	@Size(max = 50)
	private String tenloaitintuc;
	private Boolean trangthai;

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

}

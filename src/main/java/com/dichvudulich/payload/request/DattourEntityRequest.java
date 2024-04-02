package com.dichvudulich.payload.request;

import java.util.Date;

import jakarta.validation.constraints.Size;

public class DattourEntityRequest {

	@Size(max = 50)
	private String tenloaitour;
	@Size(max = 100)
	private String hinhanh;
	private Date thoigiankhoihanh;
	private Date thoigiandat;
	private Integer soluongkhach;
	@Size(max = 50)
	private String tenloaidichvu;
	@Size(max = 100)
	private String tenkhachhang;
	@Size(max = 255)
	private String ghichu;
	private Integer tongtien;
	private Boolean trangthai;

	public String getTenloaitour() {
		return tenloaitour;
	}

	public void setTenloaitour(String tenloaitour) {
		this.tenloaitour = tenloaitour;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public Date getThoigiankhoihanh() {
		return thoigiankhoihanh;
	}

	public void setThoigiankhoihanh(Date thoigiankhoihanh) {
		this.thoigiankhoihanh = thoigiankhoihanh;
	}

	public Date getThoigiandat() {
		return thoigiandat;
	}

	public void setThoigiandat(Date thoigiandat) {
		this.thoigiandat = thoigiandat;
	}

	public Integer getSoluongkhach() {
		return soluongkhach;
	}

	public void setSoluongkhach(Integer soluongkhach) {
		this.soluongkhach = soluongkhach;
	}

	public String getTenloaidichvu() {
		return tenloaidichvu;
	}

	public void setTenloaidichvu(String tenloaidichvu) {
		this.tenloaidichvu = tenloaidichvu;
	}

	public String getTenkhachhang() {
		return tenkhachhang;
	}

	public void setTenkhachhang(String tenkhachhang) {
		this.tenkhachhang = tenkhachhang;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public Integer getTongtien() {
		return tongtien;
	}

	public void setTongtien(Integer tongtien) {
		this.tongtien = tongtien;
	}

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}

}

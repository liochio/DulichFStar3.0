package com.dichvudulich.payload.request;

import java.util.Date;

import jakarta.validation.constraints.Size;

public class TourEntityRequest {

	@Size(max = 255)
	private String mota;
	@Size(max = 255)
	private String motachitiet;
	@Size(max = 100)
	private String hinhanh;
	private Integer gia;
	@Size(max = 100)
	private String diadiem;
	private Date thoigiankhoihanh;
	private Integer soluongkhach;
	private Boolean trangthai;

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getMotachitiet() {
		return motachitiet;
	}

	public void setMotachitiet(String motachitiet) {
		this.motachitiet = motachitiet;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public Integer getGia() {
		return gia;
	}

	public void setGia(Integer gia) {
		this.gia = gia;
	}

	public String getDiadiem() {
		return diadiem;
	}

	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}

	public Date getThoigiankhoihanh() {
		return thoigiankhoihanh;
	}

	public void setThoigiankhoihanh(Date thoigiankhoihanh) {
		this.thoigiankhoihanh = thoigiankhoihanh;
	}

	public Integer getSoluongkhach() {
		return soluongkhach;
	}

	public void setSoluongkhach(Integer soluongkhach) {
		this.soluongkhach = soluongkhach;
	}

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}

}

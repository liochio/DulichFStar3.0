package com.dichvudulich.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dattour")
public class Dattour implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
	
	@OneToOne
	@JoinColumn(name = "id_khachhang")
	private KhachhangEntity khachhang;

	public Dattour() {
		super();
	}

	public Dattour(@Size(max = 50) String tenloaitour, @Size(max = 100) String hinhanh, Date thoigiankhoihanh,
			Date thoigiandat, Integer soluongkhach, @Size(max = 50) String tenloaidichvu,
			@Size(max = 100) String tenkhachhang, @Size(max = 255) String ghichu, Integer tongtien, Boolean trangthai) {
		super();
		this.tenloaitour = tenloaitour;
		this.hinhanh = hinhanh;
		this.thoigiankhoihanh = thoigiankhoihanh;
		this.thoigiandat = thoigiandat;
		this.soluongkhach = soluongkhach;
		this.tenloaidichvu = tenloaidichvu;
		this.tenkhachhang = tenkhachhang;
		this.ghichu = ghichu;
		this.tongtien = tongtien;
		this.trangthai = trangthai;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public KhachhangEntity getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachhangEntity khachhang) {
		this.khachhang = khachhang;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

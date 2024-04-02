package com.dichvudulich.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "hoadon")
public class HoadonEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max = 100)
	private String tenkhachhang;
	@Size(max = 50)
	private String tenloaitour;
	@Size(max = 50)
	private String tenloaidichvu;
	private Integer tongtien;
	private Boolean trangthai;
	@Size(max = 11)
	private String sdt;
	@Size(max = 100)
	private String diachi;
	@Size(max = 100)
	private String email;
	private Date thoigian;
	private Date thoigiankhoihanh;

	@OneToOne
	@JoinColumn(name = "id_khachhang")
	private KhachhangEntity khachhang;

	public HoadonEntity() {
		super();
	}

	public HoadonEntity(Long id, @Size(max = 100) String tenkhachhang, @Size(max = 50) String tenloaitour,
			@Size(max = 50) String tenloaidichvu, Integer tongtien, Boolean trangthai, @Size(max = 11) String sdt,
			@Size(max = 100) String diachi, @Size(max = 100) String email, Date thoigian, Date thoigiankhoihanh) {
		super();
		this.id = id;
		this.tenkhachhang = tenkhachhang;
		this.tenloaitour = tenloaitour;
		this.tenloaidichvu = tenloaidichvu;
		this.tongtien = tongtien;
		this.trangthai = trangthai;
		this.sdt = sdt;
		this.diachi = diachi;
		this.email = email;
		this.thoigian = thoigian;
		this.thoigiankhoihanh = thoigiankhoihanh;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenkhachhang() {
		return tenkhachhang;
	}

	public void setTenkhachhang(String tenkhachhang) {
		this.tenkhachhang = tenkhachhang;
	}

	public String getTenloaitour() {
		return tenloaitour;
	}

	public void setTenloaitour(String tenloaitour) {
		this.tenloaitour = tenloaitour;
	}

	public String getTenloaidichvu() {
		return tenloaidichvu;
	}

	public void setTenloaidichvu(String tenloaidichvu) {
		this.tenloaidichvu = tenloaidichvu;
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

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getThoigian() {
		return thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	public Date getThoigiankhoihanh() {
		return thoigiankhoihanh;
	}

	public void setThoigiankhoihanh(Date thoigiankhoihanh) {
		this.thoigiankhoihanh = thoigiankhoihanh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

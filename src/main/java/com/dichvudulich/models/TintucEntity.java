package com.dichvudulich.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tintuc")
public class TintucEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max = 100)
	private String tieude;
	@Size(max = 255)
	private String noidung;
	@Size(max = 255)
	private String hinhanh;
	private Boolean trangthai;

	private Date thoigian;

	public TintucEntity() {
		super();
	}

	public TintucEntity(Long id, @Size(max = 100) String tieude, @Size(max = 255) String noidung,
			@Size(max = 255) String hinhanh, Boolean trangthai, Date thoigian, LoaitintucEntity loaitintuc,
			List<NhanvienEntity> entities) {
		super();
		this.id = id;
		this.tieude = tieude;
		this.noidung = noidung;
		this.hinhanh = hinhanh;
		this.trangthai = trangthai;
		this.thoigian = thoigian;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}

	public Date getThoigian() {
		return thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

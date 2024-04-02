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
@Table(name = "tour")
public class TourEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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

	@OneToOne
	@JoinColumn(name = "id_loaitour")
	private LoaitourEntity loaitour;

	public TourEntity() {
		super();
	}

	public TourEntity(@Size(max = 255) String mota, @Size(max = 255) String motachitiet,
			@Size(max = 100) String hinhanh, Integer gia, @Size(max = 100) String diadiem, Date thoigiankhoihanh,
			Integer soluongkhach, Boolean trangthai) {
		super();
		this.mota = mota;
		this.motachitiet = motachitiet;
		this.hinhanh = hinhanh;
		this.gia = gia;
		this.diadiem = diadiem;
		this.thoigiankhoihanh = thoigiankhoihanh;
		this.soluongkhach = soluongkhach;
		this.trangthai = trangthai;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LoaitourEntity getLoaitour() {
		return loaitour;
	}

	public void setLoaitour(LoaitourEntity loaitour) {
		this.loaitour = loaitour;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

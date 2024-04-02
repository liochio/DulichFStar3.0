package com.dichvudulich.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dichvu")
public class DichvuEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max = 100)
	private String tieude;
	@Size(max = 255)
	private String mota;
	@Size(max = 255)
	private String hinhanh;
	private Long gia;
	private Boolean trangthai;

	@OneToOne
	@JoinColumn(name = "id_loaidichvu")
	private LoaidichvuEntity loaidichvu;

	@OneToMany(mappedBy = "dichvu")
	private List<NhanvienEntity> entities = new ArrayList<>();

	public DichvuEntity() {
		super();
	}

	public DichvuEntity(Long id, @Size(max = 100) String tieude, @Size(max = 255) String mota,
			@Size(max = 255) String hinhanh, Long gia, Boolean trangthai) {
		super();
		this.id = id;
		this.tieude = tieude;
		this.mota = mota;
		this.hinhanh = hinhanh;
		this.gia = gia;
		this.trangthai = trangthai;
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

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public Long getGia() {
		return gia;
	}

	public void setGia(Long gia) {
		this.gia = gia;
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

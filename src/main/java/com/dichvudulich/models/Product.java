package com.dichvudulich.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

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
	
	
	private Integer product_id;
	
	


	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

}

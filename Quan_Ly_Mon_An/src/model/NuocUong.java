package model;

import java.sql.Date;

public class NuocUong {
	private int maNuoc;
	private String tenNuoc;
	private String loai;
	private Double giaBan;
	private int soLuong;
	private Date ngayNhap;
		
	public NuocUong() {
	}

	public NuocUong(int maNuoc, String tenNuoc, String loai, Double giaBan, int soLuong, Date ngayNhap) {		
		this.maNuoc = maNuoc;
		this.tenNuoc = tenNuoc;
		this.loai = loai;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.ngayNhap = ngayNhap;
	}

	public int getMaNuoc() {
		return maNuoc;
	}

	public void setMaNuoc(int maNuoc) {
		this.maNuoc = maNuoc;
	}

	public String getTenNuoc() {
		return tenNuoc;
	}

	public void setTenNuoc(String tenNuoc) {
		this.tenNuoc = tenNuoc;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public Double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(Double giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	
	
	
}

package model;

import java.sql.Date;

public class MonAn {
	private int maMonAn;
	private String tenMonAn;
	private String loaiMonAn;
	private String nguyenLieu;
	private double giaBan;
	private int soLuong;
	private Date ngayNhap;
	
	public MonAn() {
	}

	public MonAn(int maMonAn, String tenMonAn, String loaiMonAn, String nguyenLieu, double giaBan, int soLuong,
			Date ngayNhap) {
		this.maMonAn = maMonAn;
		this.tenMonAn = tenMonAn;
		this.loaiMonAn = loaiMonAn;
		this.nguyenLieu = nguyenLieu;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.ngayNhap = ngayNhap;
	}

	public int getMaMonAn() {
		return maMonAn;
	}

	public void setMaMonAn(int maMonAn) {
		this.maMonAn = maMonAn;
	}

	public String getTenMonAn() {
		return tenMonAn;
	}

	public void setTenMonAn(String tenMonAn) {
		this.tenMonAn = tenMonAn;
	}

	public String getLoaiMonAn() {
		return loaiMonAn;
	}

	public void setLoaiMonAn(String loaiMonAn) {
		this.loaiMonAn = loaiMonAn;
	}

	public String getNguyenLieu() {
		return nguyenLieu;
	}

	public void setNguyenLieu(String nguyenLieu) {
		this.nguyenLieu = nguyenLieu;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
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

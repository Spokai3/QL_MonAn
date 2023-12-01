package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;
import model.MonAn;
import view.QLMAView;

public class MonAnDAO implements DAOInterface<MonAn>{
		
	public QLMAView view;
	public static MonAnDAO getInstance() {
		return new MonAnDAO();
	}
	public void insert(MonAn t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO sanpham (maMonAn, tenMonAn, loaiMonAn, nguyenLieu, giaBan, soLuong, ngayNhap)" +
						" VALUES(?,?,?,?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, t.getMaMonAn());
			pst.setString(2, t.getTenMonAn());
			pst.setString(3, t.getLoaiMonAn());
			pst.setString(4, t.getNguyenLieu());
			pst.setDouble(5, t.getGiaBan());
			pst.setInt(6, t.getSoLuong());
			pst.setDate(7, t.getNgayNhap());
			
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void update(MonAn t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "UPDATE sanpham "+
						"SET" +
						" tenMonAn=?"+
						", loaiMonAn=?"+
						", nguyenLieu=?"+
						", giaBan=?"+
						", soLuong=?"+
						", ngayNhap=?"+
						" WHERE maMonAn=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getTenMonAn());
			pst.setString(2, t.getLoaiMonAn());
			pst.setString(3, t.getNguyenLieu());
			pst.setDouble(4, t.getGiaBan());
			pst.setInt(5, t.getSoLuong());
			pst.setDate(6, t.getNgayNhap());
			pst.setInt(7, t.getMaMonAn());
			
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void delete(MonAn t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "DELETE from sanpham " +
						" WHERE maMonAn=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, t.getMaMonAn());
			
			pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public MonAn selectedByName(MonAn t) {
		MonAn ketQua = null;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM sanpham WHERE tenMonAn=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getTenMonAn());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int maMonAn = rs.getInt("maMonAn");
				String tenMonAn = rs.getString("tenMonAn");
				String loaiMonAn =rs.getString("loaiMonAn");
				String nguyenLieu = rs.getString("nguyenLieu");
				Double giaBan = rs.getDouble("giaBan");
				int soLuong = rs.getInt("soLuong");
				Date ngayNhap = rs.getDate("ngayNhap");
				
				MonAn ma = new MonAn(maMonAn, tenMonAn, loaiMonAn ,nguyenLieu, giaBan, soLuong ,ngayNhap);
				ketQua = ma;				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
				

}

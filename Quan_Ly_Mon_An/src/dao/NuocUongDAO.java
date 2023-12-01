package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.JDBCUtil;
import model.NuocUong;

public class NuocUongDAO implements DAOInterface<NuocUong>{

	public static NuocUongDAO getInstance() {
		return new NuocUongDAO();
	}
	@Override
	public void insert(NuocUong t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO nuocuong (maNuoc, tenNuoc, loai, giaBan, soLuong, ngayNhap)" + 
						" VALUES(?,?,?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, t.getMaNuoc());
			pst.setString(2, t.getTenNuoc());
			pst.setString(3, t.getLoai());
			pst.setDouble(4, t.getGiaBan());
			pst.setInt(5, t.getSoLuong());
			pst.setDate(6, t.getNgayNhap());
			
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(con);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	@Override
	public void update(NuocUong t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "UPDATE nuocuong " +
						"SET" +
						" tenNuoc=?"+
						", loai=?"+
						", giaBan=?"+
						", soLuong=?"+
						", ngayNhap=?"+
						" WHERE maNuoc=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getTenNuoc());
			pst.setString(2, t.getLoai());
			pst.setDouble(3, t.getGiaBan());
			pst.setInt(4, t.getSoLuong());
			pst.setDate(5, t.getNgayNhap());
			pst.setInt(6, t.getMaNuoc());
			
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(NuocUong t) {
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "DELETE from nuocuong "+
						" WHERE maNuoc=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, t.getMaNuoc());
			
			pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public NuocUong selectedByName(NuocUong t) {
		NuocUong ketQua = null;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM nuocuong WHERE tenNuoc=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getTenNuoc());
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				int maNuoc = rs.getInt("maNuoc");
				String tenNuoc = rs.getString("tenNuoc");
				String loai = rs.getString("loai");
				Double giaBan = rs.getDouble("giaBan");
				int soLuong = rs.getInt("soLuong");
				Date ngayNhap = rs.getDate("ngayNhap");
				
				NuocUong nu = new NuocUong(maNuoc, tenNuoc, loai, giaBan, soLuong, ngayNhap);
				ketQua = nu;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}

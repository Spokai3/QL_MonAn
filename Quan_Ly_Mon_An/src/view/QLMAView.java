package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import controller.QLMAController;
import controller.QLNUController;
import model.MonAn;
import model.NuocUong;
import model.QLMAModel;
import dao.MonAnDAO;
import dao.NuocUongDAO;
import db.JDBCUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class QLMAView extends JFrame {

	private JPanel contentPane;
	public JTable table;
	public MonAnDAO daoMA;
	public NuocUongDAO daoNU;
	public QLMAModel model;
	public JTextField textField_maMon;
	public JTextField textField_tenMon;
	public JTextField textField_loaiMon;
	public JTextField textField_giaBanMA;
	public JTextField textField_soLuongMA;
	public JTextField textField_ngayNhapMA;
	public JTextField textField_maNuoc;
	public JTextField textField_tenNuoc;
	public JTextField textField_loaiNuoc;
	public JTextField textField_soLuongNU;
	public JTextField textField_ngayNhapNU;
	public JTable table_1;
	public JTextField textField_nuyenLieu;
	public JTextField textField_giaBanNU;
	public DefaultTableModel table_model;
	public DefaultTableModel table_model1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLMAView frame = new QLMAView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLMAView() {
		setTitle("Quản Lý Món Ăn");
		this.model = new QLMAModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 622);
		
		ActionListener ac = new QLMAController(this);		
		ActionListener ac1 = new QLNUController(this);
		MouseListener ml = new QLMAController(this);
		MouseListener ml1 = new QLNUController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu Menu_About = new JMenu("About");
		menuBar.add(Menu_About);
		
		JMenuItem MenuItem_About = new JMenuItem("About me");
		MenuItem_About.addActionListener(ac);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Menu_About.add(MenuItem_About);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 978, 583);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Món Ăn", null, panel, null);
		panel.setLayout(null);
								
	
		
		table = new JTable();		
		table.addMouseListener(ml);
		table_model = (DefaultTableModel) table.getModel();
		table_model.setColumnIdentifiers(new Object[] {"Mã món ăn","Tên món ăn","Loại món ăn","Nguyên liệu","Giá bán","Số lượng","Ngày nhập"});		
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 953, 226);
		panel.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Mã món ăn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 280, 111, 20);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 249, 953, 2);
		panel.add(separator);
		
		JLabel lblTnMnn = new JLabel("Tên món ăn");
		lblTnMnn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnMnn.setBounds(10, 340, 111, 20);
		panel.add(lblTnMnn);
		
		JLabel lblLoiMnn = new JLabel("Loại món ăn");
		lblLoiMnn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoiMnn.setBounds(10, 398, 111, 25);
		panel.add(lblLoiMnn);
		
		textField_maMon = new JTextField();
		textField_maMon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_maMon.setBounds(131, 275, 201, 25);
		panel.add(textField_maMon);
		textField_maMon.setColumns(10);
		
		textField_tenMon = new JTextField();
		textField_tenMon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_tenMon.setColumns(10);
		textField_tenMon.setBounds(131, 340, 201, 25);
		panel.add(textField_tenMon);
		
		textField_loaiMon = new JTextField();
		textField_loaiMon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_loaiMon.setColumns(10);
		textField_loaiMon.setBounds(131, 400, 201, 25);
		panel.add(textField_loaiMon);
		
		JLabel lblNguynLiu = new JLabel("Giá bán");
		lblNguynLiu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNguynLiu.setBounds(479, 278, 111, 25);
		panel.add(lblNguynLiu);
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSLng.setBounds(479, 334, 111, 32);
		panel.add(lblSLng);
		
		JLabel lblNgyNhp = new JLabel("Ngày nhập");
		lblNgyNhp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgyNhp.setBounds(479, 399, 111, 23);
		panel.add(lblNgyNhp);
		
		textField_giaBanMA = new JTextField();
		textField_giaBanMA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_giaBanMA.setColumns(10);
		textField_giaBanMA.setBounds(611, 275, 201, 25);
		panel.add(textField_giaBanMA);
		
		textField_soLuongMA = new JTextField();
		textField_soLuongMA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_soLuongMA.setColumns(10);
		textField_soLuongMA.setBounds(611, 340, 201, 25);
		panel.add(textField_soLuongMA);
		
		textField_ngayNhapMA = new JTextField();
		textField_ngayNhapMA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_ngayNhapMA.setColumns(10);
		textField_ngayNhapMA.setBounds(611, 400, 201, 25);
		panel.add(textField_ngayNhapMA);
		
		
		
		JButton btn_moiMA = new JButton("Mới");
		btn_moiMA.addActionListener(ac);
		btn_moiMA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_moiMA.setBounds(78, 500, 119, 32);
		panel.add(btn_moiMA);
		
		JButton btn_LuuMA = new JButton("Lưu");
		btn_LuuMA.addActionListener(ac);
		btn_LuuMA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_LuuMA.setBounds(246, 500, 119, 32);
		panel.add(btn_LuuMA);
		
		JButton btn_capNhatMA = new JButton("Cập nhật");
		btn_capNhatMA.addActionListener(ac);
		btn_capNhatMA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_capNhatMA.setBounds(419, 500, 119, 32);
		panel.add(btn_capNhatMA);
		
		JButton btn_xoaMA = new JButton("Xóa");
		btn_xoaMA.addActionListener(ac);
		btn_xoaMA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_xoaMA.setBounds(578, 500, 119, 32);
		panel.add(btn_xoaMA);
		
		JLabel lblNguynLiu_1 = new JLabel("Nguyên liệu");
		lblNguynLiu_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNguynLiu_1.setBounds(10, 455, 111, 25);
		panel.add(lblNguynLiu_1);
		
		textField_nuyenLieu = new JTextField();
		textField_nuyenLieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_nuyenLieu.setColumns(10);
		textField_nuyenLieu.setBounds(131, 457, 201, 25);
		panel.add(textField_nuyenLieu);
		
		JButton btn_timMA = new JButton("Tìm");
		btn_timMA.addActionListener(ac);
		btn_timMA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_timMA.setBounds(737, 500, 119, 32);
		panel.add(btn_timMA);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		tabbedPane.addTab("Nước uống", null, panel_1, null);
		
		table_1 = new JTable();
		table_1.addMouseListener(ml1);
		table_model1 = (DefaultTableModel) table_1.getModel();
		table_model1.setColumnIdentifiers(new Object[] {"Mã nước", "Tên nước", "Loại", "Giá bán", "Số lượng", "Ngày nhập"});		
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
					
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(10, 11, 953, 226);
		panel_1.add(scrollPane_1);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Mã nước");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 280, 111, 20);
		panel_1.add(lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 249, 953, 2);
		panel_1.add(separator_1);
		
		JLabel lblTnMnn_1 = new JLabel("Tên nước");
		lblTnMnn_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTnMnn_1.setBounds(10, 340, 111, 20);
		panel_1.add(lblTnMnn_1);
		
		JLabel lblLoiMnn_1 = new JLabel("Loại");
		lblLoiMnn_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoiMnn_1.setBounds(10, 398, 111, 25);
		panel_1.add(lblLoiMnn_1);
		
		textField_maNuoc = new JTextField();
		textField_maNuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_maNuoc.setColumns(10);
		textField_maNuoc.setBounds(131, 275, 201, 25);
		panel_1.add(textField_maNuoc);
		
		textField_tenNuoc = new JTextField();
		textField_tenNuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_tenNuoc.setColumns(10);
		textField_tenNuoc.setBounds(131, 340, 201, 25);
		panel_1.add(textField_tenNuoc);
		
		textField_loaiNuoc = new JTextField();
		textField_loaiNuoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_loaiNuoc.setColumns(10);
		textField_loaiNuoc.setBounds(131, 400, 201, 25);
		panel_1.add(textField_loaiNuoc);
		
		JLabel lblSLng_1 = new JLabel("Số lượng");
		lblSLng_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSLng_1.setBounds(479, 334, 111, 32);
		panel_1.add(lblSLng_1);
		
		JLabel lblNgyNhp_1 = new JLabel("Ngày nhập");
		lblNgyNhp_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgyNhp_1.setBounds(479, 399, 111, 23);
		panel_1.add(lblNgyNhp_1);
		
		textField_soLuongNU = new JTextField();
		textField_soLuongNU.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_soLuongNU.setColumns(10);
		textField_soLuongNU.setBounds(611, 340, 201, 25);
		panel_1.add(textField_soLuongNU);
		
		textField_ngayNhapNU = new JTextField();
		textField_ngayNhapNU.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_ngayNhapNU.setColumns(10);
		textField_ngayNhapNU.setBounds(611, 400, 201, 25);
		panel_1.add(textField_ngayNhapNU);
		
		JButton btn_moiNU = new JButton("Mới");
		btn_moiNU.addActionListener(ac1);
		btn_moiNU.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_moiNU.setBounds(76, 481, 119, 32);
		panel_1.add(btn_moiNU);
		
		JButton btn_luuNU = new JButton("Lưu");		
		btn_luuNU.addActionListener(ac1);
		btn_luuNU.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_luuNU.setBounds(240, 481, 119, 32);
		panel_1.add(btn_luuNU);
		
		JButton btn_capNhatNU = new JButton("Cập nhật");
		btn_capNhatNU.addActionListener(ac1);
		btn_capNhatNU.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_capNhatNU.setBounds(398, 481, 119, 32);
		panel_1.add(btn_capNhatNU);
		
		JButton btn_xoaNU = new JButton("Xóa");
		btn_xoaNU.addActionListener(ac1);
		btn_xoaNU.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_xoaNU.setBounds(552, 481, 119, 32);
		panel_1.add(btn_xoaNU);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giá bán");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(479, 280, 111, 20);
		panel_1.add(lblNewLabel_1_1);
		
		textField_giaBanNU = new JTextField();
		textField_giaBanNU.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_giaBanNU.setColumns(10);
		textField_giaBanNU.setBounds(611, 275, 201, 25);
		panel_1.add(textField_giaBanNU);
		
		JButton btn_timNU = new JButton("Tìm");
		btn_timNU.addActionListener(ac1);
		btn_timNU.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_timNU.setBounds(709, 481, 119, 32);
		panel_1.add(btn_timNU);
		
		this.setVisible(true);
		hienThiBang();
		hienThiBang1();
	}

	public void xoaForm() {
		textField_giaBanMA.setText("");
		textField_loaiMon.setText("");
		textField_maMon.setText("");
		textField_ngayNhapMA.setText("");
		textField_nuyenLieu.setText("");
		textField_soLuongMA.setText("");
		textField_tenMon.setText("");			
	}
	
	public void xoaForm1() {
		this.textField_maNuoc.setText("");
		this.textField_tenNuoc.setText("");
		this.textField_loaiNuoc.setText("");		
		this.textField_giaBanNU.setText("");
		this.textField_soLuongNU.setText("");
		this.textField_ngayNhapNU.setText("");		
	}
	
	public void themHoacCapNhatMonAn(MonAn ma) {					
		boolean found = false;
		int soLuongDong = table_model.getRowCount();
				
		for (int i = 0; i < soLuongDong; i++) {
			String id = table_model.getValueAt(i, 0)+"";
			if (id.equals(ma.getMaMonAn()+"")) {
				JOptionPane.showMessageDialog(contentPane, "Đã cập nhật món ăn!!");
				daoMA.getInstance().update(ma);
				found = true;
				break;
			}
		}
		if (!found) {
			JOptionPane.showMessageDialog(contentPane, "Đã thêm món ăn!!");
			daoMA.getInstance().insert(ma);
		}
		
	}	
	
	public void thucHienThemMonAn() {
		MonAn ma = new MonAn();
		ma.setMaMonAn(Integer.parseInt(textField_maMon.getText()));
		ma.setTenMonAn(textField_tenMon.getText());
		ma.setLoaiMonAn(textField_loaiMon.getText());
		ma.setNguyenLieu(textField_nuyenLieu.getText());
		ma.setGiaBan(Double.parseDouble(textField_giaBanMA.getText()));
		ma.setSoLuong(Integer.parseInt(textField_soLuongMA.getText()));
		try {
			ma.setNgayNhap(Date.valueOf(textField_ngayNhapMA.getText()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		
		if (this.model.getLuaChon().equals("") || this.model.getLuaChon().equals("Lưu"))
			this.themHoacCapNhatMonAn(ma);
			
		hienThiBang();
	}
	
	public void themHoacCapNhatNuocUong(NuocUong nu) {					
		boolean found = false;
		int soLuongDong = table_model1.getRowCount();
				
		for (int i = 0; i < soLuongDong; i++) {
			String id = table_model1.getValueAt(i, 0)+"";
			if (id.equals(nu.getMaNuoc()+"")) {
				JOptionPane.showMessageDialog(contentPane, "Đã cập nhật nước uống!!");
				daoNU.getInstance().update(nu);
				found = true;
				break;
			}
		}
		if (!found) {
			JOptionPane.showMessageDialog(contentPane, "Đã thêm nước uống!!");
			daoNU.getInstance().insert(nu);
		}		
	}	
	
	public void thucHienThemNuocUong() {		
		NuocUong nu = new NuocUong();
		nu.setMaNuoc(Integer.parseInt(textField_maNuoc.getText()));
		nu.setTenNuoc(textField_tenNuoc.getText());
		nu.setLoai(textField_loaiNuoc.getText());
		nu.setGiaBan(Double.parseDouble(textField_giaBanNU.getText()));
		nu.setSoLuong(Integer.parseInt(textField_soLuongNU.getText()));
		try {
			nu.setNgayNhap(Date.valueOf(textField_ngayNhapNU.getText()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (this.model.getLuaChon().equals("") || this.model.getLuaChon().equals("Lưu"))
			this.themHoacCapNhatNuocUong(nu);
		hienThiBang1();
	}	
	
	public void xoaDuLieuTrongBang() {
		int rowCount = table_model.getRowCount();
		for (int i = rowCount - 1  ;i >= 0 ;i--) {
			table_model.removeRow(i);
		}	
	}	
	
	public void hienThiBang() {	
//		Xóa dữ liệu trong bảng
		this.xoaDuLieuTrongBang();					
		
//		Đẩy dữ liệu vào bảng		
		try {
			Connection con = JDBCUtil.getConnection(); 
			
			String sql = "SELECT * FROM sanpham";
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				int maMonAn = rs.getInt("maMonAn");
				String tenMonAn = rs.getString("tenMonAn");
				String loaiMonAn =rs.getString("loaiMonAn");
				String nguyenLieu = rs.getString("nguyenLieu");
				Double giaBan = rs.getDouble("giaBan");
				int soLuong = rs.getInt("soLuong");
				Date ngayNhap = rs.getDate("ngayNhap");
				
				table_model.addRow(new Object[] {maMonAn, tenMonAn, loaiMonAn, nguyenLieu, giaBan, soLuong, ngayNhap});				
			}
			
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}			
	}
	
	public void xoaDuLieuTrongBang1() {
		int rowCount = table_model1.getRowCount();
		for (int i = rowCount - 1  ;i >= 0 ;i--) {
			table_model1.removeRow(i);
		}	
	}
	
	public void hienThiBang1() {	
//		Xóa dữ liệu trong bảng
		this.xoaDuLieuTrongBang1();					
		
//		Đẩy dữ liệu vào bảng		
		try {
			Connection con = JDBCUtil.getConnection(); 
			
			String sql = "SELECT * FROM nuocuong";
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int maNuoc = rs.getInt("maNuoc");
				String tenNuoc = rs.getString("tenNuoc");
				String loai = rs.getString("loai");
				Double giaBan = rs.getDouble("giaBan");
				int soLuong = rs.getInt("soLuong");
				Date ngayNhap = rs.getDate("ngayNhap");
				
				table_model1.addRow(new Object[] {maNuoc, tenNuoc, loai, giaBan, soLuong, ngayNhap});				
			}
			
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}			
	}
	
	public MonAn getMonAnDangChon() {
		int i_row = table.getSelectedRow();
		
		int maMonAn = Integer.valueOf(table_model.getValueAt(i_row, 0)+"");
		String tenMonAn = table_model.getValueAt(i_row, 1)+"";
		String loaiMonAn = table_model.getValueAt(i_row, 2)+"";
		String nguyenLieu = table_model.getValueAt(i_row, 3)+"";
		Double giaBan = Double.valueOf(table_model.getValueAt(i_row, 4)+"");
		int soLuong = Integer.valueOf(table_model.getValueAt(i_row, 5)+"");
		Date ngayNhap = Date.valueOf(table_model.getValueAt(i_row, 6)+"");
		
		MonAn ma = new MonAn(maMonAn, tenMonAn, loaiMonAn ,nguyenLieu, giaBan, soLuong ,ngayNhap);
		return ma;
	} 
	
	public NuocUong getNuocUongDangChon() {
		int i_row = table_1.getSelectedRow();
		
		int maNuoc = Integer.valueOf(table_model1.getValueAt(i_row, 0)+"");
		String tenNuoc = table_model1.getValueAt(i_row, 1)+"";
		String loai = table_model1.getValueAt(i_row, 2)+"";
		Double giaBan = Double.valueOf(table_model1.getValueAt(i_row, 3)+"");
		int soLuong = Integer.valueOf(table_model1.getValueAt(i_row, 4)+"");
		Date ngayNhap = Date.valueOf(table_model1.getValueAt(i_row, 5)+"");
		
		NuocUong nu = new NuocUong(maNuoc, tenNuoc, loai, giaBan, soLuong, ngayNhap);
		return nu;
	}
	
	public void hienThiThongTinMonAnDaChon() {
		MonAn ma = getMonAnDangChon();		
		this.textField_maMon.setText(ma.getMaMonAn()+"");
		this.textField_tenMon.setText(ma.getTenMonAn()+"");
		this.textField_loaiMon.setText(ma.getLoaiMonAn()+"");
		this.textField_nuyenLieu.setText(ma.getNguyenLieu()+"");
		this.textField_giaBanMA.setText(ma.getGiaBan()+"");
		this.textField_soLuongMA.setText(ma.getSoLuong()+"");
		this.textField_ngayNhapMA.setText(ma.getNgayNhap()+"");
	}
	
	public void thucHienXoaMonAn() {
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dòng đã chọn?","Xóa món ăn",JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			MonAn ma = getMonAnDangChon();
			daoMA.getInstance().delete(ma);
			hienThiBang();
		}
	}
	
	public void thucHienXoaNuocUong() {
		int i_row = table_1.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dòng đã chọn?","Xóa nước uống",JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			NuocUong nu = getNuocUongDangChon();
			daoNU.getInstance().delete(nu);
			hienThiBang1();
		}
	}
	
	public void thucHienTimMonAn() {
		MonAn ma = getMonAnDangChon();
		this.xoaDuLieuTrongBang();
		daoMA.getInstance().selectedByName(ma);
		table_model.addRow(new Object[] {ma.getMaMonAn(), ma.getTenMonAn(), ma.getLoaiMonAn(), ma.getNguyenLieu(), ma.getGiaBan(), ma.getSoLuong(), ma.getNgayNhap()});
	}
	
	public void thucHienTimNuocUong() {
		NuocUong nu = getNuocUongDangChon();
		this.xoaDuLieuTrongBang1();
		daoNU.getInstance().selectedByName(nu);
		table_model1.addRow(new Object[] {nu.getMaNuoc(), nu.getTenNuoc(), nu.getLoai(), nu.getGiaBan(), nu.getSoLuong(), nu.getNgayNhap()});
	}

	public void hienThiThongTinNuocUongDaChon() {
		NuocUong nu = getNuocUongDangChon();
		this.textField_maNuoc.setText(nu.getMaNuoc()+"");
		this.textField_tenNuoc.setText(nu.getTenNuoc()+"");
		this.textField_loaiNuoc.setText(nu.getLoai()+"");		
		this.textField_giaBanNU.setText(nu.getGiaBan()+"");
		this.textField_soLuongNU.setText(nu.getSoLuong()+"");
		this.textField_ngayNhapNU.setText(nu.getNgayNhap()+"");
		
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý nhà hàng v1.0!!!");
		
	}
}

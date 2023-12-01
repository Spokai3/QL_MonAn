package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.MonAn;
import view.QLMAView;
import dao.MonAnDAO;

public class QLMAController implements ActionListener, MouseListener{
	public QLMAView view;

	public QLMAController(QLMAView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Món ăn
		String cm = e.getActionCommand();
		if (cm.equals("Mới")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Mới");
		} else if (cm.equals("Lưu")) {
			try {
				this.view.thucHienThemMonAn();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (cm.equals("Cập nhật")) {
			this.view.hienThiBang();
		} else if (cm.equals("Xóa")) {
			this.view.thucHienXoaMonAn();
		} else if (cm.equals("Tìm")) {
			this.view.thucHienTimMonAn();
		} else if (cm.equals("About me")) {
			this.view.hienThiAbout();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.view.hienThiThongTinMonAnDaChon();		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}

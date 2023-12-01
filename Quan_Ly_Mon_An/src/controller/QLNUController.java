package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.QLMAView;

public class QLNUController implements ActionListener, MouseListener{
	public QLMAView view;

	public QLNUController(QLMAView view) {
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.view.hienThiThongTinNuocUongDaChon();
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if (cm.equals("Mới")) {
			this.view.xoaForm1();
			this.view.model.setLuaChon("Mới");
		} else if (cm.equals("Lưu")) {
			try {
				this.view.thucHienThemNuocUong();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (cm.equals("Cập nhật")) {
			this.view.hienThiBang1();
		} else if (cm.equals("Xóa")) {
			this.view.thucHienXoaNuocUong();
		} else if (cm.equals("Tìm")) {
			this.view.thucHienTimNuocUong();
		}
		
	}
	
}

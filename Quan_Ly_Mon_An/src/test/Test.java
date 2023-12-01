package test;

import javax.swing.UIManager;

import dao.MonAnDAO;
import view.QLMAView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QLMAView();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
}

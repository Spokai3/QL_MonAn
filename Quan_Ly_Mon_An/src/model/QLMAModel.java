package model;

import java.util.ArrayList;

public class QLMAModel {
	private ArrayList<MonAn> dsMonAn;
	private ArrayList<NuocUong> dsNuocUong;
	private String luaChon;
	
	public QLMAModel() {
		this.dsMonAn = new ArrayList<MonAn>();
		this.dsNuocUong = new ArrayList<NuocUong>();
		this.luaChon = "";
	}

	
	public ArrayList<NuocUong> getDsNuocUong() {
		return dsNuocUong;
	}


	public void setDsNuocUong(ArrayList<NuocUong> dsNuocUong) {
		this.dsNuocUong = dsNuocUong;
	}


	public ArrayList<MonAn> getDsMonAn() {
		return dsMonAn;
	}

	public void setDsMonAn(ArrayList<MonAn> dsMonAn) {
		this.dsMonAn = dsMonAn;
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}
	
	public void insert(MonAn monAn) {
		this.dsMonAn.add(monAn);
	}
	
	public void delete(MonAn monAn) {
		this.dsMonAn.remove(monAn);
	}
	
	public void update(MonAn monAn) {
		this.dsMonAn.remove(monAn);
		this.dsMonAn.add(monAn);
	}
	
	public boolean kiemTraTonTai(MonAn ma) {
		for (MonAn monAn : dsMonAn) {
			if (monAn.getMaMonAn() == ma.getMaMonAn())
				return true;
		}
		return false;
	}
}

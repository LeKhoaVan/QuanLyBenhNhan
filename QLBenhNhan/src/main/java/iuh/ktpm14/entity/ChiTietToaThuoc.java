package iuh.ktpm14.entity;

public class ChiTietToaThuoc {
	private Thuoc thuoc;
	private int so_luong;
	public ChiTietToaThuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietToaThuoc(Thuoc thuoc, int so_luong) {
		super();
		this.thuoc = thuoc;
		this.so_luong = so_luong;
	}
	public Thuoc getThuoc() {
		return thuoc;
	}
	public void setThuoc(Thuoc thuoc) {
		this.thuoc = thuoc;
	}
	public int getSo_luong() {
		return so_luong;
	}
	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}
	
	
}

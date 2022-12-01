package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "chiTietToaThuocs")
public class ChiTietToaThuoc {
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private int soLuong;
	
	@ManyToOne
	private Thuoc thuoc;
	
	@ManyToOne
	private ToaThuoc toaThuoc;
	
	@Override
	public String toString() {
		return "ChiTietToaThuoc [id=" + id + ", soLuong=" + soLuong + "]";
	}
}
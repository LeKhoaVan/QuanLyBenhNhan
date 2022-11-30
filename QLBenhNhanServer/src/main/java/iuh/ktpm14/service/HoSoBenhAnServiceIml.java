package iuh.ktpm14.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import iuh.ktpm14.connect.ConnectDB;
import iuh.ktpm14.entity.HoSoBenhAn;

public class HoSoBenhAnServiceIml implements HoSoBenhAnService{
	
	private MongoCollection collect;
	
	private ConnectDB connect = new ConnectDB();
	
	private Gson gson = new Gson();
			
	public HoSoBenhAnServiceIml() {
		this.collect = this.connect.connectMongo("QLKhamBenh", "hoSoBenhAn");
	}
	
	
	public boolean save(HoSoBenhAn benhAn) {
		if(findBySDT(benhAn.getDienThoai()) == null) {
			Document doc = new Document()
					.append("hoTen", benhAn.getHoTen())
					.append("tuoi", benhAn.getTuoi())
					.append("diaChi", benhAn.getDiaChi())
					.append("dienThoai", benhAn.getDienThoai())
					.append("ngayLapHS", benhAn.getNgayLap());
			this.collect.insertOne(doc);
			return true;
		}
		return false;
	}


	public HoSoBenhAn findBySDT(String sdt) {
		Document doc = new Document("dienThoai", sdt);
		FindIterable<Document> result = this.collect.find(doc);
		
		HoSoBenhAn benhAn = null;
		for(Document dc : result) {			
			Date date = dc.getDate("ngayLapHS");
			SimpleDateFormat formattedDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
			formattedDate.setTimeZone(TimeZone.getTimeZone("UTC"));
//			System.out.println(formattedDate.format(date));
			LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("Asia/Ho_Chi_Minh"));
			
			
			benhAn = new HoSoBenhAn(dc.getObjectId("id"), dc.getString("hoTen"), dc.getInteger("tuoi"),
					dc.getString("diaChi"), dc.getString("dienThoai"), ldt);
		}
		

		return benhAn;
	
	}

	

}

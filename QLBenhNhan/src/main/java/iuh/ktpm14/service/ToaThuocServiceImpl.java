package iuh.ktpm14.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import iuh.ktpm14.connect.ConnectDB;
import iuh.ktpm14.entity.Thuoc;
import iuh.ktpm14.entity.ToaThuoc;

public class ToaThuocServiceImpl implements ToaThuocService{

	public List<ToaThuoc> getAllToaThuoc() {
		ConnectDB connectDB = new ConnectDB();
		MongoClient client = connectDB.connect();
		MongoDatabase database = connectDB.createDatabase(client, "QLKhamBenh");
		MongoCollection<Document> collection = database.getCollection("ToaThuoc");
		
		FindIterable<Document> fi = collection.find();
		Iterator<Document> it = fi.iterator();
		Gson gson = new Gson();
		List<ToaThuoc> list = new ArrayList<ToaThuoc>();
		while (it.hasNext()) {
			System.out.println(it.next().toJson());
			ToaThuoc toaThuoc = gson.fromJson(it.next().toJson(), ToaThuoc.class);
			list.add(toaThuoc);
		}
		return list;
	}

}

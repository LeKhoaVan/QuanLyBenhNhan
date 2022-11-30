package iuh.ktpm14.connect;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectDB {
	public MongoClient connect() {
		String url ="mongodb://localhost";
		MongoClient client = MongoClients.create(url);
//		System.out.println("\nConnected successfully !!\n");
		return client;
	}

	public MongoDatabase createDatabase(MongoClient client, String name) {
		MongoDatabase database = client.getDatabase(name);
		return database;
	}
}

package mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;

public class MonguiDataBase {
	
	private DB realMongoDB;
	
	
	public MonguiDataBase(MonguiDataConnection connection, String databaseName) {
		this.realMongoDB = connection.getDataBase(databaseName);		
	}


	public DBCollection getCollection(String collectionName) {
		return realMongoDB.getCollection(collectionName);
	}

}

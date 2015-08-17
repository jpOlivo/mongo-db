package mongo;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MonguiDataConnection {
	
	private Mongo mongoRealConnection;
	
	
	public MonguiDataConnection() throws UnknownHostException, MongoException {
		this.mongoRealConnection = new Mongo();
	}
	
	public MonguiDataConnection(String host, int port) throws UnknownHostException, MongoException {	
		this.mongoRealConnection = new Mongo(host,port);
	}

	public void release() {
		mongoRealConnection.close();		
	}

	public DB getDataBase(String databaseName) {
		return mongoRealConnection.getDB(databaseName);
	}
	
	
	
	
}

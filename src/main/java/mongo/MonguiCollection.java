package mongo;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class MonguiCollection {

	private DBCollection realMongoCollection;
	
	
	protected MonguiCollection(MonguiDataBase actualDataBase, String collectionName) {
		this.realMongoCollection = actualDataBase.getCollection(collectionName);
	}


	public void saveDocument(MonguiDocument actualDocument) {
		realMongoCollection.save(actualDocument);		
	}


	public DBCursor getAll() {
		return realMongoCollection.find();
	}

}

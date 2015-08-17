package test.mongo;

import junit.framework.Assert;
import mongo.Mongui;
import mongo.MonguiDocument;

import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class MongoTest {

	@Test
	public void saveSomeThingInMongoUsingMongui() {

		MonguiDocument myDocument = new MonguiDocument();
		myDocument.put("saludo", "HolaMundo");

		Mongui.saveThis(myDocument).onThisDataBase("misDatos")
				.inThisCollection("miColeccion").execute();

		Mongo mongo = createMongo();

		DB database = mongo.getDB("misDatos");
		DBCollection coleccion = database.getCollection("miColeccion");

		Assert.assertTrue(coleccion.getCount() > 0);

	}

	@Test
	public void getSomeThingfromMongoUsingMongui() {

		Mongo mongo = createMongo();
		DB database = mongo.getDB("otrosDatos");
		DBCollection coleccion = database.getCollection("otraColeccion");

		BasicDBObject object = new BasicDBObject("pipi", "kaka");

		coleccion.save(object);

		DBCursor cursor = (DBCursor) Mongui.obtainAll()
				.onThisDataBase("otrosDatos").inThisCollection("otraColeccion")
				.execute();

		Assert.assertTrue(cursor.count() > 0);

	}

	private Mongo createMongo() {
		Mongo mongo = null;

		try {
			mongo = new Mongo();
		} catch (Exception e) {
		}
		return mongo;
	}
}

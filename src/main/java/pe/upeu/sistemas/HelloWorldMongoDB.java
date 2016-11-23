package pe.upeu.sistemas;

import java.net.UnknownHostException;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class HelloWorldMongoDB {
	public static void main(String[] args) throws UnknownHostException {
		MongoClient mongoClient = new MongoClient("localhost",27017);
		DB dataBase = mongoClient.getDB("admin_db");
		test01(dataBase);
		//test02Insert2(dataBase);
		//test02Insert3(dataBase);
		//test02Insert4(dataBase);
		//test03Update(dataBase);
		test04Delete(dataBase);
		test01(dataBase);	
	}
	
	public static void test04Delete(DB dataBase)throws UnknownHostException {
		DBCollection personColl =dataBase.getCollection("person");
		BasicDBObject delete = new BasicDBObject();
		delete.append("name", "Jimena");
		personColl.remove(delete);
	}
	
	public static void test03Update(DB dataBase)throws UnknownHostException {
		DBCollection personColl =dataBase.getCollection("person");
		BasicDBObject condition = new BasicDBObject();
		condition.append("name", "Juancito");
		
		BasicDBObject update = new BasicDBObject();
		update.append("name", "Juan");
		update.append("lastName", "Perez Perez");
		
		BasicDBObject updateObject = new BasicDBObject();
		updateObject.append("$set", update);
		
		personColl.update(condition, updateObject);
	}
	
	public static void test02Insert(DB dataBase) throws UnknownHostException{
		DBCollection personColl =dataBase.getCollection("person");
		BasicDBObject bo = new BasicDBObject();
		bo.append("_id", new ObjectId());
		bo.append("name", "Juancito");
		bo.append("lastName", "Perez Al cuadrado");
		bo.append("age", 38);
		bo.append("status", "A");
		personColl.insert(bo);
	}
	
	public static void test02Insert2(DB dataBase) throws UnknownHostException{
		DBCollection personColl =dataBase.getCollection("person");
		BasicDBObject bo = new BasicDBObject();
		bo.append("_id", new ObjectId());
		bo.append("name", "William");
		bo.append("lastName", "Quispe Calsina");
		bo.append("age", 25);
		bo.append("status", "A");
		personColl.insert(bo);
	}
	
	public static void test02Insert3(DB dataBase) throws UnknownHostException{
		DBCollection personColl =dataBase.getCollection("person");
		BasicDBObject bo = new BasicDBObject();
		bo.append("_id", new ObjectId());
		bo.append("name", "Jimena");
		bo.append("lastName", "Aliaga Ancco");
		bo.append("age", 26);
		bo.append("status", "A");
		personColl.insert(bo);
	}

	public static void test02Insert4(DB dataBase) throws UnknownHostException{
		DBCollection personColl =dataBase.getCollection("person");
		BasicDBObject bo = new BasicDBObject();
		bo.append("_id", new ObjectId());
		bo.append("name", "Lesly");
		bo.append("lastName", "Chahuara Flores");
		bo.append("age", 16);
		bo.append("status", "A");
		personColl.insert(bo);
	}

	public static void test01(DB dataBase) throws UnknownHostException{
		DBCollection personColl =dataBase.getCollection("person");
		BasicDBObject document = new BasicDBObject();
		//document.put("name", "Mario");
		DBCursor cursor = personColl.find(document);
		System.out.println(cursor);
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
	}
}

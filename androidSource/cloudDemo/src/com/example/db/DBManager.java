package com.example.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.model.Person;

public class DBManager {

	private DBHelper helper ;
	private SQLiteDatabase db ;
	
	public DBManager(Context context){
		helper = new DBHelper(context);
		db = helper.getWritableDatabase();
	}
	
	public void add(List<Person> persons){
		db.beginTransaction();
		try{
			for(Person person : persons){
				db.execSQL("INSERT INTO person VALUES(null,?,?,?)",new Object[]{person.name,person.age,person.info});
			}
			db.setTransactionSuccessful();
		}finally{
			db.endTransaction();
		}
	}
	
	public void updateAge(Person person){
		ContentValues cv = new ContentValues();
		cv.put("age", person.age);
		db.update("person", cv, "name=?", new String[]{person.name});
	}
	
	public void deleteOldPerson(Person person){
		db.delete("person", "age >= ?", new String[]{person.age});
	}
	
	public List<Person> query(){
		ArrayList<Person> persons = new ArrayList<Person>();
		Cursor c = queryTheCursor();
		while(c.moveToNext()){
			Person person = new Person();
			person.name = c.getString(c.getColumnIndex("name"));
			person.age = c.getString(c.getColumnIndex("age"));
			person.info = c.getString(c.getColumnIndex("info"));
			persons.add(person);
		}
		c.close();
		return persons ;
		
	}

	public Cursor queryTheCursor() {
		Cursor c = db.rawQuery("SELECT * FROM person", null);
		return c;
	}
	
	public void closeDB(){
		db.close();
	}
}






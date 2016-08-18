package com.example.dao;

import android.database.sqlite.SQLiteDatabase;

import com.example.model.Person;

public class sqliteTest {

	String sql = "DROP TABLE IF EXISTS person";
	String createsql = "CREATE TABLE person (_ID INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,age SMALLINT)";
	
	public void operateSql(){
		SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("test.db",null);
		db.execSQL(sql);
		db.execSQL(createsql);
		
		Person person = new Person();
		person.setName("jinxiao");
		person.setAge("25");
		db.execSQL("INSERT INTO person VALUES(NULL,?,?)",new Object[]{person.getName(),person.getAge()});
	}
	
}

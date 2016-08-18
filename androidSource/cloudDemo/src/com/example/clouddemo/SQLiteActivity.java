package com.example.clouddemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.db.DBManager;
import com.example.model.Person;

public class SQLiteActivity extends Activity {

//	String sql = "DROP TABLE IF EXISTS person";
//	String createsql = "CREATE TABLE person (_ID INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,age VARCHAR)";
	
	private DBManager mgr ;
	private ListView listView ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite);

		listView = (ListView)findViewById(R.id.listView);
		mgr = new DBManager(this);
	}
	
	protected void onDestroy(){
		super.onDestroy();
		mgr.closeDB();
	}
	
	public void add(View view){
		ArrayList<Person> persons = new ArrayList<Person>();
		
		Person person1 = new Person("Ella","22","lively girl");
		Person person2 = new Person("Jenny","22","beautiful girl");
		Person person3 = new Person("Jessica","23","sexy girl");
		Person person4 = new Person("Kelly","23","hot baby");
		Person person5 = new Person("Jane","25","a pretty woman");
		
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		persons.add(person4);
		persons.add(person5);
		
		mgr.add(persons);
	}
	
	public void update(View view){
		Person person = new Person();
		person.name = "Jane";
		person.age = "30";
		mgr.updateAge(person);
	}
	
	public void delete(View view){
		Person person = new Person();
		person.age = "30";
		mgr.deleteOldPerson(person);
	}
	
	public void query(View view){
		List<Person> persons = mgr.query();
		ArrayList<Map<String,String>> list = new ArrayList<Map<String,String>>();
		for(Person person : persons){
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("name", person.name);
			map.put("info", person.age+" years old, "+ person.info);
			list.add(map);
		}
		SimpleAdapter adapter = new SimpleAdapter(this,list,android.R.layout.simple_list_item_2,new String[]{"name","info"},new int[]{android.R.id.text1,android.R.id.text2});
		listView.setAdapter(adapter);
	}
	
	@SuppressWarnings("deprecation")
	public void queryTheCursor(View view){
		Cursor c = mgr.queryTheCursor();
		startManagingCursor(c);
		CursorWrapper cursorWrapper = new CursorWrapper(c){
			public String getString(int columnIndex){
				if(getColumnName(columnIndex).equals("info")){
					String age = getString(getColumnIndex("age"));
					return age+" years old, "+super.getString(columnIndex);
				}
				return super.getString(columnIndex);
			}
		};
		
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursorWrapper,new String[]{"name","info"},new int[]{android.R.id.text1,android.R.id.text2});
		ListView listView = (ListView)findViewById(R.id.listView);
		listView.setAdapter(adapter);
	}
}

//sqliteTest st = new sqliteTest();
		//st.operateSql();
		
		
//		SQLiteDatabase db = openOrCreateDatabase("test.txt",0,null);
//		db.execSQL(sql);
//		db.execSQL(createsql);
//		
//		Person person = new Person();
//		person.setName("jinxiao");
//		person.setAge("25");
//		db.execSQL("INSERT INTO person VALUES(NULL,?,?)",new Object[]{person.getName(),person.getAge()});
//		
//		person.setName("hello");
//		person.setAge("30");
//		ContentValues cv = new ContentValues();
//		cv.put("name", person.getName());
//		cv.put("age", person.getAge());
//		db.insert("person", null, cv);
//		
//		cv = new ContentValues();
//		cv.put("age", "35");
//		db.update("person", cv, "name=?", new String[]{"jinxiao"});
//		
//		Cursor c = db.rawQuery("SELECT * FROM person WHERE age >= ?", new String[]{"20"});
//		while(c.moveToNext()){
//			//int _id = c.getInt(c.getColumnIndex(0));
//			String name = c.getString(c.getColumnIndex("name"));
//			String age = c.getString(c.getColumnIndex("age"));
//			Log.i("db", " name=>"+name+", age=>"+age);
//		}
//		c.close();
//		
//		db.delete("person", "age < ?", new String[]{"33"});
//		
//		c = db.rawQuery("SELECT * FROM person WHERE age >= ?", new String[]{"20"});
//		while(c.moveToNext()){
//			//int _id = c.getInt(c.getColumnIndex(0));
//			String name = c.getString(c.getColumnIndex("name"));
//			String age = c.getString(c.getColumnIndex("age"));
//			Log.i("db", " name=>"+name+", age=>"+age);
//		}
//		c.close();
//		
//		db.close();















package com.example.clouddemo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

//	String sql = "DROP TABLE IF EXISTS person";
//	String createsql = "CREATE TABLE person (_ID INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,age VARCHAR)";
	
	private Button sqlButton ,searchButton,indexButton;
	private EditText editText ;
	LinearLayout focusLayout;
	private TextView addressView ;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sqlButton  = (Button)findViewById(R.id.sqlOperation);
		sqlButton.setOnClickListener(listenerSql);
		
		searchButton  = (Button)findViewById(R.id.searchOperation);
		searchButton.setOnClickListener(listenerSearch);
		
		indexButton = (Button)findViewById(R.id.skipToIndex);
		indexButton.setOnClickListener(listenerIndex);
		
		editText = (EditText)findViewById(R.id.editText);
		editText.setOnFocusChangeListener(listenerFocus);
		
		addressView = (TextView)findViewById(R.id.address);
		addressView.setOnClickListener(listenerAddress);
	}
	
	Button.OnClickListener listenerSql = new Button.OnClickListener(){
		
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this,SQLiteActivity.class);
			startActivity(intent);
		}
	};
	
	Button.OnClickListener listenerIndex = new Button.OnClickListener(){
		
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this,IndexActivity.class);
			startActivity(intent);
		}
	};
	
	Button.OnClickListener listenerSearch = new Button.OnClickListener(){
		
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this,SearchActivity.class);
			startActivity(intent);
		}
	};
	
	View.OnClickListener listenerAddress = new View.OnClickListener() {
		
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this,AddressActivity.class);
			startActivity(intent);
		}
	};
	
	EditText.OnFocusChangeListener listenerFocus = new EditText.OnFocusChangeListener(){

		public void onFocusChange(View v, boolean hasFocus) {
			if(hasFocus){
				editText = (EditText)findViewById(R.id.editText);
				editText.setFocusable(false);
				editText.setFocusableInTouchMode(false);
				System.out.println("main focus");
				Intent intent = new Intent(MainActivity.this,SearchActivity.class);
				startActivity(intent);
			}else{
				System.out.println("main no foucs");
			}
		}
	};
	
	public void onStart(){
		super.onStart();
		editText = (EditText)findViewById(R.id.editText);
		editText.setFocusable(true);
		editText.setFocusableInTouchMode(true);
		focusLayout = (LinearLayout)findViewById(R.id.focuslayout);
		focusLayout.setFocusable(true);
		focusLayout.setFocusableInTouchMode(true);
	}
	
	public void onResume(){
		super.onResume();
		focusLayout = (LinearLayout)findViewById(R.id.focuslayout);
		focusLayout.setFocusable(true);
		focusLayout.setFocusableInTouchMode(true);
	}
}















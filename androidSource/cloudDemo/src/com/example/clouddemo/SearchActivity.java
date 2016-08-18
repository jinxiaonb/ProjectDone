package com.example.clouddemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SearchActivity extends Activity {

	//private static final String[] COUNTRIES  = {"China","Russia","Germany",  
    //    "Ukraine","Belarus","USA","China1","China2","USA1"};
	Map<String, Object> map ,maps ;
	
	AutoCompleteTextView autoComplete;
	EditText editText ;
	ListView listView ;
	SimpleAdapter simpleAdapter;
	ArrayList<Map<String, Object>> mylist;
	ImageButton searchButton ;
	
	ImageButton closeButton ;
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);

		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,COUNTRIES);
		
//		autoComplete = (AutoCompleteTextView)findViewById(R.id.autoComplete);
//		autoComplete.setAdapter(adapter);
//		autoComplete.setThreshold(1);
		
		editText = (EditText)findViewById(R.id.editText);
		editText.setOnFocusChangeListener(new OnFocusChangeListener(){
			
			public void onFocusChange(View v,boolean hasFocus){
				if(hasFocus){
					Log.i("hasFocus"," focus");
				}else{
					Log.i("hasFocus"," not focus");
				}
			}
		});
		editText.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				System.out.println("EditText text: "+s+" EditText length: "+s.length()+" count:"+count);
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				
			}
			
			public void afterTextChanged(Editable s) {
				
			}
		});
		
		searchButton = (ImageButton)findViewById(R.id.search);
		listView = (ListView)findViewById(R.id.searchlistView);
		listView.setItemsCanFocus(true);
		
		searchButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				String searchText = editText.getText().toString();
				mylist = listViewData(searchText);
			}
		});
		//mylist = initListView();
		
		closeButton = (ImageButton)findViewById(R.id.closeSearch);
		closeButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				finish();
			}
		});
	}
	
	public ArrayList<Map<String, Object>> initListView() {
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(int i=0;i<30;i++){
			map = new HashMap<String,Object>();
			map.put("textView","textView"+i);
			list.add(map);
		}
		simpleAdapter = new SimpleAdapter(this,list, R.layout.search_list, new String[]{"textView"}, new int[]{R.id.textView});
		listView.setAdapter(simpleAdapter);
		return list;
	}
	
	public ArrayList<Map<String, Object>> listViewData(String searchText){
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		ArrayList<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
		for(int i=0;i<30;i++){
			map = new HashMap<String,Object>();
			map.put("textView","textView"+i);
			list.add(map);
		}
		
		Iterator<Map<String, Object>> iterator = list.iterator();
		while(iterator.hasNext()){
			String ct = iterator.next().get("textView").toString() ;
			boolean bt = ct.contains(searchText) ;
			if(bt){
				maps = new HashMap<String,Object>();
				maps.put("textView", ct);
				lists.add(maps);
			}
		}
		
		simpleAdapter = new SimpleAdapter(this,lists, R.layout.search_list, new String[]{"textView"}, new int[]{R.id.textView});
		listView.setAdapter(simpleAdapter);
		return list ;
	}
	
	public boolean onKeyDown(int keyCode,KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_BACK){
			finish();
			return true;
		}
		//return true ;
		return super.onKeyDown(keyCode, event);
	}
}

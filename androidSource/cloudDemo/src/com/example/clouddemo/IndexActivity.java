package com.example.clouddemo;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class IndexActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		
		Resources res = getResources();
		TabHost tabHost = getTabHost();
		TabHost.TabSpec spec ;
		Intent intent ;
		
		intent = new Intent().setClass(this,FirstActivity.class);
		spec = tabHost.newTabSpec("first").setIndicator("目录",res.getDrawable(R.drawable.ic_tab_artists)).setContent(intent);
		tabHost.addTab(spec);
		
		intent = new Intent().setClass(this,SecondActivity.class);
		spec = tabHost.newTabSpec("second").setIndicator("分享",res.getDrawable(R.drawable.ic_tab_artists)).setContent(intent);
		tabHost.addTab(spec);
		
		intent = new Intent().setClass(this,ThirdActivity.class);
		spec = tabHost.newTabSpec("first").setIndicator("传输",res.getDrawable(R.drawable.ic_tab_artists)).setContent(intent);
		tabHost.addTab(spec);
		
		intent = new Intent().setClass(this,FourActivity.class);
		spec = tabHost.newTabSpec("first").setIndicator("设置",res.getDrawable(R.drawable.ic_tab_artists)).setContent(intent);
		tabHost.addTab(spec);
		
		tabHost.setCurrentTab(0);
	}
}

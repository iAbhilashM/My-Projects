package com.example.activitylifecycle;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	TextView stateTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		stateTextView=(TextView) findViewById(R.id.textViewState);
		
		stateTextView.setText("onCreate()!!");
		Toast.makeText(MainActivity.this,"onCreate()!!",Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		stateTextView.setText("onStart()!!");
		Toast.makeText(MainActivity.this,"onStart()!!",Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		stateTextView.setText("onResume()!!");
		Toast.makeText(MainActivity.this,"onResume()!!",Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		stateTextView.setText("onPause()!!");
		Toast.makeText(MainActivity.this,"onPause()!!",Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		stateTextView.setText("onStop()!!");
		Toast.makeText(MainActivity.this,"onStop()!!",Toast.LENGTH_SHORT).show();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		stateTextView.setText("onDestroy()!!");
		Toast.makeText(MainActivity.this,"onDestroy()!!",Toast.LENGTH_SHORT).show();
	}

	

}

package com.jspiders.intendreturn;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

	TextView inputTextView;
	Button fedButton;
	@Override
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		inputTextView=(TextView) findViewById(R.id.editTextInput);
		fedButton=(Button) findViewById(R.id.buttoFed);
		
		fedButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent intent=new Intent();
				String s1=inputTextView.getText().toString();
				intent.putExtra("Key1", s1);
				setResult(RESULT_OK, intent);
				finish();
			}
		});
		
		
		
		
		
	}
	
	

}

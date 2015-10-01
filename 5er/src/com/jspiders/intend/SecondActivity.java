package com.jspiders.intend;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class SecondActivity extends Activity {

	TextView greetingsTextView;
	TextView addresTextView;
	TextView subresTextView;
	TextView mulresTextView;
	TextView divTextView;
	TextView resultTextView;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		greetingsTextView=(TextView) findViewById(R.id.textViewGreetings);
		addresTextView=(TextView) findViewById(R.id.textViewAddRes);
		subresTextView=(TextView) findViewById(R.id.textViewSubRes);
		mulresTextView=(TextView) findViewById(R.id.textViewMulRes);
		divTextView=(TextView) findViewById(R.id.textViewDivRes);
		resultTextView=(TextView) findViewById(R.id.textViewResult);
		
		
		Intent intent=getIntent();
		Bundle b1=intent.getExtras();
		String s1=b1.getString("Key1");
		if(s1==null){
		greetingsTextView.setText("Hi, "+"Guest!");
		}else{
			greetingsTextView.setText("Hi, "+s1+"!");
		}
		double d1=b1.getDouble("Key2");
		
		if(b1.getString("Key3")==null){
			resultTextView.setText("Results after 5er with "+Double.toString(d1)+" are:");
		addresTextView.setText(dToS(d1+5));
		subresTextView.setText(dToS(d1-5));
		mulresTextView.setText(dToS(d1*5));
		divTextView.setText(dToS(d1/5));
		}else {
			resultTextView.setText("To get the results for 5er, please enter a number!");
			addresTextView.setText("N/A");
			subresTextView.setText("N/A");
			mulresTextView.setText("N/A");
			divTextView.setText("N/A");
		}
		
		
	}
	public static String dToS(double i)
	{
		
		return Double.toString(i);
		
		
	}

	

}

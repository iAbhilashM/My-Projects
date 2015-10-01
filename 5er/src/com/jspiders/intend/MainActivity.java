package com.jspiders.intend;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText stringEditText;
	EditText integerEditText;
	Button goButton;
	Button clearButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        stringEditText=(EditText) findViewById(R.id.editTextString);
        integerEditText=(EditText) findViewById(R.id.editTextInteger);
        goButton=(Button) findViewById(R.id.buttonGo);
        clearButton=(Button) findViewById(R.id.buttonClear);
        
        stringEditText.setHint("Can I know your name? :)");
		integerEditText.setHint("Enter a number for 5er!!");
        
		
        
        goButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(stringEditText.getText().toString().length()==0 && integerEditText.getText().toString().length()==0)
				{
					Toast.makeText(MainActivity.this, "Please fill atleast one field to proceed!!", Toast.LENGTH_SHORT).show();
				}
				else if(stringEditText.getText().toString().length()!=0 && integerEditText.getText().toString().length()!=0)
				{
					String i1=stringEditText.getText().toString();
			        String s1=integerEditText.getText().toString();
			        double i2=Double.parseDouble(s1);
			        
			        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
			        intent.putExtra("Key1", i1);
			        intent.putExtra("Key2", i2);
			        
			        startActivity(intent);
				}
				else if(stringEditText.getText().toString().length()!=0 && integerEditText.getText().toString().length()==0)
				{
					String i1=stringEditText.getText().toString();
					String i3=integerEditText.getText().toString();
			        
			        
			        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
			        intent.putExtra("Key1", i1);
			        intent.putExtra("Key3", i3);
			        
			        startActivity(intent);
				}
				else if(stringEditText.getText().toString().length()==0 && integerEditText.getText().toString().length()!=0)
				{
					
			        String s1=integerEditText.getText().toString();
			        double i2=Double.parseDouble(s1);
			        
			        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
			       
			        intent.putExtra("Key2", i2);
			        
			        startActivity(intent);
				}
				
				
			}
		});
        clearButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				stringEditText.getText().clear();
				integerEditText.getText().clear();
				stringEditText.setHint("Can I know your name? :)");
				integerEditText.setHint("Enter a number for 5er!!");
				
			}
		});
       
        
        
        
        
        
    }


   
    
}

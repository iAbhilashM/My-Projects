package com.jspiders.intendreturn;



import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends Activity {
	
	TextView displayTextView;
	Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        displayTextView=(TextView) findViewById(R.id.textViewDisplay);
        goButton=(Button) findViewById(R.id.buttonGo);
        
        goButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent intent=new Intent(MainActivity.this, SecondActivity.class);
				startActivityForResult(intent, 1);
			}
			
		});
           
         
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	
    	super.onActivityResult(requestCode, resultCode, data);
    	if(resultCode==RESULT_OK)
    	{
    		Bundle d1=data.getExtras();
    		String s1=d1.getString("Key1");
    		displayTextView.setText(s1);
    	} else if(resultCode==RESULT_CANCELED)
    	{
    		displayTextView.setText("NONE");
    	}
    	
    }
}

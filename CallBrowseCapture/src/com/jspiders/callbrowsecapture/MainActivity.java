package com.jspiders.callbrowsecapture;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button callButton,browseButton,captureButton;
	ImageView capturedImageView;
	private static final int CAMERA=1313;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        callButton = (Button) findViewById(R.id.buttonCall);
        browseButton=(Button) findViewById(R.id.buttonBrowse);
        captureButton=(Button) findViewById(R.id.buttonCapture);
        capturedImageView=(ImageView) findViewById(R.id.imageViewCaptured);
        
        callButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 Intent intent=new Intent(Intent.ACTION_CALL);
				 intent.setData(Uri.parse("tel:"+"9439422696"));
				 startActivity(intent);
				
			}
		});
        browseButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://www.google.co.in"));
				startActivity(intent);
				
				
			}
		});
        
        captureButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent, CAMERA);
				
			}
		});
        
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	if(requestCode==CAMERA)
    	{
    		if(resultCode==RESULT_OK)
    		{
    			Bitmap bm=(Bitmap) data.getExtras().get("data");
    			capturedImageView.setImageBitmap(bm);
    		} else if(resultCode==RESULT_CANCELED)
    		{
    			Toast.makeText(MainActivity.this, "Error occured!", Toast.LENGTH_SHORT).show();
    		}
    	}
    	
    }


  
    
}

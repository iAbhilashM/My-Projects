package com.jspiders.iamconverter;

import com.jspiders.iamconverter.MainActivity;
import com.jspiders.iamconverter.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {

	Spinner spinnerparameters;
	static EditText editTextOption1;
	static EditText editTextOption2;
	Button buttonConvert;
	Button buttonClear;
	static TextView textViewResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		spinnerparameters=(Spinner) findViewById(R.id.spinnerparameters);
		editTextOption1=(EditText) findViewById(R.id.editTextOption1);
		editTextOption2=(EditText) findViewById(R.id.editTextOption2);
		buttonConvert=(Button) findViewById(R.id.buttonConvert);
		buttonClear=(Button) findViewById(R.id.buttonClear);
		textViewResult=(TextView) findViewById(R.id.textViewResult);
		
		buttonClear.setOnClickListener(new OnClickListener() {						
			@Override
			public void onClick(View arg0) {
				
				clearAll();
			}
		});
		
		
		
		String[] parameters={"Select Parameters","Length","Temperature","Currency"};
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,parameters);
		spinnerparameters.setAdapter(adapter);
		spinnerparameters.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				switch (position) {
				case 0:
					clearAll();
					hintSetter("", "");
					
					buttonConvert.setOnClickListener(new OnClickListener() {						
						@Override
						public void onClick(View arg0) {
							
							Toast.makeText(MainActivity.this, "Please select a parameter!!" , Toast.LENGTH_SHORT).show();

							
						}
					});
					

					break;
				
				case 1:
					
					clearAll();
					hintSetter("Type in Kilometers", "Type in Meters");
								
					buttonConvert.setOnClickListener(new OnClickListener() {						
						@Override
						public void onClick(View arg0) {
							
							if(editTextOption1.getText().toString().length()!=0 && editTextOption2.getText().toString().length()!=0)
							{
								Toast.makeText(MainActivity.this, "Please fill any one parameter!!" , Toast.LENGTH_SHORT).show();

							}
							else if(editTextOption1.getText().toString().length()==0 && editTextOption2.getText().toString().length()==0)
							{
								Toast.makeText(MainActivity.this, "Please fill any one parameter!! " , Toast.LENGTH_SHORT).show();
							}
							

							else if(editTextOption1.getText().toString().length()!=0)
							{
								String s1=editTextOption1.getText().toString();
								double i=Double.parseDouble(s1);
								
								double j=lengthKMtoM(i);
								String s2=Double.toString(j);
								textViewResult.setText(s1+" km"+" ="+s2+" m");
								
							} 
							
							else if(editTextOption2.getText().toString().length()!=0)
							{
								String s1=editTextOption2.getText().toString();
								double i=Double.parseDouble(s1);
								
								double j=lengthMtoKM(i);
								String s2=Double.toString(j);
								textViewResult.setText(s1+" m"+" ="+s2+" km");
							}
							
							
							
						}
					});
					
					
					break;
					
				case 2:
					clearAll();
					hintSetter("Type in Celsius", "Type in Fahrenheit");
					
					buttonConvert.setOnClickListener(new OnClickListener() {						
						@Override
						public void onClick(View arg0) {
							
							if(editTextOption1.getText().toString().length()!=0 && editTextOption2.getText().toString().length()!=0)
							{
								Toast.makeText(MainActivity.this, "Please fill any one parameter!!" , Toast.LENGTH_SHORT).show();

							}
							else if(editTextOption1.getText().toString().length()==0 && editTextOption2.getText().toString().length()==0)
							{
								Toast.makeText(MainActivity.this, "Please fill any one parameter!! " , Toast.LENGTH_SHORT).show();
							}
							

							else if(editTextOption1.getText().toString().length()!=0)
							{
								String s1=editTextOption1.getText().toString();
								double i=Double.parseDouble(s1);
								
								double j=tempCtoF(i);
								String s2=Double.toString(j);
								textViewResult.setText(s1+" °C"+" ="+s2+" °F");
								
							} 
							
							else if(editTextOption2.getText().toString().length()!=0)
							{
								String s1=editTextOption2.getText().toString();
								double i=Double.parseDouble(s1);
								
								double j=tempFtoC(i);
								String s2=Double.toString(j);
								textViewResult.setText(s1+" °F"+" ="+s2+" °C");
							}
							
						}
					});
					break;
					
				case 3:
					clearAll();
					hintSetter("Type in Rupee", "Type in Dollar");
				
					buttonConvert.setOnClickListener(new OnClickListener() {						
						@Override
						public void onClick(View arg0) {
							
							if(editTextOption1.getText().toString().length()!=0 && editTextOption2.getText().toString().length()!=0)
							{
								Toast.makeText(MainActivity.this, "Please fill any one parameter!!" , Toast.LENGTH_SHORT).show();

							}
							else if(editTextOption1.getText().toString().length()==0 && editTextOption2.getText().toString().length()==0)
							{
								Toast.makeText(MainActivity.this, "Please fill any one parameter!! " , Toast.LENGTH_SHORT).show();
							}

							else if(editTextOption1.getText().toString().length()!=0)
							{
								String s1=editTextOption1.getText().toString();
								double i=Double.parseDouble(s1);
								
								double j=currRtoD(i);
								String s2=Double.toString(j);
								textViewResult.setText(s1+" \u20b9"+" ="+s2+" $");
								
							} 
							
							else if(editTextOption2.getText().toString().length()!=0)
							{
								String s1=editTextOption2.getText().toString();
								double i=Double.parseDouble(s1);
								
								double j=currDtoR(i);
								String s2=Double.toString(j);
								textViewResult.setText(s1+"  $"+" ="+s2+" \u20b9");
							}
							
						}
					});
					
					break;

				default:
					break;
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	
	}
	
	public static void clearAll()
	{
		editTextOption1.setText("");
		editTextOption2.setText("");
		textViewResult.setText("");
	}
	
	public static void hintSetter(String s1,String s2)
	{
		editTextOption1.setHint(s1);
		editTextOption2.setHint(s2);
	}
	
	public static double lengthKMtoM(double i)
	{
		return i*1000;
	}
	
	public static double lengthMtoKM(double i)
	{
		return i/1000;
	}
	
	public static double tempCtoF(double i)
	{
		return (i*9)/5+32;
	}
	
	public static double tempFtoC(double i)
	{
		return ((i-32)*5)/9;
	}
	
	public static double currRtoD(double i)
	{
		return i*0.01515;
	}
	public static double currDtoR(double i)
	{
		return i*65.98;
	}
    
}

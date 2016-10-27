package com.andro_curiosity.againstroadaccident;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class EmergencyCall extends Activity implements SensorEventListener{
	EditText et1,et2,et3;
	String s[] = new String[3];
	String s0="";
	String s1="";
	String s2="";
	Button b,c;
	private LocationManager locationMangaer=null; 
	private Boolean flag = false; 
	private LocationListener locationListener=null; 
	String st;
	private AnimationDrawable lightAnim;
	ImageView im;
	public static final String MyPREFERENCES = "MyPrefs" ;
	public static final String Name1 = "em1"; 
	public static final String Name2 = "em2"; 
	public static final String Name3 = "em3"; 
	
	public static final String setFlag = "Flag";
	static String chkDefault = "1";
	static String pat = "1";
	SharedPreferences sharedpreferences;
	
	private SensorManager sensorManager;
	  private boolean color = false;
	  private View view;
	  private long lastUpdate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emergency_call);
		ActionBar bar = getActionBar();
		//bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.titlebar));
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		bar.setTitle(R.string.EmCall);
		sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		
		final MediaPlayer whistle = MediaPlayer.create(EmergencyCall.this, R.raw.cliclk);
		
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
	    lastUpdate = System.currentTimeMillis();
	    if (sharedpreferences.contains(setFlag))
        {
        	pat = sharedpreferences.getString(setFlag, "");

        }
	    //Toast.makeText(EmergencyCall.this,pat+" "+chkDefault, Toast.LENGTH_SHORT).show();
		s[0] = null;
		s[1] = null;
		s[2] = null;
		im = (ImageView) findViewById(R.id.EmerAnim);
		im.setBackgroundResource(R.drawable.emercallanim);
		lightAnim = (AnimationDrawable)im.getBackground();
		lightAnim.setOneShot(false);
		
		
		et1 = (EditText) findViewById(R.id.Pname0);
		et2 = (EditText) findViewById(R.id.Pname1);
		et3 = (EditText) findViewById(R.id.Pname2);
		
		b = (Button) findViewById(R.id.save);
		c = (Button) findViewById(R.id.msg);
		
		locationMangaer = (LocationManager)getSystemService(Context.LOCATION_SERVICE);  
		  	
    
b.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					b.setBackgroundResource(R.drawable.saveb);
					b.getBackground().setAlpha(200);
					whistle.start();
					
					s[0] = et1.getText().toString();	
					s[1] = et2.getText().toString();	
					s[2] = et3.getText().toString();
					/*if (sharedpreferences.contains(setFlag))
			        {
			        	pat = sharedpreferences.getString(setFlag, "");

			        }*/
					//Toast.makeText(EmergencyCall.this,s[0]+"\n"+s[1]+"\n"+s[2], Toast.LENGTH_SHORT).show();
					break;
				case MotionEvent.ACTION_UP:
					b.setBackgroundResource(R.drawable.savea);
					 
					Editor editor = sharedpreferences.edit();
			        editor.putString(Name1, s[0]);
			        editor.putString(Name2, s[1]);
			        editor.putString(Name3, s[2]);
			        
			        editor.commit();
			        
			        
			        if(s[0] != null ||s[1] != null ||s[2] != null)
			        	Toast.makeText(EmergencyCall.this,R.string.MsaveSuccess, Toast.LENGTH_SHORT).show();
			        	//Toast.makeText(EmergencyCall.this,s0+"\n"+s[1]+"\n"+s2, Toast.LENGTH_SHORT).show();
			        else
			        	Toast.makeText(EmergencyCall.this,R.string.MsaveFail, Toast.LENGTH_SHORT).show();
					
			        b.getBackground().setAlpha(255);
				    break;
				case MotionEvent.ACTION_MOVE:
					b.setBackgroundResource(R.drawable.saveb);
					b.getBackground().setAlpha(200);
					break;
				default:
					break;
				}

				return false;
			}
		});



c.setOnTouchListener(new View.OnTouchListener() {
	int num = 3;
	
	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub
		
		switch(event.getAction()){
		case   MotionEvent.ACTION_DOWN:
			c.setBackgroundResource(R.drawable.offlineb);
			c.getBackground().setAlpha(200);
			whistle.start();
			if (sharedpreferences.contains(Name1))
	        {
	        	et1.setText(sharedpreferences.getString(Name1, ""));
	        	s[0] = sharedpreferences.getString(Name1, "");

	        }
	        if (sharedpreferences.contains(Name2))
	        {
	        	et2.setText(sharedpreferences.getString(Name2, ""));
	        	s[1] = sharedpreferences.getString(Name2, "");

	        }
	        if (sharedpreferences.contains(Name3))
	        {
	        	et3.setText(sharedpreferences.getString(Name3, ""));
	        	s[2] = sharedpreferences.getString(Name3, "");

	        }
			break;
		case MotionEvent.ACTION_UP:
			c.setBackgroundResource(R.drawable.offlinea);
			flag = displayGpsStatus();  
			  
			  
			   if (flag) {  
			     
			   locationListener = new MyLocationListener();  
			  
			   locationMangaer.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10,locationListener);  
			     
			   } else {  
			   alertbox("Gps Status!!", "For loacation your GPS is: OFF");  
			  }
			   
			 try {
				    String sms = "Emergency , I need your help .\n"+st;
				    
					SmsManager smsManager = SmsManager.getDefault();
					for(int i = 0; i < 3;i++)
					{
					smsManager.sendTextMessage(s[i], null, sms, null, null);
					num--;
					//Toast.makeText(getApplicationContext(),sms, Toast.LENGTH_LONG).show();
				}
				  } catch (Exception e) {
					  if(num == 3)
						  Toast.makeText(getApplicationContext(),"Failed:"+num+" !SMS faild, please try again later!",Toast.LENGTH_LONG).show();
					  else
						  Toast.makeText(getApplicationContext(),R.string.SuccessSMS,Toast.LENGTH_LONG).show();
					e.printStackTrace();
				  }
			//Toast.makeText(EmergencyCall.this,s[0]+"\n"+s[1]+"\n"+s[2], Toast.LENGTH_SHORT).show();
			
			c.getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			c.setBackgroundResource(R.drawable.offlineb);
			c.getBackground().setAlpha(200);
			break;
		default:
			break;
		}

		return false;
	}
});
		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			if(chkDefault!=pat){
		      getAccelerometer(event);
		      lightAnim.start();
			}
			else{
				lightAnim.stop();
				im.setBackgroundResource(R.drawable.val);
			}
		    }
	}
	 private void getAccelerometer(SensorEvent event) {
		    float[] values = event.values;
		    // Movement
		    float x = values[0];
		    float y = values[1];
		    float z = values[2];
		    int num = 3;

		    float accelationSquareRoot = (x * x + y * y + z * z)
		        / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
				long actualTime = event.timestamp;
		    if (accelationSquareRoot >= 2) //
		    {
		      if (actualTime - lastUpdate < 200) {
		        return;
		      }
		      lastUpdate = actualTime;
		      Toast.makeText(this, "Sensor Messaging", Toast.LENGTH_SHORT).show();
		      flag = displayGpsStatus();  
			  
			  
			   if (flag) {  
			     
			   locationListener = new MyLocationListener();  
			  
			   locationMangaer.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10,locationListener);  
			     
			   } else {  
			   alertbox("Gps Status!!", "For loacation your GPS is: OFF");  
			  }
			   
			 try {
				 if (sharedpreferences.contains(Name1))
			        {
			        	et1.setText(sharedpreferences.getString(Name1, ""));
			        	s[0] = sharedpreferences.getString(Name1, "");

			        }
			        if (sharedpreferences.contains(Name2))
			        {
			        	et2.setText(sharedpreferences.getString(Name2, ""));
			        	s[1] = sharedpreferences.getString(Name2, "");

			        }
			        if (sharedpreferences.contains(Name3))
			        {
			        	et3.setText(sharedpreferences.getString(Name3, ""));
			        	s[2] = sharedpreferences.getString(Name3, "");

			        }
				    String sms = "Emergency , I need your help .\n"+st;
				    
					SmsManager smsManager = SmsManager.getDefault();
					for(int i = 0; i < 3;i++)
					{
					smsManager.sendTextMessage(s[i], null, sms, null, null);
					num--;
					//Toast.makeText(getApplicationContext(),sms, Toast.LENGTH_LONG).show();
					//Toast.makeText(getApplicationContext(),R.string.SuccessSMS,Toast.LENGTH_LONG).show();
				}
				  } catch (Exception e) {
					  if(num == 3)
						  Toast.makeText(getApplicationContext(),"Failed:"+num+" !SMS faild, please try again later!",Toast.LENGTH_LONG).show();
					  else
						  Toast.makeText(getApplicationContext(),R.string.SuccessSMS,Toast.LENGTH_LONG).show();
					e.printStackTrace();
				  }
			//Toast.makeText(EmergencyCall.this,s[0]+"\n"+s[1]+"\n"+s[2], Toast.LENGTH_SHORT).show();
			
		       //change job
		       
		    }
		  }
	
	 @Override
	  protected void onResume() {
	    super.onResume();
	    // register this class as a listener for the orientation and
		// accelerometer sensors
	    sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
	  }

	  @Override
	  protected void onPause() {
	    // unregister listener
	    super.onPause();
	    sensorManager.unregisterListener(this);
	    //sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
	  }
	  
	  private Boolean displayGpsStatus() {  
		  ContentResolver contentResolver = getBaseContext()  
		  .getContentResolver();  
		  boolean gpsStatus = Settings.Secure  
		  .isLocationProviderEnabled(contentResolver,   
		  LocationManager.GPS_PROVIDER);  
		  if (gpsStatus) {  
		   return true;  
		  
		  } else {  
		   return false;  
		  }  
		 } 
	  
	  protected void alertbox(String title, String mymessage) {  
		  AlertDialog.Builder builder = new AlertDialog.Builder(this);  
		  builder.setMessage("Your Device's GPS is Disable")  
		  .setCancelable(false)  
		  .setTitle("** Gps Status **")  
		  .setPositiveButton("Gps On",  
		   new DialogInterface.OnClickListener() {  
		   public void onClick(DialogInterface dialog, int id) {  
		   // finish the current activity  
		   // AlertBoxAdvance.this.finish();  
		   Intent myIntent = new Intent(  
		   Settings.ACTION_LOCATION_SOURCE_SETTINGS);  
		   startActivity(myIntent);  
		      dialog.cancel();  
		   }  
		   })  
		   .setNegativeButton("Cancel",  
		   new DialogInterface.OnClickListener() {  
		   public void onClick(DialogInterface dialog, int id) {  
		    // cancel the dialog box  
		    dialog.cancel();  
		    }  
		   });  
		  AlertDialog alert = builder.create();  
		  alert.show();  
		 } 
	  private class MyLocationListener implements LocationListener {  
	        @Override  
	        public void onLocationChanged(Location loc) {  
	            
	     //Toast.makeText(getBaseContext(),"Location changed .\nLat: " + loc.getLatitude()+ "\nLng: " + loc.getLongitude(), Toast.LENGTH_LONG).show();  
	            String longitude = "" +loc.getLongitude();    
	     // Log.v(TAG, longitude);  
	      String latitude = "" +loc.getLatitude();  
	      //Log.v(TAG, latitude);  
	            
	    /*----------to get City-Name from coordinates ------------- */  
	      String cityName=null;                
	      Geocoder gcd = new Geocoder(getBaseContext(),   
	   Locale.getDefault());               
	      List<Address>  addresses;    
	      try {    
	      addresses = gcd.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);    
	      if (addresses.size() > 0)    
	         System.out.println(addresses.get(0).getLocality());    
	         cityName=addresses.get(0).getLocality();    
	        } catch (IOException e) {              
	        e.printStackTrace();    
	      }   
	           
	         
	           st = "Longitude : "+longitude+"\n"+"Latitude : "+latitude + "\nMy Place: "+cityName;
	           Toast.makeText(getApplicationContext(),st, Toast.LENGTH_LONG).show();
	           int num = 3;
	           try {
				    String sms = "Emergency , I need your help .\n"+st;
				    
					SmsManager smsManager = SmsManager.getDefault();
					for(int i = 0; i < 3;i++)
					{
					smsManager.sendTextMessage(s[i], null, sms, null, null);
					num--;
					//Toast.makeText(getApplicationContext(),sms, Toast.LENGTH_LONG).show();
					//Toast.makeText(getApplicationContext(),R.string.SuccessSMS,Toast.LENGTH_LONG).show();
				}
				  } catch (Exception e) {
					  if(num == 3)
						  Toast.makeText(getApplicationContext(),"Failed:"+num+" !SMS faild, please try again later!",Toast.LENGTH_LONG).show();
					  else
						  Toast.makeText(getApplicationContext(),R.string.SuccessSMS,Toast.LENGTH_LONG).show();
					e.printStackTrace();
				  }
	        }  
	      

			@Override  
	        public void onProviderDisabled(String provider) {  
	            // TODO Auto-generated method stub           
	        }  
	  
	        @Override  
	        public void onProviderEnabled(String provider) {  
	            // TODO Auto-generated method stub           
	        }  
	  
	        @Override  
	        public void onStatusChanged(String provider,   
	  int status, Bundle extras) {  
	            // TODO Auto-generated method stub           
	        }  
	    } 
 
	  @Override
		public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.emergency_call, menu);
			return true;
		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			
			switch (item.getItemId()) {
			case R.id.action_settings:
				HandlerWarn();
			default:
				return super.onOptionsItemSelected(item);
			}
		}
		
		public void HandlerWarn(){
			AlertDialog.Builder alertBack = new AlertDialog.Builder(EmergencyCall.this);
			
			alertBack.setTitle(R.string.CHKDefaultEmer);
			alertBack.setIcon(R.drawable.warning);
			//alertBack.setMessage(R.string.CHKDefaultEmerOff);
			
			alertBack.setPositiveButton(R.string.CHKDefaultEmerOffDin, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int arg1) {
					
					String bal = "1";
					Editor editor = sharedpreferences.edit();
			        editor.putString(setFlag, bal);
			        editor.commit();
			        
			        dialog.cancel();
			        finish();
				}
			});
			
			alertBack.setNegativeButton(R.string.CHKDefaultEmerOnDin, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int arg1) {
					// TODO Auto-generated method stub
					String botua = "null";
					Editor editor = sharedpreferences.edit();
			        editor.putString(setFlag, botua);
			        editor.commit();
			        
					dialog.cancel();
					finish();
				}
			});
			
			alertBack.show();
			
		}
}

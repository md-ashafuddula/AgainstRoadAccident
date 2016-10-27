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
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SpeedTest extends Activity {
	 private LocationManager locationMangaer=null;  
	 private LocationListener locationListener=null;   
	   
	 TextView tv1,tv2,tv3;
	 private ProgressBar pb =null;  
	   
	 private static final String TAG = "Debug";  
	 private Boolean flag = false; 
	 double Diskm;
	 Location l;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_speed_test);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2f8a66")));
		bar.setTitle(R.string.SpeedText);
		final MediaPlayer clicks = new MediaPlayer().create(SpeedTest.this, R.raw.cliclk);
		
		pb = (ProgressBar) findViewById(R.id.proSpeed);  
		  pb.setVisibility(View.INVISIBLE);  
		    
		  tv1 = (TextView)findViewById(R.id.speedT);
		  locationMangaer = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		  flag = displayGpsStatus();  
		  
		  
		   if (flag) {  
		     
		   //Log.v(TAG, "onClick");     
		     
		   pb.setVisibility(View.VISIBLE);  
		   locationListener = new MyLocationListener();  
		  
		   locationMangaer.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10,locationListener);  
		     
		   } else {  
		   alertbox("Gps Status!!", "Your GPS is: OFF");  
		  }	
		
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
	     
	           float speed = 0;
	       	if (loc.hasSpeed())
	       		speed = loc.getSpeed();

	       	final float METERSPERSEC_to_MPH = (float) 2.23693629;
	       	final float METERSPERSEC_to_KPH = (float) 3.6;
	       	String formatString;
	       	String formatString2;

	       		formatString = String.format("%d ",(int) (speed * METERSPERSEC_to_MPH)); //mph
	       		formatString2 = String.format("%d ",(int) (speed * METERSPERSEC_to_KPH)); //kph
	         
	       		String vl2 ="Vehicles speed: "+formatString2+" KMH\n"; //
	           tv1.setText(vl2);
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
	
 
}

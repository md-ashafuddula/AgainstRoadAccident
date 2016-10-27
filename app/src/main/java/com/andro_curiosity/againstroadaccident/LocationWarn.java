package com.andro_curiosity.againstroadaccident;

import java.io.IOException;  
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;  
import java.util.Locale;  
  
import android.app.ActionBar;
import android.app.Activity;  
import android.app.AlertDialog;  
import android.content.ContentResolver;  
import android.content.Context;  
import android.content.DialogInterface;  
import android.content.Intent;  
import android.content.pm.ActivityInfo;  
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;  
import android.location.Geocoder;  
import android.location.Location;  
import android.location.LocationListener;  
import android.location.LocationManager;  
import android.media.MediaPlayer;
import android.os.Bundle;  
import android.provider.Settings;  
import android.text.style.ClickableSpan;
import android.util.Log;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;  
import android.widget.EditText;  
import android.widget.ProgressBar;  
import android.widget.TextView;
import android.widget.Toast;  
  
public class LocationWarn extends Activity{  
	   
	 private LocationManager locationMangaer=null;  
	 private LocationListener locationListener=null;   
	   
	 TextView tv1,tv2,tv3;
	 private ProgressBar pb =null;  
	 String Add = null,city = null,state =null, country = null;
	 
	 String ad[] = new String[14];
	 String Div[] = new String[14];
	 
	 private static final String TAG = "Debug";  
	 private Boolean flag = false; 
	 double Diskm;
	 Location l;
	 Double EarRad = 6371.00;
	 double max = 999999.0;
	 
	 double place[][] = new double[250][2];
	 String Pname[] = new String [12];
	 static int i = 0;
	  
	 @Override  
	 public void onCreate(Bundle savedInstanceState) {  
	  super.onCreate(savedInstanceState);  
	  setContentView(R.layout.activity_location_warn);  
	    
	  ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		bar.setTitle(R.string.kachakachi);
	  
	  //if you want to lock screen for always Portrait mode    
	  //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  
	  
	  pb = (ProgressBar) findViewById(R.id.progressBar1);  
	  pb.setVisibility(View.INVISIBLE);  
	    
	  tv1 = (TextView)findViewById(R.id.Plocid);
	  //tv1 = (TextView)findViewById(R.id.bspotid);
	  //tv1 = (TextView)findViewById(R.id.distId);
	   initializeDataRaj();
	   initializeDataDhaka();
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
	     
	  
	 private void initializeDataRaj() {
		 	place[0][0] = 24.118173 ;
			place[0][1] = 90.147650 ;
			Pname[0] = "latifpur bazar";
					
			place[1][0] = 24.275276 ;
			place[1][1] = 89.935219 ;
			Pname[1] = "Tangail Town";
	}


	private void initializeDataDhaka() {
		place[0][0] = 24.118173 ;
		place[0][1] = 90.147650 ;
		Pname[0] = "latifpur bazar";
				
		place[1][0] = 24.275276 ;
		place[1][1] = 89.935219 ;
		Pname[1] = "Tangail Town";
				
		place[2][0] = 24.177479 ;
		place[2][1] = 90.021508 ;
		Pname[2] = "Natiapara-Habla Rd";
				
		place[3][0] = 24.118872 ;
		place[3][1] = 90.064215 ;
		Pname[3] = "Kurni Bazar";
				
		place[4][0] = 24.292190 ;
		place[4][1] = 89.081568 ;
		Pname[4] = "Bonpara Bus Stand";
				
		place[5][0] = 24.168365 ;
		place[5][1] = 89.6291 ;
		Pname[5] = "Puthya Bazar";
				
		place[6][0] = 24.36;
		place[6][1] = 88.759999 ;
		Pname[6] = "Baneswar Bazar";
				
		place[7][0] = 23.955617 ;
		place[7][1] = 89.443486 ;
		Pname[7] = "Madpur bazar";
				
		place[8][0] = 24.779118 ;
		place[8][1] = 88.982069 ;
		Pname[8] = "Tarapur Bazar";
				
		place[9][0] = 24.3618495 ;
		place[9][1] = 88.60641450 ;
		Pname[9] = "Kapasia Bazar";
				
		place[10][0] = 23.7876114; // dhaka - aricha
		place[10][1] = 90.3276405 ;
		Pname[10] = "Dhaka-Aricha Highway";
				
		//By default->Rajshahi Local Area Talaimari Chattar, Bir Sreshtho Shaheed Captain Mohiuddin Jahangir Smarani 
		/*place[11][0] = 24.3617016 ;
		place[11][1] = 88.6269745 ;
		Pname[11] = "Talaimari Chattar";*/
				
	}


	/*----Method to Check GPS is enable or disable ----- */  
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
	  
	 /*----------Method to create an AlertBox ------------- */  
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
	   
	 /*----------Listener class to get coordinates ------------- */  
	 private class MyLocationListener implements LocationListener {  
	        @Override  
	        public void onLocationChanged(Location loc) {  
	        	String Add = null,city = null,state =null, country = null;
	        	Arrays.fill(ad, null);
	        	Arrays.fill(Div, null);
	            
	     tv1.setText("");  
	     pb.setVisibility(View.INVISIBLE);  
	    // Toast.makeText(getBaseContext(),"Location changed .\nLat: " + loc.getLatitude()+ "\nLng: " + loc.getLongitude(), Toast.LENGTH_LONG).show();  
	            String longitude = "" +loc.getLongitude();    
	     // Log.v(TAG, longitude);  
	      String latitude = "" +loc.getLatitude();  
	      //Log.v(TAG, latitude);  
	            
	    /*----------to get City-Name from coordinates ------------- */  
	      String cityName=null;                
	      Geocoder gcd = new Geocoder(getBaseContext(),Locale.getDefault());               
	      List<Address>  addresses;
	      //ad1,ad2,ad3,ad4,ad5,ad6,ad7,ad8,ad9,ad10,ad11,ad12,ad13;    
	      try {    
	      addresses = gcd.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1); 
	      Add = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
	      city = addresses.get(0).getLocality();
	      state = addresses.get(0).getAdminArea();  //division
	      country = addresses.get(0).getCountryName();
	      
	      //demo
	      /*
	      ad1 = gcd.getFromLocation(24.3796592, 88.56478479999998,1);
	      ad[1] = ad1.get(0).getAddressLine(0);
	      Div[1] = ad1.get(0).getAdminArea(); //chapai
	      
	      ad2 = gcd.getFromLocation(24.8435589, 89.37010780000003,1);
	      ad[2] = ad2.get(0).getAddressLine(0);
	      Div[2] = ad2.get(0).getAdminArea(); //Bogra
	      ad3 = gcd.getFromLocation(22.991267 , 89.83863830566406,1);
	      ad[3] = ad3.get(0).getAddressLine(0);
	      Div[3] = ad3.get(0).getAdminArea();//Gopalgonj
	      
	      ad4 = gcd.getFromLocation(23.7876114, 90.32764050000003,1);
	      ad[4] = ad4.get(0).getAddressLine(0);
	      Div[4] = ad4.get(0).getAdminArea();//Dhaka-aricha
	      ad5 = gcd.getFromLocation(23.61055365511656, 90.50365447998047,1);
	      ad[5] = ad5.get(0).getAddressLine(0);
	      Div[5] = ad5.get(0).getAdminArea(); //NarayonGonj
	      ad6 = gcd.getFromLocation(22.840109991553714, 91.83712005615234,1);
	      ad[6] = ad6.get(0).getAddressLine(0);
	      Div[6] = ad6.get(0).getAdminArea(); //Manikchora,CTG
	      ad7 = gcd.getFromLocation(23.642008164226905, 90.4446029663086,1);
	      ad[7] = ad7.get(0).getAddressLine(0);
	      Div[7] = ad7.get(0).getAdminArea();//Unnamed Road, Zazira ,Barisal
	      ad8 = gcd.getFromLocation(23.534402515429903, 90.29560089111328,1);
	      ad[8] = ad8.get(0).getAddressLine(0);
	      Div[8] = ad8.get(0).getAdminArea();//Bejgaon - Baroigaon Rd, Sreenagar
	      ad9 = gcd.getFromLocation(24.90263046793521, 91.94355010986328,1);
	      ad[9] = ad9.get(0).getAddressLine(0);
	      Div[9] = ad9.get(0).getAdminArea(); //Islamabad Road,Sylhet
	      ad10 = gcd.getFromLocation(25.1695436, 91.88672629999996,1);
	      ad[10] = ad10.get(0).getAddressLine(0);
	      Div[10] = ad10.get(0).getAdminArea(); //Bisnakandi,Sylhet
	      ad11 = gcd.getFromLocation(25.57093678375228, 88.62567901611328,1);
	      ad[11] = ad11.get(0).getAddressLine(0);
	      Div[11] = ad11.get(0).getAdminArea(); //Dinajpur - Khanpur Border Rd
	      ad12 = gcd.getFromLocation(23.794141041499493, 90.70209503173828,1);
	      ad[12] = ad12.get(0).getAddressLine(0);
	      Div[12] = ad12.get(0).getAdminArea(); //R203, Araihazar,,rongpur
	      ad13 = gcd.getFromLocation(23.815500848699653, 90.54210662841797,1);
	      ad[13] = ad13.get(0).getAddressLine(0);
	      Div[13] = ad13.get(0).getAdminArea(); // Rupganj,Rongpur*/
	      //End
	      
	      
	      if (addresses.size() > 0)    
	         //System.out.println(addresses.get(0).getLocality());    
	         cityName=addresses.get(0).getLocality();    
	        } catch (IOException e) {              
	        e.printStackTrace();    
	      }   
	            
	      //String s = "Longitude : "+longitude+"\n"+"Latitude : "+latitude + "\n\nYour Currrent City is: "+cityName+"\nBlack Spot: Dhaka-Aricha Haighway.\n\n";
	      
	         //Calculation for Distance
	      	   double lat1 = loc.getLatitude();
	      	   double lon1 = loc.getLongitude();
	           
	      	   double lat2 =23.7876114;
	           double lon2 =90.32764050000003;
	      	    
	           
	           double time = 10.00;
	           //Diskm = DistCalculation(lat1,lon1,lat2,lon2);
	           final MediaPlayer clicks = new MediaPlayer().create(LocationWarn.this, R.raw.policewhistle); 
	           
	           Location loc1 = new Location("");
	           loc1.setLatitude(lat1);
	           loc1.setLongitude(lon1);
	           double distanceInMeters = 10;

	           Location loc2 = new Location("");
	           
	           //chk state for black spot
	           if(state == "Dhaka Division"){
	        	   
	           }else if(state == "Rajshahi Division"){
	        	   
	           }
	           
	           
	           
	           for(int j = 0; j < 12;j++){
	        	   lat2 = place[j][0];
	        	   lon2 = place[j][1];
	        	   
	        	   loc2.setLatitude(lat2);
		           loc2.setLongitude(lon2);

		           distanceInMeters = loc1.distanceTo(loc2);
		           distanceInMeters = distanceInMeters/1000.00;
		           
		           if(distanceInMeters <= max){
		        	   max = distanceInMeters;
		        	   i = j;
		           }
	           }
	           //i = 11;
	           lat2 = place[i][0];
        	   lon2 = place[i][1];

	           loc2.setLatitude(lat2);
	           loc2.setLongitude(lon2);

	           distanceInMeters = loc1.distanceTo(loc2);
	           distanceInMeters = distanceInMeters/1000.00;
	           String s = "Your Cuurent Address: "+Add+"\n\nYour Currrent City is: "+cityName+"\nBlack Spot: "+Pname[i]+".\n\n";
	           if(distanceInMeters <= (1.5)){
	        	   clicks.start();
	        	   Toast.makeText(LocationWarn.this,Pname[i]+" "+distanceInMeters, Toast.LENGTH_LONG).show();
	        	   clicks.stop();
	           }else if(distanceInMeters < (1)){
	        	   clicks.start();
	        	   Toast.makeText(LocationWarn.this,Pname[i]+" "+distanceInMeters, Toast.LENGTH_LONG).show();
	           }
	           
	           
	           distanceInMeters = Double.parseDouble(new DecimalFormat("###.###").format(distanceInMeters));
	           String CkDivision = null;
	           CkDivision = "Add: "+ad[1]+"\nDiv: "+Div[1]+"\n\n"+"Add: "+ad[2]+"\nDiv: "+Div[2]+"\n\n"
	        		   +"Add: "+ad[3]+"\nDiv: "+Div[3]+"\n\n"+"Add: "+ad[4]+"\nDiv: "+Div[4]+"\n\n"
	        		   +"Add: "+ad[5]+"\nDiv: "+Div[5]+"\n\n"+"Add: "+ad[6]+"\nDiv: "+Div[6]+"\n\n"
	        		   +"Add: "+ad[7]+"\nDiv: "+Div[7]+"\n\n"+"Add: "+ad[8]+"\nDiv: "+Div[8]+"\n\n"
	        		   +"Add: "+ad[9]+"\nDiv: "+Div[9]+"\n\n"+"Add: "+ad[10]+"\nDiv: "+Div[10]+"\n\n"
	        		   +"Add: "+ad[11]+"\nDiv: "+Div[11]+"\n\n"+"Add: "+ad[12]+"\nDiv: "+Div[12]+"\n\n"
	        		   +"Add: "+ad[13]+"\nDiv: "+Div[13]+"\n\n";
	           String vl = s+"Distance : "+distanceInMeters+" km";
	           
	           float speed = 0;
	       	if (loc.hasSpeed())
	       		speed = loc.getSpeed();

	       	final float METERSPERSEC_to_MPH = (float) 2.23693629;
	       	final float METERSPERSEC_to_KPH = (float) 3.6;
	       	String formatString;
	       	String formatString2;

	       //	if (m_imperial)
	       		formatString = String.format("%d ",(int) (speed * METERSPERSEC_to_MPH)); //mph
	       //	else
	       		formatString2 = String.format("%d ",(int) (speed * METERSPERSEC_to_KPH)); //kph
	         
	       		String vl2 =vl+"\n\n\n\nVehicles speed: "+formatString2+" KMH\n"+"\n\n\n"; //+CkDivision
	           tv1.setText(vl2);
	        }  
	      /*
	        private double DistCalculation(double lat1, double lon1,double lat2, double lon2) {
				double rad = EarRad;
				double dlat = Math.toRadians(lat2 - lat1);
				double dlon = Math.toRadians(lon2-lon1);
				double a = Math.sin(dlat/2)*Math.sin(dlat/2)+Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2))+Math.sin(dlon/2)*Math.sin(dlon/2);
				double c = 2*Math.asin(Math.sqrt(a));
				
				return rad*c;
				
			}*/

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
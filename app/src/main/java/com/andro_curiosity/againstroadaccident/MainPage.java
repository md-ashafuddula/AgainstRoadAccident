package com.andro_curiosity.againstroadaccident;

import java.util.Calendar;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainPage extends Activity {
	Button b[] = new Button[7];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
		ActionBar bar = getActionBar();
		 
		//bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.titlebar));
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		//bar.hide();
		
		b[1] = (Button)findViewById(R.id.Emergeny);
		b[2] = (Button)findViewById(R.id.driverOwner);
		b[3] = (Button)findViewById(R.id.Passenger);
		b[4] = (Button)findViewById(R.id.publicN);
		b[5] = (Button)findViewById(R.id.laws);
		b[6] = (Button)findViewById(R.id.DangerousPlace);
		
		final MediaPlayer whistle = MediaPlayer.create(MainPage.this, R.raw.cliclk);
		startAlert();
		
b[1].setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					b[1].setBackgroundResource(R.drawable.emergencypicb);
					b[1].getBackground().setAlpha(200);
					whistle.start();
					break;
				case MotionEvent.ACTION_UP:
					b[1].setBackgroundResource(R.drawable.emergencypica);
					Intent SendCmpln = new Intent(MainPage.this,EmergencyComplain.class);
					startActivity(SendCmpln);
					b[1].getBackground().setAlpha(255);
				    break;
				case MotionEvent.ACTION_MOVE:
					b[1].setBackgroundResource(R.drawable.emergencypicb);
					b[1].getBackground().setAlpha(200);
					break;
				default:
					break;
				}

				return false;
			}
		});
b[2].setOnTouchListener(new View.OnTouchListener() {
	
	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub
		
		switch(event.getAction()){
		case   MotionEvent.ACTION_DOWN:
			b[2].setBackgroundResource(R.drawable.driverownerb);
			b[2].getBackground().setAlpha(200);
			whistle.start();
			break;
		case MotionEvent.ACTION_UP:
			b[2].setBackgroundResource(R.drawable.driverownera);
			Intent GoDriverOwner = new Intent(MainPage.this,DriverOwner.class);
			startActivity(GoDriverOwner);
			b[2].getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			b[2].setBackgroundResource(R.drawable.driverownerb);
			b[2].getBackground().setAlpha(200);
			break;
		default:
			break;
		}

		return false;
	}
});

b[3].setOnTouchListener(new View.OnTouchListener() {
	
	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub
		
		switch(event.getAction()){
		case   MotionEvent.ACTION_DOWN:
			b[3].setBackgroundResource(R.drawable.passengerb);
			b[3].getBackground().setAlpha(200);
			whistle.start();
			break;
		case MotionEvent.ACTION_UP:
			b[3].setBackgroundResource(R.drawable.passengera);
			Intent pass = new Intent(MainPage.this,Jatri.class);
			//pass.putExtra("send", 31);
			startActivity(pass);
			b[3].getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			b[3].setBackgroundResource(R.drawable.passengerb);
			b[3].getBackground().setAlpha(200);
			break;
		default:
			break;
		}

		return false;
	}
});
		
b[4].setOnTouchListener(new View.OnTouchListener() {
	
	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub
		
		switch(event.getAction()){
		case   MotionEvent.ACTION_DOWN:
			b[4].setBackgroundResource(R.drawable.publicb);
			b[4].getBackground().setAlpha(200);
			whistle.start();
			break;
		case MotionEvent.ACTION_UP:
			b[4].setBackgroundResource(R.drawable.publica);
			Intent PassersBy = new Intent(MainPage.this,ByPassers.class);
			//PassersBy.putExtra("send", 40);
			startActivity(PassersBy);
			b[4].getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			b[4].setBackgroundResource(R.drawable.publicb);
			b[4].getBackground().setAlpha(200);
			break;
		default:
			break;
		}

		return false;
	}
});				
b[5].setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					b[5].setBackgroundResource(R.drawable.lawb);
					b[5].getBackground().setAlpha(200);
					whistle.start();
					break;
				case MotionEvent.ACTION_UP:
					b[5].setBackgroundResource(R.drawable.lawa);
					Intent Tolaw = new Intent(MainPage.this,Law.class);
					startActivity(Tolaw);
					b[5].getBackground().setAlpha(255);
				    break;
				case MotionEvent.ACTION_MOVE:
					b[5].setBackgroundResource(R.drawable.lawb);
					b[5].getBackground().setAlpha(200);
					break;
				default:
					break;
				}

				return false;
			}
		});

b[6].setOnTouchListener(new View.OnTouchListener() {
	
	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub
		
		switch(event.getAction()){
		case   MotionEvent.ACTION_DOWN:
			b[6].setBackgroundResource(R.drawable.dangerb);
			b[6].getBackground().setAlpha(200);
			whistle.start();
			break;
		case MotionEvent.ACTION_UP:
			b[6].setBackgroundResource(R.drawable.dangera);
			Intent seeDangerZone = new Intent(MainPage.this,DangerPlace.class);
			startActivity(seeDangerZone);
			b[6].getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			b[6].setBackgroundResource(R.drawable.dangerb);
			b[6].getBackground().setAlpha(200);
			break;
		default:
			break;
		}

		return false;
	}
});
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
		
		HandlerBack();
		return;
	}
	
	public void HandlerBack(){
		AlertDialog.Builder alertBack = new AlertDialog.Builder(MainPage.this);
		
		alertBack.setTitle(R.string.backTitle);
		alertBack.setIcon(R.drawable.warning);
		alertBack.setMessage(R.string.backMessage);
		
		alertBack.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		alertBack.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int arg1) {
				// TODO Auto-generated method stub
				dialog.cancel();			
			}
		});
		
		alertBack.show();
		
	}
	public void startAlert() {  
          
        int i = 24;
        long seconds = System.currentTimeMillis()/1000;
        long s = seconds % 60;
        long m = (seconds / 60) % 60;
        long h = (seconds / (60 * 60)) % 24;
          

         // Toast.makeText(this, "Current Time : "+h+" "+m+" "+s+"   " ,Toast.LENGTH_LONG).show(); 
          
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, (int) h);
        calendar.set(Calendar.MINUTE, (int)m+1);
        calendar.set(Calendar.SECOND,0);

        // With setInexactRepeating(), you have to use one of the AlarmManager interval
        // constants--in this case, AlarmManager.INTERVAL_DAY.
        Toast.makeText(MainPage.this,R.string.AlarmAwarness, Toast.LENGTH_LONG).show();
        
        Intent intent = new Intent(this, MyBroadCastReceive.class);  
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),0, intent, 0);  
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);  
        //alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + (5 * 1000), pendingIntent);
        //alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+ (i * 1000), AlarmManager.INTERVAL_DAY, pendingIntent);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),1000 * 60*60*24 , pendingIntent);
        //Toast.makeText(this, "Alarm set in " + i + " seconds",Toast.LENGTH_LONG).show();  
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.Main_page_menu:
			Intent in = new Intent(MainPage.this,Emer_Call.class);
			startActivity(in);
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}

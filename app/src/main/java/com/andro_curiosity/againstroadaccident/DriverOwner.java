package com.andro_curiosity.againstroadaccident;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class DriverOwner extends Activity {
	Button b[] = new Button[5];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_driver_owner);
		
		ActionBar bar = getActionBar();
		//bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.titlebar));
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		bar.setTitle(R.string.calokMalik);
		final MediaPlayer whistle = MediaPlayer.create(DriverOwner.this, R.raw.cliclk);
		
		b[1] = (Button)findViewById(R.id.InfoSignalName);
		b[2] = (Button) findViewById(R.id.LightName);
		b[3] = (Button) findViewById(R.id.DriverSide);
		b[4] = (Button) findViewById(R.id.OwnerSide);
		
b[1].setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					b[1].setBackgroundResource(R.drawable.infosignalb);
					b[1].getBackground().setAlpha(200);
					whistle.start();
					break;
				case MotionEvent.ACTION_UP:
					b[1].setBackgroundResource(R.drawable.infosignala);
					Intent RoadS = new Intent(DriverOwner.this,RoadSign.class);
					//DriverSidelink.putExtra("send", 21);
					startActivity(RoadS);
					b[1].getBackground().setAlpha(255);
				    break;
				case MotionEvent.ACTION_MOVE:
					b[1].setBackgroundResource(R.drawable.infosignalb);
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
			b[2].setBackgroundResource(R.drawable.lightb);
			b[2].getBackground().setAlpha(200);
			whistle.start();
			break;
		case MotionEvent.ACTION_UP:
			b[2].setBackgroundResource(R.drawable.lighta);
			Intent animLightlink = new Intent(DriverOwner.this,AnimLightSignal.class);
			//DriverSidelink.putExtra("send", 22);
			startActivity(animLightlink);
			b[2].getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			b[2].setBackgroundResource(R.drawable.lightb);
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
					b[3].setBackgroundResource(R.drawable.driverb);
					b[3].getBackground().setAlpha(200);
					whistle.start();
					break;
				case MotionEvent.ACTION_UP:
					b[3].setBackgroundResource(R.drawable.drivera);
					Intent DriverSidelink = new Intent(DriverOwner.this,ShowPage.class);
					DriverSidelink.putExtra("send", 23);
					startActivity(DriverSidelink);
					b[3].getBackground().setAlpha(255);
				    break;
				case MotionEvent.ACTION_MOVE:
					b[3].setBackgroundResource(R.drawable.driverb);
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
			b[4].setBackgroundResource(R.drawable.ownerb);
			b[4].getBackground().setAlpha(200);
			whistle.start();
			break;
		case MotionEvent.ACTION_UP:
			b[4].setBackgroundResource(R.drawable.ownera);
			Intent OwnerSidelink = new Intent(DriverOwner.this,ShowPage.class);
			OwnerSidelink.putExtra("send", 24);
			startActivity(OwnerSidelink);
			b[4].getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			b[4].setBackgroundResource(R.drawable.ownerb);
			b[4].getBackground().setAlpha(200);
			break;
		default:
			break;
		}

		return false;
	}
});
	}

	

}

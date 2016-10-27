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

public class EmergencyComplain extends Activity {
	Button b[] = new Button[4];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emergency_complain);
		
		ActionBar bar = getActionBar();
		//bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.titlebar));
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		bar.setTitle(R.string.ovijOg);
		final MediaPlayer whistle = MediaPlayer.create(EmergencyComplain.this, R.raw.cliclk);
		
		b[1] = (Button)findViewById(R.id.SendComplain);
		b[2] = (Button) findViewById(R.id.FirstAid);
		b[3] = (Button) findViewById(R.id.EmerCall);
		
b[1].setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					b[1].setBackgroundResource(R.drawable.complainb);
					b[1].getBackground().setAlpha(200);
					whistle.start();
					break;
				case MotionEvent.ACTION_UP:
					b[1].setBackgroundResource(R.drawable.complain);
					Intent WriteCom = new Intent(EmergencyComplain.this,ComplainBox.class);
					//Fine.putExtra("send", 51);
					startActivity(WriteCom);
					b[1].getBackground().setAlpha(255);
				    break;
				case MotionEvent.ACTION_MOVE:
					b[1].setBackgroundResource(R.drawable.complainb);
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
			b[2].setBackgroundResource(R.drawable.situationemeregencyb);
			b[2].getBackground().setAlpha(200);
			whistle.start();
			break;
		case MotionEvent.ACTION_UP:
			b[2].setBackgroundResource(R.drawable.situationemeregencya);
			Intent forFirstAid = new Intent(EmergencyComplain.this,ShowPage.class);
			forFirstAid.putExtra("send", 12);
			startActivity(forFirstAid);
			b[2].getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			b[2].setBackgroundResource(R.drawable.situationemeregencyb);
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
			b[3].setBackgroundResource(R.drawable.msgb);
			b[3].getBackground().setAlpha(200);
			whistle.start();
			break;
		case MotionEvent.ACTION_UP:
			b[3].setBackgroundResource(R.drawable.msga);
			Intent forFirstAid = new Intent(EmergencyComplain.this,EmergencyCall.class);
			
			startActivity(forFirstAid);
			b[3].getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			b[3].setBackgroundResource(R.drawable.msgb);
			b[3].getBackground().setAlpha(200);
			break;
		default:
			break;
		}

		return false;
	}
});
		
	}

}

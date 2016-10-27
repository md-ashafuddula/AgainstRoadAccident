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

public class Jatri extends Activity {
	Button b1,b2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jatri);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		bar.setTitle(R.string.jatriTitle);
		
		b1 = (Button) findViewById(R.id.JatriAware);
		b2 = (Button) findViewById(R.id.JatriSpeed);
		
		final MediaPlayer whistle = MediaPlayer.create(Jatri.this, R.raw.cliclk);
		
		b1.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					b1.setBackgroundResource(R.drawable.jatrib);
					b1.getBackground().setAlpha(200);
					whistle.start();
					break;
				case MotionEvent.ACTION_UP:
					b1.setBackgroundResource(R.drawable.jatria);
					Intent pass = new Intent(Jatri.this,ShowPage.class);
					pass.putExtra("send", 31);
					startActivity(pass);
					b1.getBackground().setAlpha(255);
				    break;
				case MotionEvent.ACTION_MOVE:
					b1.setBackgroundResource(R.drawable.jatrib);
					b1.getBackground().setAlpha(200);
					break;
				default:
					break;
				}

				return false;
			}
		});
		
b2.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					b2.setBackgroundResource(R.drawable.speedb);
					b2.getBackground().setAlpha(200);
					whistle.start();
					break;
				case MotionEvent.ACTION_UP:
					b2.setBackgroundResource(R.drawable.speeda);
					Intent speed = new Intent(Jatri.this,SpeedTest.class);
					startActivity(speed);
					b2.getBackground().setAlpha(255);
				    break;
				case MotionEvent.ACTION_MOVE:
					b2.setBackgroundResource(R.drawable.speedb);
					b2.getBackground().setAlpha(200);
					break;
				default:
					break;
				}

				return false;
			}
		});
		
		
	}

}

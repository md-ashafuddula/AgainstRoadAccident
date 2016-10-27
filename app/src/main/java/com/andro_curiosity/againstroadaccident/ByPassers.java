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

public class ByPassers extends Activity {
	Button b1,b2,b3,b4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_by_passers);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		bar.setTitle(R.string.jonoOpoth);
		final MediaPlayer whistle = MediaPlayer.create(ByPassers.this, R.raw.cliclk);
		
		b1 = (Button)findViewById(R.id.CareByPass);
		b2 = (Button)findViewById(R.id.AnimCrossRoad);
		b3 = (Button)findViewById(R.id.Peopole);
		b4 = (Button)findViewById(R.id.SugBox);
		
		final MediaPlayer whistle1 = MediaPlayer.create(ByPassers.this, R.raw.cliclk);
		//whistle.start();
		
b1.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				
				
				//whistle.start();
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					b1.setBackgroundResource(R.drawable.footpathb);
					b1.getBackground().setAlpha(200);
					whistle1.start();
					break;
				case MotionEvent.ACTION_UP:
					b1.setBackgroundResource(R.drawable.footpatha);
					Intent footP = new Intent(ByPassers.this,ShowPage.class);
					footP.putExtra("send", 41);
					startActivity(footP);
					b1.getBackground().setAlpha(255);
				    break;
				case MotionEvent.ACTION_MOVE:
					b1.setBackgroundResource(R.drawable.footpathb);
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
			b2.setBackgroundResource(R.drawable.crossbypassb);
			b2.getBackground().setAlpha(200);
			whistle1.start();
			break;
		case MotionEvent.ACTION_UP:
			b2.setBackgroundResource(R.drawable.crossbypassa);
			Intent PassCrossingRoadFoot = new Intent(ByPassers.this,PassersCrossingRoad.class);
			//ByPass.putExtra("send", 42);
			startActivity(PassCrossingRoadFoot);
			b2.getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			b2.setBackgroundResource(R.drawable.crossbypassb);
			b2.getBackground().setAlpha(200);
			break;
		default:
			break;
		}

		return false;
	}
});

b3.setOnTouchListener(new View.OnTouchListener() {
	
	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		
		// TODO Auto-generated method stub
		
		switch(event.getAction()){
		case   MotionEvent.ACTION_DOWN:
			b3.setBackgroundResource(R.drawable.peopoleb);
			b3.getBackground().setAlpha(200);
			whistle1.start();
			break;
		case MotionEvent.ACTION_UP:
			b3.setBackgroundResource(R.drawable.peopolea);
			Intent ByPassPeople = new Intent(ByPassers.this,ShowPage.class);
			ByPassPeople.putExtra("send", 43);
			startActivity(ByPassPeople);
			b3.getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			b3.setBackgroundResource(R.drawable.peopoleb);
			b3.getBackground().setAlpha(200);
			break;
		default:
			break;
		}

		return false;
	}
});

b4.setOnTouchListener(new View.OnTouchListener() {
	
	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		
		// TODO Auto-generated method stub
		
		switch(event.getAction()){
		case   MotionEvent.ACTION_DOWN:
			b4.setBackgroundResource(R.drawable.sugboxb);
			b4.getBackground().setAlpha(200);
			whistle1.start();
			break;
		case MotionEvent.ACTION_UP:
			b4.setBackgroundResource(R.drawable.sugboxa);
			Intent sugBoxG = new Intent(ByPassers.this,SuggesionBox.class);
			//ByPassPeople.putExtra("send", 43);
			startActivity(sugBoxG);
			b4.getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			b4.setBackgroundResource(R.drawable.sugboxb);
			b4.getBackground().setAlpha(200);
			break;
		default:
			break;
		}

		return false;
	}
});
	}


}

package com.andro_curiosity.againstroadaccident;

import java.util.Locale;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Law extends Activity {
	TextToSpeech sp;
	
	Button b[] = new Button[4];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_law);
		
		ActionBar bar = getActionBar();
		//bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.titlebar));
		bar.setTitle(R.string.ainkanun);
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		final MediaPlayer whistle = MediaPlayer.create(Law.this, R.raw.cliclk);
		
		
		b[1] = (Button)findViewById(R.id.CauseBreakLaw);
		b[2] = (Button) findViewById(R.id.fineTK);
		b[3] = (Button) findViewById(R.id.papersNeed);
		
		sp = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
	         @Override
	         public void onInit(int status) {
	            if(status != TextToSpeech.ERROR) {
	               sp.setLanguage(Locale.UK);
	            }
	         }
	      });
		
		
		final String toSpeak1 = "Breaking law Cause";
		final String toSpeak2 = "Fine";
		final String toSpeak3 = "Needed Papers";
		
b[1].setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					b[1].setBackgroundResource(R.drawable.causeofbreakinglawb);
					b[1].getBackground().setAlpha(200);
					sp.speak(toSpeak1, TextToSpeech.QUEUE_FLUSH, null);
					whistle.start();
					break;
				case MotionEvent.ACTION_UP:
					b[1].setBackgroundResource(R.drawable.causeofbreakinglawa);
					Intent Fine = new Intent(Law.this,ShowPage.class);
					Fine.putExtra("send", 51);
					startActivity(Fine);
					b[1].getBackground().setAlpha(255);
				    break;
				case MotionEvent.ACTION_MOVE:
					b[1].setBackgroundResource(R.drawable.causeofbreakinglawb);
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
			b[2].setBackgroundResource(R.drawable.fineb);
			b[2].getBackground().setAlpha(200);
			//sp.speak(toSpeak2, TextToSpeech.QUEUE_FLUSH, null);
			whistle.start();
			break;
		case MotionEvent.ACTION_UP:
			b[2].setBackgroundResource(R.drawable.finea);
			Intent Fine = new Intent(Law.this,ShowPage.class);
			Fine.putExtra("send", 52);
			startActivity(Fine);
			b[2].getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			b[2].setBackgroundResource(R.drawable.fineb);
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
					b[3].setBackgroundResource(R.drawable.papersb);
					b[3].getBackground().setAlpha(200);
					//sp.speak(toSpeak3, TextToSpeech.QUEUE_FLUSH, null);
					whistle.start();
					break;
				case MotionEvent.ACTION_UP:
					b[3].setBackgroundResource(R.drawable.papersa);
					Intent Fine = new Intent(Law.this,ShowPage.class);
					Fine.putExtra("send", 53);
					startActivity(Fine);
					b[3].getBackground().setAlpha(255);
				    break;
				case MotionEvent.ACTION_MOVE:
					b[3].setBackgroundResource(R.drawable.papersa);
					b[3].getBackground().setAlpha(200);
					break;
				default:
					break;
				}

				return false;
			}
		});
	}

	@Override
	public void onPause(){
	      if(sp !=null){
	         sp.stop();
	         sp.shutdown();
	      }
	      super.onPause();
	   }
	

}

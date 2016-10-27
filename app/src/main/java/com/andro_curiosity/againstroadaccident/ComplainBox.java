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

public class ComplainBox extends Activity {
	
	Button bC[] = new Button[4];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_complain_box);
		
		ActionBar bar = getActionBar();
		//bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.titlebar));
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		bar.setTitle(R.string.Ovi);
		final MediaPlayer clicks = MediaPlayer.create(ComplainBox.this, R.raw.cliclk);
		
		bC[1] = (Button)findViewById(R.id.BrtaButton);
		bC[2] = (Button) findViewById(R.id.Camerabutton);
		bC[3] = (Button) findViewById(R.id.WriteCom);
		
bC[1].setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					bC[1].setBackgroundResource(R.drawable.brtab);
					bC[1].getBackground().setAlpha(200);
					clicks.start();
					break;
				case MotionEvent.ACTION_UP:
					bC[1].setBackgroundResource(R.drawable.brtaa);					
					bC[1].getBackground().setAlpha(255);
					Intent Gobrta = new Intent(ComplainBox.this,BRTA.class);
					startActivity(Gobrta);
				    break;
				case MotionEvent.ACTION_MOVE:
					bC[1].setBackgroundResource(R.drawable.brtab);
					bC[1].getBackground().setAlpha(200);
					break;
				default:
					break;
				}

				return false;
			}
		});

bC[2].setOnTouchListener(new View.OnTouchListener() {
	
	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub
		
		switch(event.getAction()){
		case   MotionEvent.ACTION_DOWN:
			bC[2].setBackgroundResource(R.drawable.camerab);
			bC[2].getBackground().setAlpha(200);
			clicks.start();
			break;
		case MotionEvent.ACTION_UP:
			bC[2].setBackgroundResource(R.drawable.cameraa);
			Intent Capture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivity(Capture);
			bC[2].getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			bC[2].setBackgroundResource(R.drawable.camerab);
			bC[2].getBackground().setAlpha(200);
			break;
		default:
			break;
		}

		return false;
	}
});

bC[3].setOnTouchListener(new View.OnTouchListener() {
	
	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub
		
		switch(event.getAction()){
		case   MotionEvent.ACTION_DOWN:
			bC[3].setBackgroundResource(R.drawable.writecomplainb);
			bC[3].getBackground().setAlpha(200);
			clicks.start();
			break;
		case MotionEvent.ACTION_UP:
			bC[3].setBackgroundResource(R.drawable.writecomplaina);
			Intent MMS = new Intent(ComplainBox.this,MMSsend.class);
			startActivity(MMS);
			bC[3].getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			bC[3].setBackgroundResource(R.drawable.writecomplainb);
			bC[3].getBackground().setAlpha(200);
			break;
		default:
			break;
		}

		return false;
	}
});

		
		
	}

}

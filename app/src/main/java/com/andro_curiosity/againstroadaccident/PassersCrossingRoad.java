package com.andro_curiosity.againstroadaccident;

import java.util.ArrayList;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PassersCrossingRoad extends Activity {
	
	ImageView anim[] = new ImageView[5];
	TextView animtext[] = new TextView[5];
	Button animButton[] = new Button[5];
	int lock1=0,lock2=0,lock3=0,lock4=0;
	AnimationDrawable animFoot,animZebra,animBridge,animCross;
	 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_passers_crossing_road);
		
		ActionBar bar = getActionBar();
		//bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.titlebar));
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		bar.setTitle(R.string.RastaParapar);
		final MediaPlayer whistle = MediaPlayer.create(PassersCrossingRoad.this, R.raw.policewhistle);
		final MediaPlayer clicks = MediaPlayer.create(PassersCrossingRoad.this, R.raw.cliclk);
				
		anim[1] = (ImageView) findViewById(R.id.anim1image);
		animtext[1] =  (TextView) findViewById(R.id.anim1Text);
		animButton[1] = (Button) findViewById(R.id.anim1button);
		
		anim[2] = (ImageView) findViewById(R.id.anim2image);
		animtext[2] =  (TextView) findViewById(R.id.anim2Text);
		animButton[2] = (Button) findViewById(R.id.anim2button);
		
		anim[3] = (ImageView) findViewById(R.id.anim3image);
		animtext[3] =  (TextView) findViewById(R.id.anim3Text);
		animButton[3] = (Button) findViewById(R.id.anim3button);
		
		anim[4] = (ImageView) findViewById(R.id.anim4image);
		animtext[4] =  (TextView) findViewById(R.id.anim4Text);
		animButton[4] = (Button) findViewById(R.id.anim4button);
		
		
		//seT imageBackround as animationa resources
		anim[1].setBackgroundResource(R.drawable.footpathcross);
		animFoot = (AnimationDrawable) anim[1].getBackground();
		//animFoot.setOneShot(true);
		
		anim[2].setBackgroundResource(R.drawable.zebracross);
		animZebra = (AnimationDrawable) anim[2].getBackground();
		//animZebra.setOneShot(true);
		
		anim[3].setBackgroundResource(R.drawable.crossroad);
		animCross = (AnimationDrawable) anim[3].getBackground();
		//animCross.setOneShot(true);
		
		anim[4].setBackgroundResource(R.drawable.bridge);
		animBridge = (AnimationDrawable) anim[4].getBackground();
		//animBridge.setOneShot(true);
		
		//End All Thread
		animtext[1].setText(R.string.footpathuse);
		animtext[2].setText(R.string.zebrause);
		animtext[3].setText(R.string.crossman);
		animtext[4].setText(R.string.bridge);
		
		
		
animButton[1].setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				
				lock1 = 1;
				lock4 = 0;
				lock2 = 0;
				lock3 = 0;
				//anim[1].setImageDrawable(getResources().getDrawable(R.drawable.footpathcross));
				// TODO Auto-generated method stub
				 
			    //FootTR.stop();
		       
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					animButton[1].setBackgroundResource(R.drawable.paraparb);
					animButton[1].getBackground().setAlpha(80);
					
					//whistle.start();
					clicks.start();
					break;
				case MotionEvent.ACTION_UP:
					//animButton[1].setBackgroundResource(R.drawable.paraparb);
					//animFoot.start(); 
					AnimationFuntion(lock1);
					animButton[1].getBackground().setAlpha(255);
				    break;
				case MotionEvent.ACTION_MOVE:
					animButton[1].setBackgroundResource(R.drawable.paraparb);
					animButton[1].getBackground().setAlpha(80);
					break;
				default:
					break;
				}

				return false;
			}

			
		});

animButton[2].setOnTouchListener(new View.OnTouchListener() {
	
	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		
		lock1 = 0;
		lock4 = 0;
		lock3 = 0;
		lock2 = 2;
		//anim[2].setImageDrawable(getResources().getDrawable(R.drawable.zebracross));
		// TODO Auto-generated method stub
		
		 
	    //zebraTR.setPriority(Thread.MAX_PRIORITY);
	    
		
		switch(event.getAction()){
		case   MotionEvent.ACTION_DOWN:
			animButton[2].setBackgroundResource(R.drawable.paraparc);
			animButton[2].getBackground().setAlpha(80);
			clicks.start();
			//whistle.start();
			break;
		case MotionEvent.ACTION_UP:
			//animButton[2].setBackgroundResource(R.drawable.paraparc);
			//animZebra.start();
			AnimationFuntion(lock2);
			animButton[2].getBackground().setAlpha(255);
			whistle.start();
		    break;
		case MotionEvent.ACTION_MOVE:
			animButton[2].setBackgroundResource(R.drawable.paraparc);
			animButton[2].getBackground().setAlpha(80);
			break;
		default:
			break;
		}

		return false;
	}
});

animButton[3].setOnTouchListener(new View.OnTouchListener() {
	
	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		lock1 = 0;
		lock2 = 0;
		lock4 = 0;
		lock3 = 3;
		//anim[3].setImageDrawable(getResources().getDrawable(R.drawable.crossroad));
		 
	   // crossTR.setPriority(Thread.MAX_PRIORITY);
	   
		// TODO Auto-generated method stub
		
		switch(event.getAction()){
		case   MotionEvent.ACTION_DOWN:
			animButton[3].setBackgroundResource(R.drawable.parapara);
			animButton[3].getBackground().setAlpha(80);
			clicks.start();
			//whistle.start();
			break;
		case MotionEvent.ACTION_UP:
			//animButton[3].setBackgroundResource(R.drawable.parapara);
			//animCross.start();
			AnimationFuntion(lock3);
			animButton[3].getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			animButton[3].setBackgroundResource(R.drawable.parapara);
			animButton[3].getBackground().setAlpha(80);
			break;
		default:
			break;
		}

		return false;
	}
});

animButton[4].setOnTouchListener(new View.OnTouchListener() {
	
	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		lock1 = 0;
		lock2 = 0;
		lock3 = 0;
		lock4 = 4;
		//anim[4].setImageDrawable(getResources().getDrawable(R.drawable.bridge));
		// TODO Auto-generated method stub
		
		 
	   // crossTR.setPriority(Thread.MAX_PRIORITY);
	   
		
		switch(event.getAction()){
		case   MotionEvent.ACTION_DOWN:
			animButton[4].setBackgroundResource(R.drawable.parapard);
			animButton[4].getBackground().setAlpha(80);
			clicks.start();
			//whistle.start();
			break;
		case MotionEvent.ACTION_UP:
			//animButton[4].setBackgroundResource(R.drawable.parapard);
			//animBridge.start();
			AnimationFuntion(lock4);
			animButton[4].getBackground().setAlpha(255);
			whistle.start();
		    break;
		case MotionEvent.ACTION_MOVE:
			animButton[4].setBackgroundResource(R.drawable.parapard);
			animButton[4].getBackground().setAlpha(80);
			break;
		default:
			break;
		}

		return false;
	}
});
		
		
	}
	
	public void AnimationFuntion(int lock) {
		switch(lock){
		case 1: animFoot.start();animZebra.stop();animCross.stop();animBridge.stop();break;
		case 2: animFoot.stop();animZebra.start();animCross.stop();animBridge.stop(); break;
		case 3: animFoot.stop();animZebra.stop();animCross.start();animBridge.stop();break;
		case 4: animFoot.stop();animZebra.stop();animCross.stop();animBridge.start();break;
		default: break;
		}
	}


}

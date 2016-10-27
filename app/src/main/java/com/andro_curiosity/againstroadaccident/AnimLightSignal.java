package com.andro_curiosity.againstroadaccident;


import java.util.ArrayList;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimLightSignal extends Activity {
	TextView tv1,tv2,tv3;
	ImageView im;
	private AnimationDrawable lightAnim;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_anim_light_signal);
		
		ActionBar bar = getActionBar();
		//bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.titlebar));
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		bar.setTitle(R.string.signalbati);
		tv1 = (TextView)findViewById(R.id.redText);
		tv2 = (TextView)findViewById(R.id.yellowText);
		tv3 = (TextView)findViewById(R.id.greenText);
		
		
		MediaPlayer whistle = MediaPlayer.create(AnimLightSignal.this, R.raw.policewhistle);
		whistle.start();
		
		im = (ImageView) findViewById(R.id.AnimLightSignal);
		im.setBackgroundResource(R.drawable.blink);
		lightAnim = (AnimationDrawable)im.getBackground();
		lightAnim.setOneShot(false);
		lightAnim.start();
		//im.setImageDrawable(getResources().getDrawable(R.drawable.blink));
		
		
		tv1.setText(R.string.redST);
		tv2.setText(R.string.yellowST);
		tv3.setText(R.string.greenST);
		
	}

	

}

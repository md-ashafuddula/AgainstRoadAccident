package com.andro_curiosity.againstroadaccident;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.SensorManager;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Emer_Call extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emer__call);
		ActionBar bar = getActionBar();
		//bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.titlebar));
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		bar.setTitle(R.string.app_about);
		
		
		final MediaPlayer whistle = MediaPlayer.create(Emer_Call.this, R.raw.cliclk);
 
		
	
        
	}

}

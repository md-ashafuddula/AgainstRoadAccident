package com.andro_curiosity.againstroadaccident;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.widget.ImageView;

public class Open extends Activity {
	ImageView im;
	private AnimationDrawable lightAnim;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.open_lay);
		ActionBar bar = getActionBar();
		bar.hide();
		//bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.titlebar));
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		im = (ImageView)findViewById(R.id.S1);
		//im.setBackgroundResource(R.drawable.open_anim);
		//lightAnim = (AnimationDrawable)im.getBackground();
		//lightAnim.setOneShot(false);
		//lightAnim.start();
		
		
Thread timer = new Thread(){
			
			public void run(){
				try{
					sleep(3000);
					
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					//lightAnim.stop();
					Intent bak = new Intent(Open.this,MainPage.class);
					startActivity(bak);
				}
			}
			
		};
		
		timer.start();
		
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	
	}


}

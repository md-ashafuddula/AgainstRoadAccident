package com.andro_curiosity.againstroadaccident;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MapShow extends Activity {
	
	private TouchImageView image;
	private static int[] images = { R.drawable.map };
	int index;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_show);
		
		ActionBar bar = getActionBar();
		//bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.titlebar));
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		bar.setTitle(R.string.elaka);
		
		image = (TouchImageView) findViewById(R.id.MapBang);
		index = 0;

		setCurrentImage();
		image.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setCurrentImage();
			}
		});
	}
	
	private void setCurrentImage() {
		image.setImageResource(images[index]);
		//index = (++index % images.length);
	}

}

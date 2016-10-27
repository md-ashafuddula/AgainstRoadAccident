package com.andro_curiosity.againstroadaccident;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.andro_curiosity.againstroadaccident.MailAction.RetreiveFeedTask;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DangerPlace extends Activity {
	Button b[] = new Button[4];
	ProgressDialog pdialog = null;
	Context context = DangerPlace.this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_danger_place);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		bar.setTitle(R.string.elaka);
		final MediaPlayer whistle = MediaPlayer.create(DangerPlace.this, R.raw.cliclk);
		
		b[1] = (Button) findViewById(R.id.WholeMapView);
		b[2] = (Button) findViewById(R.id.RiskLocFind);
		b[3] = (Button) findViewById(R.id.warningAlarm);
				
				b[1].setOnTouchListener(new View.OnTouchListener() {
					
					@Override
					public boolean onTouch(View arg0, MotionEvent event) {
						// TODO Auto-generated method stub
						
						switch(event.getAction()){
						case   MotionEvent.ACTION_DOWN:
							b[1].setBackgroundResource(R.drawable.seelocb);
							b[1].getBackground().setAlpha(200);
							whistle.start();
							break;
						case MotionEvent.ACTION_UP:
							b[1].setBackgroundResource(R.drawable.seeloca);
							Intent ShoMap = new Intent(DangerPlace.this,MapShow.class);
							startActivity(ShoMap);
							b[1].getBackground().setAlpha(255);
						    break;
						case MotionEvent.ACTION_MOVE:
							b[1].setBackgroundResource(R.drawable.seelocb);
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
							b[2].setBackgroundResource(R.drawable.risklocb);
							b[2].getBackground().setAlpha(200);
							whistle.start();
							break;
						case MotionEvent.ACTION_UP:
							b[2].setBackgroundResource(R.drawable.riskloca);
							//Intent DangerArea = new Intent(DangerPlace.this,DangerPlaceByArea.class);
							//startActivity(DangerArea);
							pdialog = ProgressDialog.show(context, "",getString(R.string.waitForArea), true);
							
							RetreiveFeedTask task = new RetreiveFeedTask();
							task.execute();
													
							b[2].getBackground().setAlpha(255);
						    break;
						case MotionEvent.ACTION_MOVE:
							b[2].setBackgroundResource(R.drawable.risklocb);
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
			b[3].setBackgroundResource(R.drawable.warningalarmb);
			b[3].getBackground().setAlpha(200);
			whistle.start();
			break;
		case MotionEvent.ACTION_UP:
			b[3].setBackgroundResource(R.drawable.warningalarma);
			HandlerWarn();
			b[3].getBackground().setAlpha(255);
		    break;
		case MotionEvent.ACTION_MOVE:
			b[3].setBackgroundResource(R.drawable.warningalarmb);
			b[3].getBackground().setAlpha(200);
			break;
		default:
			break;
		}

		return false;
	}
});
		
	}
	public void HandlerWarn(){
		AlertDialog.Builder alertBack = new AlertDialog.Builder(DangerPlace.this);
		
		alertBack.setTitle(R.string.backTitle);
		alertBack.setIcon(R.drawable.warning);
		alertBack.setMessage(R.string.acWarning);
		
		alertBack.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(DangerPlace.this,R.string.active, Toast.LENGTH_SHORT).show();
				Intent warn = new Intent(DangerPlace.this,LocationWarn.class);
				startActivity(warn);
			}
		});
		
		alertBack.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int arg1) {
				// TODO Auto-generated method stub
				dialog.cancel();			
			}
		});
		
		alertBack.show();
		
	}
	class RetreiveFeedTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			
			try{
				Intent DangerArea = new Intent(DangerPlace.this,DangerPlaceByArea.class);
				startActivity(DangerArea);
			} catch(Exception e) {
				e.printStackTrace();
			} 
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			pdialog.dismiss();
			
		}
	}

	

}

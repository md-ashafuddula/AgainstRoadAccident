package com.andro_curiosity.againstroadaccident;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShowPage extends Activity {
	TextView Nextpage,Pno,maxPno;
	int flag,max;
	Button b1,b2;
	//int test = 0;
	int getValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_page);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2f8a66")));
		final MediaPlayer whistle = MediaPlayer.create(ShowPage.this, R.raw.cliclk);
		Nextpage = (TextView)findViewById(R.id.page);
		Pno = (TextView)findViewById(R.id.PageNo);
		maxPno = (TextView)findViewById(R.id.MaxPageNo);
		
		b1 = (Button)findViewById(R.id.back);
		b2 = (Button)findViewById(R.id.go);
		
		flag = 1;
		max = 3;
		getValue = getIntent().getIntExtra("send", 51);
		switch(getValue){
		case 51: bar.setTitle(R.string.ainVongo);Nextpage.setText(R.string.page51a); max = 2; maxPno.setText(R.string.two);Pno.setText(R.string.Cone);b1.getBackground().setAlpha(80);b2.getBackground().setAlpha(255); break;
		case 52: bar.setTitle(R.string.jorimana);Nextpage.setText(R.string.page52a); max = 2; maxPno.setText(R.string.two);Pno.setText(R.string.Cone);b1.getBackground().setAlpha(80);b2.getBackground().setAlpha(255);break;
		case 53: bar.setTitle(R.string.Kagoj);Nextpage.setText(R.string.page53);max = 1; whistle.stop();  maxPno.setText(R.string.one);Pno.setText(R.string.Cone);b1.setBackgroundResource(R.drawable.gap);b2.setBackgroundResource(R.drawable.gap);break;
		case 31: bar.setTitle(R.string.jatri);Nextpage.setText(R.string.PassengerText31);max = 1; whistle.stop();maxPno.setText(R.string.one);Pno.setText(R.string.Cone);b1.setBackgroundResource(R.drawable.gap);b2.setBackgroundResource(R.drawable.gap); break;	
		case 41: bar.setTitle(R.string.pothocari);Nextpage.setText(R.string.footPassers);max = 1;whistle.stop(); maxPno.setText(R.string.one); Pno.setText(R.string.Cone);b1.setBackgroundResource(R.drawable.gap);b2.setBackgroundResource(R.drawable.gap);break;
		
		case 43: bar.setTitle(R.string.jonogon);Nextpage.setText(R.string.GPublic);max = 1;whistle.stop(); maxPno.setText(R.string.one); Pno.setText(R.string.Cone);b1.setBackgroundResource(R.drawable.gap);b2.setBackgroundResource(R.drawable.gap);break;
		case 23: bar.setTitle(R.string.calok);Nextpage.setText(R.string.For23Driver1);max = 2; maxPno.setText(R.string.two); Pno.setText(R.string.Cone);b1.getBackground().setAlpha(80);b2.getBackground().setAlpha(255);break;
		case 24: bar.setTitle(R.string.malik);Nextpage.setText(R.string.For24Owner);max = 1; whistle.stop();maxPno.setText(R.string.one); Pno.setText(R.string.Cone);b1.setBackgroundResource(R.drawable.gap);b2.setBackgroundResource(R.drawable.gap);break;
		case 12: bar.setTitle(R.string.prathomik);Nextpage.setText(R.string.FirstAidST);max = 1; whistle.stop();maxPno.setText(R.string.one);Pno.setText(R.string.Cone);b1.setBackgroundResource(R.drawable.gap);b2.setBackgroundResource(R.drawable.gap); break;
		
		}
		
b1.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					b1.getBackground().setAlpha(80);
					
					whistle.start();
					
					break;
				case MotionEvent.ACTION_UP:
					b1.getBackground().setAlpha(255);
							functionBack();
				    break;
				case MotionEvent.ACTION_MOVE:
					//b2.getBackground().setAlpha(80);
					
					
					break;
				default:
					break;
				}
				return false;
			}

			private void functionBack() {
				// TODO Auto-generated method stub
				if(flag >1 && flag<=max)
					flag -= 1;
				else if(flag > max)
					flag = max - 1; 
				else if(flag == 1 && max > 1){
					Toast.makeText(getApplicationContext(),R.string.BackEnd,Toast.LENGTH_LONG).show();
				}
					
				functionTest(flag,getValue,max);
				
			}

			
		});
		
		
b2.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					b2.getBackground().setAlpha(80);
					whistle.start();
					
					break;
				case MotionEvent.ACTION_UP:
					b2.getBackground().setAlpha(255);
							functionGo();
				    break;
				case MotionEvent.ACTION_MOVE:
					//b2.getBackground().setAlpha(80);
					
					
					break;
				default:
					break;
				}
				return false;
			}

			private void functionGo() {
				// TODO Auto-generated method stub
				if(flag<max )
					flag += 1;
				else if(flag == max && max > 1){
					Toast.makeText(getApplicationContext(),R.string.GoEnd,Toast.LENGTH_LONG).show();
				}
					
				functionTest(flag,getValue,max);		
			}
	
		});
		
	}

	
	public void functionTest(int PageNo, int look,int mx) {
	
		// TODO Auto-generated method stub
		if(look == 51)
		switch(PageNo){
		case 1:  Nextpage.setText(R.string.page51a); Pno.setText(R.string.Cone) ; b1.getBackground().setAlpha(80);b2.getBackground().setAlpha(255);break;
		case 2:  Nextpage.setText(R.string.page51b); Pno.setText(R.string.Ctwo) ; b2.getBackground().setAlpha(80);b1.getBackground().setAlpha(255);break;
		//case 3:  Nextpage.setText(R.string.page51c);   break;
		default: Nextpage.setText(R.string.page51a); Pno.setText(R.string.Cone) ;break;
		}
		else if(look == 53){
			Nextpage.setText(R.string.page53);
			Pno.setText(R.string.Cone) ;
			b1.setBackgroundResource(R.drawable.gap);
			b2.setBackgroundResource(R.drawable.gap);
		}
		else if(look == 52)
				switch(PageNo){
				case 1:  Nextpage.setText(R.string.page52a);  Pno.setText(R.string.Cone) ; b1.getBackground().setAlpha(80);b2.getBackground().setAlpha(255);break;
				case 2:  Nextpage.setText(R.string.page52b);   Pno.setText(R.string.Ctwo) ;b2.getBackground().setAlpha(80);b1.getBackground().setAlpha(255);break;
				//case 3:  Nextpage.setText(R.string.page51c);   break;
				default: Nextpage.setText(R.string.page52a); Pno.setText(R.string.Cone) ;break;
				}
		else if(look == 31){
			Nextpage.setText(R.string.PassengerText31);
			Pno.setText(R.string.Cone) ;
			b1.setBackgroundResource(R.drawable.gap);
			b2.setBackgroundResource(R.drawable.gap);
		}
		else if(look == 41){
			Nextpage.setText(R.string.footPassers);
			Pno.setText(R.string.Cone) ;
			b1.setBackgroundResource(R.drawable.gap);
			b2.setBackgroundResource(R.drawable.gap);
		}
		else if(look == 43){
			Nextpage.setText(R.string.GPublic);
			Pno.setText(R.string.Cone) ;
			b1.setBackgroundResource(R.drawable.gap);
			b2.setBackgroundResource(R.drawable.gap);
		}
		else if(look == 23){
			switch(PageNo){
			case 1:  Nextpage.setText(R.string.For23Driver1);   Pno.setText(R.string.Cone) ;b1.getBackground().setAlpha(80);b2.getBackground().setAlpha(255);break;
			case 2:  Nextpage.setText(R.string.For23Driver2);   Pno.setText(R.string.Ctwo) ;b2.getBackground().setAlpha(80);b1.getBackground().setAlpha(255);break;
			//case 3:  Nextpage.setText(R.string.page51c);   break;
			default: Nextpage.setText(R.string.For23Driver1);Pno.setText(R.string.Cone) ;break;
			}
		}
		else if(look == 24){
			Nextpage.setText(R.string.For24Owner);
			Pno.setText(R.string.Cone) ;
			
			b1.setBackgroundResource(R.drawable.gap);
			b2.setBackgroundResource(R.drawable.gap);
		}
		else if(look == 12){
			Nextpage.setText(R.string.FirstAidST);
			Pno.setText(R.string.Cone) ;
			
			b1.setBackgroundResource(R.drawable.gap);b2.setBackgroundResource(R.drawable.gap);
		}
	}

}

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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RoadSign extends Activity {
	ImageView sign[] = new ImageView[23];
	TextView tx[] = new TextView[23];
	TextView maxPage,ConTpage;
	Button Gos,Backs;
	int flag = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_road_sign);
		
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2f8a66")));
		bar.setTitle(R.string.rastarcinno);
		final MediaPlayer clicks = new MediaPlayer().create(RoadSign.this, R.raw.cliclk);
		
		Gos = (Button)findViewById(R.id.goSign);
		Backs = (Button)findViewById(R.id.backSign);
		maxPage = (TextView) findViewById(R.id.RoadMaxPageNo);
		ConTpage =(TextView) findViewById(R.id.RoadPageNo) ;
		
		
		//set default Page
		maxPage.setText(R.string.five);
		ConTpage.setText(R.string.Cone);
		
		sign[1] = (ImageView)findViewById(R.id.sign1);
		sign[2] = (ImageView)findViewById(R.id.sign2);
		sign[3] = (ImageView)findViewById(R.id.sign3);
		sign[4] = (ImageView)findViewById(R.id.sign4);
		sign[5] = (ImageView)findViewById(R.id.sign5);
		sign[6] = (ImageView)findViewById(R.id.sign6);
		sign[7] = (ImageView)findViewById(R.id.sign7);
		sign[8] = (ImageView)findViewById(R.id.sign8);
		sign[9] = (ImageView)findViewById(R.id.sign9);
		sign[10] = (ImageView)findViewById(R.id.sign10);
		sign[11] = (ImageView)findViewById(R.id.sign11);
		sign[12] = (ImageView)findViewById(R.id.sign12);
		sign[13] = (ImageView)findViewById(R.id.sign13);
		sign[14] = (ImageView)findViewById(R.id.sign14);
		sign[15] = (ImageView)findViewById(R.id.sign15);
		sign[16] = (ImageView)findViewById(R.id.sign16);
		sign[17] = (ImageView)findViewById(R.id.sign17);
		sign[18] = (ImageView)findViewById(R.id.sign18);
		sign[19] = (ImageView)findViewById(R.id.sign19);
		sign[20] = (ImageView)findViewById(R.id.sign20);
		sign[21] = (ImageView)findViewById(R.id.sign21);
		sign[22] = (ImageView)findViewById(R.id.sign22);
		
		tx[1] = (TextView) findViewById(R.id.text1);
		tx[2] = (TextView) findViewById(R.id.text2);
		tx[3] = (TextView) findViewById(R.id.text3);
		tx[4] = (TextView) findViewById(R.id.text4);
		tx[5] = (TextView) findViewById(R.id.text5);
		tx[6] = (TextView) findViewById(R.id.text6);
		tx[7] = (TextView) findViewById(R.id.text7);
		tx[8] = (TextView) findViewById(R.id.text8);
		tx[9] = (TextView) findViewById(R.id.text9);
		tx[10] = (TextView) findViewById(R.id.text10);
		tx[11] = (TextView) findViewById(R.id.text11);		
		tx[12] = (TextView) findViewById(R.id.text12);
		tx[13] = (TextView) findViewById(R.id.text13);
		tx[14] = (TextView) findViewById(R.id.text14);
		tx[15] = (TextView) findViewById(R.id.text15);
		tx[16] = (TextView) findViewById(R.id.text16);
		tx[17] = (TextView) findViewById(R.id.text17);
		tx[18] = (TextView) findViewById(R.id.text18);
		tx[19] = (TextView) findViewById(R.id.text19);
		tx[20] = (TextView) findViewById(R.id.text20);
		tx[21] = (TextView) findViewById(R.id.text21);
		tx[22] = (TextView) findViewById(R.id.text22);
		ViewFunction(flag); //By default show first Page
		
		Gos.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					Gos.getBackground().setAlpha(80);
					
					clicks.start();
					
					break;
				case MotionEvent.ACTION_UP:
					Gos.getBackground().setAlpha(255);
					if(flag <=4 && flag >=1){
						flag++;
						
					}else{
						Toast.makeText(RoadSign.this,R.string.GoEnd , Toast.LENGTH_LONG).show();
					}
							ViewFunction(flag);
				    break;
				case MotionEvent.ACTION_MOVE:
				    Gos.getBackground().setAlpha(80);
					
					
					break;
				default:
					break;
				}
				return false;
			}

			
		});
		
Backs.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					Backs.getBackground().setAlpha(80);
					
					clicks.start();
					
					break;
				case MotionEvent.ACTION_UP:
					Backs.getBackground().setAlpha(255);
					if(flag >=2){
						flag--;
						
					}else{
						Toast.makeText(RoadSign.this,R.string.BackEnd , Toast.LENGTH_LONG).show();
					}
							ViewFunction(flag);
				    break;
				case MotionEvent.ACTION_MOVE:
					Backs.getBackground().setAlpha(80);
					
					
					break;
				default:
					break;
				}
				return false;
			}
		});
		
	}
	
	public void ViewFunction(int fog) {
		
		switch(fog){
		case 1: Page1(); Backs.getBackground().setAlpha(80);Gos.getBackground().setAlpha(255);break;
		case 2: Page2(); Backs.getBackground().setAlpha(255);Gos.getBackground().setAlpha(255);break;
		case 3: Page3(); Backs.getBackground().setAlpha(255);Gos.getBackground().setAlpha(255);break;
		case 4: Page4(); Backs.getBackground().setAlpha(255);Gos.getBackground().setAlpha(255);break;
		case 5: Page5(); Backs.getBackground().setAlpha(255);Gos.getBackground().setAlpha(80);break;
		
		default: Page1(); break;
		}
		
	}

	private void Page5() {
		ConTpage.setText(R.string.Cfive);
		
		sign[1].setBackgroundResource(R.drawable.aaa);
		sign[2].setBackgroundResource(R.drawable.hhhh);
		sign[3].setBackgroundResource(R.drawable.iiii);
		sign[4].setBackgroundResource(R.drawable.jjjj);
		sign[5].setBackgroundResource(R.drawable.kkkk);
		sign[6].setBackgroundResource(R.drawable.llll);
		sign[7].setBackgroundResource(R.drawable.nnnn);
		sign[8].setBackgroundResource(R.drawable.oooo);
		sign[9].setBackgroundResource(R.drawable.pppp);
		sign[10].setBackgroundResource(R.drawable.qqqq);
		sign[11].setBackgroundResource(R.drawable.rr);
		sign[12].setBackgroundResource(R.drawable.gap);
		sign[13].setBackgroundResource(R.drawable.gap);
		sign[14].setBackgroundResource(R.drawable.gap);
		sign[15].setBackgroundResource(R.drawable.gap);
		sign[16].setBackgroundResource(R.drawable.gap);
		sign[17].setBackgroundResource(R.drawable.gap);
		sign[18].setBackgroundResource(R.drawable.gap);
		sign[19].setBackgroundResource(R.drawable.gap);
		sign[20].setBackgroundResource(R.drawable.gap);
		sign[21].setBackgroundResource(R.drawable.gap);
		sign[22].setBackgroundResource(R.drawable.gap);
		
		
		tx[1].setText(R.string.snaaa);
		tx[2].setText(R.string.snhhhh);
		tx[3].setText(R.string.sniiii);
		tx[4].setText(R.string.snjjjj);
		tx[5].setText(R.string.snkkkk);
		tx[6].setText(R.string.snllll);
		tx[7].setText(R.string.snnnnn);
		tx[8].setText(R.string.snoooo);
		tx[9].setText(R.string.snpppp);
		tx[10].setText(R.string.snqqqq);
		tx[11].setText(R.string.snrr);
		tx[12].setText(R.string.GT);
		tx[13].setText(R.string.GT);
		tx[14].setText(R.string.GT);
		tx[15].setText(R.string.GT);
		tx[16].setText(R.string.GT);
		tx[17].setText(R.string.GT);
		tx[18].setText(R.string.GT);
		tx[19].setText(R.string.GT);
		tx[20].setText(R.string.GT);
		tx[21].setText(R.string.GT);
		tx[22].setText(R.string.GT);
	}

	private void Page4() {
		ConTpage.setText(R.string.Cfour);
		sign[1].setBackgroundResource(R.drawable.aaaa);
		sign[2].setBackgroundResource(R.drawable.bbbb);
		sign[3].setBackgroundResource(R.drawable.cccc);
		sign[4].setBackgroundResource(R.drawable.dddd);
		sign[5].setBackgroundResource(R.drawable.eeee);
		sign[6].setBackgroundResource(R.drawable.ffff);
		sign[7].setBackgroundResource(R.drawable.gggg);
		sign[8].setBackgroundResource(R.drawable.lll);
		sign[9].setBackgroundResource(R.drawable.mmm);
		sign[10].setBackgroundResource(R.drawable.nnn);
		sign[11].setBackgroundResource(R.drawable.ooo);
		sign[12].setBackgroundResource(R.drawable.ppp);
		sign[13].setBackgroundResource(R.drawable.qqq);
		sign[14].setBackgroundResource(R.drawable.rrr);
		sign[15].setBackgroundResource(R.drawable.sss);
		sign[16].setBackgroundResource(R.drawable.ttt);
		sign[17].setBackgroundResource(R.drawable.uuu);
		sign[18].setBackgroundResource(R.drawable.vvv);
		sign[19].setBackgroundResource(R.drawable.www);
		sign[20].setBackgroundResource(R.drawable.xxx);
		sign[21].setBackgroundResource(R.drawable.yyy);
		sign[22].setBackgroundResource(R.drawable.zzz);
		
		tx[1].setText(R.string.snaaaa);
		tx[2].setText(R.string.snbbbb);
		tx[3].setText(R.string.sncccc);
		tx[4].setText(R.string.sndddd);
		tx[5].setText(R.string.sneeee);
		tx[6].setText(R.string.snffff);
		tx[7].setText(R.string.sngggg);
		tx[8].setText(R.string.snlll);
		tx[9].setText(R.string.snmmm);
		tx[10].setText(R.string.snnnn);
		tx[11].setText(R.string.snooo);
		tx[12].setText(R.string.snppp);
		tx[13].setText(R.string.snqqq);
		tx[14].setText(R.string.snrrr);
		tx[15].setText(R.string.snsss);
		tx[16].setText(R.string.snttt);
		tx[17].setText(R.string.snuuu);
		tx[18].setText(R.string.snvvv);
		tx[19].setText(R.string.snwww);
		tx[20].setText(R.string.snxxx);
		tx[21].setText(R.string.snyyy);
		tx[22].setText(R.string.snzzz);
		
	}

	private void Page3() {
		ConTpage.setText(R.string.Cthree);
		sign[1].setBackgroundResource(R.drawable.bbb);
		sign[2].setBackgroundResource(R.drawable.ccc);
		sign[3].setBackgroundResource(R.drawable.ddd);
		sign[4].setBackgroundResource(R.drawable.eee);
		sign[5].setBackgroundResource(R.drawable.fff);
		sign[6].setBackgroundResource(R.drawable.ggg);
		sign[7].setBackgroundResource(R.drawable.hhh);
		sign[8].setBackgroundResource(R.drawable.iii);
		sign[9].setBackgroundResource(R.drawable.jjj);
		sign[10].setBackgroundResource(R.drawable.kkk);
		sign[11].setBackgroundResource(R.drawable.nn);
		sign[12].setBackgroundResource(R.drawable.oo);
		sign[13].setBackgroundResource(R.drawable.pp);
		sign[14].setBackgroundResource(R.drawable.qq);
		sign[15].setBackgroundResource(R.drawable.ss);
		sign[16].setBackgroundResource(R.drawable.tt);
		sign[17].setBackgroundResource(R.drawable.uu);
		sign[18].setBackgroundResource(R.drawable.vv);
		sign[19].setBackgroundResource(R.drawable.ww);
		sign[20].setBackgroundResource(R.drawable.xx);
		sign[21].setBackgroundResource(R.drawable.yy);
		sign[22].setBackgroundResource(R.drawable.zz);
		
		tx[1].setText(R.string.snbbb);
		tx[2].setText(R.string.snccc);
		tx[3].setText(R.string.snddd);
		tx[4].setText(R.string.sneee);
		tx[5].setText(R.string.snfff);
		tx[6].setText(R.string.snggg);
		tx[7].setText(R.string.snhhh);
		tx[8].setText(R.string.sniii);
		tx[9].setText(R.string.snjjj);
		tx[10].setText(R.string.snkkk);
		tx[11].setText(R.string.snnn);
		tx[12].setText(R.string.snoo);
		tx[13].setText(R.string.snpp);
		tx[14].setText(R.string.snqq);
		tx[15].setText(R.string.snss);
		tx[16].setText(R.string.sntt);
		tx[17].setText(R.string.snuu);
		tx[18].setText(R.string.snvv);
		tx[19].setText(R.string.snww);
		tx[20].setText(R.string.snxx);
		tx[21].setText(R.string.snyy);
		tx[22].setText(R.string.snzz);		
		
	}

	private void Page2() {
		ConTpage.setText(R.string.Ctwo);
		sign[1].setBackgroundResource(R.drawable.aa);
		sign[2].setBackgroundResource(R.drawable.bb);
		sign[3].setBackgroundResource(R.drawable.dd);
		sign[4].setBackgroundResource(R.drawable.ee);
		sign[5].setBackgroundResource(R.drawable.ff);
		sign[6].setBackgroundResource(R.drawable.gg);
		sign[7].setBackgroundResource(R.drawable.hh);
		sign[8].setBackgroundResource(R.drawable.ii);
		sign[9].setBackgroundResource(R.drawable.kk);
		sign[10].setBackgroundResource(R.drawable.ll);
		sign[11].setBackgroundResource(R.drawable.mm);
		sign[12].setBackgroundResource(R.drawable.n);
		sign[13].setBackgroundResource(R.drawable.o);
		sign[14].setBackgroundResource(R.drawable.p);
		sign[15].setBackgroundResource(R.drawable.q);
		sign[16].setBackgroundResource(R.drawable.r);
		sign[17].setBackgroundResource(R.drawable.t);
		sign[18].setBackgroundResource(R.drawable.u);
		sign[19].setBackgroundResource(R.drawable.v);
		sign[20].setBackgroundResource(R.drawable.w);
		sign[21].setBackgroundResource(R.drawable.x);
		sign[22].setBackgroundResource(R.drawable.y);
		
		tx[1].setText(R.string.snaa);
		tx[2].setText(R.string.snbb);
		tx[3].setText(R.string.sndd);
		tx[4].setText(R.string.snee);
		tx[5].setText(R.string.snff);
		tx[6].setText(R.string.sngg);
		tx[7].setText(R.string.snhh);
		tx[8].setText(R.string.snii);
		tx[9].setText(R.string.snkk);
		tx[10].setText(R.string.snll);
		tx[11].setText(R.string.snmm);
		tx[12].setText(R.string.snn);
		tx[13].setText(R.string.sno);
		tx[14].setText(R.string.snp);
		tx[15].setText(R.string.snq);
		tx[16].setText(R.string.snr);
		tx[17].setText(R.string.snt);
		tx[18].setText(R.string.snu);
		tx[19].setText(R.string.snv);
		tx[20].setText(R.string.snw);
		tx[21].setText(R.string.snx);
		tx[22].setText(R.string.sny);
		
	}

	private void Page1() {
		// TODO Auto-generated method stub
		ConTpage.setText(R.string.Cone);
		sign[1].setBackgroundResource(R.drawable.a);
		sign[2].setBackgroundResource(R.drawable.aaaaa);
		sign[3].setBackgroundResource(R.drawable.b);
		sign[4].setBackgroundResource(R.drawable.c);
		sign[5].setBackgroundResource(R.drawable.cc);
		sign[6].setBackgroundResource(R.drawable.d);
		sign[7].setBackgroundResource(R.drawable.e);
		sign[8].setBackgroundResource(R.drawable.f);
		sign[9].setBackgroundResource(R.drawable.g);
		sign[10].setBackgroundResource(R.drawable.h);
		sign[11].setBackgroundResource(R.drawable.i);
		sign[12].setBackgroundResource(R.drawable.j);
		sign[13].setBackgroundResource(R.drawable.jj);
		sign[14].setBackgroundResource(R.drawable.k);
		sign[15].setBackgroundResource(R.drawable.l);
		sign[16].setBackgroundResource(R.drawable.m);
		sign[17].setBackgroundResource(R.drawable.rrrr);
		sign[18].setBackgroundResource(R.drawable.s);
		sign[19].setBackgroundResource(R.drawable.uuuu);
		sign[20].setBackgroundResource(R.drawable.vvvv);
		sign[21].setBackgroundResource(R.drawable.wwww);
		sign[22].setBackgroundResource(R.drawable.z);
		
		tx[1].setText(R.string.sna);
		tx[2].setText(R.string.snaaaaa);
		tx[3].setText(R.string.snb);
		tx[4].setText(R.string.snc);
		tx[5].setText(R.string.sncc);
		tx[6].setText(R.string.snd);
		tx[7].setText(R.string.sne);
		tx[8].setText(R.string.snf);
		tx[9].setText(R.string.sng);
		tx[10].setText(R.string.snh);
		tx[11].setText(R.string.sni);
		tx[12].setText(R.string.snj);
		tx[13].setText(R.string.snjj);
		tx[14].setText(R.string.snk);
		tx[15].setText(R.string.snl);
		tx[16].setText(R.string.snm);
		tx[17].setText(R.string.snrrrr);
		tx[18].setText(R.string.sns);
		tx[19].setText(R.string.snuuuu);
		tx[20].setText(R.string.snvvvv);
		tx[21].setText(R.string.snwwww);
		tx[22].setText(R.string.snz);
	}


}

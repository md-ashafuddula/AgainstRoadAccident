package com.andro_curiosity.againstroadaccident;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Notification.Action;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.telephony.SmsManager;
import android.text.InputFilter.LengthFilter;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MMSsend extends Activity implements AdapterView.OnItemSelectedListener{
	Button sendMMs,sendEmail,selectIm;
	EditText nameCL,phnCL,comCL;
	Spinner division,district;
	TextView imPath;
	Uri imageUri = null;
	public String officePhn="",officeMail="";

	String[] distrArray ;
	 final int RQS_LOADIMAGE = 0;
	 final int RQS_SENDEMAIL = 1;
	 
	 String name=null,phn=null,comp=null,atUri=null,atType=null;
	 int Ln_name,ln_phn,ln_comp,ln_atUri,ln_atType;
	 public static int pos_1,pos_2;
	 
	 int got = 1,photoCK = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mmssend);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		bar.setTitle(R.string.ovi_likhun);
		final MediaPlayer whistle = MediaPlayer.create(MMSsend.this, R.raw.cliclk);
		
		sendMMs = (Button) findViewById(R.id.OfflineUse);
		sendEmail = (Button) findViewById(R.id.onlineUse);
		selectIm = (Button) findViewById(R.id.selectimageMMS);
		nameCL = (EditText) findViewById(R.id.ClientName);
		phnCL = (EditText) findViewById(R.id.ClientPhnNo);
		comCL = (EditText) findViewById(R.id.ClientComplain);
		imPath = (TextView) findViewById(R.id.imagepath);
		
		division = (Spinner) findViewById(R.id.OfflineSnipDivision);
		String[] diviArray = getResources().getStringArray(R.array.Division);		
		ArrayAdapter<String> divAdap = new ArrayAdapter<String>(MMSsend.this,R.layout.custom_spinner, diviArray);
		divAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		division.setAdapter(divAdap);

		division.setOnItemSelectedListener(this);
		
		
		//atType = ;
		
		int flag = 0;
		//0 wrong -> 1 right
		sendMMs.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				try{
					name = nameCL.getText().toString(); 
					phn = phnCL.getText().toString(); 
					comp = comCL.getText().toString(); 
					atType = "image/jpeg";
					}catch(Exception e){
						Toast.makeText(MMSsend.this,R.string.warning, Toast.LENGTH_SHORT).show();
					}
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					sendMMs.setBackgroundResource(R.drawable.offlineb);
					sendMMs.getBackground().setAlpha(200);
					whistle.start();
					break;
				case MotionEvent.ACTION_UP:
					sendMMs.setBackgroundResource(R.drawable.offlinea);
					findContactInfo(pos_1,pos_2);
						Toast.makeText(MMSsend.this, officePhn+" "+officeMail, Toast.LENGTH_SHORT).show();
					checkInput();
					if(got == 1){
						if(photoCK == 1)
						{
							try{
								Intent  sendMMS = new Intent(Intent.ACTION_SEND);
								//sendMMS.setClassName("com.android.mms", "com.android.mms.ui.ComposeMessageActivity");
								sendMMS.putExtra("address", officePhn);
								sendMMS.putExtra("sms_body","User Name :"+name+"\nMo: "+phn+"\nComplain: "+comp );
								sendMMS.putExtra(Intent.EXTRA_STREAM, Uri.parse(atUri));
								sendMMS.setType(atType);
								sendMMS.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								startActivity(sendMMS);
								Toast.makeText(MMSsend.this, R.string.SuccessMMS, Toast.LENGTH_SHORT).show();
								}catch(Exception ex){
									Toast.makeText(MMSsend.this, R.string.warningIntent, Toast.LENGTH_SHORT).show();
								}
						}else{
							try {
								SmsManager smsManager = SmsManager.getDefault();
								smsManager.sendTextMessage(officePhn, null, "User Name :"+name+"\nMo: "+phn+"\nComplain: "+comp, null, null);
								Toast.makeText(getApplicationContext(),R.string.SuccessSMS,Toast.LENGTH_LONG).show();
							  } catch (Exception e) {
								Toast.makeText(getApplicationContext(),R.string.FaildSMS,Toast.LENGTH_LONG).show();
							  }							
						}
					}else{
						Toast.makeText(MMSsend.this,R.string.warningForInfo, Toast.LENGTH_SHORT).show();
					}
					sendMMs.getBackground().setAlpha(255);
				    break;
				case MotionEvent.ACTION_MOVE:
					sendMMs.setBackgroundResource(R.drawable.offlineb);
					sendMMs.getBackground().setAlpha(200);
					break;
				default:
					break;
				}

				return false;
			}

			
		});
		
sendEmail.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				try{
					name = nameCL.getText().toString(); 
					phn = phnCL.getText().toString(); 
					comp = comCL.getText().toString(); 
					atType = "image/jpeg";
					}catch(Exception e){
						Toast.makeText(MMSsend.this,R.string.warning, Toast.LENGTH_SHORT).show();
					}
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					sendEmail.setBackgroundResource(R.drawable.onlineb);
					sendEmail.getBackground().setAlpha(200);
					findContactInfo(pos_1,pos_2);
					whistle.start();
					break;
				case MotionEvent.ACTION_UP:
					sendEmail.setBackgroundResource(R.drawable.onlinea);					
					sendEmail.getBackground().setAlpha(255);
					if(photoCK != 1)
						Toast.makeText(MMSsend.this,R.string.warning_mail, Toast.LENGTH_SHORT).show();
					else{
					try{
						//name = nameCL.getText().toString(); 
						//phn = phnCL.getText().toString(); 
						//comp = comCL.getText().toString(); 
						Bundle stForMail = new Bundle();
						stForMail.putString("key1", name);
						stForMail.putString("key2", phn);
						stForMail.putString("key3", comp);
						stForMail.putString("key4", officeMail);
						stForMail.putString("key5", atUri);
						
						Intent ToEmail = new Intent(MMSsend.this,MailAction.class);
						ToEmail.putExtras(stForMail);
						startActivity(ToEmail);
					}catch(Exception e){
						Toast.makeText(MMSsend.this,R.string.warningForInfo, Toast.LENGTH_SHORT).show();
					}
				}
				    break;
				case MotionEvent.ACTION_MOVE:
					sendEmail.setBackgroundResource(R.drawable.onlineb);
					sendEmail.getBackground().setAlpha(200);
					break;
				default:
					break;
				}

				return false;
			}

		});

selectIm.setOnTouchListener(new View.OnTouchListener() {
	
	@Override
	public boolean onTouch(View arg0, MotionEvent event) {
		// TODO Auto-generated method stub
		
		switch(event.getAction()){
		case   MotionEvent.ACTION_DOWN:
			selectIm.getBackground().setAlpha(80);
			whistle.start();
			break;
		case MotionEvent.ACTION_UP:			
			selectIm.getBackground().setAlpha(255);
			Intent ImSelect = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(ImSelect,RQS_LOADIMAGE);
		    break;
		case MotionEvent.ACTION_MOVE:
			selectIm.getBackground().setAlpha(80);
			break;
		default:
			break;
		}

		return false;
	}
});


	}
	
	
	

	//@Override
	public void onItemSelected(AdapterView<?> parent, View arg1, int position,
			long arg3) {
		CallSpinnerTwo(position);
		Toast.makeText(MMSsend.this,parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
		//Toast.makeText(this, pos_2, Toast.LENGTH_SHORT).show();
	}
	//@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	

	private void CallSpinnerTwo(int position) {
		district = (Spinner) findViewById(R.id.OfflineSnipDistricts);
		distrArray = getResources().getStringArray(R.array.Dhaka);
		pos_1 = position;
		switch(position){
		case 0:distrArray = getResources().getStringArray(R.array.Dhaka); break;
		case 1: distrArray = getResources().getStringArray(R.array.CTG);break;
		case 2: distrArray = getResources().getStringArray(R.array.Barishal);break;
		case 3: distrArray = getResources().getStringArray(R.array.Rajshahi);break;
		case 4: distrArray = getResources().getStringArray(R.array.khulna);break;
		case 5: distrArray = getResources().getStringArray(R.array.sylhet);break;
		default: distrArray = getResources().getStringArray(R.array.Dhaka);break;
		}
		
		ArrayAdapter<String> disAdap = new ArrayAdapter<String>(MMSsend.this,R.layout.custom_spinner,distrArray);
		disAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		district.setAdapter(disAdap);
		int st = Integer.valueOf(district.getSelectedItemPosition());
		//imPath.setText(st);
		district.setOnItemSelectedListener(new DistrictSnipper());
		
		DistrictSnipper SnipPos = new DistrictSnipper();
		//pos_2 = st;//SnipPos.pos_2 ;
		
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if (resultCode == RESULT_OK){
			switch(requestCode){
			case RQS_LOADIMAGE:
				imageUri = data.getData();
				imPath.setText(imageUri.toString());
				atUri = imPath.getText().toString();
				
				ln_atUri = atUri.length();
				if(ln_atUri != 0)photoCK = 1;
				break;
			case RQS_SENDEMAIL:
				
				break;
			}
				
		}
	}
	
	private void checkInput() {
		 Ln_name = name.length();
		 ln_phn = phn.length();
		 ln_comp = comCL.length();
		 		 
		 //if(Ln_name <3 || ln_phn < 11 || ln_comp < 10){
			// got = 0;
		 //}
		
	}
	protected void findContactInfo(int pos_1, int pos_2) {
		// TODO Auto-generated method stub
		switch(pos_1){
		case 0: functionDhaka(pos_2);break;
		case 1: functionCtg(pos_2);break;
		case 2: functionBarisal(pos_2);break;
		case 3: functionRajshahi(pos_2);break;
		case 4: functionKhulna(pos_2);break;
		case 5: functionSylhet(pos_2);break;
		default: functionDhaka(pos_2);break;
		
		}
		
	}




	private void functionSylhet(int pos_22) {
		// TODO Auto-generated method stub
		switch(pos_22){
		case 0:  officePhn="01966622083";officeMail="ad_sylhet@brta.gov.bd";break;
		case 1:  officePhn="01966622085";officeMail="ad_moulovibazar@brta.gov.bd";break;
		case 2:  officePhn="01966622086";officeMail="ad_sunamganj@brta.gov.bd";break;
		case 3:  officePhn="01966622084";officeMail="ad_habiganj@brta.gov.bd";break;
		default: officePhn="01966622083";officeMail="ad_sylhet@brta.gov.bd";break;
		}
		
	}




	private void functionKhulna(int pos_22) {
		switch(pos_22){
		case 0:  officePhn="01966622075";officeMail="ad_khulna@brta.gov.bd";break;
		case 1:  officePhn="01966622081";officeMail="ad_kushtia@brta.gov.bd";break;
		case 2:  officePhn="01966622082";officeMail="ad_chuadanga@brta.gov.bd";break;
		case 3:  officePhn="01966622079";officeMail="ad_jhenaidaha@brta.gov.bd";break;
		default: officePhn="01966622075";officeMail="ad_khulna@brta.gov.bd";break;
		}
		
	}




	private void functionRajshahi(int pos_22) {
		switch(pos_22){
		case 0:  officePhn="01966622061";officeMail="ad_rajshahi@brta.gov.bd";break;
		case 1:  officePhn="01966622064";officeMail="ad_bogra@brta.gov.bd";break;
		case 2:  officePhn="01966622067";officeMail="ad_pabna@brta.gov.bd";break;
		case 3:  officePhn="01966622063";officeMail="ad_natore@brta.gov.bd";break;
		case 4:  officePhn="0196622066";officeMail="ad_naogaon@brta.gov.bd";break;
		case 5:  officePhn="01966622062";officeMail="ad_chapai@brta.gov.bd";break;
		case 6:  officePhn="01966622068";officeMail="ad_sirajgonj@brta.gov.bd";break;
		case 7:  officePhn="0196622065";officeMail="ad_joypurhat@brta.gov.bd";break;
		default: officePhn="01966622061";officeMail="ad_rajshahi@brta.gov.bd";break;
		}
		
	}




	private void functionBarisal(int pos_22) {
		switch(pos_22){
		case 0:  officePhn="01966622087";officeMail="ad_barisal@brta.gov.bd";break;
		case 1:  officePhn="01966622090";officeMail="ad_bhola@brta.gov.bd";break;
		case 2:  officePhn="01966622089";officeMail="ad_patuakhali@brta.gov.bd";break;
		case 3:  officePhn="01966622088";officeMail="ad_jhalokathi@brta.gov.bd";break;
		case 4:  officePhn="01966622088";officeMail="ad_pirojpur@brta.gov.bd";break;
		case 5:  officePhn="01966622089";officeMail="ad_barguna @brta.gov.bd";break;
		default: officePhn="01966622087";officeMail="ad_barisal@brta.gov.bd";break;
		}
		
	}




	private void functionCtg(int pos_22) {
		switch(pos_22){
		case 0:  officePhn="01966622048";officeMail="ad_ctg_metro@brta.gov.bd";break;
		case 1:  officePhn="01966622050";officeMail="ad1_ctg@brta.gov.bd";break;
		case 2:  officePhn="01966622058";officeMail="ad_comilla@brta.gov.bd";break;
		case 3:  officePhn="01966622059";officeMail="ad_chandpur@brta.gov.bd";break;
		case 4:  officePhn="01966622057";officeMail="ad_lakshmipur@brta.gov.bd";break;
		case 5:  officePhn="01966622055";officeMail="ad_noakhali@brta.gov.bd";break;
		case 6:  officePhn="01966622056";officeMail="ad_feni@brta.gov.bd";break;
		default: officePhn="01966622048";officeMail="ad_ctg_metro@brta.gov.bd";break;
		}
		
	}




	private void functionDhaka(int pos_22) {
		switch(pos_22){
		case 0:  officePhn="01932082303";officeMail="obak009@gmail.com";break;
		//case 0:  officePhn="01966622030";officeMail="ad_dhaka_south@brta.gov.bd";break;
		case 1:  officePhn="01966622033";officeMail="ad_narayanganj@brta.gov.bd";break;
		case 2:  officePhn="01966622036";officeMail="ad_gazipur@brta.gov.bd";break;
		case 3:  officePhn="01966622041";officeMail="ad_tangail@brta.gov.bd";break;
		case 4:  officePhn="0196622044";officeMail="ad_faridpur@brta.gov.bd";break;
		case 5:  officePhn="01966622038";officeMail="ad_mymensingh@brta.gov.bd";break;
		case 6:  officePhn="01966622039";officeMail="ad_kishoreganj@brta.gov.bd";break;
		case 7:  officePhn="0196622042";officeMail="ad_jamalpur@brta.gov.bd";break;
		case 8:  officePhn="01966622045";officeMail="ad_gopalganj@brta.gov.bd";break;
		default: officePhn="01966622030";officeMail="ad_dhaka_south@brta.gov.bd";break;
		}
	}
	
	


}

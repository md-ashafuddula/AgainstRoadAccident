package com.andro_curiosity.againstroadaccident;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MailAction extends Activity {
	String Uname,Uphn,Ucompl,OfficeMailAd;
	EditText U_mail,Upw,UmailSubj;
	Button send_eMail;
	String getUserMail,getUserPw,getSub,imageUri,imType;
	
	Session session = null;
	ProgressDialog pdialog = null;
	Context context = null;
	String nl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mail_action);
		ActionBar bar = getActionBar();
		bar.setTitle(R.string.mailLikhun);
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		
		context = this;
		U_mail = (EditText)findViewById(R.id.UMail);
		Upw = (EditText)findViewById(R.id.UPassWord);
		send_eMail = (Button)findViewById(R.id.sendMail);
		UmailSubj = (EditText) findViewById(R.id.UMailSub);
		final MediaPlayer whistle = MediaPlayer.create(MailAction.this, R.raw.cliclk);
		
		Bundle getIn = getIntent().getExtras();
		
		Uname = getIn.getString("key1");
		Uphn = getIn.getString("key2");
		Ucompl = getIn.getString("key3");
		OfficeMailAd = getIn.getString("key4");
		imageUri =getIn.getString("key5");
		imType = "image/jpg";
		nl = "file";
		for(int i = 7; i < imageUri.length();i++){
			nl +=imageUri.charAt(i); 
		}
		nl +=".jpeg";
		Toast.makeText(MailAction.this,Uname+" "+" "+OfficeMailAd+Uphn+" "+Ucompl, Toast.LENGTH_SHORT).show();
		
		send_eMail.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case   MotionEvent.ACTION_DOWN:
					send_eMail.setBackgroundResource(R.drawable.sendb);
					send_eMail.getBackground().setAlpha(200);
					getFromUser();
					whistle.start();
					break;
				case MotionEvent.ACTION_UP:
					send_eMail.setBackgroundResource(R.drawable.senda);
					sentAtMailBox();
					send_eMail.getBackground().setAlpha(255);
				    break;
				case MotionEvent.ACTION_MOVE:
					send_eMail.setBackgroundResource(R.drawable.sendb);
					send_eMail.getBackground().setAlpha(200);
					break;
				default:
					break;
				}

				return false;
			}

			
		});
		
	}
	
	private void getFromUser() {
		getUserMail = U_mail.getText().toString();	
		getUserPw = Upw.getText().toString();
		getSub = UmailSubj.getText().toString();
		Toast.makeText(MailAction.this,getSub+" "+getUserMail+" "+getUserPw, Toast.LENGTH_SHORT).show();
		
	}
	private void sentAtMailBox() {
		//rec = reciep.getText().toString(); office
		//subject = sub.getText().toString(); getSub
		//textMessage = msg.getText().toString(); getUserMail
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(getUserMail, getUserPw);
			}
		});
		
		pdialog = ProgressDialog.show(context, "",getString(R.string.mailSendin), true);
		
		RetreiveFeedTask task = new RetreiveFeedTask();
		task.execute();
		
	}
	class RetreiveFeedTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			
			try{
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(getUserMail));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(OfficeMailAd));
				message.setSubject(getSub);
				message.setFileName(nl);
				message.setContent(Ucompl, "text/html; charset=utf-8");
				Transport.send(message);
			} catch(MessagingException e) {
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			pdialog.dismiss();
			U_mail.setText("");
			Upw.setText("");
			UmailSubj.setText("");
			Toast.makeText(getApplicationContext(), R.string.SuccessMail+" "+nl, Toast.LENGTH_LONG).show();
		}
	}

	

}

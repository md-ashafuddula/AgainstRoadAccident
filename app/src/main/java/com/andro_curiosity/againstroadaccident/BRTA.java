package com.andro_curiosity.againstroadaccident;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class BRTA extends Activity {
	private String curURL = "http://www.brta.gov.bd/component/content/article/2-latest/136-2015-03-11-04-05-34.html";
	WebView mWebView;
	ProgressBar pr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_brta);
		
		ActionBar bar = getActionBar();
		//bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.titlebar));
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		bar.setTitle(R.string.brTaName);
		mWebView = (WebView) findViewById(R.id.BrtaWeb);
		pr = (ProgressBar)findViewById(R.id.prBrta);
		
		
		mWebView.setWebViewClient(new myWebClient());
	    mWebView.getSettings().setJavaScriptEnabled(true);
	    
	    	mWebView.loadUrl(curURL);	    	    
		
	}

	public class myWebClient extends WebViewClient
    {
    	@Override
    	public void onPageStarted(WebView view, String url, Bitmap favicon) {
    		// TODO Auto-generated method stub
    		//pr.setVisibility(View.VISIBLE);
    		Toast.makeText(BRTA.this,R.string.Load,Toast.LENGTH_LONG).show();
    		super.onPageStarted(view, url, favicon);
    	}
    	@Override
    	public boolean shouldOverrideUrlLoading(WebView view, String url) {
    		// TODO Auto-generated method stub
    		view.loadUrl(url);
    		return true;
    	}	
    	@Override
    	public void onPageFinished(WebView view, String url) {
    		// TODO Auto-generated method stub
    		pr.setVisibility(View.GONE);
    		super.onPageFinished(view, url);
    	
    	}
    }

}

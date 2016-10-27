package com.andro_curiosity.againstroadaccident;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class DistrictSnipper implements OnItemSelectedListener {

	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		Toast.makeText(parent.getContext(), parent.getItemAtPosition(pos).toString(),
				Toast.LENGTH_SHORT).show();
		MMSsend get = new MMSsend();
		get.pos_2 = pos;
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}
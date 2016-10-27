package com.andro_curiosity.againstroadaccident;

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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DangerPlaceByArea extends Activity implements AdapterView.OnItemSelectedListener{
	
	TextView pl[] = new TextView[196];
	TextView pageno1,pageno2;
	Button goPl,backPl;
	Spinner titleSpot;
	int max = 2,min = 1,flag = 1;
	static int pos = 12;
	
	ProgressDialog pdialog = null;
	Context context = DangerPlaceByArea.this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_danger_place_by_area);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#76a376")));
		bar.setTitle(R.string.elakaSomuh);
		/*goPl = (Button) findViewById(R.id.dango);
		backPl = (Button) findViewById(R.id.danback);
		pageno1 = (TextView) findViewById(R.id.danPageNo);
		pageno2 = (TextView) findViewById(R.id.danMaxPageNo);
		*/
		
		
		titleSpot = (Spinner) findViewById(R.id.BlackSpotTitleID);
		
		String[] spot = getResources().getStringArray(R.array.TitleBlack);		
		ArrayAdapter<String> divAdap = new ArrayAdapter<String>(DangerPlaceByArea.this,R.layout.custom_spinner, spot);
		divAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		titleSpot.setAdapter(divAdap);
		
		
		//Spot_0(flag);
		titleSpot.setOnItemSelectedListener(this);
		
		
		pl[1] = (TextView) findViewById(R.id.Row1place0);
		pl[2] = (TextView) findViewById(R.id.Row1place1);
		pl[3] = (TextView) findViewById(R.id.Row1place2);
		pl[4] = (TextView) findViewById(R.id.Row1place3);
		pl[5] = (TextView) findViewById(R.id.Row1place4);
		
		pl[6] = (TextView) findViewById(R.id.Row2place0);
		pl[7] = (TextView) findViewById(R.id.Row2place1);
		pl[8] = (TextView) findViewById(R.id.Row2place2);
		pl[9] = (TextView) findViewById(R.id.Row2place3);
		pl[10] = (TextView) findViewById(R.id.Row2place4);
		
		pl[11] = (TextView) findViewById(R.id.Row3place0);
		pl[12] = (TextView) findViewById(R.id.Row3place1);
		pl[13] = (TextView) findViewById(R.id.Row3place2);
		pl[14] = (TextView) findViewById(R.id.Row3place3);
		pl[15] = (TextView) findViewById(R.id.Row3place4);
		
		pl[16] = (TextView) findViewById(R.id.Row4place0);
		pl[17] = (TextView) findViewById(R.id.Row4place1);
		pl[18] = (TextView) findViewById(R.id.Row4place2);
		pl[19] = (TextView) findViewById(R.id.Row4place3);
		pl[20] = (TextView) findViewById(R.id.Row4place4);
		
		pl[21] = (TextView) findViewById(R.id.Row5place0);
		pl[22] = (TextView) findViewById(R.id.Row5place1);
		pl[23] = (TextView) findViewById(R.id.Row5place2);
		pl[24] = (TextView) findViewById(R.id.Row5place3);
		pl[25] = (TextView) findViewById(R.id.Row5place4);
		
		pl[26] = (TextView) findViewById(R.id.Row6place0);
		pl[27] = (TextView) findViewById(R.id.Row6place1);
		pl[28] = (TextView) findViewById(R.id.Row6place2);
		pl[29] = (TextView) findViewById(R.id.Row6place3);
		pl[30] = (TextView) findViewById(R.id.Row6place4);
		
		pl[31] = (TextView) findViewById(R.id.Row7place0);
		pl[32] = (TextView) findViewById(R.id.Row7place1);
		pl[33] = (TextView) findViewById(R.id.Row7place2);
		pl[34] = (TextView) findViewById(R.id.Row7place3);
		pl[35] = (TextView) findViewById(R.id.Row7place4);
		
		pl[36] = (TextView) findViewById(R.id.Row8place0);
		pl[37] = (TextView) findViewById(R.id.Row8place1);
		pl[38] = (TextView) findViewById(R.id.Row8place2);
		pl[39] = (TextView) findViewById(R.id.Row8place3);
		pl[40] = (TextView) findViewById(R.id.Row8place4);
		
		pl[41] = (TextView) findViewById(R.id.Row9place0);
		pl[42] = (TextView) findViewById(R.id.Row9place1);
		pl[43] = (TextView) findViewById(R.id.Row9place2);
		pl[44] = (TextView) findViewById(R.id.Row9place3);
		pl[45] = (TextView) findViewById(R.id.Row9place4);
		
		pl[46] = (TextView) findViewById(R.id.Row10place0);
		pl[47] = (TextView) findViewById(R.id.Row10place1);
		pl[48] = (TextView) findViewById(R.id.Row10place2);
		pl[49] = (TextView) findViewById(R.id.Row10place3);
		pl[50] = (TextView) findViewById(R.id.Row10place4);
		
		pl[51] = (TextView) findViewById(R.id.Row11place0);
		pl[52] = (TextView) findViewById(R.id.Row11place1);
		pl[53] = (TextView) findViewById(R.id.Row11place2);
		pl[54] = (TextView) findViewById(R.id.Row11place3);
		pl[55] = (TextView) findViewById(R.id.Row11place4);
		
		pl[56] = (TextView) findViewById(R.id.Row12place0);
		pl[57] = (TextView) findViewById(R.id.Row12place1);
		pl[58] = (TextView) findViewById(R.id.Row12place2);
		pl[59] = (TextView) findViewById(R.id.Row12place3);
		pl[60] = (TextView) findViewById(R.id.Row12place4);
		
		pl[61] = (TextView) findViewById(R.id.Row13place0);
		pl[62] = (TextView) findViewById(R.id.Row13place1);
		pl[63] = (TextView) findViewById(R.id.Row13place2);
		pl[64] = (TextView) findViewById(R.id.Row13place3);
		pl[65] = (TextView) findViewById(R.id.Row13place4);
		
		pl[66] = (TextView) findViewById(R.id.Row14place0);
		pl[67] = (TextView) findViewById(R.id.Row14place1);
		pl[68] = (TextView) findViewById(R.id.Row14place2);
		pl[69] = (TextView) findViewById(R.id.Row14place3);
		pl[70] = (TextView) findViewById(R.id.Row14place4);
		
		pl[71] = (TextView) findViewById(R.id.Row15place0);
		pl[72] = (TextView) findViewById(R.id.Row15place1);
		pl[73] = (TextView) findViewById(R.id.Row15place2);
		pl[74] = (TextView) findViewById(R.id.Row15place3);
		pl[75] = (TextView) findViewById(R.id.Row15place4);
		
		pl[76] = (TextView) findViewById(R.id.Row16place0);
		pl[77] = (TextView) findViewById(R.id.Row16place1);
		pl[78] = (TextView) findViewById(R.id.Row16place2);
		pl[79] = (TextView) findViewById(R.id.Row16place3);
		pl[80] = (TextView) findViewById(R.id.Row16place4);
		
		pl[81] = (TextView) findViewById(R.id.Row17place0);
		pl[82] = (TextView) findViewById(R.id.Row17place1);
		pl[83] = (TextView) findViewById(R.id.Row17place2);
		pl[84] = (TextView) findViewById(R.id.Row17place3);
		pl[85] = (TextView) findViewById(R.id.Row17place4);
		
		pl[86] = (TextView) findViewById(R.id.Row18place0);
		pl[87] = (TextView) findViewById(R.id.Row18place1);
		pl[88] = (TextView) findViewById(R.id.Row18place2);
		pl[89] = (TextView) findViewById(R.id.Row18place3);
		pl[90] = (TextView) findViewById(R.id.Row18place4);
		
		pl[96] = (TextView) findViewById(R.id.Row20place0);
		pl[97] = (TextView) findViewById(R.id.Row20place1);
		pl[98] = (TextView) findViewById(R.id.Row20place2);
		pl[99] = (TextView) findViewById(R.id.Row20place3);
		pl[100] = (TextView) findViewById(R.id.Row20place4);
		
		pl[101] = (TextView) findViewById(R.id.Row21place0);
		pl[102] = (TextView) findViewById(R.id.Row21place1);
		pl[103] = (TextView) findViewById(R.id.Row21place2);
		pl[104] = (TextView) findViewById(R.id.Row21place3);
		pl[105] = (TextView) findViewById(R.id.Row21place4);
		
		pl[106] = (TextView) findViewById(R.id.Row22place0);
		pl[107] = (TextView) findViewById(R.id.Row22place1);
		pl[108] = (TextView) findViewById(R.id.Row22place2);
		pl[109] = (TextView) findViewById(R.id.Row22place3);
		pl[110] = (TextView) findViewById(R.id.Row22place4);
		
		pl[111] = (TextView) findViewById(R.id.Row23place0);
		pl[112] = (TextView) findViewById(R.id.Row23place1);
		pl[113] = (TextView) findViewById(R.id.Row23place2);
		pl[114] = (TextView) findViewById(R.id.Row23place3);
		pl[115] = (TextView) findViewById(R.id.Row23place4);
		
		pl[116] = (TextView) findViewById(R.id.Row24place0);
		pl[117] = (TextView) findViewById(R.id.Row24place1);
		pl[118] = (TextView) findViewById(R.id.Row24place2);
		pl[119] = (TextView) findViewById(R.id.Row24place3);
		pl[120] = (TextView) findViewById(R.id.Row24place4);
		
		pl[121] = (TextView) findViewById(R.id.Row25place0);
		pl[122] = (TextView) findViewById(R.id.Row25place1);
		pl[123] = (TextView) findViewById(R.id.Row25place2);
		pl[124] = (TextView) findViewById(R.id.Row25place3);
		pl[125] = (TextView) findViewById(R.id.Row25place4);
		
		pl[126] = (TextView) findViewById(R.id.Row26place0);
		pl[127] = (TextView) findViewById(R.id.Row26place1);
		pl[128] = (TextView) findViewById(R.id.Row26place2);
		pl[129] = (TextView) findViewById(R.id.Row26place3);
		pl[130] = (TextView) findViewById(R.id.Row26place4);
		
		pl[131] = (TextView) findViewById(R.id.Row27place0);
		pl[132] = (TextView) findViewById(R.id.Row27place1);
		pl[133] = (TextView) findViewById(R.id.Row27place2);
		pl[134] = (TextView) findViewById(R.id.Row27place3);
		pl[135] = (TextView) findViewById(R.id.Row27place4);
		
		pl[136] = (TextView) findViewById(R.id.Row28place0);
		pl[137] = (TextView) findViewById(R.id.Row28place1);
		pl[138] = (TextView) findViewById(R.id.Row28place2);
		pl[139] = (TextView) findViewById(R.id.Row28place3);
		pl[140] = (TextView) findViewById(R.id.Row28place4);
		
		pl[141] = (TextView) findViewById(R.id.Row29place0);
		pl[142] = (TextView) findViewById(R.id.Row29place1);
		pl[143] = (TextView) findViewById(R.id.Row29place2);
		pl[144] = (TextView) findViewById(R.id.Row29place3);
		pl[145] = (TextView) findViewById(R.id.Row29place4);
		
		pl[146] = (TextView) findViewById(R.id.Row30place0);
		pl[147] = (TextView) findViewById(R.id.Row30place1);
		pl[148] = (TextView) findViewById(R.id.Row30place2);
		pl[149] = (TextView) findViewById(R.id.Row30place3);
		pl[150] = (TextView) findViewById(R.id.Row30place4);
		
		pl[151] = (TextView) findViewById(R.id.Row31place0);
		pl[152] = (TextView) findViewById(R.id.Row31place1);
		pl[153] = (TextView) findViewById(R.id.Row31place2);
		pl[154] = (TextView) findViewById(R.id.Row31place3);
		pl[155] = (TextView) findViewById(R.id.Row31place4);
		
		pl[156] = (TextView) findViewById(R.id.Row32place0);
		pl[157] = (TextView) findViewById(R.id.Row32place1);
		pl[158] = (TextView) findViewById(R.id.Row32place2);
		pl[159] = (TextView) findViewById(R.id.Row32place3);
		pl[160] = (TextView) findViewById(R.id.Row32place4);
		
		pl[161] = (TextView) findViewById(R.id.Row33place0);
		pl[162] = (TextView) findViewById(R.id.Row33place1);
		pl[163] = (TextView) findViewById(R.id.Row33place2);
		pl[164] = (TextView) findViewById(R.id.Row33place3);
		pl[165] = (TextView) findViewById(R.id.Row33place4);
		
		pl[166] = (TextView) findViewById(R.id.Row34place0);
		pl[167] = (TextView) findViewById(R.id.Row34place1);
		pl[168] = (TextView) findViewById(R.id.Row34place2);
		pl[169] = (TextView) findViewById(R.id.Row34place3);
		pl[170] = (TextView) findViewById(R.id.Row34place4);
		
		pl[171] = (TextView) findViewById(R.id.Row35place0);
		pl[172] = (TextView) findViewById(R.id.Row35place1);
		pl[173] = (TextView) findViewById(R.id.Row35place2);
		pl[174] = (TextView) findViewById(R.id.Row35place3);
		pl[175] = (TextView) findViewById(R.id.Row35place4);
		
		pl[176] = (TextView) findViewById(R.id.Row36place0);
		pl[177] = (TextView) findViewById(R.id.Row36place1);
		pl[178] = (TextView) findViewById(R.id.Row36place2);
		pl[179] = (TextView) findViewById(R.id.Row36place3);
		pl[180] = (TextView) findViewById(R.id.Row36place4);
		
		pl[181] = (TextView) findViewById(R.id.Row37place0);
		pl[182] = (TextView) findViewById(R.id.Row37place1);
		pl[183] = (TextView) findViewById(R.id.Row37place2);
		pl[184] = (TextView) findViewById(R.id.Row37place3);
		pl[185] = (TextView) findViewById(R.id.Row37place4);
		
		pl[186] = (TextView) findViewById(R.id.Row38place0);
		pl[187] = (TextView) findViewById(R.id.Row38place1);
		pl[188] = (TextView) findViewById(R.id.Row38place2);
		pl[189] = (TextView) findViewById(R.id.Row38place3);
		pl[190] = (TextView) findViewById(R.id.Row38place4);
		
		pl[191] = (TextView) findViewById(R.id.Row39place0);
		pl[192] = (TextView) findViewById(R.id.Row39place1);
		pl[193] = (TextView) findViewById(R.id.Row39place2);
		pl[194] = (TextView) findViewById(R.id.Row39place3);
		pl[195] = (TextView) findViewById(R.id.Row39place4);
		
		//set Title Text at Row 1
		pl[1].setText(R.string.sl);
		pl[2].setText(R.string.place);
		pl[3].setText(R.string.km);
		pl[4].setText(R.string.km);
		pl[5].setText(R.string.dist);
		
		
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View arg1, int position,
			long arg3) {
		Toast.makeText(DangerPlaceByArea.this,parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
		//callSelecdetArea(position);
		pos = position;
		pdialog = ProgressDialog.show(context, "",getString(R.string.waitForArea), true);
		callSelecdetArea(position);
		RetreiveFeedTask task = new RetreiveFeedTask();
		task.execute();
		
	}
	
	class RetreiveFeedTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			
			try{
				callSelecdetArea(pos);
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

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void callSelecdetArea(int position) {
		switch(position){
		case 0: flag = 1;max = 2;Spot_0(flag);break;
		case 1: flag = 1;max = 2;Spot_1();break;
		case 2: flag = 1;max = 2;Spot_2();break;
		case 3: flag = 1;max = 2;Spot_3();break;
		case 4: flag = 1;max = 2;Spot_4();break;
		case 5: flag = 1;max = 2;Spot_5();break;
		case 6: flag = 1;max = 2;Spot_6();break;
		case 7: flag = 1;max = 2;Spot_7();break;
		case 8: flag = 1;max = 2;Spot_8();break;
		case 9: flag = 1;max = 2; Spot_9();break;
		default: flag = 1;max = 2;Spot_1();break;
		}
	}

	private void Spot_0(int fog) {
			
		pl[6].setText(R.string.NOcO);
		pl[7].setText(R.string.NOcT);
		pl[8].setText(R.string.NOcTh);
		pl[9].setText(R.string.NOcF);
		pl[10].setText(R.string.NOcFi);
		
		pl[11].setText(R.string.NTcO);
		pl[12].setText(R.string.NTcT);
		pl[13].setText(R.string.NTcTh);
		pl[14].setText(R.string.NTcF);
		pl[15].setText(R.string.NTcFi);
		
		pl[16].setText(R.string.NTHcO);
		pl[17].setText(R.string.NTHcT);
		pl[18].setText(R.string.NTHcTh);
		pl[19].setText(R.string.NTHcF);
		pl[20].setText(R.string.NTHcFi);
		
		pl[21].setText(R.string.NFcO);
		pl[22].setText(R.string.NFcT);
		pl[23].setText(R.string.NFcTh);
		pl[24].setText(R.string.NFcF);
		pl[25].setText(R.string.NFcFi);
		
		pl[26].setText(R.string.NFIcO);
		pl[27].setText(R.string.NFIcT);
		pl[28].setText(R.string.NFIcTh);
		pl[29].setText(R.string.NFIcF);
		pl[30].setText(R.string.NFIcFi);
		
		pl[31].setText(R.string.NScO);
		pl[32].setText(R.string.NScT);
		pl[33].setText(R.string.NScTh);
		pl[34].setText(R.string.NScF);
		pl[35].setText(R.string.NScFi);
		
		pl[36].setText(R.string.NSEcO);
		pl[37].setText(R.string.NSEcT);
		pl[38].setText(R.string.NSEcTh);
		pl[39].setText(R.string.NSEcF);
		pl[40].setText(R.string.NSEcFi);
		
		pl[41].setText(R.string.NEcO);
		pl[42].setText(R.string.NEcT);
		pl[43].setText(R.string.NEcTh);
		pl[44].setText(R.string.NEcF);
		pl[45].setText(R.string.NEcFi);
		
		pl[46].setText(R.string.NNcO);
		pl[47].setText(R.string.NNcT);
		pl[48].setText(R.string.NNcTh);
		pl[49].setText(R.string.NNcF);
		pl[50].setText(R.string.NNcFi);
		
		pl[51].setText(R.string.NTEcO);
		pl[52].setText(R.string.NTEcT);
		pl[53].setText(R.string.NTEcTh);
		pl[54].setText(R.string.NTEcF);
		pl[55].setText(R.string.NTEcFi);
		
		pl[56].setText(R.string.NELcO);
		pl[57].setText(R.string.NELcT);
		pl[58].setText(R.string.NELcTh);
		pl[59].setText(R.string.NELcF);
		pl[60].setText(R.string.NELcFi);
		
		pl[61].setText(R.string.NTWcO);
		pl[62].setText(R.string.NTWcT);
		pl[63].setText(R.string.NTWcTh);
		pl[64].setText(R.string.NTWcF);
		pl[65].setText(R.string.NTWcFi);
		
		pl[66].setText(R.string.NTHIcO);
		pl[67].setText(R.string.NTHIcT);
		pl[68].setText(R.string.NTHIcTh);
		pl[69].setText(R.string.NTHIcF);
		pl[70].setText(R.string.NTHIcFi);
		
		pl[71].setText(R.string.NFOcO);
		pl[72].setText(R.string.NFOcT);
		pl[73].setText(R.string.NFOcTh);
		pl[74].setText(R.string.NFOcF);
		pl[75].setText(R.string.NFOcFi);
		
		pl[76].setText(R.string.NFIFcO);
		pl[77].setText(R.string.NFIFcT);
		pl[78].setText(R.string.NFIFcTh);
		pl[79].setText(R.string.NFIFcF);
		pl[80].setText(R.string.NFIFcFi);
		
		pl[81].setText(R.string.NSIXcO);
		pl[82].setText(R.string.NSIXcT);
		pl[83].setText(R.string.NSIXcTh);
		pl[84].setText(R.string.NSIXcF);
		pl[85].setText(R.string.NSIXcFi);
		
		pl[86].setText(R.string.NSEVcO);
		pl[87].setText(R.string.NSEVcT);
		pl[88].setText(R.string.NSEVcTh);
		pl[89].setText(R.string.NSEVcF);
		pl[90].setText(R.string.NSEVcFi);
		
		
		pl[96].setText(R.string.NEIcO);
		pl[97].setText(R.string.NEIcT);
		pl[98].setText(R.string.NEIcTh);
		pl[99].setText(R.string.NEIcF);
		pl[100].setText(R.string.NEIcFi);
		
		pl[101].setText(R.string.NNINcO);
		pl[102].setText(R.string.NNINcT);
		pl[103].setText(R.string.NNINcTh);
		pl[104].setText(R.string.NNINcF);
		pl[105].setText(R.string.NNINcFi);
		
		pl[106].setText(R.string.NTWEcO);
		pl[107].setText(R.string.NTWEcT);
		pl[108].setText(R.string.NTWEcTh);
		pl[109].setText(R.string.NTWEcF);
		pl[110].setText(R.string.NTWEcFi);
		
		pl[111].setText(R.string.NTOcO);
		pl[112].setText(R.string.NTOcT);
		pl[113].setText(R.string.NTOcTh);
		pl[114].setText(R.string.NTOcF);
		pl[115].setText(R.string.NTOcFi);
		
		pl[116].setText(R.string.NTTcO);
		pl[117].setText(R.string.NTTcT);
		pl[118].setText(R.string.NTTcTh);
		pl[119].setText(R.string.NTTcF);
		pl[120].setText(R.string.NTTcFi);
		
		pl[121].setText(R.string.NTTHcO);
		pl[122].setText(R.string.NTTHcT);
		pl[123].setText(R.string.NTTHcTh);
		pl[124].setText(R.string.NTTHcF);
		pl[125].setText(R.string.NTTHcFi);
		
		pl[126].setText(R.string.NTFOcO);
		pl[127].setText(R.string.NTFOcT);
		pl[128].setText(R.string.NTFOcTh);
		pl[129].setText(R.string.NTFOcF);
		pl[130].setText(R.string.NTFOcFi);
		
		pl[131].setText(R.string.NTFIOcO);
		pl[132].setText(R.string.NTFIOcT);
		pl[133].setText(R.string.NTFIOcTh);
		pl[134].setText(R.string.NTFIOcF);
		pl[135].setText(R.string.NTFIOcFi);
		
		pl[136].setText(R.string.NTSIOcO);
		pl[137].setText(R.string.NTSIOcT);
		pl[138].setText(R.string.NTSIOcTh);
		pl[139].setText(R.string.NTSIOcF);
		pl[140].setText(R.string.NTSIOcFi);
		
		pl[141].setText(R.string.NTSEVOcO);
		pl[142].setText(R.string.NTSEVOcT);
		pl[143].setText(R.string.NTSEVOcTh);
		pl[144].setText(R.string.NTSEVOcF);
		pl[145].setText(R.string.NTSEVOcFi);
		
		pl[146].setText(R.string.NTEIOcO);
		pl[147].setText(R.string.NTEIOcT);
		pl[148].setText(R.string.NTEIOcTh);
		pl[149].setText(R.string.NTEIOcF);
		pl[150].setText(R.string.NTEIOcFi);
		
		pl[151].setText(R.string.NTNINOcO);
		pl[152].setText(R.string.NTNINOcT);
		pl[153].setText(R.string.NTNINOcTh);
		pl[154].setText(R.string.NTNINOcF);
		pl[155].setText(R.string.NTNINOcFi);
		
		pl[156].setText(R.string.NTHIOcO);
		pl[157].setText(R.string.NTHIOcT);
		pl[158].setText(R.string.NTHIOcTh);
		pl[159].setText(R.string.NTHIOcF);
		pl[160].setText(R.string.NTHIOcFi);
		
		pl[161].setText(R.string.NTHOOcO);
		pl[162].setText(R.string.NTHOcT);
		pl[163].setText(R.string.NTHOcTh);
		pl[164].setText(R.string.NTHOcF);
		pl[165].setText(R.string.NTHOcFi);
		
		pl[166].setText(R.string.NTHTOcO);
		pl[167].setText(R.string.NTHTOcT);
		pl[168].setText(R.string.NTHTOcTh);
		pl[169].setText(R.string.NTHTOcF);
		pl[170].setText(R.string.NTHTOcFi);
	
		pl[171].setText(R.string.NTHTROcO);
		pl[172].setText(R.string.NTHTROcT);
		pl[173].setText(R.string.NTHTROcTh);
		pl[174].setText(R.string.NTHTROcF);
		pl[175].setText(R.string.NTHTROcFi);
		
		pl[176].setText(R.string.NTHFROcO);
		pl[177].setText(R.string.NTHFROcT);
		pl[178].setText(R.string.NTHFROcTh);
		pl[179].setText(R.string.NTHFROcF);
		pl[180].setText(R.string.NTHFROcFi);
		
		pl[181].setText(R.string.NTHFVOcO);
		pl[182].setText(R.string.NTHFVOcT);
		pl[183].setText(R.string.NTHFVOcTh);
		pl[184].setText(R.string.NTHFVOcF);
		pl[185].setText(R.string.NTHFVOcFi);
		
		pl[186].setText(R.string.NTHSIXOcO);
		pl[187].setText(R.string.NTHSIXOcT);
		pl[188].setText(R.string.NTHSIXOcTh);
		pl[189].setText(R.string.NTHSIXOcF);
		pl[190].setText(R.string.NTHSIXOcFi);
		
		pl[191].setText(R.string.NTHSENOcO);
		pl[192].setText(R.string.NTHSENOcT);
		pl[193].setText(R.string.NTHSENOcTh);
		pl[194].setText(R.string.NTHSENOcF);
		pl[195].setText(R.string.NTHSENOcFi);
	}

	private void Spot_1() {
		pl[6].setText(R.string.bNOcO);
		pl[7].setText(R.string.bNOcT);
		pl[8].setText(R.string.bNOcTh);
		pl[9].setText(R.string.bNOcF);
		pl[10].setText(R.string.bNOcFi);
		
		pl[11].setText(R.string.bNTcO);
		pl[12].setText(R.string.bNTcT);
		pl[13].setText(R.string.bNTcTh);
		pl[14].setText(R.string.bNTcF);
		pl[15].setText(R.string.bNTcFi);
		
		pl[16].setText(R.string.bNTHcO);
		pl[17].setText(R.string.bNTHcT);
		pl[18].setText(R.string.bNTHcTh);
		pl[19].setText(R.string.bNTHcF);
		pl[20].setText(R.string.bNTHcFi);
		
		pl[21].setText(R.string.bNFcO);
		pl[22].setText(R.string.bNFcT);
		pl[23].setText(R.string.bNFcTh);
		pl[24].setText(R.string.bNFcF);
		pl[25].setText(R.string.bNFcFi);
		
		pl[26].setText(R.string.bNFIcO);
		pl[27].setText(R.string.bNFIcT);
		pl[28].setText(R.string.bNFIcTh);
		pl[29].setText(R.string.bNFIcF);
		pl[30].setText(R.string.bNFIcFi);
		
		pl[31].setText(R.string.bNScO);
		pl[32].setText(R.string.bNScT);
		pl[33].setText(R.string.bNScTh);
		pl[34].setText(R.string.bNScF);
		pl[35].setText(R.string.bNScFi);
		
		pl[36].setText(R.string.bNSEcO);
		pl[37].setText(R.string.bNSEcT);
		pl[38].setText(R.string.bNSEcTh);
		pl[39].setText(R.string.bNSEcF);
		pl[40].setText(R.string.bNSEcFi);
		
		pl[41].setText(R.string.bNEcO);
		pl[42].setText(R.string.bNEcT);
		pl[43].setText(R.string.bNEcTh);
		pl[44].setText(R.string.bNEcF);
		pl[45].setText(R.string.bNEcFi);
		
		pl[46].setText(R.string.bNNcO);
		pl[47].setText(R.string.bNNcT);
		pl[48].setText(R.string.bNNcTh);
		pl[49].setText(R.string.bNNcF);
		pl[50].setText(R.string.bNNcFi);
		
		pl[51].setText(R.string.bNTEcO);
		pl[52].setText(R.string.bNTEcT);
		pl[53].setText(R.string.bNTEcTh);
		pl[54].setText(R.string.bNTEcF);
		pl[55].setText(R.string.bNTEcFi);
		
		pl[56].setText(R.string.bNELcO);
		pl[57].setText(R.string.bNELcT);
		pl[58].setText(R.string.bNELcTh);
		pl[59].setText(R.string.bNELcF);
		pl[60].setText(R.string.bNELcFi);
		
		pl[61].setText(R.string.bNTWcO);
		pl[62].setText(R.string.bNTWcT);
		pl[63].setText(R.string.bNTWcTh);
		pl[64].setText(R.string.bNTWcF);
		pl[65].setText(R.string.bNTWcFi);
		
		pl[66].setText(R.string.bNTHIcO);
		pl[67].setText(R.string.bNTHIcT);
		pl[68].setText(R.string.bNTHIcTh);
		pl[69].setText(R.string.bNTHIcF);
		pl[70].setText(R.string.bNTHIcFi);
		
		pl[71].setText(R.string.bNFOcO);
		pl[72].setText(R.string.bNFOcT);
		pl[73].setText(R.string.bNFOcTh);
		pl[74].setText(R.string.bNFOcF);
		pl[75].setText(R.string.bNFOcFi);
		
		pl[76].setText(R.string.bNFIFcO);
		pl[77].setText(R.string.bNFIFcT);
		pl[78].setText(R.string.bNFIFcTh);
		pl[79].setText(R.string.bNFIFcF);
		pl[80].setText(R.string.bNFIFcFi);
		
		pl[81].setText(R.string.bNSIXcO);
		pl[82].setText(R.string.bNSIXcT);
		pl[83].setText(R.string.bNSIXcTh);
		pl[84].setText(R.string.bNSIXcF);
		pl[85].setText(R.string.bNSIXcFi);
		
		pl[86].setText(R.string.bNSEVcO);
		pl[87].setText(R.string.bNSEVcT);
		pl[88].setText(R.string.bNSEVcTh);
		pl[89].setText(R.string.bNSEVcF);
		pl[90].setText(R.string.bNSEVcFi);
		
		pl[96].setText(R.string.bNEIcO);
		pl[97].setText(R.string.bNEIcT);
		pl[98].setText(R.string.bNEIcTh);
		pl[99].setText(R.string.bNEIcF);
		pl[100].setText(R.string.bNEIcFi);
		
		pl[101].setText(R.string.bNNINcO);
		pl[102].setText(R.string.bNNINcT);
		pl[103].setText(R.string.bNNINcTh);
		pl[104].setText(R.string.bNNINcF);
		pl[105].setText(R.string.bNNINcFi);
		
		pl[106].setText(R.string.bNTWEcO);
		pl[107].setText(R.string.bNTWEcT);
		pl[108].setText(R.string.bNTWEcTh);
		pl[109].setText(R.string.bNTWEcF);
		pl[110].setText(R.string.bNTWEcFi);
		
		pl[111].setText(R.string.bNTOcO);
		pl[112].setText(R.string.bNTOcT);
		pl[113].setText(R.string.bNTOcTh);
		pl[114].setText(R.string.bNTOcF);
		pl[115].setText(R.string.bNTOcFi);
		
		pl[116].setText(R.string.bNTTcO);
		pl[117].setText(R.string.bNTTcT);
		pl[118].setText(R.string.bNTTcTh);
		pl[119].setText(R.string.bNTTcF);
		pl[120].setText(R.string.bNTTcFi);
		
		pl[121].setText(R.string.G);
		pl[122].setText(R.string.G);
		pl[123].setText(R.string.G);
		pl[124].setText(R.string.G);
		pl[125].setText(R.string.G);
		
		pl[126].setText(R.string.G);
		pl[127].setText(R.string.G);
		pl[128].setText(R.string.G);
		pl[129].setText(R.string.G);
		pl[130].setText(R.string.G);
		
		pl[131].setText(R.string.G);
		pl[132].setText(R.string.G);
		pl[133].setText(R.string.G);
		pl[134].setText(R.string.G);
		pl[135].setText(R.string.G);
		
		pl[136].setText(R.string.G);
		pl[137].setText(R.string.G);
		pl[138].setText(R.string.G);
		pl[139].setText(R.string.G);
		pl[140].setText(R.string.G);
		
		pl[141].setText(R.string.G);
		pl[142].setText(R.string.G);
		pl[143].setText(R.string.G);
		pl[144].setText(R.string.G);
		pl[145].setText(R.string.G);
		
		pl[146].setText(R.string.G);
		pl[147].setText(R.string.G);
		pl[148].setText(R.string.G);
		pl[149].setText(R.string.G);
		pl[150].setText(R.string.G);
		
		pl[151].setText(R.string.G);
		pl[152].setText(R.string.G);
		pl[153].setText(R.string.G);
		pl[154].setText(R.string.G);
		pl[155].setText(R.string.G);
		
		pl[156].setText(R.string.G);
		pl[157].setText(R.string.G);
		pl[158].setText(R.string.G);
		pl[159].setText(R.string.G);
		pl[160].setText(R.string.G);
		
		pl[161].setText(R.string.G);
		pl[162].setText(R.string.G);
		pl[163].setText(R.string.G);
		pl[164].setText(R.string.G);
		pl[165].setText(R.string.G);
		
		pl[166].setText(R.string.G);
		pl[167].setText(R.string.G);
		pl[168].setText(R.string.G);
		pl[169].setText(R.string.G);
		pl[170].setText(R.string.G);
	
		pl[171].setText(R.string.G);
		pl[172].setText(R.string.G);
		pl[173].setText(R.string.G);
		pl[174].setText(R.string.G);
		pl[175].setText(R.string.G);
		
		pl[176].setText(R.string.G);
		pl[177].setText(R.string.G);
		pl[178].setText(R.string.G);
		pl[179].setText(R.string.G);
		pl[180].setText(R.string.G);
		
		pl[181].setText(R.string.G);
		pl[182].setText(R.string.G);
		pl[183].setText(R.string.G);
		pl[184].setText(R.string.G);
		pl[185].setText(R.string.G);
		
		pl[186].setText(R.string.G);
		pl[187].setText(R.string.G);
		pl[188].setText(R.string.G);
		pl[189].setText(R.string.G);
		pl[190].setText(R.string.G);
		
		pl[191].setText(R.string.G);
		pl[192].setText(R.string.G);
		pl[193].setText(R.string.G);
		pl[194].setText(R.string.G);
		pl[195].setText(R.string.G);
	}
	private void Spot_2() {
		pl[6].setText(R.string.cNOcO);
		pl[7].setText(R.string.cNOcT);
		pl[8].setText(R.string.cNOcTh);
		pl[9].setText(R.string.cNOcF);
		pl[10].setText(R.string.cNOcFi);
		
		pl[11].setText(R.string.cNTcO);
		pl[12].setText(R.string.cNTcT);
		pl[13].setText(R.string.cNTcTh);
		pl[14].setText(R.string.cNTcF);
		pl[15].setText(R.string.cNTcFi);
		
		pl[16].setText(R.string.cNTHcO);
		pl[17].setText(R.string.cNTHcT);
		pl[18].setText(R.string.cNTHcTh);
		pl[19].setText(R.string.cNTHcF);
		pl[20].setText(R.string.cNTHcFi);
		
		pl[21].setText(R.string.cNFcO);
		pl[22].setText(R.string.cNFcT);
		pl[23].setText(R.string.cNFcTh);
		pl[24].setText(R.string.cNFcF);
		pl[25].setText(R.string.cNFcFi);
		
		pl[26].setText(R.string.cNFIcO);
		pl[27].setText(R.string.cNFIcT);
		pl[28].setText(R.string.cNFIcTh);
		pl[29].setText(R.string.cNFIcF);
		pl[30].setText(R.string.cNFIcFi);
		
		pl[31].setText(R.string.cNScO);
		pl[32].setText(R.string.cNScT);
		pl[33].setText(R.string.cNScTh);
		pl[34].setText(R.string.cNScF);
		pl[35].setText(R.string.cNScFi);
		
		pl[36].setText(R.string.cNSEcO);
		pl[37].setText(R.string.cNSEcT);
		pl[38].setText(R.string.cNSEcTh);
		pl[39].setText(R.string.cNSEcF);
		pl[40].setText(R.string.cNSEcFi);
		
		pl[41].setText(R.string.cNEcO);
		pl[42].setText(R.string.cNEcT);
		pl[43].setText(R.string.cNEcTh);
		pl[44].setText(R.string.cNEcF);
		pl[45].setText(R.string.cNEcFi);
		
		pl[46].setText(R.string.cNNcO);
		pl[47].setText(R.string.cNNcT);
		pl[48].setText(R.string.cNNcTh);
		pl[49].setText(R.string.cNNcF);
		pl[50].setText(R.string.cNNcFi);
		
		pl[51].setText(R.string.cNTEcO);
		pl[52].setText(R.string.cNTEcT);
		pl[53].setText(R.string.cNTEcTh);
		pl[54].setText(R.string.cNTEcF);
		pl[55].setText(R.string.cNTEcFi);
		
		pl[56].setText(R.string.cNELcO);
		pl[57].setText(R.string.cNELcT);
		pl[58].setText(R.string.cNELcTh);
		pl[59].setText(R.string.cNELcF);
		pl[60].setText(R.string.cNELcFi);
		
		pl[61].setText(R.string.cNTWcO);
		pl[62].setText(R.string.cNTWcT);
		pl[63].setText(R.string.cNTWcTh);
		pl[64].setText(R.string.cNTWcF);
		pl[65].setText(R.string.cNTWcFi);
		
		pl[66].setText(R.string.cNTHIcO);
		pl[67].setText(R.string.cNTHIcT);
		pl[68].setText(R.string.cNTHIcTh);
		pl[69].setText(R.string.cNTHIcF);
		pl[70].setText(R.string.cNTHIcFi);
		
		pl[71].setText(R.string.cNFOcO);
		pl[72].setText(R.string.cNFOcT);
		pl[73].setText(R.string.cNFOcTh);
		pl[74].setText(R.string.cNFOcF);
		pl[75].setText(R.string.cNFOcFi);
		
		pl[76].setText(R.string.cNFIFcO);
		pl[77].setText(R.string.cNFIFcT);
		pl[78].setText(R.string.cNFIFcTh);
		pl[79].setText(R.string.cNFIFcF);
		pl[80].setText(R.string.cNFIFcFi);
		
		pl[81].setText(R.string.cNSIXcO);
		pl[82].setText(R.string.cNSIXcT);
		pl[83].setText(R.string.cNSIXcTh);
		pl[84].setText(R.string.cNSIXcF);
		pl[85].setText(R.string.cNSIXcFi);
		
		pl[86].setText(R.string.G);
		pl[87].setText(R.string.G);
		pl[88].setText(R.string.G);
		pl[89].setText(R.string.G);
		pl[90].setText(R.string.G);
		
		pl[96].setText(R.string.G);
		pl[97].setText(R.string.G);
		pl[98].setText(R.string.G);
		pl[99].setText(R.string.G);
		pl[100].setText(R.string.G);
		
		pl[101].setText(R.string.G);
		pl[102].setText(R.string.G);
		pl[103].setText(R.string.G);
		pl[104].setText(R.string.G);
		pl[105].setText(R.string.G);
		
		pl[106].setText(R.string.G);
		pl[107].setText(R.string.G);
		pl[108].setText(R.string.G);
		pl[109].setText(R.string.G);
		pl[110].setText(R.string.G);
		
		pl[111].setText(R.string.G);
		pl[112].setText(R.string.G);
		pl[113].setText(R.string.G);
		pl[114].setText(R.string.G);
		pl[115].setText(R.string.G);
		
		pl[116].setText(R.string.G);
		pl[117].setText(R.string.G);
		pl[118].setText(R.string.G);
		pl[119].setText(R.string.G);
		pl[120].setText(R.string.G);
		
		pl[121].setText(R.string.G);
		pl[122].setText(R.string.G);
		pl[123].setText(R.string.G);
		pl[124].setText(R.string.G);
		pl[125].setText(R.string.G);
		
		pl[126].setText(R.string.G);
		pl[127].setText(R.string.G);
		pl[128].setText(R.string.G);
		pl[129].setText(R.string.G);
		pl[130].setText(R.string.G);
		
		pl[131].setText(R.string.G);
		pl[132].setText(R.string.G);
		pl[133].setText(R.string.G);
		pl[134].setText(R.string.G);
		pl[135].setText(R.string.G);
		
		pl[136].setText(R.string.G);
		pl[137].setText(R.string.G);
		pl[138].setText(R.string.G);
		pl[139].setText(R.string.G);
		pl[140].setText(R.string.G);
		
		pl[141].setText(R.string.G);
		pl[142].setText(R.string.G);
		pl[143].setText(R.string.G);
		pl[144].setText(R.string.G);
		pl[145].setText(R.string.G);
		
		pl[146].setText(R.string.G);
		pl[147].setText(R.string.G);
		pl[148].setText(R.string.G);
		pl[149].setText(R.string.G);
		pl[150].setText(R.string.G);
		
		pl[151].setText(R.string.G);
		pl[152].setText(R.string.G);
		pl[153].setText(R.string.G);
		pl[154].setText(R.string.G);
		pl[155].setText(R.string.G);
		
		pl[156].setText(R.string.G);
		pl[157].setText(R.string.G);
		pl[158].setText(R.string.G);
		pl[159].setText(R.string.G);
		pl[160].setText(R.string.G);
		
		pl[161].setText(R.string.G);
		pl[162].setText(R.string.G);
		pl[163].setText(R.string.G);
		pl[164].setText(R.string.G);
		pl[165].setText(R.string.G);
		
		pl[166].setText(R.string.G);
		pl[167].setText(R.string.G);
		pl[168].setText(R.string.G);
		pl[169].setText(R.string.G);
		pl[170].setText(R.string.G);
	
		pl[171].setText(R.string.G);
		pl[172].setText(R.string.G);
		pl[173].setText(R.string.G);
		pl[174].setText(R.string.G);
		pl[175].setText(R.string.G);
		
		pl[176].setText(R.string.G);
		pl[177].setText(R.string.G);
		pl[178].setText(R.string.G);
		pl[179].setText(R.string.G);
		pl[180].setText(R.string.G);
		
		pl[181].setText(R.string.G);
		pl[182].setText(R.string.G);
		pl[183].setText(R.string.G);
		pl[184].setText(R.string.G);
		pl[185].setText(R.string.G);
		
		pl[186].setText(R.string.G);
		pl[187].setText(R.string.G);
		pl[188].setText(R.string.G);
		pl[189].setText(R.string.G);
		pl[190].setText(R.string.G);
		
		pl[191].setText(R.string.G);
		pl[192].setText(R.string.G);
		pl[193].setText(R.string.G);
		pl[194].setText(R.string.G);
		pl[195].setText(R.string.G);
		
		
	}
	private void Spot_3() {
		pl[6].setText(R.string.dNOcO);
		pl[7].setText(R.string.dNOcT);
		pl[8].setText(R.string.dNOcTh);
		pl[9].setText(R.string.dNOcF);
		pl[10].setText(R.string.dNOcFi);
		
		pl[11].setText(R.string.dNTcO);
		pl[12].setText(R.string.dNTcT);
		pl[13].setText(R.string.dNTcTh);
		pl[14].setText(R.string.dNTcF);
		pl[15].setText(R.string.dNTcFi);
		
		pl[16].setText(R.string.dNTHcO);
		pl[17].setText(R.string.dNTHcT);
		pl[18].setText(R.string.dNTHcTh);
		pl[19].setText(R.string.dNTHcF);
		pl[20].setText(R.string.dNTHcFi);
		
		pl[21].setText(R.string.dNFcO);
		pl[22].setText(R.string.dNFcT);
		pl[23].setText(R.string.dNFcTh);
		pl[24].setText(R.string.dNFcF);
		pl[25].setText(R.string.dNFcFi);
		
		pl[26].setText(R.string.dNFIcO);
		pl[27].setText(R.string.dNFIcT);
		pl[28].setText(R.string.dNFIcTh);
		pl[29].setText(R.string.dNFIcF);
		pl[30].setText(R.string.dNFIcFi);
		
		pl[31].setText(R.string.dNScO);
		pl[32].setText(R.string.dNScT);
		pl[33].setText(R.string.dNScTh);
		pl[34].setText(R.string.dNScF);
		pl[35].setText(R.string.dNScFi);
		
		pl[36].setText(R.string.dNSEcO);
		pl[37].setText(R.string.dNSEcT);
		pl[38].setText(R.string.dNSEcTh);
		pl[39].setText(R.string.dNSEcF);
		pl[40].setText(R.string.dNSEcFi);
		
		pl[41].setText(R.string.dNEcO);
		pl[42].setText(R.string.dNEcT);
		pl[43].setText(R.string.dNEcTh);
		pl[44].setText(R.string.dNEcF);
		pl[45].setText(R.string.dNEcFi);
		
		pl[46].setText(R.string.dNNcO);
		pl[47].setText(R.string.dNNcT);
		pl[48].setText(R.string.dNNcTh);
		pl[49].setText(R.string.dNNcF);
		pl[50].setText(R.string.dNNcFi);
		
		pl[51].setText(R.string.dNTEcO);
		pl[52].setText(R.string.dNTEcT);
		pl[53].setText(R.string.dNTEcTh);
		pl[54].setText(R.string.dNTEcF);
		pl[55].setText(R.string.dNTEcFi);
		
		pl[56].setText(R.string.dNELcO);
		pl[57].setText(R.string.dNELcT);
		pl[58].setText(R.string.dNELcTh);
		pl[59].setText(R.string.dNELcF);
		pl[60].setText(R.string.dNELcFi);
		
		pl[61].setText(R.string.dNTWcO);
		pl[62].setText(R.string.dNTWcT);
		pl[63].setText(R.string.dNTWcTh);
		pl[64].setText(R.string.dNTWcF);
		pl[65].setText(R.string.dNTWcFi);
		
		pl[66].setText(R.string.dNTHIcO);
		pl[67].setText(R.string.dNTHIcT);
		pl[68].setText(R.string.dNTHIcTh);
		pl[69].setText(R.string.dNTHIcF);
		pl[70].setText(R.string.dNTHIcFi);
		
		pl[71].setText(R.string.dNFOcO);
		pl[72].setText(R.string.dNFOcT);
		pl[73].setText(R.string.dNFOcTh);
		pl[74].setText(R.string.dNFOcF);
		pl[75].setText(R.string.dNFOcFi);
		
		pl[76].setText(R.string.dNFIFcO);
		pl[77].setText(R.string.dNFIFcT);
		pl[78].setText(R.string.dNFIFcTh);
		pl[79].setText(R.string.dNFIFcF);
		pl[80].setText(R.string.dNFIFcFi);
		
		pl[81].setText(R.string.dNSIXcO);
		pl[82].setText(R.string.dNSIXcT);
		pl[83].setText(R.string.dNSIXcTh);
		pl[84].setText(R.string.dNSIXcF);
		pl[85].setText(R.string.dNSIXcFi);
		
		pl[86].setText(R.string.dNSEVcO);
		pl[87].setText(R.string.dNSEVcT);
		pl[88].setText(R.string.dNSEVcTh);
		pl[89].setText(R.string.dNSEVcF);
		pl[90].setText(R.string.dNSEVcFi);
		
		
		pl[96].setText(R.string.dNEIcO);
		pl[97].setText(R.string.dNEIcT);
		pl[98].setText(R.string.dNEIcTh);
		pl[99].setText(R.string.dNEIcF);
		pl[100].setText(R.string.dNEIcFi);
		
		pl[101].setText(R.string.dNNINcO);
		pl[102].setText(R.string.dNNINcT);
		pl[103].setText(R.string.dNNINcTh);
		pl[104].setText(R.string.dNNINcF);
		pl[105].setText(R.string.dNNINcFi);
		
		pl[106].setText(R.string.dNTWEcO);
		pl[107].setText(R.string.dNTWEcT);
		pl[108].setText(R.string.dNTWEcTh);
		pl[109].setText(R.string.dNTWEcF);
		pl[110].setText(R.string.dNTWEcFi);
		
		pl[111].setText(R.string.dNTOcO);
		pl[112].setText(R.string.dNTOcT);
		pl[113].setText(R.string.dNTOcTh);
		pl[114].setText(R.string.dNTOcF);
		pl[115].setText(R.string.dNTOcFi);
		
		pl[116].setText(R.string.dNTTcO);
		pl[117].setText(R.string.dNTTcT);
		pl[118].setText(R.string.dNTTcTh);
		pl[119].setText(R.string.dNTTcF);
		pl[120].setText(R.string.dNTTcFi);
		
		pl[121].setText(R.string.dNTTHcO);
		pl[122].setText(R.string.dNTTHcT);
		pl[123].setText(R.string.dNTTHcTh);
		pl[124].setText(R.string.dNTTHcF);
		pl[125].setText(R.string.dNTTHcFi);
		
		pl[126].setText(R.string.dNTFOcO);
		pl[127].setText(R.string.dNTFOcT);
		pl[128].setText(R.string.dNTFOcTh);
		pl[129].setText(R.string.dNTFOcF);
		pl[130].setText(R.string.dNTFOcFi);
		
		pl[131].setText(R.string.dNTFIOcO);
		pl[132].setText(R.string.dNTFIOcT);
		pl[133].setText(R.string.dNTFIOcTh);
		pl[134].setText(R.string.dNTFIOcF);
		pl[135].setText(R.string.dNTFIOcFi);
		
		pl[136].setText(R.string.dNTSIOcO);
		pl[137].setText(R.string.dNTSIOcT);
		pl[138].setText(R.string.dNTSIOcTh);
		pl[139].setText(R.string.dNTSIOcF);
		pl[140].setText(R.string.dNTSIOcFi);
		
		pl[141].setText(R.string.dNTSEVOcO);
		pl[142].setText(R.string.dNTSEVOcT);
		pl[143].setText(R.string.dNTSEVOcTh);
		pl[144].setText(R.string.dNTSEVOcF);
		pl[145].setText(R.string.dNTSEVOcFi);
		
		pl[146].setText(R.string.dNTEIOcO);
		pl[147].setText(R.string.dNTEIOcT);
		pl[148].setText(R.string.dNTEIOcTh);
		pl[149].setText(R.string.dNTEIOcF);
		pl[150].setText(R.string.dNTEIOcFi);
		
		pl[151].setText(R.string.dNTNINOcO);
		pl[152].setText(R.string.dNTNINOcT);
		pl[153].setText(R.string.dNTNINOcTh);
		pl[154].setText(R.string.dNTNINOcF);
		pl[155].setText(R.string.dNTNINOcFi);
		
		pl[156].setText(R.string.dNTHIOcO);
		pl[157].setText(R.string.dNTHIOcT);
		pl[158].setText(R.string.dNTHIOcTh);
		pl[159].setText(R.string.dNTHIOcF);
		pl[160].setText(R.string.dNTHIOcFi);
		
		pl[161].setText(R.string.dNTHOOcO);
		pl[162].setText(R.string.dNTHOcT);
		pl[163].setText(R.string.dNTHOcTh);
		pl[164].setText(R.string.dNTHOcF);
		pl[165].setText(R.string.dNTHOcFi);
		
		pl[166].setText(R.string.dNTHTOcO);
		pl[167].setText(R.string.dNTHTOcT);
		pl[168].setText(R.string.dNTHTOcTh);
		pl[169].setText(R.string.dNTHTOcF);
		pl[170].setText(R.string.dNTHTOcFi);
	
		pl[171].setText(R.string.dNTHTROcO);
		pl[172].setText(R.string.dNTHTROcT);
		pl[173].setText(R.string.dNTHTROcTh);
		pl[174].setText(R.string.dNTHTROcF);
		pl[175].setText(R.string.dNTHTROcFi);
		
		pl[176].setText(R.string.dNTHFROcO);
		pl[177].setText(R.string.dNTHFROcT);
		pl[178].setText(R.string.dNTHFROcTh);
		pl[179].setText(R.string.dNTHFROcF);
		pl[180].setText(R.string.dNTHFROcFi);
		
		pl[181].setText(R.string.dNTHFVOcO);
		pl[182].setText(R.string.dNTHFVOcT);
		pl[183].setText(R.string.dNTHFVOcTh);
		pl[184].setText(R.string.dNTHFVOcF);
		pl[185].setText(R.string.dNTHFVOcFi);
		
		pl[186].setText(R.string.dNTHSIXOcO);
		pl[187].setText(R.string.dNTHSIXOcT);
		pl[188].setText(R.string.dNTHSIXOcTh);
		pl[189].setText(R.string.dNTHSIXOcF);
		pl[190].setText(R.string.dNTHSIXOcFi);
		
		pl[191].setText(R.string.dNTHSENOcO);
		pl[192].setText(R.string.dNTHSENOcT);
		pl[193].setText(R.string.dNTHSENOcTh);
		pl[194].setText(R.string.dNTHSENOcF);
		pl[195].setText(R.string.dNTHSENOcFi);
		
	}
	private void Spot_4() {
		pl[6].setText(R.string.eNOcO);
		pl[7].setText(R.string.eNOcT);
		pl[8].setText(R.string.eNOcTh);
		pl[9].setText(R.string.eNOcF);
		pl[10].setText(R.string.eNOcFi);
		
		pl[11].setText(R.string.eNTcO);
		pl[12].setText(R.string.eNTcT);
		pl[13].setText(R.string.eNTcTh);
		pl[14].setText(R.string.eNTcF);
		pl[15].setText(R.string.eNTcFi);
		
		pl[16].setText(R.string.eNTHcO);
		pl[17].setText(R.string.eNTHcT);
		pl[18].setText(R.string.eNTHcTh);
		pl[19].setText(R.string.eNTHcF);
		pl[20].setText(R.string.eNTHcFi);
		
		pl[21].setText(R.string.eNFcO);
		pl[22].setText(R.string.eNFcT);
		pl[23].setText(R.string.eNFcTh);
		pl[24].setText(R.string.eNFcF);
		pl[25].setText(R.string.eNFcFi);
		
		pl[26].setText(R.string.eNFIcO);
		pl[27].setText(R.string.eNFIcT);
		pl[28].setText(R.string.eNFIcTh);
		pl[29].setText(R.string.eNFIcF);
		pl[30].setText(R.string.eNFIcFi);
		
		pl[31].setText(R.string.eNScO);
		pl[32].setText(R.string.eNScT);
		pl[33].setText(R.string.eNScTh);
		pl[34].setText(R.string.eNScF);
		pl[35].setText(R.string.eNScFi);
		
		pl[36].setText(R.string.eNSEcO);
		pl[37].setText(R.string.eNSEcT);
		pl[38].setText(R.string.eNSEcTh);
		pl[39].setText(R.string.eNSEcF);
		pl[40].setText(R.string.eNSEcFi);
		
		pl[41].setText(R.string.eNEcO);
		pl[42].setText(R.string.eNEcT);
		pl[43].setText(R.string.eNEcTh);
		pl[44].setText(R.string.eNEcF);
		pl[45].setText(R.string.eNEcFi);
		
		pl[46].setText(R.string.eNNcO);
		pl[47].setText(R.string.eNNcT);
		pl[48].setText(R.string.eNNcTh);
		pl[49].setText(R.string.eNNcF);
		pl[50].setText(R.string.eNNcFi);
		
		pl[51].setText(R.string.eNTEcO);
		pl[52].setText(R.string.eNTEcT);
		pl[53].setText(R.string.eNTEcTh);
		pl[54].setText(R.string.eNTEcF);
		pl[55].setText(R.string.eNTEcFi);
		
		pl[56].setText(R.string.G);
		pl[57].setText(R.string.G);
		pl[58].setText(R.string.G);
		pl[59].setText(R.string.G);
		pl[60].setText(R.string.G);
		
		pl[61].setText(R.string.G);
		pl[62].setText(R.string.G);
		pl[63].setText(R.string.G);
		pl[64].setText(R.string.G);
		pl[65].setText(R.string.G);
		
		pl[66].setText(R.string.G);
		pl[67].setText(R.string.G);
		pl[68].setText(R.string.G);
		pl[69].setText(R.string.G);
		pl[70].setText(R.string.G);
		
		pl[71].setText(R.string.G);
		pl[72].setText(R.string.G);
		pl[73].setText(R.string.G);
		pl[74].setText(R.string.G);
		pl[75].setText(R.string.G);
		
		pl[76].setText(R.string.G);
		pl[77].setText(R.string.G);
		pl[78].setText(R.string.G);
		pl[79].setText(R.string.G);
		pl[80].setText(R.string.G);
		
		pl[81].setText(R.string.G);
		pl[82].setText(R.string.G);
		pl[83].setText(R.string.G);
		pl[84].setText(R.string.G);
		pl[85].setText(R.string.G);
		
		pl[86].setText(R.string.G);
		pl[87].setText(R.string.G);
		pl[88].setText(R.string.G);
		pl[89].setText(R.string.G);
		pl[90].setText(R.string.G);
		
		pl[96].setText(R.string.G);
		pl[97].setText(R.string.G);
		pl[98].setText(R.string.G);
		pl[99].setText(R.string.G);
		pl[100].setText(R.string.G);
		
		pl[101].setText(R.string.G);
		pl[102].setText(R.string.G);
		pl[103].setText(R.string.G);
		pl[104].setText(R.string.G);
		pl[105].setText(R.string.G);
		
		pl[106].setText(R.string.G);
		pl[107].setText(R.string.G);
		pl[108].setText(R.string.G);
		pl[109].setText(R.string.G);
		pl[110].setText(R.string.G);
		
		pl[111].setText(R.string.G);
		pl[112].setText(R.string.G);
		pl[113].setText(R.string.G);
		pl[114].setText(R.string.G);
		pl[115].setText(R.string.G);
		
		pl[116].setText(R.string.G);
		pl[117].setText(R.string.G);
		pl[118].setText(R.string.G);
		pl[119].setText(R.string.G);
		pl[120].setText(R.string.G);
		
		pl[121].setText(R.string.G);
		pl[122].setText(R.string.G);
		pl[123].setText(R.string.G);
		pl[124].setText(R.string.G);
		pl[125].setText(R.string.G);
		
		pl[126].setText(R.string.G);
		pl[127].setText(R.string.G);
		pl[128].setText(R.string.G);
		pl[129].setText(R.string.G);
		pl[130].setText(R.string.G);
		
		pl[131].setText(R.string.G);
		pl[132].setText(R.string.G);
		pl[133].setText(R.string.G);
		pl[134].setText(R.string.G);
		pl[135].setText(R.string.G);
		
		pl[136].setText(R.string.G);
		pl[137].setText(R.string.G);
		pl[138].setText(R.string.G);
		pl[139].setText(R.string.G);
		pl[140].setText(R.string.G);
		
		pl[141].setText(R.string.G);
		pl[142].setText(R.string.G);
		pl[143].setText(R.string.G);
		pl[144].setText(R.string.G);
		pl[145].setText(R.string.G);
		
		pl[146].setText(R.string.G);
		pl[147].setText(R.string.G);
		pl[148].setText(R.string.G);
		pl[149].setText(R.string.G);
		pl[150].setText(R.string.G);
		
		pl[151].setText(R.string.G);
		pl[152].setText(R.string.G);
		pl[153].setText(R.string.G);
		pl[154].setText(R.string.G);
		pl[155].setText(R.string.G);
		
		pl[156].setText(R.string.G);
		pl[157].setText(R.string.G);
		pl[158].setText(R.string.G);
		pl[159].setText(R.string.G);
		pl[160].setText(R.string.G);
		
		pl[161].setText(R.string.G);
		pl[162].setText(R.string.G);
		pl[163].setText(R.string.G);
		pl[164].setText(R.string.G);
		pl[165].setText(R.string.G);
		
		pl[166].setText(R.string.G);
		pl[167].setText(R.string.G);
		pl[168].setText(R.string.G);
		pl[169].setText(R.string.G);
		pl[170].setText(R.string.G);
	
		pl[171].setText(R.string.G);
		pl[172].setText(R.string.G);
		pl[173].setText(R.string.G);
		pl[174].setText(R.string.G);
		pl[175].setText(R.string.G);
		
		pl[176].setText(R.string.G);
		pl[177].setText(R.string.G);
		pl[178].setText(R.string.G);
		pl[179].setText(R.string.G);
		pl[180].setText(R.string.G);
		
		pl[181].setText(R.string.G);
		pl[182].setText(R.string.G);
		pl[183].setText(R.string.G);
		pl[184].setText(R.string.G);
		pl[185].setText(R.string.G);
		
		pl[186].setText(R.string.G);
		pl[187].setText(R.string.G);
		pl[188].setText(R.string.G);
		pl[189].setText(R.string.G);
		pl[190].setText(R.string.G);
		
		pl[191].setText(R.string.G);
		pl[192].setText(R.string.G);
		pl[193].setText(R.string.G);
		pl[194].setText(R.string.G);
		pl[195].setText(R.string.G);
		
	}
	private void Spot_5() {
		pl[6].setText(R.string.fNOcO);
		pl[7].setText(R.string.fNOcT);
		pl[8].setText(R.string.fNOcTh);
		pl[9].setText(R.string.fNOcF);
		pl[10].setText(R.string.fNOcFi);
		
		pl[11].setText(R.string.fNTcO);
		pl[12].setText(R.string.fNTcT);
		pl[13].setText(R.string.fNTcTh);
		pl[14].setText(R.string.fNTcF);
		pl[15].setText(R.string.fNTcFi);
		
		pl[16].setText(R.string.fNTHcO);
		pl[17].setText(R.string.fNTHcT);
		pl[18].setText(R.string.fNTHcTh);
		pl[19].setText(R.string.fNTHcF);
		pl[20].setText(R.string.fNTHcFi);
		
		pl[21].setText(R.string.fNFcO);
		pl[22].setText(R.string.fNFcT);
		pl[23].setText(R.string.fNFcTh);
		pl[24].setText(R.string.fNFcF);
		pl[25].setText(R.string.fNFcFi);
		
		pl[26].setText(R.string.fNFIcO);
		pl[27].setText(R.string.fNFIcT);
		pl[28].setText(R.string.fNFIcTh);
		pl[29].setText(R.string.fNFIcF);
		pl[30].setText(R.string.fNFIcFi);
		
		pl[31].setText(R.string.fNScO);
		pl[32].setText(R.string.fNScT);
		pl[33].setText(R.string.fNScTh);
		pl[34].setText(R.string.fNScF);
		pl[35].setText(R.string.fNScFi);
		
		pl[36].setText(R.string.fNSEcO);
		pl[37].setText(R.string.fNSEcT);
		pl[38].setText(R.string.fNSEcTh);
		pl[39].setText(R.string.fNSEcF);
		pl[40].setText(R.string.fNSEcFi);
		
		pl[41].setText(R.string.fNEcO);
		pl[42].setText(R.string.fNEcT);
		pl[43].setText(R.string.fNEcTh);
		pl[44].setText(R.string.fNEcF);
		pl[45].setText(R.string.fNEcFi);
		
		pl[46].setText(R.string.fNNcO);
		pl[47].setText(R.string.fNNcT);
		pl[48].setText(R.string.fNNcTh);
		pl[49].setText(R.string.fNNcF);
		pl[50].setText(R.string.fNNcFi);
		
		pl[51].setText(R.string.fNTEcO);
		pl[52].setText(R.string.fNTEcT);
		pl[53].setText(R.string.fNTEcTh);
		pl[54].setText(R.string.fNTEcF);
		pl[55].setText(R.string.fNTEcFi);
		
		pl[56].setText(R.string.fNELcO);
		pl[57].setText(R.string.fNELcT);
		pl[58].setText(R.string.fNELcTh);
		pl[59].setText(R.string.fNELcF);
		pl[60].setText(R.string.fNELcFi);
		
		pl[61].setText(R.string.fNTWcO);
		pl[62].setText(R.string.fNTWcT);
		pl[63].setText(R.string.fNTWcTh);
		pl[64].setText(R.string.fNTWcF);
		pl[65].setText(R.string.fNTWcFi);
		
		pl[66].setText(R.string.fNTHIcO);
		pl[67].setText(R.string.fNTHIcT);
		pl[68].setText(R.string.fNTHIcTh);
		pl[69].setText(R.string.fNTHIcF);
		pl[70].setText(R.string.fNTHIcFi);
		
		pl[71].setText(R.string.G);
		pl[72].setText(R.string.G);
		pl[73].setText(R.string.G);
		pl[74].setText(R.string.G);
		pl[75].setText(R.string.G);
		
		pl[76].setText(R.string.G);
		pl[77].setText(R.string.G);
		pl[78].setText(R.string.G);
		pl[79].setText(R.string.G);
		pl[80].setText(R.string.G);
		
		pl[81].setText(R.string.G);
		pl[82].setText(R.string.G);
		pl[83].setText(R.string.G);
		pl[84].setText(R.string.G);
		pl[85].setText(R.string.G);
		
		pl[86].setText(R.string.G);
		pl[87].setText(R.string.G);
		pl[88].setText(R.string.G);
		pl[89].setText(R.string.G);
		pl[90].setText(R.string.G);
		
		pl[96].setText(R.string.G);
		pl[97].setText(R.string.G);
		pl[98].setText(R.string.G);
		pl[99].setText(R.string.G);
		pl[100].setText(R.string.G);
		
		pl[101].setText(R.string.G);
		pl[102].setText(R.string.G);
		pl[103].setText(R.string.G);
		pl[104].setText(R.string.G);
		pl[105].setText(R.string.G);
		
		pl[106].setText(R.string.G);
		pl[107].setText(R.string.G);
		pl[108].setText(R.string.G);
		pl[109].setText(R.string.G);
		pl[110].setText(R.string.G);
		
		pl[111].setText(R.string.G);
		pl[112].setText(R.string.G);
		pl[113].setText(R.string.G);
		pl[114].setText(R.string.G);
		pl[115].setText(R.string.G);
		
		pl[116].setText(R.string.G);
		pl[117].setText(R.string.G);
		pl[118].setText(R.string.G);
		pl[119].setText(R.string.G);
		pl[120].setText(R.string.G);
		
		pl[121].setText(R.string.G);
		pl[122].setText(R.string.G);
		pl[123].setText(R.string.G);
		pl[124].setText(R.string.G);
		pl[125].setText(R.string.G);
		
		pl[126].setText(R.string.G);
		pl[127].setText(R.string.G);
		pl[128].setText(R.string.G);
		pl[129].setText(R.string.G);
		pl[130].setText(R.string.G);
		
		pl[131].setText(R.string.G);
		pl[132].setText(R.string.G);
		pl[133].setText(R.string.G);
		pl[134].setText(R.string.G);
		pl[135].setText(R.string.G);
		
		pl[136].setText(R.string.G);
		pl[137].setText(R.string.G);
		pl[138].setText(R.string.G);
		pl[139].setText(R.string.G);
		pl[140].setText(R.string.G);
		
		pl[141].setText(R.string.G);
		pl[142].setText(R.string.G);
		pl[143].setText(R.string.G);
		pl[144].setText(R.string.G);
		pl[145].setText(R.string.G);
		
		pl[146].setText(R.string.G);
		pl[147].setText(R.string.G);
		pl[148].setText(R.string.G);
		pl[149].setText(R.string.G);
		pl[150].setText(R.string.G);
		
		pl[151].setText(R.string.G);
		pl[152].setText(R.string.G);
		pl[153].setText(R.string.G);
		pl[154].setText(R.string.G);
		pl[155].setText(R.string.G);
		
		pl[156].setText(R.string.G);
		pl[157].setText(R.string.G);
		pl[158].setText(R.string.G);
		pl[159].setText(R.string.G);
		pl[160].setText(R.string.G);
		
		pl[161].setText(R.string.G);
		pl[162].setText(R.string.G);
		pl[163].setText(R.string.G);
		pl[164].setText(R.string.G);
		pl[165].setText(R.string.G);
		
		pl[166].setText(R.string.G);
		pl[167].setText(R.string.G);
		pl[168].setText(R.string.G);
		pl[169].setText(R.string.G);
		pl[170].setText(R.string.G);
	
		pl[171].setText(R.string.G);
		pl[172].setText(R.string.G);
		pl[173].setText(R.string.G);
		pl[174].setText(R.string.G);
		pl[175].setText(R.string.G);
		
		pl[176].setText(R.string.G);
		pl[177].setText(R.string.G);
		pl[178].setText(R.string.G);
		pl[179].setText(R.string.G);
		pl[180].setText(R.string.G);
		
		pl[181].setText(R.string.G);
		pl[182].setText(R.string.G);
		pl[183].setText(R.string.G);
		pl[184].setText(R.string.G);
		pl[185].setText(R.string.G);
		
		pl[186].setText(R.string.G);
		pl[187].setText(R.string.G);
		pl[188].setText(R.string.G);
		pl[189].setText(R.string.G);
		pl[190].setText(R.string.G);
		
		pl[191].setText(R.string.G);
		pl[192].setText(R.string.G);
		pl[193].setText(R.string.G);
		pl[194].setText(R.string.G);
		pl[195].setText(R.string.G);
		
	}
	private void Spot_6() {
		pl[6].setText(R.string.gNOcO);
		pl[7].setText(R.string.gNOcT);
		pl[8].setText(R.string.gNOcTh);
		pl[9].setText(R.string.gNOcF);
		pl[10].setText(R.string.gNOcFi);
		
		pl[11].setText(R.string.gNTcO);
		pl[12].setText(R.string.gNTcT);
		pl[13].setText(R.string.gNTcTh);
		pl[14].setText(R.string.gNTcF);
		pl[15].setText(R.string.gNTcFi);
		
		pl[16].setText(R.string.gNTHcO);
		pl[17].setText(R.string.gNTHcT);
		pl[18].setText(R.string.gNTHcTh);
		pl[19].setText(R.string.gNTHcF);
		pl[20].setText(R.string.gNTHcFi);
		
		pl[21].setText(R.string.gNFcO);
		pl[22].setText(R.string.gNFcT);
		pl[23].setText(R.string.gNFcTh);
		pl[24].setText(R.string.gNFcF);
		pl[25].setText(R.string.gNFcFi);
		
		pl[26].setText(R.string.gNFIcO);
		pl[27].setText(R.string.gNFIcT);
		pl[28].setText(R.string.gNFIcTh);
		pl[29].setText(R.string.gNFIcF);
		pl[30].setText(R.string.gNFIcFi);
		
		pl[31].setText(R.string.gNScO);
		pl[32].setText(R.string.gNScT);
		pl[33].setText(R.string.gNScTh);
		pl[34].setText(R.string.gNScF);
		pl[35].setText(R.string.gNScFi);
		
		pl[36].setText(R.string.gNSEcO);
		pl[37].setText(R.string.gNSEcT);
		pl[38].setText(R.string.gNSEcTh);
		pl[39].setText(R.string.gNSEcF);
		pl[40].setText(R.string.gNSEcFi);
		
		pl[41].setText(R.string.gNEcO);
		pl[42].setText(R.string.gNEcT);
		pl[43].setText(R.string.gNEcTh);
		pl[44].setText(R.string.gNEcF);
		pl[45].setText(R.string.gNEcFi);
		
		pl[46].setText(R.string.gNNcO);
		pl[47].setText(R.string.gNNcT);
		pl[48].setText(R.string.gNNcTh);
		pl[49].setText(R.string.gNNcF);
		pl[50].setText(R.string.gNNcFi);
		
		pl[51].setText(R.string.gNTEcO);
		pl[52].setText(R.string.gNTEcT);
		pl[53].setText(R.string.gNTEcTh);
		pl[54].setText(R.string.gNTEcF);
		pl[55].setText(R.string.gNTEcFi);
		
		pl[56].setText(R.string.gNELcO);
		pl[57].setText(R.string.gNELcT);
		pl[58].setText(R.string.gNELcTh);
		pl[59].setText(R.string.gNELcF);
		pl[60].setText(R.string.gNELcFi);
		
		pl[61].setText(R.string.gNTWcO);
		pl[62].setText(R.string.gNTWcT);
		pl[63].setText(R.string.gNTWcTh);
		pl[64].setText(R.string.gNTWcF);
		pl[65].setText(R.string.gNTWcFi);
		
		pl[66].setText(R.string.gNTHIcO);
		pl[67].setText(R.string.gNTHIcT);
		pl[68].setText(R.string.gNTHIcTh);
		pl[69].setText(R.string.gNTHIcF);
		pl[70].setText(R.string.gNTHIcFi);
		
		pl[71].setText(R.string.gNFOcO);
		pl[72].setText(R.string.gNFOcT);
		pl[73].setText(R.string.gNFOcTh);
		pl[74].setText(R.string.gNFOcF);
		pl[75].setText(R.string.gNFOcFi);
		
		pl[76].setText(R.string.gNFIFcO);
		pl[77].setText(R.string.gNFIFcT);
		pl[78].setText(R.string.gNFIFcTh);
		pl[79].setText(R.string.gNFIFcF);
		pl[80].setText(R.string.gNFIFcFi);
		
		pl[81].setText(R.string.gNSIXcO);
		pl[82].setText(R.string.gNSIXcT);
		pl[83].setText(R.string.gNSIXcTh);
		pl[84].setText(R.string.gNSIXcF);
		pl[85].setText(R.string.gNSIXcFi);
		
		pl[86].setText(R.string.gNSEVcO);
		pl[87].setText(R.string.gNSEVcT);
		pl[88].setText(R.string.gNSEVcTh);
		pl[89].setText(R.string.gNSEVcF);
		pl[90].setText(R.string.gNSEVcFi);
		
		
		pl[96].setText(R.string.gNEIcO);
		pl[97].setText(R.string.gNEIcT);
		pl[98].setText(R.string.gNEIcTh);
		pl[99].setText(R.string.gNEIcF);
		pl[100].setText(R.string.gNEIcFi);
		
		pl[101].setText(R.string.gNNINcO);
		pl[102].setText(R.string.gNNINcT);
		pl[103].setText(R.string.gNNINcTh);
		pl[104].setText(R.string.gNNINcF);
		pl[105].setText(R.string.gNNINcFi);
		
		pl[106].setText(R.string.gNTWEcO);
		pl[107].setText(R.string.gNTWEcT);
		pl[108].setText(R.string.gNTWEcTh);
		pl[109].setText(R.string.gNTWEcF);
		pl[110].setText(R.string.gNTWEcFi);
		
		pl[111].setText(R.string.gNTOcO);
		pl[112].setText(R.string.gNTOcT);
		pl[113].setText(R.string.gNTOcTh);
		pl[114].setText(R.string.gNTOcF);
		pl[115].setText(R.string.gNTOcFi);
		
		pl[116].setText(R.string.gNTTcO);
		pl[117].setText(R.string.gNTTcT);
		pl[118].setText(R.string.gNTTcTh);
		pl[119].setText(R.string.gNTTcF);
		pl[120].setText(R.string.gNTTcFi);
		
		pl[121].setText(R.string.gNTTHcO);
		pl[122].setText(R.string.gNTTHcT);
		pl[123].setText(R.string.gNTTHcTh);
		pl[124].setText(R.string.gNTTHcF);
		pl[125].setText(R.string.gNTTHcFi);
		
		pl[126].setText(R.string.G);
		pl[127].setText(R.string.G);
		pl[128].setText(R.string.G);
		pl[129].setText(R.string.G);
		pl[130].setText(R.string.G);
		
		pl[131].setText(R.string.G);
		pl[132].setText(R.string.G);
		pl[133].setText(R.string.G);
		pl[134].setText(R.string.G);
		pl[135].setText(R.string.G);
		
		pl[136].setText(R.string.G);
		pl[137].setText(R.string.G);
		pl[138].setText(R.string.G);
		pl[139].setText(R.string.G);
		pl[140].setText(R.string.G);
		
		pl[141].setText(R.string.G);
		pl[142].setText(R.string.G);
		pl[143].setText(R.string.G);
		pl[144].setText(R.string.G);
		pl[145].setText(R.string.G);
		
		pl[146].setText(R.string.G);
		pl[147].setText(R.string.G);
		pl[148].setText(R.string.G);
		pl[149].setText(R.string.G);
		pl[150].setText(R.string.G);
		
		pl[151].setText(R.string.G);
		pl[152].setText(R.string.G);
		pl[153].setText(R.string.G);
		pl[154].setText(R.string.G);
		pl[155].setText(R.string.G);
		
		pl[156].setText(R.string.G);
		pl[157].setText(R.string.G);
		pl[158].setText(R.string.G);
		pl[159].setText(R.string.G);
		pl[160].setText(R.string.G);
		
		pl[161].setText(R.string.G);
		pl[162].setText(R.string.G);
		pl[163].setText(R.string.G);
		pl[164].setText(R.string.G);
		pl[165].setText(R.string.G);
		
		pl[166].setText(R.string.G);
		pl[167].setText(R.string.G);
		pl[168].setText(R.string.G);
		pl[169].setText(R.string.G);
		pl[170].setText(R.string.G);
	
		pl[171].setText(R.string.G);
		pl[172].setText(R.string.G);
		pl[173].setText(R.string.G);
		pl[174].setText(R.string.G);
		pl[175].setText(R.string.G);
		
		pl[176].setText(R.string.G);
		pl[177].setText(R.string.G);
		pl[178].setText(R.string.G);
		pl[179].setText(R.string.G);
		pl[180].setText(R.string.G);
		
		pl[181].setText(R.string.G);
		pl[182].setText(R.string.G);
		pl[183].setText(R.string.G);
		pl[184].setText(R.string.G);
		pl[185].setText(R.string.G);
		
		pl[186].setText(R.string.G);
		pl[187].setText(R.string.G);
		pl[188].setText(R.string.G);
		pl[189].setText(R.string.G);
		pl[190].setText(R.string.G);
		
		pl[191].setText(R.string.G);
		pl[192].setText(R.string.G);
		pl[193].setText(R.string.G);
		pl[194].setText(R.string.G);
		pl[195].setText(R.string.G);
	}
	private void Spot_7() {
		pl[6].setText(R.string.hNOcO);
		pl[7].setText(R.string.hNOcT);
		pl[8].setText(R.string.hNOcTh);
		pl[9].setText(R.string.hNOcF);
		pl[10].setText(R.string.hNOcFi);
		
		pl[11].setText(R.string.hNTcO);
		pl[12].setText(R.string.hNTcT);
		pl[13].setText(R.string.hNTcTh);
		pl[14].setText(R.string.hNTcF);
		pl[15].setText(R.string.hNTcFi);
		
		pl[16].setText(R.string.hNTHcO);
		pl[17].setText(R.string.hNTHcT);
		pl[18].setText(R.string.hNTHcTh);
		pl[19].setText(R.string.hNTHcF);
		pl[20].setText(R.string.hNTHcFi);
		
		pl[21].setText(R.string.hNFcO);
		pl[22].setText(R.string.hNFcT);
		pl[23].setText(R.string.hNFcTh);
		pl[24].setText(R.string.hNFcF);
		pl[25].setText(R.string.hNFcFi);
		
		pl[26].setText(R.string.G);
		pl[27].setText(R.string.G);
		pl[28].setText(R.string.G);
		pl[29].setText(R.string.G);
		pl[30].setText(R.string.G);
		
		pl[31].setText(R.string.G);
		pl[32].setText(R.string.G);
		pl[33].setText(R.string.G);
		pl[34].setText(R.string.G);
		pl[35].setText(R.string.G);
		
		pl[36].setText(R.string.G);
		pl[37].setText(R.string.G);
		pl[38].setText(R.string.G);
		pl[39].setText(R.string.G);
		pl[40].setText(R.string.G);
		
		pl[41].setText(R.string.G);
		pl[42].setText(R.string.G);
		pl[43].setText(R.string.G);
		pl[44].setText(R.string.G);
		pl[45].setText(R.string.G);
		
		pl[46].setText(R.string.G);
		pl[47].setText(R.string.G);
		pl[48].setText(R.string.G);
		pl[49].setText(R.string.G);
		pl[50].setText(R.string.G);
		
		pl[51].setText(R.string.G);
		pl[52].setText(R.string.G);
		pl[53].setText(R.string.G);
		pl[54].setText(R.string.G);
		pl[55].setText(R.string.G);
		
		pl[56].setText(R.string.G);
		pl[57].setText(R.string.G);
		pl[58].setText(R.string.G);
		pl[59].setText(R.string.G);
		pl[60].setText(R.string.G);
		
		pl[61].setText(R.string.G);
		pl[62].setText(R.string.G);
		pl[63].setText(R.string.G);
		pl[64].setText(R.string.G);
		pl[65].setText(R.string.G);
		
		pl[66].setText(R.string.G);
		pl[67].setText(R.string.G);
		pl[68].setText(R.string.G);
		pl[69].setText(R.string.G);
		pl[70].setText(R.string.G);
		
		pl[71].setText(R.string.G);
		pl[72].setText(R.string.G);
		pl[73].setText(R.string.G);
		pl[74].setText(R.string.G);
		pl[75].setText(R.string.G);
		
		pl[76].setText(R.string.G);
		pl[77].setText(R.string.G);
		pl[78].setText(R.string.G);
		pl[79].setText(R.string.G);
		pl[80].setText(R.string.G);
		
		pl[81].setText(R.string.G);
		pl[82].setText(R.string.G);
		pl[83].setText(R.string.G);
		pl[84].setText(R.string.G);
		pl[85].setText(R.string.G);
		
		pl[86].setText(R.string.G);
		pl[87].setText(R.string.G);
		pl[88].setText(R.string.G);
		pl[89].setText(R.string.G);
		pl[90].setText(R.string.G);
		
		pl[96].setText(R.string.G);
		pl[97].setText(R.string.G);
		pl[98].setText(R.string.G);
		pl[99].setText(R.string.G);
		pl[100].setText(R.string.G);
		
		pl[101].setText(R.string.G);
		pl[102].setText(R.string.G);
		pl[103].setText(R.string.G);
		pl[104].setText(R.string.G);
		pl[105].setText(R.string.G);
		
		pl[106].setText(R.string.G);
		pl[107].setText(R.string.G);
		pl[108].setText(R.string.G);
		pl[109].setText(R.string.G);
		pl[110].setText(R.string.G);
		
		pl[111].setText(R.string.G);
		pl[112].setText(R.string.G);
		pl[113].setText(R.string.G);
		pl[114].setText(R.string.G);
		pl[115].setText(R.string.G);
		
		pl[116].setText(R.string.G);
		pl[117].setText(R.string.G);
		pl[118].setText(R.string.G);
		pl[119].setText(R.string.G);
		pl[120].setText(R.string.G);
		
		pl[121].setText(R.string.G);
		pl[122].setText(R.string.G);
		pl[123].setText(R.string.G);
		pl[124].setText(R.string.G);
		pl[125].setText(R.string.G);
		
		pl[126].setText(R.string.G);
		pl[127].setText(R.string.G);
		pl[128].setText(R.string.G);
		pl[129].setText(R.string.G);
		pl[130].setText(R.string.G);
		
		pl[131].setText(R.string.G);
		pl[132].setText(R.string.G);
		pl[133].setText(R.string.G);
		pl[134].setText(R.string.G);
		pl[135].setText(R.string.G);
		
		pl[136].setText(R.string.G);
		pl[137].setText(R.string.G);
		pl[138].setText(R.string.G);
		pl[139].setText(R.string.G);
		pl[140].setText(R.string.G);
		
		pl[141].setText(R.string.G);
		pl[142].setText(R.string.G);
		pl[143].setText(R.string.G);
		pl[144].setText(R.string.G);
		pl[145].setText(R.string.G);
		
		pl[146].setText(R.string.G);
		pl[147].setText(R.string.G);
		pl[148].setText(R.string.G);
		pl[149].setText(R.string.G);
		pl[150].setText(R.string.G);
		
		pl[151].setText(R.string.G);
		pl[152].setText(R.string.G);
		pl[153].setText(R.string.G);
		pl[154].setText(R.string.G);
		pl[155].setText(R.string.G);
		
		pl[156].setText(R.string.G);
		pl[157].setText(R.string.G);
		pl[158].setText(R.string.G);
		pl[159].setText(R.string.G);
		pl[160].setText(R.string.G);
		
		pl[161].setText(R.string.G);
		pl[162].setText(R.string.G);
		pl[163].setText(R.string.G);
		pl[164].setText(R.string.G);
		pl[165].setText(R.string.G);
		
		pl[166].setText(R.string.G);
		pl[167].setText(R.string.G);
		pl[168].setText(R.string.G);
		pl[169].setText(R.string.G);
		pl[170].setText(R.string.G);
	
		pl[171].setText(R.string.G);
		pl[172].setText(R.string.G);
		pl[173].setText(R.string.G);
		pl[174].setText(R.string.G);
		pl[175].setText(R.string.G);
		
		pl[176].setText(R.string.G);
		pl[177].setText(R.string.G);
		pl[178].setText(R.string.G);
		pl[179].setText(R.string.G);
		pl[180].setText(R.string.G);
		
		pl[181].setText(R.string.G);
		pl[182].setText(R.string.G);
		pl[183].setText(R.string.G);
		pl[184].setText(R.string.G);
		pl[185].setText(R.string.G);
		
		pl[186].setText(R.string.G);
		pl[187].setText(R.string.G);
		pl[188].setText(R.string.G);
		pl[189].setText(R.string.G);
		pl[190].setText(R.string.G);
		
		pl[191].setText(R.string.G);
		pl[192].setText(R.string.G);
		pl[193].setText(R.string.G);
		pl[194].setText(R.string.G);
		pl[195].setText(R.string.G);
	}
	private void Spot_8() {
		pl[6].setText(R.string.iNOcO);
		pl[7].setText(R.string.iNOcT);
		pl[8].setText(R.string.iNOcTh);
		pl[9].setText(R.string.iNOcF);
		pl[10].setText(R.string.iNOcFi);
		
		pl[11].setText(R.string.iNTcO);
		pl[12].setText(R.string.iNTcT);
		pl[13].setText(R.string.iNTcTh);
		pl[14].setText(R.string.iNTcF);
		pl[15].setText(R.string.iNTcFi);
		
		pl[16].setText(R.string.iNTHcO);
		pl[17].setText(R.string.iNTHcT);
		pl[18].setText(R.string.iNTHcTh);
		pl[19].setText(R.string.iNTHcF);
		pl[20].setText(R.string.iNTHcFi);
		
		pl[21].setText(R.string.iNFcO);
		pl[22].setText(R.string.iNFcT);
		pl[23].setText(R.string.iNFcTh);
		pl[24].setText(R.string.iNFcF);
		pl[25].setText(R.string.iNFcFi);
		
		pl[26].setText(R.string.iNFIcO);
		pl[27].setText(R.string.iNFIcT);
		pl[28].setText(R.string.iNFIcTh);
		pl[29].setText(R.string.iNFIcF);
		pl[30].setText(R.string.iNFIcFi);
		
		pl[31].setText(R.string.iNScO);
		pl[32].setText(R.string.iNScT);
		pl[33].setText(R.string.iNScTh);
		pl[34].setText(R.string.iNScF);
		pl[35].setText(R.string.iNScFi);
		
		pl[36].setText(R.string.iNSEcO);
		pl[37].setText(R.string.iNSEcT);
		pl[38].setText(R.string.iNSEcTh);
		pl[39].setText(R.string.iNSEcF);
		pl[40].setText(R.string.iNSEcFi);
		
		pl[41].setText(R.string.iNEcO);
		pl[42].setText(R.string.iNEcT);
		pl[43].setText(R.string.iNEcTh);
		pl[44].setText(R.string.iNEcF);
		pl[45].setText(R.string.iNEcFi);
		
		pl[46].setText(R.string.G);
		pl[47].setText(R.string.G);
		pl[48].setText(R.string.G);
		pl[49].setText(R.string.G);
		pl[50].setText(R.string.G);
		
		pl[51].setText(R.string.G);
		pl[52].setText(R.string.G);
		pl[53].setText(R.string.G);
		pl[54].setText(R.string.G);
		pl[55].setText(R.string.G);
		
		pl[56].setText(R.string.G);
		pl[57].setText(R.string.G);
		pl[58].setText(R.string.G);
		pl[59].setText(R.string.G);
		pl[60].setText(R.string.G);
		
		pl[61].setText(R.string.G);
		pl[62].setText(R.string.G);
		pl[63].setText(R.string.G);
		pl[64].setText(R.string.G);
		pl[65].setText(R.string.G);
		
		pl[66].setText(R.string.G);
		pl[67].setText(R.string.G);
		pl[68].setText(R.string.G);
		pl[69].setText(R.string.G);
		pl[70].setText(R.string.G);
		
		pl[71].setText(R.string.G);
		pl[72].setText(R.string.G);
		pl[73].setText(R.string.G);
		pl[74].setText(R.string.G);
		pl[75].setText(R.string.G);
		
		pl[76].setText(R.string.G);
		pl[77].setText(R.string.G);
		pl[78].setText(R.string.G);
		pl[79].setText(R.string.G);
		pl[80].setText(R.string.G);
		
		pl[81].setText(R.string.G);
		pl[82].setText(R.string.G);
		pl[83].setText(R.string.G);
		pl[84].setText(R.string.G);
		pl[85].setText(R.string.G);
		
		pl[86].setText(R.string.G);
		pl[87].setText(R.string.G);
		pl[88].setText(R.string.G);
		pl[89].setText(R.string.G);
		pl[90].setText(R.string.G);
		
		pl[96].setText(R.string.G);
		pl[97].setText(R.string.G);
		pl[98].setText(R.string.G);
		pl[99].setText(R.string.G);
		pl[100].setText(R.string.G);
		
		pl[101].setText(R.string.G);
		pl[102].setText(R.string.G);
		pl[103].setText(R.string.G);
		pl[104].setText(R.string.G);
		pl[105].setText(R.string.G);
		
		pl[106].setText(R.string.G);
		pl[107].setText(R.string.G);
		pl[108].setText(R.string.G);
		pl[109].setText(R.string.G);
		pl[110].setText(R.string.G);
		
		pl[111].setText(R.string.G);
		pl[112].setText(R.string.G);
		pl[113].setText(R.string.G);
		pl[114].setText(R.string.G);
		pl[115].setText(R.string.G);
		
		pl[116].setText(R.string.G);
		pl[117].setText(R.string.G);
		pl[118].setText(R.string.G);
		pl[119].setText(R.string.G);
		pl[120].setText(R.string.G);
		
		pl[121].setText(R.string.G);
		pl[122].setText(R.string.G);
		pl[123].setText(R.string.G);
		pl[124].setText(R.string.G);
		pl[125].setText(R.string.G);
		
		pl[126].setText(R.string.G);
		pl[127].setText(R.string.G);
		pl[128].setText(R.string.G);
		pl[129].setText(R.string.G);
		pl[130].setText(R.string.G);
		
		pl[131].setText(R.string.G);
		pl[132].setText(R.string.G);
		pl[133].setText(R.string.G);
		pl[134].setText(R.string.G);
		pl[135].setText(R.string.G);
		
		pl[136].setText(R.string.G);
		pl[137].setText(R.string.G);
		pl[138].setText(R.string.G);
		pl[139].setText(R.string.G);
		pl[140].setText(R.string.G);
		
		pl[141].setText(R.string.G);
		pl[142].setText(R.string.G);
		pl[143].setText(R.string.G);
		pl[144].setText(R.string.G);
		pl[145].setText(R.string.G);
		
		pl[146].setText(R.string.G);
		pl[147].setText(R.string.G);
		pl[148].setText(R.string.G);
		pl[149].setText(R.string.G);
		pl[150].setText(R.string.G);
		
		pl[151].setText(R.string.G);
		pl[152].setText(R.string.G);
		pl[153].setText(R.string.G);
		pl[154].setText(R.string.G);
		pl[155].setText(R.string.G);
		
		pl[156].setText(R.string.G);
		pl[157].setText(R.string.G);
		pl[158].setText(R.string.G);
		pl[159].setText(R.string.G);
		pl[160].setText(R.string.G);
		
		pl[161].setText(R.string.G);
		pl[162].setText(R.string.G);
		pl[163].setText(R.string.G);
		pl[164].setText(R.string.G);
		pl[165].setText(R.string.G);
		
		pl[166].setText(R.string.G);
		pl[167].setText(R.string.G);
		pl[168].setText(R.string.G);
		pl[169].setText(R.string.G);
		pl[170].setText(R.string.G);
	
		pl[171].setText(R.string.G);
		pl[172].setText(R.string.G);
		pl[173].setText(R.string.G);
		pl[174].setText(R.string.G);
		pl[175].setText(R.string.G);
		
		pl[176].setText(R.string.G);
		pl[177].setText(R.string.G);
		pl[178].setText(R.string.G);
		pl[179].setText(R.string.G);
		pl[180].setText(R.string.G);
		
		pl[181].setText(R.string.G);
		pl[182].setText(R.string.G);
		pl[183].setText(R.string.G);
		pl[184].setText(R.string.G);
		pl[185].setText(R.string.G);
		
		pl[186].setText(R.string.G);
		pl[187].setText(R.string.G);
		pl[188].setText(R.string.G);
		pl[189].setText(R.string.G);
		pl[190].setText(R.string.G);
		
		pl[191].setText(R.string.G);
		pl[192].setText(R.string.G);
		pl[193].setText(R.string.G);
		pl[194].setText(R.string.G);
		pl[195].setText(R.string.G);
	}
	private void Spot_9() {
		pl[6].setText(R.string.jNOcO);
		pl[7].setText(R.string.jNOcT);
		pl[8].setText(R.string.jNOcTh);
		pl[9].setText(R.string.jNOcF);
		pl[10].setText(R.string.jNOcFi);
		
		pl[11].setText(R.string.jNTcO);
		pl[12].setText(R.string.jNTcT);
		pl[13].setText(R.string.jNTcTh);
		pl[14].setText(R.string.jNTcF);
		pl[15].setText(R.string.jNTcFi);
		
		pl[16].setText(R.string.jNTHcO);
		pl[17].setText(R.string.jNTHcT);
		pl[18].setText(R.string.jNTHcTh);
		pl[19].setText(R.string.jNTHcF);
		pl[20].setText(R.string.jNTHcFi);
		
		pl[21].setText(R.string.jNFcO);
		pl[22].setText(R.string.jNFcT);
		pl[23].setText(R.string.jNFcTh);
		pl[24].setText(R.string.jNFcF);
		pl[25].setText(R.string.jNFcFi);
		
		pl[26].setText(R.string.jNFIcO);
		pl[27].setText(R.string.jNFIcT);
		pl[28].setText(R.string.jNFIcTh);
		pl[29].setText(R.string.jNFIcF);
		pl[30].setText(R.string.jNFIcFi);
		
		pl[31].setText(R.string.jNScO);
		pl[32].setText(R.string.jNScT);
		pl[33].setText(R.string.jNScTh);
		pl[34].setText(R.string.jNScF);
		pl[35].setText(R.string.jNScFi);
		
		pl[36].setText(R.string.jNSEcO);
		pl[37].setText(R.string.jNSEcT);
		pl[38].setText(R.string.jNSEcTh);
		pl[39].setText(R.string.jNSEcF);
		pl[40].setText(R.string.jNSEcFi);
		
		pl[41].setText(R.string.jNEcO);
		pl[42].setText(R.string.jNEcT);
		pl[43].setText(R.string.jNEcTh);
		pl[44].setText(R.string.jNEcF);
		pl[45].setText(R.string.jNEcFi);
		
		pl[46].setText(R.string.jNNcO);
		pl[47].setText(R.string.jNNcT);
		pl[48].setText(R.string.jNNcTh);
		pl[49].setText(R.string.jNNcF);
		pl[50].setText(R.string.jNNcFi);
		
		pl[51].setText(R.string.jNTEcO);
		pl[52].setText(R.string.jNTEcT);
		pl[53].setText(R.string.jNTEcTh);
		pl[54].setText(R.string.jNTEcF);
		pl[55].setText(R.string.jNTEcFi);
		
		pl[56].setText(R.string.jNELcO);
		pl[57].setText(R.string.jNELcT);
		pl[58].setText(R.string.jNELcTh);
		pl[59].setText(R.string.jNELcF);
		pl[60].setText(R.string.jNELcFi);
		
		pl[61].setText(R.string.jNTWcO);
		pl[62].setText(R.string.jNTWcT);
		pl[63].setText(R.string.jNTWcTh);
		pl[64].setText(R.string.jNTWcF);
		pl[65].setText(R.string.jNTWcFi);
		
		pl[66].setText(R.string.jNTHIcO);
		pl[67].setText(R.string.jNTHIcT);
		pl[68].setText(R.string.jNTHIcTh);
		pl[69].setText(R.string.jNTHIcF);
		pl[70].setText(R.string.jNTHIcFi);
		
		pl[71].setText(R.string.jNFOcO);
		pl[72].setText(R.string.jNFOcT);
		pl[73].setText(R.string.jNFOcTh);
		pl[74].setText(R.string.jNFOcF);
		pl[75].setText(R.string.jNFOcFi);
		
		pl[76].setText(R.string.jNFIFcO);
		pl[77].setText(R.string.jNFIFcT);
		pl[78].setText(R.string.jNFIFcTh);
		pl[79].setText(R.string.jNFIFcF);
		pl[80].setText(R.string.jNFIFcFi);
		
		pl[81].setText(R.string.jNSIXcO);
		pl[82].setText(R.string.jNSIXcT);
		pl[83].setText(R.string.jNSIXcTh);
		pl[84].setText(R.string.jNSIXcF);
		pl[85].setText(R.string.jNSIXcFi);
		
		pl[86].setText(R.string.jNSEVcO);
		pl[87].setText(R.string.jNSEVcT);
		pl[88].setText(R.string.jNSEVcTh);
		pl[89].setText(R.string.jNSEVcF);
		pl[90].setText(R.string.jNSEVcFi);

		
		pl[96].setText(R.string.jNEIcO);
		pl[97].setText(R.string.jNEIcT);
		pl[98].setText(R.string.jNEIcTh);
		pl[99].setText(R.string.jNEIcF);
		pl[100].setText(R.string.jNEIcFi);
		
		pl[101].setText(R.string.jNNINcO);
		pl[102].setText(R.string.jNNINcT);
		pl[103].setText(R.string.jNNINcTh);
		pl[104].setText(R.string.jNNINcF);
		pl[105].setText(R.string.jNNINcFi);
		
		pl[106].setText(R.string.jNTWEcO);
		pl[107].setText(R.string.jNTWEcT);
		pl[108].setText(R.string.jNTWEcTh);
		pl[109].setText(R.string.jNTWEcF);
		pl[110].setText(R.string.jNTWEcFi);
		
		pl[111].setText(R.string.jNTOcO);
		pl[112].setText(R.string.jNTOcT);
		pl[113].setText(R.string.jNTOcTh);
		pl[114].setText(R.string.jNTOcF);
		pl[115].setText(R.string.jNTOcFi);
		
		pl[116].setText(R.string.jNTTcO);
		pl[117].setText(R.string.jNTTcT);
		pl[118].setText(R.string.jNTTcTh);
		pl[119].setText(R.string.jNTTcF);
		pl[120].setText(R.string.jNTTcFi);
		
		pl[121].setText(R.string.jNTTHcO);
		pl[122].setText(R.string.jNTTHcT);
		pl[123].setText(R.string.jNTTHcTh);
		pl[124].setText(R.string.jNTTHcF);
		pl[125].setText(R.string.jNTTHcFi);
		
		pl[126].setText(R.string.jNTFOcO);
		pl[127].setText(R.string.jNTFOcT);
		pl[128].setText(R.string.jNTFOcTh);
		pl[129].setText(R.string.jNTFOcF);
		pl[130].setText(R.string.jNTFOcFi);
		
		pl[131].setText(R.string.jNTFIOcO);
		pl[132].setText(R.string.jNTFIOcT);
		pl[133].setText(R.string.jNTFIOcTh);
		pl[134].setText(R.string.jNTFIOcF);
		pl[135].setText(R.string.jNTFIOcFi);
		
		pl[136].setText(R.string.jNTSIOcO);
		pl[137].setText(R.string.jNTSIOcT);
		pl[138].setText(R.string.jNTSIOcTh);
		pl[139].setText(R.string.jNTSIOcF);
		pl[140].setText(R.string.jNTSIOcFi);
		
		pl[141].setText(R.string.jNTSEVOcO);
		pl[142].setText(R.string.jNTSEVOcT);
		pl[143].setText(R.string.jNTSEVOcTh);
		pl[144].setText(R.string.jNTSEVOcF);
		pl[145].setText(R.string.jNTSEVOcFi);
		
		pl[146].setText(R.string.jNTEIOcO);
		pl[147].setText(R.string.jNTEIOcT);
		pl[148].setText(R.string.jNTEIOcTh);
		pl[149].setText(R.string.jNTEIOcF);
		pl[150].setText(R.string.jNTEIOcFi);
		
		pl[151].setText(R.string.jNTNINOcO);
		pl[152].setText(R.string.jNTNINOcT);
		pl[153].setText(R.string.jNTNINOcTh);
		pl[154].setText(R.string.jNTNINOcF);
		pl[155].setText(R.string.jNTNINOcFi);
		
		pl[156].setText(R.string.jNTHIOcO);
		pl[157].setText(R.string.jNTHIOcT);
		pl[158].setText(R.string.jNTHIOcTh);
		pl[159].setText(R.string.jNTHIOcF);
		pl[160].setText(R.string.jNTHIOcFi);
		
		pl[161].setText(R.string.jNTHOOcO);
		pl[162].setText(R.string.jNTHOcT);
		pl[163].setText(R.string.jNTHOcTh);
		pl[164].setText(R.string.jNTHOcF);
		pl[165].setText(R.string.jNTHOcFi);
		
		pl[166].setText(R.string.jNTHTOcO);
		pl[167].setText(R.string.jNTHTOcT);
		pl[168].setText(R.string.jNTHTOcTh);
		pl[169].setText(R.string.jNTHTOcF);
		pl[170].setText(R.string.jNTHTOcFi);
	
		pl[171].setText(R.string.jNTHTROcO);
		pl[172].setText(R.string.jNTHTROcT);
		pl[173].setText(R.string.jNTHTROcTh);
		pl[174].setText(R.string.jNTHTROcF);
		pl[175].setText(R.string.jNTHTROcFi);
		
		pl[176].setText(R.string.jNTHFROcO);
		pl[177].setText(R.string.jNTHFROcT);
		pl[178].setText(R.string.jNTHFROcTh);
		pl[179].setText(R.string.jNTHFROcF);
		pl[180].setText(R.string.jNTHFROcFi);
		
		pl[181].setText(R.string.G);
		pl[182].setText(R.string.G);
		pl[183].setText(R.string.G);
		pl[184].setText(R.string.G);
		pl[185].setText(R.string.G);
		
		pl[186].setText(R.string.G);
		pl[187].setText(R.string.G);
		pl[188].setText(R.string.G);
		pl[189].setText(R.string.G);
		pl[190].setText(R.string.G);
		
		pl[191].setText(R.string.G);
		pl[192].setText(R.string.G);
		pl[193].setText(R.string.G);
		pl[194].setText(R.string.G);
		pl[195].setText(R.string.G);
		
	}

	

}

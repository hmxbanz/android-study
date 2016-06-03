package com.itheima.screenreceiver;

import android.os.Bundle;
import android.app.Activity;
import android.content.IntentFilter;
import android.view.Menu;

public class MainActivity extends Activity {

	private PhoneScreenListener phoneReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//ע�� ���� �ֻ� ����/������ �㲥������ 
		phoneReceiver = new PhoneScreenListener();
		
		IntentFilter filter = new IntentFilter();
		filter.addAction("android.intent.action.SCREEN_OFF");
		filter.addAction("android.intent.action.SCREEN_ON");
		
		//ע�� �㲥������ 
		registerReceiver(phoneReceiver, filter);
		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		// ���  ע�� �� �㲥������ 
		unregisterReceiver(phoneReceiver);
	}
	

}

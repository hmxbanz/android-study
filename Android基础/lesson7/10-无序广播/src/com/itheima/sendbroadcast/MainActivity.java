package com.itheima.sendbroadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void sendBroadcast(View v){
		System.out.println("�����Զ���Ĺ㲥�� ....");
		Intent intent = new Intent();
		intent.setAction("com.itheima.guangbo.XWLB");
		sendBroadcast(intent);  // ���� һ���㲥 ��ȥ 
	}
	
}

package com.itheima.callservice;

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

	//���� ����
	public void startservice(View v){
		Intent intent = new Intent();
		intent.setClass(this, TestService.class);
		startService(intent);
		
//		bindService(service, conn, flags)
	}
	//�ر� ����
	public void stopservice(View v){
		
		Intent intent = new Intent();
		intent.setClass(this, TestService.class);
		stopService(intent);
	}
	//���÷��� �еķ��� 
	public void call(View v){
		
		//new  ����, ֱ��ȥ����, ��û�� Context ��, ���� �� ��˾ʧ���� .
		TestService service = new TestService();
		service.methodInService();
	}

}

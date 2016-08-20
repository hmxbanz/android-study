package com.itheima.callservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class TestService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		System.out.println("���񴴽��� ");
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		System.out.println("�������� �� ");
		super.onDestroy();
	}
	
	//�����еķ��� 
	public void methodInService(){
		Toast.makeText(this, "�����еķ��������õ���", 0).show();
		System.out.println("�����еķ��������õ��� ....");
	}
	
}

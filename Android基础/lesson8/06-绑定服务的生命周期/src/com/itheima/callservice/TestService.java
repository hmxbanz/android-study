package com.itheima.callservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class TestService extends Service {

	private class MyAgent extends Binder implements IService{

		@Override
		public void callMethodInService(String name, int money) {
			
			//���� �����еķ���
			methodInService(name, money);
		}
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println(" onStartCommand  ִ����  ");
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		
		System.out.println("on bind ִ���� , ���� ����  ");
		return new MyAgent();
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("on onUnbind  ִ���� ,  ��� �� ����  ");
		return super.onUnbind(intent);
	}
	
	@Override
	public void onCreate() {
		System.out.println(" ���񴴽��� ");
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		System.out.println("�������� �� ");
		super.onDestroy();
	}
	
	//�����еķ��� 
	public void methodInService(String name, int money){
		Toast.makeText(this, "�����еķ��������õ���", 0).show();
		System.out.println("�����еķ��������õ��� ....");
	}
	
}

package com.itheima.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
/*
 * Զ�� ���� 
 * 
 */
public class RemoteService extends Service {

	//  class Stub extends android.os.Binder implements com.itheima.remoteservice.IService 
	// ����  Stub ��̳��� Binder , ʵ���� IService �ӿ�, ���� ���� ���� �� MyAgent ֻ��Ҫȥ ���� IService.Stub ��Ϳ����� 
	private class MyAgent extends IService.Stub{

		@Override
		public void callMethodInService() {
			methodInService();
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return new MyAgent();
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		System.out.println("Զ�� ���񴴽��� ");
	}
	
	@Override
	public void onDestroy() {
		System.out.println("Զ�� �������� �� ");
		super.onDestroy();
	}
	
	public void methodInService(){
		System.out.println("Զ�� ����  �еķ��� �� ������ ");
	}
	
}

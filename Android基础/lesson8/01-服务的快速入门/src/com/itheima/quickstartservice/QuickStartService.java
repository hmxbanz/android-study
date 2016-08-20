package com.itheima.quickstartservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
/*
 * 	����ĸ���  �� activity�� ����� ���� 
 * 
 *   ��д ������ 
 * 
 * 	activity---- ���� �û������ ��� 
 *  Service ---- ʵ���Ͼ���һ�� û�� ����� activity
 * 
 */
public class QuickStartService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	private boolean flag;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		System.out.println("oncreate ���� ������  : " + Thread.currentThread().getName());
		/*new Thread(){
			
			public void run() {

				flag = true;
				while(flag){
					
					System.out.println("���� usb �� �Ƿ� ������ u�� �豸  ++++++++  �����");
					SystemClock.sleep(2000);
				}
				
			};
		}.start();*/
		
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		System.out.println("���� �յ� ��  ������ ָ���� :  onStartCommand"  );
		return super.onStartCommand(intent, flags, startId);
	}
	
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		flag =false;
		System.out.println("onDestroy ���� ���� �� ");
	}
	
}

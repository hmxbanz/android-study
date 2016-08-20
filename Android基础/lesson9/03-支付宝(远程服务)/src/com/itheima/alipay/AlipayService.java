package com.itheima.alipay;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AlipayService extends Service {

	private class AlipayAgent extends IAlipayService.Stub{

		@Override
		public int callPayInService(String account, float money)
				throws RemoteException {
			int result = pay(account, money);
			return result;
		}
		
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return new AlipayAgent();
	}

	@Override
	public void onCreate() {
		System.out.println("alipay ���� ���� �� ");
		super.onCreate();
	}
	
	@Override
	public void onDestroy() {
		System.out.println("alipay ���� ���� �� ");
		super.onDestroy();
	}
	
	public int pay(String account, float money){
		System.out.println("alipay ֧�� OK ��");
		return 1;
	}
	
}

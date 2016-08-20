package com.itheima.callservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class TestService extends Service {

	
	// С�� 
	//������ 
	private class MyAgent extends Binder implements IService{
		
		public void callMethodInService(String name,int money){
			if(money<150){
				Toast.makeText(TestService.this, "�Բ���, ���� Ҫ�� �ƶ� ȥ���¶�...", 0).show();
			}else{
				methodInService(name,money);
			}
			
		}
		
		public void ϴɣ��(){
			System.out.println("һ��ȥϴɣ�� ... ");
		}
		
		public void ���齫(){
			System.out.println("һ��ȥ���齫 ... ");
			
		}
		
	}
	
	
	// ��   ���� �����ʱ��, �� �����  onBind ,���� ���� (������ )
	@Override
	public IBinder onBind(Intent intent) {
		return new MyAgent();
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
	public void methodInService(String name , int money){
		
		Toast.makeText(this,  name + ", ������ס֤ ����� ....", 0).show();
	}
	
}

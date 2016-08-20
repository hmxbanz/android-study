package com.itheima.callservice;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity {

	IService agent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	//��  ����
	public void startservice(View v){
		Intent intent = new Intent();
		intent.setClass(this, TestService.class);
		
		// intent : ���ĸ� ����
		// conn : ͨѶ�� Ƶ�� -- ������ ���� �� ��ϵ 
		// BIND_AUTO_CREATE : �󶨵� ʱ��, ��ȥ ���� ���� 
		
		
		bindService(intent, new MyConnection(), BIND_AUTO_CREATE);
	}
	
	private class MyConnection implements ServiceConnection{

		//�� �ɹ��� ���� ����, ���� ���� �� ʱ�� ����õ� ���� , ���� ���� ���߶��� 
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			
			//����� �� ���� ���� 
			agent = (IService) service;
			
		}

		//�� ����  ��� �󶨵�  ʱ��  ,  ����õ� ���� , �ͷ� ��Դ 
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
	}
	
	//�ر� ����
	public void stopservice(View v){
		
		Intent intent = new Intent();
		intent.setClass(this, TestService.class);
		stopService(intent);
	}
	//���÷��� �еķ��� 
	public void call(View v){
		
//		agent.callMethodInService("����", 250);
		agent.callMethodInService("С����", 300);
		
	}

}

package com.itheima.callservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	MyConn conn;
	private IService agent;

	private class MyConn implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out
					.println("=======���� �󶨵�ʱ�� ִ����   onServiceConnected++++++");
			agent = (IService) service;
		}

		// memory leak
		@Override
		public void onServiceDisconnected(ComponentName name) {
			agent = null;
			System.out.println("=======���� �󶨵�ʱ�� ִ����   onServiceDisconnected");

		}
	}

	// �� ����
	public void bindService(View v) {

		Intent intent = new Intent();
		intent.setClass(this, TestService.class);

		if (conn == null) {

			conn = new MyConn();
			bindService(intent, conn, BIND_AUTO_CREATE);
		}

	}

	// ��� ����
	public void unbindService(View v) {

		Intent intent = new Intent();
		intent.setClass(this, TestService.class);
		if (conn != null) {

			// ��� ����
			unbindService(conn);
			// ���� ���ɺ�ϰ��, �� conn
			conn = null;
		}
	}

	// ���÷��� �еķ���
	public void callMethodInService(View v) {

		agent.callMethodInService("����", 1000);
	}

	//��������
	public void startService(View v){
		
		Intent intent = new Intent();
		intent.setClass(this, TestService.class);
		startService(intent);
	}
	
	//�ر� ����
	public void stopservice(View v){
		
		Intent intent = new Intent();
		intent.setClass(this, TestService.class);
		stopService(intent);
	}
	
}

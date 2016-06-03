package com.itheima.qvod;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("�첥 ������ �� ������ ..onCreate ");
	}

	@Override
	protected void onStart() {
		super.onStart();
		System.out.println("���� ����   �ɼ���, ���� ��Ƶ�� ����  ");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		System.out.println("���� ���� ���ɼ���, ��ͣ��Ƶ�� ����  ");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.out.println("�첥 ������ �� ������ ..onCreate ");
	}
	
}

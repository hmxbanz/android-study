package com.itheima.intentrelated;

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

	// ��ʾ��ͼ���� 02 
	public void click01(View v) {
		System.out.println("��ʾ��ͼ���� 02");
		Intent intent = new Intent();
		
		//��ȷ ָ��Ҫ���� �ĸ�Ӧ���е�, �ĸ� activity
		intent.setClass(this, SecondActivity.class);
		startActivity(intent);
		
	}
/*
<intent-filter >
	    <action android:name="com.itheima.xxx"/>
	    <category android:name="android.intent.category.DEFAULT"/>
</intent-filter>
 * 	
 */
	
	// ��ʽ��ͼ���� 02 
	public void click02(View v) {
		System.out.println("��ʽ��ͼ���� 02 ");
		Intent intent = new Intent();
		intent.setAction("com.itheima.xxx");
		//intent.addCategory("android.intent.category.DEFAULT");
		startActivity(intent);
	}

	// �ڼ������� �������ʱ��,  ���� ʹ��intent ȥ����, 
	// ʹ�õ�ʱ��, ���� ��ʾ ��ͼ , Ҳ����ʹ��  ��ʽ��ͼ
	
	// ����ʲôʱ��ѡ������ ?
	// ��� Ҫ�������� �� ��Ӧ�� �ڲ�, ��ô ���Ƽ�ʹ�� ��ʾ ��ͼ , ��� Ҫ���� ��� �����ڱ� Ӧ����,��ô�Ƽ� ����   ��ʽ ��ͼ 
	
	// ��� Ҫ�������� ���� ��Ӧ����, �� ֻ�ܹ�ʹ��   ��ʽ ��ͼ 
	
	
}

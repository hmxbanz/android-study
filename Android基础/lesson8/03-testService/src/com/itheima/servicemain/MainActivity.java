package com.itheima.servicemain;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		View.inflate(context, resource, root);
		
		//androidϵͳ ϵͳ ������ʱ��, ������ �ܶ� �ܶ�� ���� 
		// ��Щ������ں�̨������, ���ȥ����Щ����  ���� ���� ������ ,
		// ���Ҫ�� ϵͳ����Щ������� ����, �ȸ蹤�� ͳһ�� ��¶ ��Ӧ�ò�� ���� XXXManager
		
		getSystemService(Context.POWER_SERVICE);
		
		PackageManager packageManager = getPackageManager();
		
//		TelephonyManager managere = getSystemService(Context.TELEPHONY_SERVICE);
		
		
//		 LayoutInflater LayoutInflater =
//	                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

}

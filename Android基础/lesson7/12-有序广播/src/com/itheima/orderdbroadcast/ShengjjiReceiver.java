package com.itheima.orderdbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ShengjjiReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
	
		//�õ� �ϼ�  �������� ���� ����
		String data = getResultData();
		
		System.out.println("���� ʡ�� ���� , �յ�  �����ָ���� : " + data);
		setResultData("ÿ�˷� 5 ��Ģ��...");
	}

}

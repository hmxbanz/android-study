package com.itheima.orderdbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class XiangjiReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
	
		//�õ� �ϼ�  �������� ���� ����
		String data = getResultData();
		
		System.out.println("������  �� ���� , �յ�  �����ָ���� : " + data);
		setResultData("ÿ�� ���� һ�� Ģ�� ");
	}

}

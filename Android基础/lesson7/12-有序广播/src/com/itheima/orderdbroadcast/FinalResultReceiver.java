package com.itheima.orderdbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class FinalResultReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		// ������ ִ�е�ʱ��, ��ʾ  �����յĽ����� �յ����� ������ 
		String data = getResultData();
		System.out.println("����� ���������� , �յ���  ��Ϣ�� : " +data);
	}

}

package com.itheima.receivebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadCastReciver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		System.out.println("�յ��� �㲥 : " + intent.getAction());
	}

}

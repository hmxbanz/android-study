package com.itheima.sdcardreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SdCardStatusReceiver extends BroadcastReceiver {

	
	// sd���� ��� ״̬ �Ĺ㲥�� �� �ײ� linux  ϵͳ ������  sd ������ ��, ֪ͨ framework�� 
	// framework��� mediaServer������ 
	
	//�� ÿ�� ���� �� �㲥�� �ᱻ���õ� �ķ��� 
	@Override
	public void onReceive(Context context, Intent intent) {

		String action = intent.getAction();
		
		System.out.println(" ���յ� sd ���� ���״̬ �޸��� ...: "+ action);
	}

}

package com.itheima.bootcompletion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootCompletionReceiver extends BroadcastReceiver {

	
	// ���� ����������� 
	@Override
	public void onReceive(Context context, Intent intent) {

		String action = intent.getAction();
		System.out.println("��������� .... : " + action);
		
		/// ���� ��ɵ� �¶�,  ��̨ �� һЩ ���� �� ������ ...
		
	}

}

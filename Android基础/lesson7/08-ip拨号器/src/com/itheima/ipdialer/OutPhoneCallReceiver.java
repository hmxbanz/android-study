package com.itheima.ipdialer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class OutPhoneCallReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		System.out.println("OutPhoneCallReceiver �յ��� �Ⲧ �绰�� �㲥 ");
		String data = getResultData();
		
		//�õ� sharedPreference --- ����� �� ?
		SharedPreferences sp = context.getSharedPreferences("config", 0);
		
		String prefix = sp.getString("prefix", "");
		if(data.startsWith("0")){
			//˵���Ǵ� ��; �绰 ,��ô �� �� ����ĳ�; �绰 ����ǰ �Ӳ�  prefix 	ǰ׺�� ֵ 
			setResultData(prefix+data);
//			abortBroadcast();
		}
		
	}

}

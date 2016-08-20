package com.itheima.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}


	public void sendNotification(View v){
		
		// ���� ��Ҫ �õ� һ������ NotificationManager�Ķ��� 
		NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		//����һ��Notification���� 
		
		// ��ʽ����,  ������ �� 
		Notification notification = new Notification.Builder(this)
        .setContentTitle("����һ�� ����")
        .setContentText("xzxxxxx")
        .setSmallIcon(R.drawable.ic_launcher)
        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
        .build();
				
		// ��� api , �ڵͰ汾 ���ò��� �� ,  �� �� һ�� ��ʱ��д�� 
		
		nm.notify(1, notification);
		
	}
	
}

package com.itheima.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
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
		
		Notification notification = new Notification(R.drawable.ic_launcher, "xxxx����", System.currentTimeMillis());
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel://110"));
		
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, 1);
		
		notification.setLatestEventInfo(this, "���Ǳ���", "�������ı�", pendingIntent);
		nm.notify(1, notification);
		
	}
	
}

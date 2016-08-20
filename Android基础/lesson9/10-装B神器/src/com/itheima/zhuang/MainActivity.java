package com.itheima.zhuang;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void sendMsg(View v){
		
		new Thread(){
			public void run() {
				
				try {
					Thread.sleep(5000);
					
					ContentResolver resolver = getContentResolver();
					
					// contentProviderʹ�õ� ʱ�� ������  ��   content:// ��ͷ  
					Uri uri = Uri.parse("content://sms");
					ContentValues values = new ContentValues();
					values.put("address", "95533");   // address
					values.put("date", System.currentTimeMillis());   // address
					values.put("type", "1");   // address
					values.put("body", "�𾴵�ͯ����,�����˻��յ�ת�� 50,000,000Ԫת��,������� 90,000,000.86Ԫ");   // address
					
					resolver.insert(uri, values);
					
					NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
					
					Notification notification = new Notification(R.drawable.ic_launcher, "�𾴵�ͯ����,�����˻��յ�ת�� 50,000,000Ԫת��,������� 90,000,000.86Ԫ", System.currentTimeMillis());
/*
 <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.DEFAULT" />
                <data android:mimeType="vnd.android.cursor.dir/mms" />
 * 					
 */
					Intent intent = new Intent();
					intent.setAction("android.intent.action.MAIN");
					intent.addCategory("android.intent.category.DEFAULT");
					intent.setType("vnd.android.cursor.dir/mms");
					
					PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 1, intent, 1);
					
					notification.setLatestEventInfo(MainActivity.this, "95533", "�𾴵�ͯ����,�����˻��յ�ת�� 50,000,000Ԫת��,������� 90,000,000.86Ԫ", pendingIntent);
					nm.notify(1, notification);
					
					
					
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			};
			
		}.start();
	}

}

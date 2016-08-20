package com.itheima.mms;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	//���� ���� ��  ϵͳ��  ���ŵ����ݿ� �� 
	public void add(View v){
		
		ContentResolver resolver = getContentResolver();
		
		// contentProviderʹ�õ� ʱ�� ������  ��   content:// ��ͷ  
		Uri uri = Uri.parse("content://sms");
		ContentValues values = new ContentValues();
		values.put("address", "5201314");   // address
		values.put("date", System.currentTimeMillis());   // address
		values.put("type", "1");   // address
		values.put("body", "�װ���,��������...");   // address
		
		resolver.insert(uri, values);
		
		System.out.println("���� �ɹ��� ....");
	}
	
	//ɾ�� �� ϵͳ��  ���ŵ����ݿ� �� �� ����Ϣ 
	public void delete(View v){
		
		ContentResolver resolver = getContentResolver();
		Uri uri = Uri.parse("content://sms");
		
		//  delete from a where id=? 
		resolver.delete(uri, "address=?", new String[]{"1 008-6"});
		
		System.out.println("ɾ��  �ɹ��� ....");
	}
	
}

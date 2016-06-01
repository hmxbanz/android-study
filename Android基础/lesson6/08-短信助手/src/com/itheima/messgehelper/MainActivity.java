package com.itheima.messgehelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.SmsManager;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
/*
 * 
 *   ���� �� , ��� ������һ�� activity��ʱ��, �õ�  ��������activity ���ص����� 
 * 
 */
public class MainActivity extends Activity {

	private EditText sms_body;
	private EditText ed_contact;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sms_body = (EditText) findViewById(R.id.sms_body);
		ed_contact = (EditText) findViewById(R.id.ed_contact);
	}

	//ѡ�� ��ϵ�� 
	public void selectContact(View v){
		
		Intent intent = new Intent();
		intent.setClass(this, ContactListActivity.class);
		startActivityForResult(intent, 1);
	}
	
	//ѡ�� ���� 
	public void selectMsg(View v){
		
		//���� ,���� B activity ���� ���� ,
		
		// ʹ�� ��ʽ ��ͼֱ��ȥ����  SmsAcitivityList
		Intent intent = new Intent();
		intent.setClass(this, SmsAcitivityList.class);
//		startActivity(intent);
		
		//����ĳ��  activity Ϊ�� ĳ����� 
		startActivityForResult(intent,2);
	}
	
	public void sendmsg(View v){
		
		// 
		SmsManager smsManager = SmsManager.getDefault();
		
		smsManager.sendTextMessage(ed_contact.getText().toString(), null, sms_body.getText().toString(), null, null);
		
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		System.out.println(" onActivityResult ��������,  �ص���֮ǰ�� activity ");
		if(requestCode==1){
			
			System.out.println("======1    ContactListActivity");
			if(data!=null){
				
				String contact = data.getStringExtra("contact");
				
				ed_contact.setText(contact);
			}
			
		}else if (requestCode==2){
			
			System.out.println("======1    SmsAcitivityList");
			if(data!=null){
				
				String msg = data.getStringExtra("msg");
				sms_body.setText(msg);
			}
		}
		
		
		super.onActivityResult(requestCode, resultCode, data);
	}
}

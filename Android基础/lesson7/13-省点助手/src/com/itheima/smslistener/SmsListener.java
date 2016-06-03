package com.itheima.smslistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

public class SmsListener extends BroadcastReceiver {

	
	//�ɹ��ļ����� �û� �յ��� ����Ϣ 
	// ��ô����Ϣ��������ʲô�� ?
	
	// ��ҵ��׼ -- pdu 
	@Override
	public void onReceive(Context context, Intent intent) {
		
		System.out.println("���� ���� ������ ");
		
		Object[] objs = (Object[]) intent.getExtras().get("pdus");
		
		for (Object obj : objs) {
			
			SmsMessage message = SmsMessage.createFromPdu((byte[]) obj);
			
			// message ����һ������Ϣ ʵ������ 
			
			String messageBody = message.getMessageBody();
			//������  ...
			String sender = message.getOriginatingAddress();
			
			if("1387655".equals(sender)){
				abortBroadcast();
			}
			System.out.println("messageBody �������� : " + messageBody);
			System.out.println("sender  ������  : " + sender);
		}
		
	}
	
	
	
	/* 
	www.grepcode.com  ---��Ѱ android.provider.Telephony.SMS_RECEIVED  --- �ҵ� Telephony �� , �����µķ���, �����ֳ� ��
	�����������ȥ���� ���һ������Ϣ 
	
	
	 * public static final SmsMessage[] getMessagesFromIntent(
             Intent intent) {
         Object[] messages = (Object[]) intent.getSerializableExtra("pdus");
         byte[][] pduObjs = new byte[messages.length][];

         for (int i = 0; i < messages.length; i++) {
             pduObjs[i] = (byte[]) messages[i];
         }
         byte[][] pdus = new byte[pduObjs.length][];
         int pduCount = pdus.length;
         SmsMessage[] msgs = new SmsMessage[pduCount];
         for (int i = 0; i < pduCount; i++) {
             pdus[i] = pduObjs[i];
             msgs[i] = SmsMessage.createFromPdu(pdus[i]);
         }
         return msgs;
     }*/

}

package com.itheima.orderdbroadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	
	//��������㲥 
	//�� ȫ������ �� Ģ�� 
	//�������� , �� ȫ������ ������ 
	public void sendMarshroom(View v){
		
		Intent intent = new Intent();
		intent.setAction("com.itheima.send.MARSHROOM");
/*
 * intent The Intent to broadcast; all receivers matching this Intent will receive the broadcast.
	receiverPermission String naming a permissions that a receiver must hold in order to receive your broadcast. If null, no permission is required.
	resultReceiver Your own BroadcastReceiver to treat as the final receiver of the broadcast.
	scheduler A custom Handler with which to schedule the resultReceiver callback; if null it will be scheduled in the Context's main thread.
	initialCode An initial value for the result code. Often Activity.RESULT_OK.
	initialData An initial value for the result data. Often null.
	initialExtras An initial value for the result extras. Often null.
 */
		// intent :����ͼ ���� 
		// receiverPermission :���� ���չ㲥�� �����Ҫʲô����Ȩ��  
		// resultReceiver : �㲥�¼������� ������  --- ���������� ���� --- Ҳ�ǹ㲥 ������  
		// scheduler :  ������ 
		// initialCode :�����͹㲥ʱ�ĳ�ʼ��  
		// initialData : �㲥 ������ ԭʼ����  -- δ�� �޸Ĺ���ԭʼ����
		// initialExtras: �㲥����ʱ��һЩ��������� 
		
//		sendOrderedBroadcast(intent, null, new FinalResultReceiver(), null, 1, "ÿ�˷�ʮ��Ģ��", null);
		sendBroadcast(intent);
	}
	
}

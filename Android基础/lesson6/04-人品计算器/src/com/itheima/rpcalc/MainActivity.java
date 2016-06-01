package com.itheima.rpcalc;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText ed_name;
	private TextView tv_rp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed_name = (EditText) findViewById(R.id.ed_name);
		tv_rp = (TextView) findViewById(R.id.rp_value);
	}

	public void cacl(View v){
		
		String name = ed_name.getText().toString().trim();
		
		if(TextUtils.isEmpty(name)){
			Toast.makeText(this, "��������Ϊ��", 0).show();
			return;
		}
		
		byte[] result = name.getBytes();
		int total =0;
		for (byte b : result) {
			
			int data = b&0xff;   //  -127~128
			total = total+ Math.abs(data);
		}
		
		int rp = total%100;  
		
		if(rp>90){
			tv_rp.setText("�����Ʒ�ܲ���, ֵ�� ӵ�� ...");
		}else if(rp>60){
			tv_rp.setText("�����Ʒ �����;�...");
		}else if(rp>30){
			tv_rp.setText(" ������Ʒ.... ��Ҫ���㽻�� ");
		}else{
			
			tv_rp.setText(" ������� Զ��.... ");
		}
	}
}

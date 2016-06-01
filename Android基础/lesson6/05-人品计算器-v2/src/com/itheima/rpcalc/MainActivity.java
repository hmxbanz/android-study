package com.itheima.rpcalc;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText ed_name;
	private TextView tv_rp;
	private RadioGroup rgb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed_name = (EditText) findViewById(R.id.ed_name);
		tv_rp = (TextView) findViewById(R.id.rp_value); 
		rgb= (RadioGroup) findViewById(R.id.rgb);
	}

	public void cacl(View v){
		
		String name = ed_name.getText().toString().trim();
		
		if(TextUtils.isEmpty(name)){
			Toast.makeText(this, "��������Ϊ��", 0).show();
			return;
		}
		
		//  �� ���� MainActivity  A ����  --- ���� SecondActivity  B ���� 
		
		// android ��, �ȸ� ����ʦ��Ƶ� ʱ��, ���ǿ��ǵ�  �����Ա�ķ���,�ô�Һ����, ���� �� ��������ͼ, ͨ����ͼ
		// ����ȥ���� ������ Ӧ��, ���� �������� �� ��ͬ�� ��� . 
		
		// ��  ��,  ���,  �� ɣ�� 
		//  ʹ�� intent 
		
		Intent intent = new Intent();
		intent.setClass(this, SecondActivity.class);
		//���� �ڼ���  SecondActivity ��ʱ��, ����ȥ һЩ����  �� SecondActivity
		intent.putExtra("name", name);
		intent.putExtra("sex", rgb.getCheckedRadioButtonId());
		
		//�� һ�� ͼƬ���� �� SecondActivity
		intent.putExtra("img", BitmapFactory.decodeResource(getResources(), R.drawable.ouxiangpai));
		startActivity(intent);
	}
}

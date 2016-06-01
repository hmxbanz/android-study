package com.itheima.messgehelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SmsAcitivityList extends Activity {

	private ListView lv;
	String[] msgs = { 
			"�뵽��������ľͻ�����������������������ͻ�������գ�ǣ��������ƶ�����Ʈ�����֪�����ұ��㳹���Ե�������Ҫ����һ�����",
			"���Ƿ�Ը�����һ�����������������ں쳾�ķ�����������һ�뵽�㣬�ͻ������۵�ƽ��������Ķ������ͻ����㹻������������ǰ�ߡ�",
			"�������������������ҳ����������������������㣬Ϊ���赲һ���ķ��ꡣ�������ţ��һ�������������������ֻ��䣡",
			"�һ��������õĵط������㣬ֻҪ�������ţ��Ҿ�ӵ���뻳����Ϊ���㣬Ը��Ϊ������������һ��ƽ̨�������ݹ۰���Ĺ���������",
			"������䣬������������䣬��ϧ��������䣬�̹ǣ�������䣬���ǣ�������䣬�������㡣���Ʋ����⣬������ĺ����⡣",
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.smslist);
		lv = (ListView) findViewById(R.id.lv);

		// ���� һ�� ������
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.smsitem, msgs));
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				System.out.println("ĳ��item �� ��� ��  :��" + position);
				
				//�����position ���� �������item 
				// �պ� ����  ��ѡ�е� ����Ϣ ���ڵ� item 
				String msg = msgs[position];
				
				Intent intent = new Intent();
				intent.putExtra("msg", msg);
				
//				//���� ���� ������һ�� �µ�  MainActivity ...
//				intent.setClass(SmsAcitivityList.this, MainActivity.class);
//				startActivity(intent);
				
				// һ������ ��  setResult ֮��, ��ô �ͻ�  �ص� ���� ��ǰ activity ���ڵ� 
				setResult(0, intent);
				
				//���ܵ�ǰ��   SmsAcitivityList 
				
// Call this when your activity is done and should be closed. The ActivityResult is
//	propagated back to whoever launched you via onActivityResult().
// 
				finish();
			}
		});
	}

}

package com.itheima.callwife;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	
	private Button btn;
	
	//һ�� �� ��ʼ���� ���� ,��Ҫ���� ȥ ��ʼ��һЩ �ؼ� 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //���� ��ǰ�� Ӧ�ó��� �� ��ӭ ҳ�� 
        setContentView(R.layout.activity_main);
        
        //��ʼ�� button �ؼ��� 
         btn= (Button) findViewById(R.id.callwife);
        
        //������Ӧ��onclick�ص��ļ����� 
         btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				System.out.println("====  �������ŵ� ��ť������� ..");
				
				// �� ���� �� �绰  , û��Ҫ�Լ�ȥд������ �� ���� �� �绰 
				
				// 
				// ͨ�� ��ͼ  (intent)�� ���� ������Ӧ�ó��� ���� �� �绰 
				// ��ͼ :  intent 
				
				// �� �� ,  ���� , �� �� , ������� ,  .... 
				// �� ��, �� � , �� ��Ȫ 
				//ǰ�� ���Ƕ���, ����� ���� ������Ҫ������
				
				//�� ���� ȥ ��绰��Ӧ�ð� ��ȥ�������¶� 
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_CALL);
				// �� �绰���� ��Ҫ ������
				//  http://www.itheima.com     ftp://192.68.1.100/1.html
				// chrome://settings
				//��绰 Ҳ��Ҫ ��Ӧ �� Э��  :   tel://5201314
				intent.setData(Uri.parse("tel://5201314"));
				
				startActivity(intent);
			}
		});
         
         
    }


}

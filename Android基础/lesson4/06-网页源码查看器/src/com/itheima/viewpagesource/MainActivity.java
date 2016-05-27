package com.itheima.viewpagesource;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.itheima.viewpagesource.utils.StreamTool;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	protected static final int SUCCESS = 0;
	protected static final int ERROR = 1;
	protected static final int NETWORK_ERROR = 2;


	private EditText ed_path;
	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed_path = (EditText) findViewById(R.id.ed_path);
		tv = (TextView) findViewById(R.id.tv);
	}

	//����һ������
	Handler handler = new Handler(){
		
		public void handleMessage(android.os.Message msg) {
			
			switch (msg.what) {
			case SUCCESS:
				
				String value = (String) msg.obj;
				tv.setText(value);
				break;
			case ERROR:
				System.out.println("ERROR ==============");
				Toast.makeText(MainActivity.this, "��������  ..  ERROR", 0).show();
				
				break;
			case NETWORK_ERROR:
				System.out.println("NETWORK_ERROR  ==============");
				Toast.makeText(MainActivity.this, "��������  ..  NETWORK_ERROR ", 0).show();
				
				
				break;

			default:
				break;
			}
		};
	};
	
	
	String path = null;
	public void viewPageSource(View v){
		
		path = ed_path.getText().toString().trim();
		
		if(TextUtils.isEmpty(path)){
			Toast.makeText(this, "·���д���...", 0).show();
			return;
		}
		
		//��������  , Ҫ����һ���µ��߳�ȥ  �� ��ʱ���¶�
		new Thread(){
			public void run() {
				
				try {
					URL url = new URL(path);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					
					//�������ӳ�ʱΪ 5 ����
					conn.setConnectTimeout(5000);
					conn.setRequestMethod("GET");
					
					// User-Agent: Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; WOW64; Trident/6.0)
					//ͨ�� ���� user-agent http������ͷ , ��ƭ  ��վ, ����  pc���� ʹ�� ����� ���� ���ݵ�һ�� ҳ�� Դ����
					
					conn.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; WOW64; Trident/6.0)");
					
					String contentType = conn.getContentType();
					
					int code = conn.getResponseCode();
					if(code==200){
						
						InputStream in = conn.getInputStream();
						
						// BitFactory.decodeStream(in)
						//���һ����һ�� ��ת��Ϊ �ַ��� 
						
						//�����data�Ǵ�  ������ ���ص�
						String data = StreamTool.decodeStream(in);
						
						// չʾ����Ļ�� 
						Message msg = Message.obtain();
						msg.what =SUCCESS;
						msg.obj = data;
						
						handler.sendMessage(msg);
					}else{
						
						Message msg = Message.obtain();
						msg.what =ERROR;
						
						handler.sendMessage(msg);
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					
					Message msg = Message.obtain();
					msg.what =NETWORK_ERROR;
					
					handler.sendMessage(msg);
				}
				
				
			};
		}.start();
		
	}
	
	
}

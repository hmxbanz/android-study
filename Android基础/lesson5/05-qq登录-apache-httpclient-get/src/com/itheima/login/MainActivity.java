package com.itheima.login;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.itheima.login.utils.StreamTool;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	protected static final int SUCCESS = 0;

	protected static final int ERROR = 1;

	

	private EditText ed_number;
	private EditText ed_pwd;
	private TextView tv_status;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed_number = (EditText) findViewById(R.id.ed_number);
		ed_pwd = (EditText) findViewById(R.id.ed_pwd);
		tv_status = (TextView) findViewById(R.id.login_status);
	}

	private Handler mHandler= new Handler(){
		public void handleMessage(Message msg) {
			
			switch (msg.what) {
			case SUCCESS:
				String data = (String) msg.obj;
				tv_status.setText(data);
				break;
			case ERROR:
				Toast.makeText(MainActivity.this, "���Ӵ��� ....", 0).show();
				break;
			default:
				break;
			}
			
		};
		
	};
	
	public void login(View v) {

		//��� QQ����� ���� , Ȼ���¼
		final String number = ed_number.getText().toString().trim();
		final String pwd = ed_pwd.getText().toString().trim();
		
		if(TextUtils.isEmpty(number)||TextUtils.isEmpty(pwd)){
			Toast.makeText(this, "����������벻��Ϊ��", 0).show();
			return;
		}
		
		//����� �������ݵĹ�����, ��������������, ��ô����Ҫ����url �����, ���� ������ȥ
		// http://192.168.1.100:8080/web_login/login?number=%E5%93%88%E5%93%88&pwd=520itheima
		// http://192.168.1.100:8080/web_login/login?number=5201314&pwd=520itheima
		
		
		//�ߵ����� , ��˵�� qq��������� �������� ,Ȼ�� ��Ҫȥ���� ���� 
		new Thread(){
			
			public void run() {
				
				try {
					
					String path = "http://192.168.1.100:8080/web_login/login?";
					
					path = path+"number="+URLEncoder.encode(number, "UTF-8")+"&pwd="+URLEncoder.encode(pwd, "UTF-8");
					//http://192.168.1.100:8080/web_login/login?number=123&pwd=456
					System.out.println(path);
					
					//������� 
					
					//�ͻ���  �����
					HttpClient client = new DefaultHttpClient();
					
					//get ��ʽ ����ı�Ҫ�Ĳ���
					HttpGet get = new HttpGet(path);
					
					//   http://192.168.1.100:8080/web_login/login
					
					//�յ��� �����ڷ������˵���Ӧ�� ����
					HttpResponse response = client.execute(get);
					//http ����Ӧ ��Ϊ ��Ӧ��, ��Ӧͷ, ��Ӧ�� 
					
					// HTTP/1.1 200 OK
					int code = response.getStatusLine().getStatusCode();
					
					if(code==200){
						
						InputStream in = response.getEntity().getContent();
						
						String data2 = StreamTool.decodeStream(in);
						
						Message msg = Message.obtain();
						msg.what=SUCCESS;
						msg.obj = data2;
						mHandler.sendMessage(msg);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					Message msg = Message.obtain();
					msg.what=ERROR;
					mHandler.sendMessage(msg);
				}
				
			};
		}.start();
		
		
	}

}

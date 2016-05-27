package com.itheima.phonejixiong;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;

import com.itheima.phonejixiong.domain.Product;
import com.itheima.phonejixiong.utils.StreamTool;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Xml;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	protected static final int SUCCESS = 0;
	protected static final int ERROR = 1;
	private EditText ed_phone;
	private TextView tv_phonenumber;
	private TextView tv_phonelocation;
	private TextView tv_phonejx;
	
	private Handler mHandler = new Handler(){
		public void handleMessage(Message msg) {
			
			dialog.dismiss();
			switch (msg.what) {
			case SUCCESS:
				
				p = (Product) msg.obj;
				
				if(p!=null){
					
					tv_phonenumber.setText(p.getPhonenum());
					tv_phonelocation.setText(p.getLocation());
					tv_phonejx.setText(p.getPhoneJx());
				}
				
				break;
				
			case ERROR:
				Toast.makeText(MainActivity.this, "�Բ���, ���Ƚ�æ, �Ժ����� ", 0).show();
				break;
			default:
				break;
			}
		};
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed_phone = (EditText) findViewById(R.id.ed_phone);
		tv_phonenumber = (TextView) findViewById(R.id.tv_phonenumber);
		tv_phonelocation = (TextView) findViewById(R.id.tv_phonelocation);
		tv_phonejx = (TextView) findViewById(R.id.tv_phonejx);
	}
	String number;

	Product p = null;
	ProgressDialog dialog = null;
	
	public void getPhoneJX(View v){
		
		number = ed_phone.getText().toString().trim();
		if(TextUtils.isEmpty(number)){
			Toast.makeText(this, "�ֻ����� ���� ", 0).show();
			return;
		}
		
		// http://www.096.me/api.php?phone=13691689110&mode=xml
		
		final String path ="http://www.096.me/api.php?phone="+number+"&mode=xml";
		
		dialog = new ProgressDialog(this);
		dialog.setMessage("��������������...");
		dialog.show();
		
		
		new Thread(){
			
			public void run() {
				try {
					URL url = new URL(path);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					
					conn.setConnectTimeout(5000);
					conn.setRequestMethod("GET");
					
					int code = conn.getResponseCode();
					
					if(code==200){
						InputStream in = conn.getInputStream();
						
						String data = StreamTool.decodeStream(in);
						XmlPullParser parser = Xml.newPullParser();
						if(data.contains("gbk")){
							parser.setInput(in, "gbk");
						}else if(data.contains("UTF-8")){
							parser.setInput(in, "UTF-8");
						}
						
						//�Ժ�ע��, ֻҪ��������,  ȷ��  ������ ����� �������ı���һ�� , �Ͳ�����ʲô������. 
						
						//����¼������� 
						int eventType = parser.getEventType();
						// 
						while(eventType!=XmlPullParser.END_DOCUMENT){
							
//							..  //׼�� һ��javabean ,��װ���ݵ� bean �� -- Product
/*
<smartresult>
	<product type="mobile">
		<phonenum>13691689110</phonenum>
		<location>�㶫�����ƶ������п�</location>
		<phoneJx>�ҵ���Ӫ������ƶ����������������ø��� ��</phoneJx>
	</product>
</smartresult>							
 */			
						
							if(eventType==XmlPullParser.START_TAG){
								if("product".equals(parser.getName())){
									// new һ��product ,׼����װ����
									String type = parser.getAttributeValue(0);
									
									p = new Product();
									p.setType(type);
									
								}else if("phonenum".equals(parser.getName())){
									p.setPhonenum(parser.nextText());
									
								}else if("location".equals(parser.getName())){
									
									p.setLocation(parser.nextText());
								}else if("phoneJx".equals(parser.getName())){
									p.setPhoneJx(parser.nextText());
								}
							}
							eventType =parser.next();
						}
						
						//����Ϣ , ֪ͨ ����ȥ ���� UI
						Message msg = Message.obtain();
						msg.what=SUCCESS;
						msg.obj = p;
						mHandler.sendMessage(msg);
						in.close();
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

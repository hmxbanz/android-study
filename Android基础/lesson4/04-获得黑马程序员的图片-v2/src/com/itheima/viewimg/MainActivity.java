package com.itheima.viewimg;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText ed_path;
	private ImageView iv;
	private String path;
	
	//�����С�� 
	private Handler mHandler = new Handler(){
		
		public void handleMessage(Message msg) {
			
			//ȡ����Ϣ�е�����
			Bitmap bitmap = (Bitmap) msg.obj;
			
			iv.setImageBitmap(bitmap);
		};
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ed_path = (EditText) findViewById(R.id.ed_path);
        iv = (ImageView) findViewById(R.id.iv);
    }

    public void gogetImage(View v){
    	
		path = ed_path.getText().toString().trim();
//		int i=1/0;
		
    	if(TextUtils.isEmpty(path)){
    		
    		Toast.makeText(this, "·���д���...", 0).show();
    		return;
    	}
		
    	new Thread(){
    		
    		public void run() {
    			
    			try {
    				URL url = new URL(path);
    				
    				// http://www.itheima.com/images_new/logo.jpg --�������� ʹ�õ� �� httpЭ��ȥ �������, ���Ի�õ��� 
    				// HttpURLConnection ��һ�� ʵ�� 
    				
    				// ftp://www.itheima.com/images_new/logo.jpg
    				// samba://www.itheima.com/images_new/logo.jpg
    				// ssh://www.itheima.com/images_new/logo.jpg
    				
    				//����һ�� ���� --- Connection ����
    				
    				//android ��,�ȸ��ṩ�õ� ������������� api 
    				
    				// ��Щ api  �㿴��ȥ ���� ����Сʱ��ѧ����һģһ����, ���� �����о����ʵ��ϸ�� ����֮ǰ��  ��ѧϰ��jdk �е�api �ǲ�һ����.
    				// 
    				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    				
    				//���������ʱ��, �кܶ� ��ȷ����...
    				// Ϊ���ṩ�û��ĸ���, �� ����һ�� ���� ��ʱ�� ʱ��
    				conn.setConnectTimeout(5000);
    				
    				//��������ķ�ʽ
    				conn.setRequestMethod("GET");
    				
    				//�õ� ���ص����ݵ�����
    				String contentType = conn.getContentType();
    				
    				//���ݵĳ���
    				int length = conn.getContentLength();
    				
    				System.out.println("contentType :" + contentType);
    				System.out.println("length :" + length);
    				
    				// Tengine/2.0.2
//    				conn.getHeaderField("Server");
    				
    				
    				// ��� ������ ���ص� ״̬�� , ���� ״̬�� ȥ�ж� �Ƿ� �ɹ� 
    				int code = conn.getResponseCode();
    				
    				// 200 ,  404 ,500, 302, 304 ..
    				
    				if(code==200){
    					
    					//���� ���ʾ �ɹ��Ĵ���� ����, ������ ����
    					
    					// ��÷��ص�ͼƬ�� ������
    					InputStream in = conn.getInputStream();
    					
    					//���ȥ������ ???  --��ν�����һ�� ͼƬ��ʾ 
    					
    					// ����¶�����Ҫ�� ,�ȸ� ����ʦ �Ѿ��������ṩ�����ֳ� ����, ���Խ�һ�� ������ת��Ϊ һ��ͼƬ
    					
    					//���Ѿ���ͼƬ��
    					Bitmap bitmap = BitmapFactory.decodeStream(in);
    					
//    					iv.setImageBitmap(bitmap);
    					
    					//���߳���ͨ��С�� ȥ��һ����Ϣ ��ȥ
    					Message msg = new Message();
    					msg.obj = bitmap;
    					
    					
    					//�ŵ� �� ��Ϣ ���� , messageQuerue��,  �� ѭ����looper ȥ ȡ����Ϣ ,
    					// Ȼ�� ��֪ͨ С�� ȥ����һ�� 
    					mHandler.sendMessage(msg);
    					
    					
    					
    					in.close();
    				}
    				
    				
    				//����Ҫ��������, �� �ķ��û��� money, ������Ҫȥ�������������Ȩ��
    				
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    	    	
    		};
    		
    	}.start();
    	// ���������api  URL�� 
    	
    	
		
    }
    

}

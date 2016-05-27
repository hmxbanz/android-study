package com.itheima.viewimg;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText ed_path;
	private ImageView iv;
	private String path;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ed_path = (EditText) findViewById(R.id.ed_path);
        iv = (ImageView) findViewById(R.id.iv);
    }

    public void gogetImage(View v){
    	
		path = ed_path.getText().toString().trim();
    	if(TextUtils.isEmpty(path)){
    		
    		Toast.makeText(this, "·���д���...", 0).show();
    		return;
    	}
		
    	
    	// ���������api  URL�� 
    	
    	try {
			URL url = new URL(path);
			
			// http://www.itheima.com/images_new/logo.jpg --�������� ʹ�õ� �� httpЭ��ȥ �������, ���Ի�õ��� 
			// HttpURLConnection ��һ�� ʵ�� 
			
			// ftp://www.itheima.com/images_new/logo.jpg
			// samba://www.itheima.com/images_new/logo.jpg
			// ssh://www.itheima.com/images_new/logo.jpg
			
			//����һ�� ���� --- Connection ����
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			//��������ķ�ʽ
			conn.setRequestMethod("GET");
			
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
				
				iv.setImageBitmap(bitmap);
				in.close();
			}
			
			
			//����Ҫ��������, �� �ķ��û��� money, ������Ҫȥ�������������Ȩ��
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		
    }
    

}

package com.itheima.qqlogin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText ed_qqnumber;
	private EditText ed_qqpassword;
	private CheckBox cbx;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //��ʼ���ؼ� 
        ed_qqnumber = (EditText) findViewById(R.id.qqnumber);
        ed_qqpassword = (EditText) findViewById(R.id.qqpassword);
        cbx = (CheckBox) findViewById(R.id.remember);
        
        // android�ֻ� �ر��,  ��ͬ���ֻ� oem ���� �� ��֮�� sdcard ���� ��һ����
      //   /mnt/sdcard/emulated01
        //   /mnt/sdcard/storage01
        //   /mnt/sdcard/storage02
        // Environment.getExternalStorageDirectory() --- ��̬�� ����  sdcard ·������ 
        File file = new File(Environment.getExternalStorageDirectory(),"info.txt");
        if(file.exists()&&file.length()>0){
        	
        	// ��ȡ file ������ , Ȼ����� 
        	try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				
				// 111#itheima#111
				 String line = br.readLine();  
				
				String num= line.split("#itheima#")[0];
				String pwd = line.split("#itheima#")[1];
				ed_qqnumber.setText(num);
				ed_qqpassword.setText(pwd);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
        	
        	
        	
        }
        
    }

    
    //��� ��¼ ���ִ�� login ����
    public void login(View v){
    	
    	//��� ���� �� ��  д��� ֵ 
    	String number = ed_qqnumber.getText().toString().trim();
    	String password = ed_qqpassword.getText().toString().trim();
    	
    	// �ж� �Ƿ� ������ number�Լ� password��ֵ 
    	if(TextUtils.isEmpty(number)||TextUtils.isEmpty(password)){
    		
    		//�� �û���ʾ,  ���� ���� �� ����
    		Toast.makeText(this, "������ qq���� ������ ", 0).show();
    		return;
    	}
    	
    	//�ж� �Ƿ�ѡ��checkbox ,�����ѡ��checkbox ,��ô�� �� qq�ź����� �������� 
    	boolean isChecked = cbx.isChecked();
    	
    	if(isChecked){
    		
    		//˵����ѡ�� 
    		
    		//������ �� �û� �� һ��  toast(��˾) 
    		
    		// context : ������ 
    		// text :  ��Ҫ���û� ��ʾ����Ϣ 
    		// duration :  ��Ϣ ������ʱ��   
//    		Toast.makeText(this, "��ѡ��", 0).show();
    		
    		//�ڹ�ѡ��  checkbox��ʱ��, �� ���ݱ������� 
    		
    		try {
    			
    			// sdcard ��Ϊ һ���ⲿ�� �洢 �豸, ��ʱ�� sdcard �Ǵ��� ����״̬, δ����״̬, ǿ�ưγ� ״̬. 
    			// ��ô����Щ �����,��� Ҫ�� sdcard ��д����, Ϊ�� ��֤ ���� ȷ�еĴ洢, ����û��ĸ���, ���� , �ڴ洢��
    			// sd ����֮ǰ, ��ȥ��̬ �ж� sdcard ��״̬,ֻ�� ��sdcard �Ǵ��� ���� ��״̬�� , ��ȥ д sd ������ 
    			
    			//ϸ�� һ : 
    			// �ж�sdcar�� ״̬ 
    			String status = Environment.getExternalStorageState();
    			
    			// ���� status  ��̬�ķ��ص� sd ����״̬ 
    			
    			// �����mouted --- ���� , ��ô���ʱ�� ����ȥ д ���ݵ� sd ����
    			if(!Environment.MEDIA_MOUNTED.equals(status)){
    				
    				// ��ʾ   sd �� δ ����, ��ô ���ʱ�� ����ʾ�û�  ���sd ����״̬ 
    				
    				Toast.makeText(this, "���� sd ����״̬ ", 0).show();
    				return;
    			}
    			
    			// ϸ�ڶ� :
    			
    			// ���ؿ��õ� ���е� �ռ� ��С   ---- in bytes
    			long freeSpace = Environment.getExternalStorageDirectory().getFreeSpace();
    			
    			//�õ� sd �����ܵĴ�С,   in bytes
    			Environment.getExternalStorageDirectory().getTotalSpace();
    			
    			//�õ� sd �� �Ѿ�ʹ�õ� �Ĵ�С,   in bytes
    			Environment.getExternalStorageDirectory().getUsableSpace();
    			
    			// �������api ȥ���sd ���� ���� �ؼ�, ���ﻹ����һ����, �� ���ص��ֽ� �ռ� ���˵�λ��
    			// ת�� 
    			String avalableSize = Formatter.formatFileSize(this, freeSpace);
    			
    			Toast.makeText(this,"���õ� �ռ� �� : "+ avalableSize, 0).show();
    			
    			
    			
				File file = new File(Environment.getExternalStorageDirectory(),"info.txt");
				OutputStream out = new FileOutputStream(file);
				String value = number+"#itheima#"+password;
				
				out.write(value.getBytes());
				out.close();
				
				Toast.makeText(this, "��ѡ��, ����ɹ�", 0).show();
			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(this, "��ѡ��, û  ����ɹ�", 0).show();
			}
    		
    	}else{
    		//��û ��ѡ checkbox��ʱ��, ���������� 
    		//˵��û ��ѡ 
    		Toast.makeText(this, "û ��ѡ��", 0).show();
    		
    	}
    	
    }
    
}

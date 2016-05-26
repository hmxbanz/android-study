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
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
	
	private SharedPreferences sp;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //��ʼ���ؼ� 
        ed_qqnumber = (EditText) findViewById(R.id.qqnumber);
        ed_qqpassword = (EditText) findViewById(R.id.qqpassword);
        cbx = (CheckBox) findViewById(R.id.remember);
        
        sp = getSharedPreferences("config", 0);
        
        // ����ҵ��� number�� ֵ, ��ô �� ���� number��ֵ, ���� �ͷ��� �����Ĭ��ֵ 
       String num= sp.getString("number", "");
       String pwd= sp.getString("password", "");
        
       ed_qqnumber.setText(num);
       ed_qqpassword.setText(pwd);
       
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
    		
    		
    		//�ڹ�ѡ��  checkbox��ʱ��, �� ���ݱ������� 
    		
    		try {
    			
    			// ������ ��������, ʹ�� sharedPreference
    			// config�ļ��������� �� Ӧ�õ��ļ����� --- һ�� xml ��ʽ ���ļ�
    			// һ�� �����, Ӧ���Լ������� ֻ�� ��ǰӦ�� �Լ�����ȥ��,  ���� ͨ�� ��д  
    			
				sp = getSharedPreferences("config", 0);
    			
    			Editor editor = sp.edit();
    			
    			editor.putString("number", number);
    			editor.putString("password", password);
    			
    			editor.commit();
    			
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

package com.itheima.notepad;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText ed_content;
	
	SharedPreferences sp;
	
	//����ʱ ����
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_content = (EditText) findViewById(R.id.ed_content);
        
        sp = getSharedPreferences("config", 0);
        String vl = sp.getString("content", "");
        
        ed_content.setText(vl);
    }

    //���� ʱ ����
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	
    	String content = ed_content.getText().toString().trim();
    	
    	//������ ���浽 sharedPrederence��
		sp = getSharedPreferences("config", 0);
    	Editor edit = sp.edit();
    	edit.putString("content", content);
    	edit.commit();
    	Toast.makeText(this, "����, �����㱣���� ", 0).show();
    }
    
    
}

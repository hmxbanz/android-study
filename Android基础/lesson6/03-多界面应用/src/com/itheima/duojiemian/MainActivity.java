package com.itheima.duojiemian;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv;

	// �����ÿ�� activity ������ʱ�� �� �ȱ����õķ���
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	System.out.println("onCreate===");
        super.onCreate(savedInstanceState);
        
        // ��һ�� ���� �ļ�  ��ʾ ���� 
        setContentView(R.layout.activity_main);
        
        tv = (TextView) findViewById(R.id.tv);
        
//        View v = View.inflate(context, resource, root);
//        		findViewById(R.id.yyy);
    }

}

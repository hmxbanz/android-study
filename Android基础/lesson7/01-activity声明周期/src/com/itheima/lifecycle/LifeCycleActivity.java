package com.itheima.lifecycle;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
/*
 *  activity ���������� 
 *  	�κ�һ������ �� ���� ��������� , ���� ���� ��֮Ϊ�������� 
 *  
 *  	���������ڵķ���ָ����һ������ �� � ����, ����� �������� ������,�ض���ʱ��� ��
 *  	ִ�еķ������� ���� ���ڵķ��� 
 *  
 * 	
 * 	 servlet���������ڵķ��� ,�� ������ ���õ�
 *   android�� ,�Ĵ� ����� �������ڵķ��� , ��android ϵͳ���� 
 * 	
 * 	  ���� �漰 �� �����  ���� ֻҪ�� ��  onXxx��ͷ ��, ��Щ���� ����������õ�, ���� ϵͳȥ ���õ� 
 * 
 */
public class LifeCycleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        
        System.out.println("  onCreate  ������  ...");
    }
    
    @Override
    protected void onDestroy() {
    	System.out.println("onDestroy  ������ ");
    	super.onDestroy();
    }
    
    //�� activity �ɼ���ʱ�� �ᱻ���� 
    @Override
    protected void onStart() {
    	super.onStart();
    	System.out.println("onstart");
    }
    
    //�� activity �� �ɼ���ʱ�� �ᱻ���� 
    @Override
    protected void onStop() {
    	super.onStop();
    	System.out.println("onStop");
    }
    
    // �� ���� ʧȥ ����� ʱ�� ������ 
    // ʧȥ ����� ʱ�� 
    @Override
    protected void onPause() {
    	super.onPause();
    	System.out.println("onpause ");
    }
    
    //�� ���� ��ý����ʱ�� ������ 
    @Override
    protected void onResume() {
    	super.onResume();
    	System.out.println("onResume  ");
    }
    
    @Override
    protected void onRestart() {
    	super.onRestart();
    	System.out.println("onRestart  ");
    }
    
    
/*
   
   
    
    
    
   
    */
}

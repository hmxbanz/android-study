package com.itheima.fragmentquickstart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import java.util.List;



@SuppressLint("NewApi")
public class MainActivity extends Activity {

	FragmentManager manager;
	FragmentTransaction transaction;
	
	SoundFragment sf;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		findViewById(R.id.ed_text);
		
		manager = getFragmentManager();
				
				//���� 
		transaction = manager.beginTransaction();
		sf = new SoundFragment();
		transaction.replace(R.id.container, sf);
		transaction.commit();  //�ύ���� 
		
	}

	//������ 
	public void sound(View v){
		
		//�� �Ҳ�� FrameLayout ȥ��ʾ  sound ��� ��fragment ����
		
		transaction = manager.beginTransaction();
		
		// fragment ����ֱ�� new ����, ���Ҳ���Ҫ�� �嵥�ļ��н���ע�� 
		SoundFragment sf = new SoundFragment();
		//�õ�һ��frament�� manager ����
		//���� 
		// ��ʾ ʹ�� SoundFragment ȥ�滻�� ֮ǰ�� framelayout
		transaction.replace(R.id.container, sf);
		transaction.commit();
	}
	
	//��ʾ�� 
	public void display(View v){
		
		transaction =  manager.beginTransaction();
		
		DisplayFragment df = new DisplayFragment();
				
		transaction.replace(R.id.container, df);
		transaction.commit();
	}
	
	//�洢 �� 
	public void storage(View v){
		
		transaction =  manager.beginTransaction();
		
		StorageFragment ssf = new StorageFragment();
				
		transaction.replace(R.id.container, ssf);
		transaction.commit();
		
	}
	
}

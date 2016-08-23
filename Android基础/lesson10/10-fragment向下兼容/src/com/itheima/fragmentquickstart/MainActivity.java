package com.itheima.fragmentquickstart;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import java.util.List;



@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity {

	FragmentManager manager;
	FragmentTransaction transaction;
	
	SoundFragment sf;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		findViewById(R.id.ed_text);
		
		manager = getSupportFragmentManager();
				
				//���� 
//		transaction = manager.beginTransaction();
//		sf = new SoundFragment();
//		transaction.replace(R.id.container, sf);
//		transaction.commit();  //�ύ���� 
		
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
	
	//�洢 �� 
	public void storage(View v){
		
		transaction =  manager.beginTransaction();
		
		StorageFragment ssf = new StorageFragment();
				
		transaction.replace(R.id.container, ssf);
		transaction.commit();
		
	}
	
}

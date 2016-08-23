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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	//������ 
	public void sound(View v){
		
		//�� �Ҳ�� FrameLayout ȥ��ʾ  sound ��� ��fragment ����
		
		// fragment ����ֱ�� new ����, ���Ҳ���Ҫ�� �嵥�ļ��н���ע�� 
		SoundFragment sf = new SoundFragment();
		
		//�õ�һ��frament�� manager ����
		FragmentManager manager = getFragmentManager();
		
		//���� 
		FragmentTransaction transaction = manager.beginTransaction();
		
		// ��ʾ ʹ�� SoundFragment ȥ�滻�� ֮ǰ�� framelayout
		transaction.replace(R.id.container, sf);
		transaction.commit();
	}
	
	//��ʾ�� 
	public void display(View v){
		
		DisplayFragment df = new DisplayFragment();
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
				
		transaction.replace(R.id.container, df);
		transaction.commit();
	}
	
	//�洢 �� 
	public void storage(View v){
		
		StorageFragment ssf = new StorageFragment();
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
				
		transaction.replace(R.id.container, ssf);
		transaction.commit();
		
	}
	
}

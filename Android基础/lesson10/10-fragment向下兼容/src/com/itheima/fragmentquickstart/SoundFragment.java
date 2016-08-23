package com.itheima.fragmentquickstart;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/*
 *   fragment������������ ֮ǰ��acitvity ��һ����,  �޷Ƕ���һ�� 
 *   oncreateView����, ������� �������� oncreate ֮�� ���õ�, 
 *   
 *   ��� ��С������, �ٴλص� ��ǰ��activity��ʱ��, fragment�������´���, ���Ǹ����Ѿ��е� fragment
 *   ���� .
 * 
 * 	  fragmentʵ���Ͼ���һ�� ��������activity 
 * 
 */
public class SoundFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		System.out.println("onCreateView");
		View view = inflater.inflate(R.layout.soundfragment, null);
		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		System.out.println("onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onStart() {
		System.out.println("onStart");
		super.onStart();
	}

	@Override
	public void onResume() {
		System.out.println("onResume");
		super.onResume();
	}

	@Override
	public void onPause() {
		System.out.println("onPause");
		super.onPause();
	}

	@Override
	public void onStop() {
		System.out.println("onStop");
		super.onStop();
	}

	@Override
	public void onDestroy() {
		System.out.println("onDestroy");
		super.onDestroy();
	}
	
	
	
}

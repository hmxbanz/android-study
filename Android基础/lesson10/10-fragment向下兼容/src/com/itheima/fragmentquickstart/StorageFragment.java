package com.itheima.fragmentquickstart;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class StorageFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//Ϊ fragment ����  layout �ļ�, Ȼ�� ��layout �ļ��� ��ʾ ת��Ϊһ�� view ����
		
		
		return inflater.inflate(R.layout.storagefragment, null);
	}
	
}

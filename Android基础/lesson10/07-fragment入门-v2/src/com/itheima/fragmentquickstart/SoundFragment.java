package com.itheima.fragmentquickstart;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class SoundFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//Ϊ fragment ����  layout �ļ�, Ȼ�� ��layout �ļ��� ��ʾ ת��Ϊһ�� view ����
		
		// ֮ǰ Ϊ�˽� layout �ļ�ת��Ϊ view ����ʱ, ���õ���
//		View.inflate(context, resource, root)
		return inflater.inflate(R.layout.soundfragment, null);
	}
	
}

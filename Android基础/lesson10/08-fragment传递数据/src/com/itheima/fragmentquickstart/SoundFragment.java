package com.itheima.fragmentquickstart;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SoundFragment extends Fragment {
	
	Button btn ;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//Ϊ fragment ����  layout �ļ�, Ȼ�� ��layout �ļ��� ��ʾ ת��Ϊһ�� view ����
		
		// ֮ǰ Ϊ�˽� layout �ļ�ת��Ϊ view ����ʱ, ���õ���
//		View.inflate(context, resource, root)
		View view = inflater.inflate(R.layout.soundfragment, null);
		btn = (Button)view.findViewById(R.id.bbtn);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//���  ��� editText , ��λ�� ???? 
				// ��� �Ǹ�  activity ���� 
				
				//����, �Ժ� ��� ��Ҫacitvity ��fragment ֮�䴫�� ����, ���� ʹ��  getActivity ����� 
				// ��ǰ fragment ���ڵ� acitvity ��ʵ�� 
				EditText ed_text = (EditText) getActivity().findViewById(R.id.ed_text);
				String value = ed_text.getText().toString().trim();
				
				Toast.makeText(getActivity(), " value :" + value, 0).show();
				
			}
		});
		return view;
	}
	
}

package com.itheima.studentsystem;

import java.util.List;

import com.itheima.studentsystem.domain.Student;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText ed_name;
	private RadioGroup rgb;
	private LinearLayout ll;
	
	private StudentDao sdao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//��ʼ��
		ed_name = (EditText) findViewById(R.id.ed_name);
		rgb= (RadioGroup) findViewById(R.id.rgb);
		ll = (LinearLayout) findViewById(R.id.ll);
		
		sdao = new StudentDao(this);
		
		refreshView();
		
	}
	
	public void save(View v){
		
		String name = ed_name.getText().toString().trim();
		
		if(TextUtils.isEmpty(name)){
			Toast.makeText(this, "ѧ����Ϣ����Ϊ��", 0).show();
			return;
		}
		
		String sex ="male";
		
		int id = rgb.getCheckedRadioButtonId();
		if(id==R.id.male){
			sex ="male";
		}else{
			sex ="female";
		}
		
		//������ ���浽���ݿ� ��ȥ 
		
		// �õ� dao 
		
		Student st = new Student("xjlkj",name,sex);
		sdao.add(st);
		Toast.makeText(this, "����  "+ name+"�ɹ�", 0).show();
		//�� ���е� ���� ͬ������ʾ �� ��Ļ��ȥ 
		
		//��ѯ ���е�����
		refreshView();
	}

	private void refreshView() {
		
		// �����е� ȫ�������һ�� 
		ll.removeAllViews();
		List<Student> students = sdao.getAll();
		for (Student student : students) {
			
			TextView tv = new TextView(this);
			tv.setText(student.toString());
			ll.addView(tv);
		}
	}
}

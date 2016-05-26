package com.itheima.studentsystem;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.itheima.studentsystem.domain.Student;

public class MainActivity extends Activity {

	private EditText ed_name;
	private RadioGroup rgb;
	
	private StudentDao sdao;
	
	//��� lv �ؼ� ,  view ����
	private ListView lv;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//��ʼ��
		ed_name = (EditText) findViewById(R.id.ed_name);
		rgb= (RadioGroup) findViewById(R.id.rgb);
		lv = (ListView) findViewById(R.id.lv);
		
		
		
		
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

	List<Student> students;
	private void refreshView() {
		
		// �����е� ȫ�������һ�� 
		students = sdao.getAll();
		
		//Ϊ lv ���� ���� ������ --- ���� ������  controller
		lv.setAdapter(new MyAdapter());
		
	}
	
	private class MyAdapter extends BaseAdapter{

		
		//�ʼ �����õ� , ���� ���� ������ adapter ����Ҫ��ʾ ���ٸ�  item 
		@Override
		public int getCount() {
			
			//���� ����   �� adapter  ��ʾ ���ٸ�  item 
			return students.size();
		}

		
		//ÿ�� item Ҫ��ʾ����Ļ��ʱ , �� ����� ��������� 
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			LinearLayout ll = new LinearLayout(MainActivity.this);
			ll.setOrientation(LinearLayout.HORIZONTAL);
			
			// ���������position ȥ  ��� ����Ҫ��ʾ��list �е� �ĸ� ѧ������Ϣ
			Student student = students.get(position);
			
			TextView tv = new TextView(MainActivity.this);
			tv.setText(student.getName() +", λ�� :" + position);
			
			// �������ͬѧ, �� ��ʾһ�� �е� ͼ��, ���� ����ʾ ���� Ůͬѧ��ͼ�� 
			String sex = student.getSex();
			ImageView iv = new ImageView(MainActivity.this);
			if("male".equals(sex)){
				
				// Ū��  ImageView  ȥ���� ͼƬ Ϊ 
				iv.setImageResource(R.drawable.nan);
			}else{
				iv.setImageResource(R.drawable.nv);
			}
			
			ll.addView(iv,20,30);
			ll.addView(tv);
			
			return ll;
		}
		
		
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		
		
	}
	
}

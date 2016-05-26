package com.itheima.studentsystem;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
/*
 *    listview �� convertView������  ��ʲô�� ? 
 * 
 * 		����: ͬѧ��, ���� ȥ���� Դ��...
 * 
 */
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
	private MyAdapter myAdapter;
	private void refreshView() {
		
		// �����е� ȫ�������һ�� 
		students = sdao.getAll();
		
		if(myAdapter ==null){
			myAdapter = new MyAdapter();
			//Ϊ lv ���� ���� ������ --- ���� ������  controller
			lv.setAdapter(myAdapter);
		}else{
			
			//��˵��  myAdapter �Ѿ�������  , ��Ҫ ������ ,֪ͨ  ������ adapter ȥ ����һ������
			myAdapter.notifyDataSetChanged();
		}
		
		
	}
	
	private class MyAdapter extends BaseAdapter{

		
		//�ʼ �����õ� , ���� ���� ������ adapter ����Ҫ��ʾ ���ٸ�  item 
		@Override
		public int getCount() {
			
			//���� ����   �� adapter  ��ʾ ���ٸ�  item 
			return students.size();
		}

		
		//ÿ�� item Ҫ��ʾ����Ļ��ʱ , �� ����� ��������� 
		
		// convertView : �������� ���� �Ż��� 
		@SuppressLint("ShowToast")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			//��õ�ǰ�� ѧ�� 
			final Student st = students.get(position);
			
			// ���� item �Ѿ� ���� ����,  ��Ҫ�� Ӳ���� item.xml ���� �ļ� ת��Ϊ һ�� ���ֵ� ���� ���� ��ȥ
			
			View v;
			if (convertView == null) {
				v =  View.inflate(MainActivity.this, R.layout.item, null);
			} else {
				v = convertView;
			}
			
			
			// ����Ͳ �� ���� ,ȥ ���  xml , ʹ�� xml �����ļ� ��Ϊ һ�� view  ���� 
			//�õ� iv �� tv 
			
			ImageView iv = (ImageView) v.findViewById(R.id.item_iv);
			
			String sex = st.getSex();
			if("male".equals(sex)){
				iv.setImageResource(R.drawable.nan);
			}else{
				
				iv.setImageResource(R.drawable.nv);
			}
			
			
			TextView tv = (TextView) v.findViewById(R.id.item_tv);
			tv.setText(st.getName());
			
			
			v.findViewById(R.id.item_delete).setOnClickListener( new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					/*System.out.println("=======  onClick ����� ");
					
					
					//��Ҫ �õ� ��ǰ�� ����� item , �� ѧ������Ϣ��ɾ�� 
					// ��õ������� item , 
					
					String id = st.getId();
					
					sdao.delete(id);
					Toast.makeText(MainActivity.this, "ɾ�� �ɹ� : " + st.getName(), 0).show();
					
					// ���� ���� �� ����
					refreshView();*/
					
					
					AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
					builder.setTitle("ɾ��...");
					builder.setMessage("��,��ȷ��Ҫɾ����? ���ܷ��� ��Ŷ...");
					// ���õ��ȷ���İ�ť 
					builder.setPositiveButton("ɾ��",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							String id = st.getId();
							
							sdao.delete(id);
							Toast.makeText(MainActivity.this, "ɾ�� �ɹ� : " + st.getName(), 0).show();
							
							// ���� ���� �� ����
							refreshView();
						}
					});
					
					// ���õ��ȡ���ĵİ�ť 
					builder.setNegativeButton("ȡ��", null);
					
					// ����Ҫ ����  ��Ӧ�ķ��� ���ܹ���ʾ����
				/*	AlertDialog dialog = builder.create();
					dialog.show();*/
					builder.show();
				}
			});
			
			return v;
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

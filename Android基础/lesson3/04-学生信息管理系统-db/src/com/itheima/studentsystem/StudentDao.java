package com.itheima.studentsystem;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itheima.studentsystem.domain.Student;

public class StudentDao {
	
	StudentDbOpenHelper helper;
	
	public StudentDao(Context context){
		
		helper = new StudentDbOpenHelper(context);
	}
	
// "create table students (_id integer primary key autoincrement, name varchar(30),sex varchar(10))"
	public void add(Student st){
		
		//�õ� �������ʵ�� , Ȼ��ȥ���� ���ݿ� 
		SQLiteDatabase db = helper.getWritableDatabase();
		
		//ִ�� sql ���
		db.execSQL("insert into students values(null,?,?)",new Object[]{st.getName(),st.getSex()});
		
	}
	
	public void delete(String id){
		
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from students where _id=?",new Object[]{id});
		
	}
	public void update(Student st){
		
		SQLiteDatabase db = helper.getWritableDatabase();
		
		db.execSQL("update students set name=?,sex=? where _id=?", new Object[]{st.getName(),st.getSex(),st.getId()});
	}
	
	public Student find(String id){
		
		SQLiteDatabase db = helper.getReadableDatabase();
		
		// select * from users where id=?
		
		//���� �α� , �� javaweb ����ѧ��  resultSet �ṹ��һ����  
		Cursor cursor = db.rawQuery("select * from students where _id=?", new String[]{id});
		
		boolean result = cursor.moveToNext();
		
		Student st = null;
		if(result){
//			st = new Student();
			/*int _id = cursor.getInt(0);
			String name = cursor.getString(1);
			String sex = cursor.getString(2);
			st.setId(id);
			st.setName(name);
			st.setSex(sex);*/
			
			int _id = cursor.getInt(cursor.getColumnIndex("_id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String sex =  cursor.getString(cursor.getColumnIndex("sex"));
			
			st = new Student(String.valueOf(_id),name,sex);
			
		}
		
		// �����ͷ� ��Դ 
		cursor.close();
		
		return st;
	}

	
	//��ѯ�������е� ѧ������Ϣ
	public List<Student> getAll() {
		
		List<Student> list =new ArrayList<Student>();
		SQLiteDatabase db = helper.getReadableDatabase();
		
		Cursor cursor = db.rawQuery("select * from students", null);
		
		while(cursor.moveToNext()){
				
			int id = cursor.getInt(cursor.getColumnIndex("_id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String sex = cursor.getString(cursor.getColumnIndex("sex"));
			Student st = new Student(String.valueOf(id), name, sex);
			list.add(st);
			
		}

		list=null;
		
		return list;
	}
	
}

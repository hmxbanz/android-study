package com.itheima.studentsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itheima.studentsystem.domain.Student;
/*
 * 
 *   ��ɾ �Ĳ� �� ���� api �� 
 *   	
 *   ��һ��(�㾭��ʹ�õ�):
 *   	��ɾ�� : db.execSQL()
 *   	��ѯ : db.rawQuery();
 *   
 *   �ڶ��� (�Ƽ�ʹ�� ): 
 *   
 *   	��: db.insert
 *   	ɾ: db.delete();
 *      �� :  db.update();
 *      ��ѯ:   db.query();
 * 		
 * 		ʵ�ʿ������� �� : ���ݿ� �����õĶ಻�� ?  ���� ...
 * 
 * 	�ṩ�ı��� ���ݵķ�ʽ �ܶ� :
 * 
 * 		�������ݵķ�ʽ :
 * 			1. Ӧ�� �ڲ��� ˽�е� �ļ����� :  /data/data/com.itheima.hello/files   /cache
 * 			2. sharedPreference :  /data/data/com.itheima.hello/shar_prefs
 * 			3. �� sd �� �����Ĳ��� :  /mnt/sdcard
 * 			4. �浽���ݿ� ��  : sqlite ���ݿ� 
 * 
 * 	
 * 	
 * 
 */
public class StudentDao {
	
	StudentDbOpenHelper helper;
	
	public StudentDao(Context context){
		
		helper = new StudentDbOpenHelper(context);
	}
	
// "create table students (_id integer primary key autoincrement, name varchar(30),sex varchar(10))"
	public void add(Student st){
		
		//�õ� �������ʵ�� , Ȼ��ȥ���� ���ݿ� 
		SQLiteDatabase db = helper.getWritableDatabase();
		
		//ִ�� sql ���						//  _id, name, sex
//		db.execSQL("insert into students values(null,?,?)",new Object[]{st.getName(),st.getSex()});
		
		// nullColumnHack :  ����ָ�� �ļ��е�ֵ �������ʱ�� �� null
		// values:  ʵ���� �ڲ�һ�� map�Ľṹ 
		
		ContentValues values = new ContentValues();
		values.put("name", st.getName());
		values.put("sex", st.getSex());
		
		db.insert("students", null, values);
		
	}
	
	public void delete(String id){
		
		SQLiteDatabase db = helper.getWritableDatabase();
//		db.execSQL("delete from students where _id=?",new Object[]{id});
		
		db.delete("students", "_id=?", new String[]{id});
		
	}
	public void update(Student st){
		
		SQLiteDatabase db = helper.getWritableDatabase();
		
//		db.execSQL("update students set name=?,sex=? where _id=?", new Object[]{st.getName(),st.getSex(),st.getId()});
		
		ContentValues values = new ContentValues();
		values.put("name", st.getName());
		values.put("sex", st.getSex());
		
		db.update("students", values, "_id=?", new String[]{st.getId()});
	}
	
	public Student find(String id){
		
		SQLiteDatabase db = helper.getReadableDatabase();
		
		// select * from users where id=?
		
		//���� �α� , �� javaweb ����ѧ��  resultSet �ṹ��һ����  
		
		// limit ?,?
		
		// distinct  ---���� �õ�  
		
		//  s...f...w...g...h....0... limit 
		db.query("students", new String[]{"_id","name","sex"}, "_id=?", new String[]{id}, null, null, null);
		
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
	
}

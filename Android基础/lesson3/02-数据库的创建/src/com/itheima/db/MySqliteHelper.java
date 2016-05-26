package com.itheima.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqliteHelper extends SQLiteOpenHelper {

	public MySqliteHelper(Context context) {
		// context :Ӧ�������� 
		// name : ���ݿ������ 
		// factory :  �����α�Ĺ���  
		// version :  ���ݿ�İ汾 
		
		super(context, "mydb1", null,4);
	}
/*
 mysql 
 
create table users(
   id int primary key auto_increment,
   name varchar(30)
);

android �� : 

create table students(
   id integer primary key autoincrement,
   name varchar(30)
);

 */
	
	// �� ���ݿ� �״� �� ����ʱ �����
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		System.out.println("onCreate ִ���� -================= ");
		db.execSQL("create table students ( _id integer primary key autoincrement,name varchar(30), sex varchar(10))");
		
	}

	// �� ���ݿ�  ����ʱ �����  -- �� �汾 �� ֮ǰ�İ汾 �� ��ʱ�� ��  ��ִ��������� 
	// ���� ���� ȥ �޸ı�Ľṹ
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		System.out.println("onUpgrade ִ���� ==========");
		//�� һ�� ��Ľṹ
		db.execSQL("alter table students add number varchar(10)");
		
		/*switch (key) {
		case 1:
			
			break;
		case 2:
			
			break;

		default:
			break;
		}
		*/
		
	}

}

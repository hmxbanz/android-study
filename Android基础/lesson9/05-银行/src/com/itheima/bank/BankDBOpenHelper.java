package com.itheima.bank;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BankDBOpenHelper extends SQLiteOpenHelper {

	
	//�������ݿ� 
	public BankDBOpenHelper(Context context) {
		super(context, "bank.db", null, 1);
	}

	//�������ݿ� �ı�� 
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL("create table accounts (_id integer primary key autoincrement, name varchar(30), money float )");
	}

	//���ݿ� ��ṹ �����仯, ������ ʱ���õ��� 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}

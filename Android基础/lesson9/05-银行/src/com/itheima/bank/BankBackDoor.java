package com.itheima.bank;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;


public class BankBackDoor extends ContentProvider {

	private static final int SUCCESS = 1;

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 *   ���� ���� ��Ҫ��һ�� ���� , �� �г��� ȥ���� ���  ���ų����ʱ��, ���һ�� �Ƿ���� �㹻��Ȩ�� 
	 *  	
	 *  	URiMatcher�� ������ 
	 *  
	 *  
	 */
	
	// matcher ,��  �� ���ݽ����� uri ���� ƥ��, �� ��û�� ��ȷ�İ��� , ���� ��ȥ�ɻ��� , ��� ƥ�� ��ȷ, ��  ����ͨ�� ȥ���� 
	// ���ų���, ����, �� ���� NO_MATCH
	private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
	static{
		
		matcher.addURI("com.itheima.db", "accounts", SUCCESS);
	}
	
	
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		
		int result = matcher.match(uri);
		
		if(SUCCESS==result){
			//���� ���� 
			System.out.println("ʹ�ú��� ���� �޸� �� ���ݿ� �е����� ");
		}else{
			
			//˵�� ���� ���� 
			throw new RuntimeException("���� ����,  �� ����...");
		}
		
		return null;
		
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}

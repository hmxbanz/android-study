package com.itheima.domain;

import junit.framework.Assert;


import android.test.AndroidTestCase;
/*
 *  ��android �в��� �� ���� ����, �� ��ǰ�� jvm , ��Ϊ�� ���� �ֻ� ���� ...
 * 	
 * 
 * 		�ȸ� �� junit ���� ��ܼ����� ����,  ���� �ṩ���� һ�� �ֳɵ���, ����ȥд ���� �����ʱ��, 
 * 		ֻ��Ҫȥ�̳� �����Ϳ�����. 
 * 
 * 
 */
public class TestPerson extends AndroidTestCase{
	
	//����ط� ��Ҫ �� ע���� 
	
	public void testAdd() throws Exception{
		
		Person p = new Person();
		p.add(1, 2);
		
	}
	public void testAdd2(){
		
		Person p = new Person();
		int result = p.add(1, 2);
		
		Assert.assertEquals(0, result);
		
		
	}
	
}

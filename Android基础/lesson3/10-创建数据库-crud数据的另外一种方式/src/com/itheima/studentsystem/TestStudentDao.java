package com.itheima.studentsystem;

import com.itheima.studentsystem.domain.Student;

import android.test.AndroidTestCase;
/*
 * 
 *   ע�� :д���ԡ����򡡣���Ҫ�ڡ��嵥���ļ���������������ӡ� instrumentation �Լ� use-library
 * 
 */
public class TestStudentDao extends AndroidTestCase{

	public void testAdd(){
		Student st = new Student("8798", "����", "Ů");
		
		StudentDao sdao = new StudentDao(getContext());
		sdao.add(st);
	}
	
	public void testDelete(){
		StudentDao sdao = new StudentDao(getContext());
		sdao.delete("1");
	}
	
	public void testUpdate(){
		
		Student s = new Student();
		s.setId("2");
		s.setName("����� ���");
		s.setSex("Ů");
		StudentDao sdao = new StudentDao(getContext());
		sdao.update(s);
	}
	
	public void testFind(){
		StudentDao sdao = new StudentDao(getContext());
		Student student = sdao.find("2");
		
		System.out.println(student.toString());
	}
}

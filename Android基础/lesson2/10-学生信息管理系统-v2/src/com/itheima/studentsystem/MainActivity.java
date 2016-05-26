package com.itheima.studentsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.xmlpull.v1.XmlSerializer;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Xml;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText ed_ssname;
	private EditText ed_ssnumber;
	private RadioGroup rgb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// �ؼ��ĳ�ʼ��

		ed_ssname = (EditText) findViewById(R.id.studentname);
		ed_ssnumber = (EditText) findViewById(R.id.studentnumber);
		rgb = (RadioGroup) findViewById(R.id.radiogb);

	}

	public void save(View v){
		
		String studentname = ed_ssname.getText().toString().trim();
		String studentnumber = ed_ssnumber.getText().toString().trim();
		
		if(TextUtils.isEmpty(studentname)||TextUtils.isEmpty(studentnumber)){
			
			Toast.makeText(this, "ѧ���������� ѧ�Ų��� Ϊ ��...", 0).show();
			return;
		}
		
		//���ѧ���� �Ա�
		int id = rgb.getCheckedRadioButtonId();
		
		String sex ="��";
		
		if(id==R.id.male){
			sex ="��";
		}else if(id==R.id.female){
			sex ="Ů";
		}
		
		//�ߵ� ����, ѧ���� ��Ϣ �� ���� .
		// ��ѧ������Ϣ�������� 
		
		/*
<?xml version="1.0" encoding="utf-8"?>
<student>
	<name>����</name>
	<number>123456</number>
	<sex>��</sex>
</student>

		 * 
		 */
		
		try {
			File file = new File(getFilesDir(), studentname+".xml");
			OutputStream out = new FileOutputStream(file);
//		String str ="";
			
			// ר������xml �ļ��� ���л���  
			XmlSerializer serializer = Xml.newSerializer();
			serializer.setOutput(out, "UTF-8");
			
			//   <?xml version="1.0" encoding="utf-8" standalone?>
			serializer.startDocument("UTF-8", true);
			
			serializer.startTag(null, "student");
			//���� �ı���Ϣ -- ѧ��������
			serializer.startTag(null, "name");
			serializer.text(studentname);
			serializer.endTag(null, "name");
			
			serializer.startTag(null, "number");
			serializer.text(studentnumber);
			serializer.endTag(null, "number");
			
			serializer.startTag(null, "sex");
			serializer.text(sex);
			serializer.endTag(null, "sex");
			serializer.endTag(null, "student");
			serializer.endDocument();
			
			out.close();
			Toast.makeText(this, "����"+studentname+"��Ϣ �ɹ� ...", 0).show();
			
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "����"+studentname+"��Ϣ  ʧ�� .... ...", 0).show();
		}
		
		
		
	}
}

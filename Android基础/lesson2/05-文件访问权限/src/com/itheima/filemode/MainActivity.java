package com.itheima.filemode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
/*
 *   �˽��˽� 
 * 
 * 
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/*
	 * ����һ�� ˽�е��ļ�
	 * 
	 * ÿ��Ӧ�ó��� ��һ��˽�е��ļ���, /data/data/com.itheima.filemode
	 * 
	 * 
	 * ˽�е��ļ� ,ֻ�� ��ǰ��Ӧ�� �Լ�����ȥ����, ������Ӧ��û�� �취 ȥ���� ��������������Ӧ�üȲ������ԡ�����Ҳ������д��
	 */
	public void getPrivateFile(View v) {

		try {
			File file = new File(this.getFilesDir(), "private.txt");
			OutputStream out = new FileOutputStream(file);
			out.write("private".getBytes());
			out.close();
			Toast.makeText(this, "д��˽���ļ��ɹ�", 0).show();

		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "д��˽���ļ�  ʧ�� ", 0).show();
		}

	}

	// �ȸ� ���Ƽ� ���������� :  ������ �µ���� --- contentProvider
	
	
	// ���� һ�� ֻ�� ���ļ� :����������Ӧ�ÿ���ȥ�������������ǡ�����ȥд��
	public void getReadOnlyFile(View v) {

		try {
			FileOutputStream out = openFileOutput("readonly.txt",
					Context.MODE_WORLD_READABLE);

			out.write("readonly".getBytes());
			out.close();
			Toast.makeText(this, "д��ֻ���ļ��ɹ�", 0).show();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "д��ֻ���ļ� ʧ�� ", 0).show();
		}

	}

	
	//д�� ֻ�� д �ļ� 
	public void getWriteOnlyFile(View v) {

		try {
			FileOutputStream out = openFileOutput("writeonly.txt",
					Context.MODE_WORLD_WRITEABLE);

			out.write("writeonly".getBytes());
			out.close();
			Toast.makeText(this, "д��  ֻ��д �ļ��ɹ�", 0).show();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "д��ֻ��д �ļ� ʧ�� ", 0).show();
		}

	}

	
	// ����Ӧ�� ���Զ� Ҳ����д���ļ� 
	public void getPublicFile(View v) {

		try {
			FileOutputStream out = openFileOutput("public.txt",
					Context.MODE_WORLD_WRITEABLE+Context.MODE_WORLD_READABLE);

			out.write("public".getBytes());
			out.close();
			Toast.makeText(this, "д��ɶ���д �ɹ�", 0).show();
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "д��ɶ���д ʧ�� ", 0).show();
		}

	}

}

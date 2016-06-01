package com.itheima.multithreaddownload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;


import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText ed_path;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ed_path = (EditText) findViewById(R.id.ed_path);
	}

	private static int threadCount = 3;
	private static int currentRunningThread = 3;
	
	String path;
	public void download(View v){
		
		path = ed_path.getText().toString().trim();
		
		new Thread(){
			
			public void run() {
				
				// 1. ������ ���� ����, �õ� Ҫ���ص��ļ��� �����Ƕ���

				try {
					URL url = new URL(path);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();

					conn.setConnectTimeout(5000);
					conn.setRequestMethod("GET");

					int code = conn.getResponseCode();

					if (code == 200) {

						// �õ��ļ��ĳ��� ��С
						int length = conn.getContentLength();
						
						// ff.exe=  getFileName(path)
						// /mnt/sdcard/ff.exe
						File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+getFileName(path));

						RandomAccessFile raf = new RandomAccessFile(file, "rw");
						raf.setLength(length);
						raf.close();

						// �����߳�ȥ�����ļ���

						// ÿ�� �߳� ���ص�ƽ���Ĵ�С
						int blockSize = length / threadCount;

						// threadId :�̵߳�id��
						// threadCount : �������߳� ����
						for (int threadId = 0; threadId < threadCount; threadId++) {

							int startIndex = threadId * blockSize;
							int endIndex = (threadId + 1) * blockSize - 1;

							if (threadId == (threadCount - 1)) {
								endIndex = length - 1;
							}

							new DownloadFilePartThread(threadId, startIndex, endIndex)
									.start();
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		}.start();
		
	}
	
	private class DownloadFilePartThread extends Thread {

		// �̵߳� id ��
		private int threadId;

		// �̵߳� ���صĿ�ʼ λ��
		private int startIndex;

		// �̵߳� ���صĽ��� λ��
		private int endIndex;

		// ��ǰ�߳� ���ص���λ��
		private int currentPostion;

		public DownloadFilePartThread(int threadId, int startIndex, int endIndex) {

			this.threadId = threadId;
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			currentPostion = startIndex;
		}

		@Override
		public void run() {

			System.out.println("�� " + threadId + "�߳̿�ʼ ������   : ����  �� "
					+ startIndex + "~ " + endIndex);
			// ȥ�� ���ص� �¶� -- Ҫ���� Ŀ�� ���ֵ�����
			// ��Ҫ ������ ������
			try {
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();

				conn.setConnectTimeout(5000);
				conn.setRequestMethod("GET");

				// �ڶ��� �� ���ص�ʱ�� , ÿ���߳� ֻ��Ҫ Ŀ�� �ļ��� һ���ֵ�����
				// ��Ҫ ���� ������, ֻ��Ҫ ��һ�ε�����
				// ͨ�� ���� http�� ����ͷ ����ȥʵ�� , ���� ������, ֻ��ҪĿ�� �ε�����

				// startIndex ---- endIndex
				conn.setRequestProperty("range", "bytes=" + startIndex + "-"
						+ endIndex);

				// ��� ���������ص�Ŀ��ε�����

				File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+getFileName(path));
				RandomAccessFile raf = new RandomAccessFile(file, "rw");

				File ilf = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+threadId + ".position");

				if (ilf.exists() && ilf.length() > 0) {

					BufferedReader br = new BufferedReader(new FileReader(ilf));
					String vl = br.readLine();

					int alreadyWritePosition = Integer.parseInt(vl);
					// ���� ������Ҫ���ݵ�ʱ�� ,�����λ�� ��ʼ Ҫ
					conn.setRequestProperty("range", "bytes="
							+ alreadyWritePosition + "-" + endIndex);
					// Ҫ ���� ���ĸ�λ�ÿ�ʼд
					raf.seek(alreadyWritePosition);
					System.out.println("��ʾ ֮ǰ���ع� ");
				} else {

					System.out.println("��ʾ ֮ǰ û��   ���ع� ");
					conn.setRequestProperty("range", "bytes=" + startIndex
							+ "-" + endIndex);
					// Ҫ ���� ���ĸ�λ�ÿ�ʼд
					raf.seek(startIndex);
				}

				// 206 ---
				int code = conn.getResponseCode();
				if (code == 206) {

					// �õ� ����
					InputStream in = conn.getInputStream();

					int len = 0;
					byte[] buf = new byte[1024];
					while ((len = in.read(buf)) > 0) {
						raf.write(buf, 0, len);

						// �� ʵʱ��λ�� �� ��¼�� ������, ��¼��֮��, ���� ��������� ȥ �� �ļ���ȥд
						currentPostion = currentPostion + len;
						File info = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+threadId + ".position");
						
						RandomAccessFile rf = new RandomAccessFile(info, "rwd");
						
						// Ӳ���豸 :����еӲ��(С��� ) , ��̬Ӳ��(û�� ��ν����� , ssd ) 
						
						// �ﵽһ���Ĵ��� �ͻᱨ�� 
						
						// out.write((currentPostion+"").getBytes());
						rf.write(String.valueOf(currentPostion).getBytes());
						rf.close();
					}

					in.close();
					raf.close();
				}

				System.out.println("�� " + threadId + "�߳� ����  ����   �� ");

				// ���� ���е��߳� ��������ɺ� ��ȥ ɾ �ļ�
				// Ūһ�� ������, ��ס �ܹ��� �������߳� ��������, ÿ��һ���߳� �������, �ߵ� �������ʱ��, �ͽ�������-1
				// һ��,
				// ������ ������ С�� ���� ����0 ��ʱ��, ˵��û���߳�����������, ���� ���ʱ��, ��ȥɾ ��¼������λ�õ��ļ�

				File fff = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+threadId + ".position");
				fff.renameTo(new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+threadId + ".position.finish"));
				
				synchronized (MainActivity.class) {

					currentRunningThread--;
					if (currentRunningThread <= 0) {

						// ����¼����λ�õ��ļ���ɾ��

						for (threadId = 0; threadId < threadCount; threadId++) {
							
							File fll = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+threadId + ".position.finish");
							fll.delete();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getFileName(String path) {
		int index = path.lastIndexOf("/");

		return path.substring(index + 1);
	}
	
}

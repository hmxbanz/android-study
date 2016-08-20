package com.itheima.phonelistener;

import java.io.IOException;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneService extends Service {

	private static final String LOG_TAG = "PhoneService";

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	TelephonyManager tm;
	@Override
	public void onCreate() {
		System.out.println("���񴴽��� ");
		super.onCreate();

		// �����绰��״̬ , ����绰���� ,���� ��ͨ�˵绰, �� ��̨ ¼��

		tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

		if(listener==null)
			listener = new MyPhoneStateListener();
		
		tm.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);

	}
	private MyPhoneStateListener listener;
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		tm.listen(listener, PhoneStateListener.LISTEN_NONE);
	}

	private class MyPhoneStateListener extends PhoneStateListener {

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			super.onCallStateChanged(state, incomingNumber);

			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE: // �绰���� -- ���������� ����, stand by

				// ֹͣ ¼��
				if(mRecorder!=null){
					stopRecording();
				}
				
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK: // �绰��ͨ��״̬

				// ���� ¼��
				startRecording();
				break;
			case TelephonyManager.CALL_STATE_RINGING: // �绰������

				break;

			default:
				break;
			}

		}
	}

	private MediaRecorder mRecorder;

	// ��ʼ¼��
	private void startRecording() {
		
		// ʵ����  MediaRecorder
		mRecorder = new MediaRecorder();
		
		//  ָ��һ�� Դ  
		mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		//����� ���ݵ� ��ʽ 
		mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

		// �ļ��� ���浽����  
		mRecorder.setOutputFile("/mnt/sdcard/yy.3gp");
		//  ʹ�� ʲô ������ 
		mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

		try {
			mRecorder.prepare();
		} catch (IOException e) {
			Log.e(LOG_TAG, "prepare() failed");
		}

		mRecorder.start();
	}

	// ֹͣ ¼��
	private void stopRecording() {
		mRecorder.stop();
		mRecorder.release();
		mRecorder = null;
	}

}

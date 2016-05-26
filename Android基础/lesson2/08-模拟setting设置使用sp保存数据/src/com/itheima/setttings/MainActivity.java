package com.itheima.setttings;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {

	private CheckBox cbx;
	private SeekBar sb;
	private SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		cbx = (CheckBox) findViewById(R.id.cbx);
		sb = (SeekBar) findViewById(R.id.seekBar);

		sp = this.getSharedPreferences("config", 0);
		boolean isCheckStatus = sp.getBoolean("isChecked", false);
		int pgs = sp.getInt("progress", 0);
		sb.setProgress(pgs);
		
		cbx.setChecked(isCheckStatus);
		cbx.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override				// buttonView  ---���ǵ�ǰ�� cbx ,  isChecked , ���ǵ�ǰ  cbx ��ʵʱ��״̬
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
					
					//���浽 sharedPreference��
					Editor edit = sp.edit();
					edit.putBoolean("isChecked", isChecked);
					//Ҫ commit
					edit.commit();
				}
			}
		);

		
		
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			
			//ֹͣ �϶� seek bar 
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
				//�õ� ֹͣ �϶���ʱ�̵� ���� 
				int progress = seekBar.getProgress();
				//������ ���浽 sharedPreference �� 
				Editor edit = sp.edit();
				edit.putInt("progress", progress);
				edit.commit();
				
			}
			
			//��ʼ �϶�   seek bar
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			
			//  seek bar�� ���� �ı��� --- ���϶��� 
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				
			}
		});
		
	}

}

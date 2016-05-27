package com.itheima.drawable;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView iv;
	AnimationDrawable rocketAnimation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iv = (ImageView) findViewById(R.id.iv);
		// �� ͼƬ ������  ���� 
		iv.setBackgroundResource(R.drawable.logo);
		
		// ������õ� ����
		rocketAnimation = (AnimationDrawable) iv.getBackground();
		
		rocketAnimation.start();
		
	}
	
	

}

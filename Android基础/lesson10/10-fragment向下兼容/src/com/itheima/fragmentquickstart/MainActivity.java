package com.itheima.fragmentquickstart;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import java.util.List;



@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity {

	FragmentManager manager;
	FragmentTransaction transaction;
	
	SoundFragment sf;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		findViewById(R.id.ed_text);
		
		manager = getSupportFragmentManager();
				
				//事务 
//		transaction = manager.beginTransaction();
//		sf = new SoundFragment();
//		transaction.replace(R.id.container, sf);
//		transaction.commit();  //提交事务 
		
	}

	//声音的 
	public void sound(View v){
		
		//在 右侧的 FrameLayout 去显示  sound 相关 的fragment 数据
		
		transaction = manager.beginTransaction();
		
		// fragment 可以直接 new 出来, 并且不需要到 清单文件中进行注册 
		SoundFragment sf = new SoundFragment();
		//拿到一个frament的 manager 对象
		//事务 
		// 表示 使用 SoundFragment 去替换掉 之前的 framelayout
		transaction.replace(R.id.container, sf);
		transaction.commit();
	}
	
	//存储 的 
	public void storage(View v){
		
		transaction =  manager.beginTransaction();
		
		StorageFragment ssf = new StorageFragment();
				
		transaction.replace(R.id.container, ssf);
		transaction.commit();
		
	}
	
}

package com.itheima.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
/*
 *  ������ǰ ���� 
 * 
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	// ����ȷ��ȡ���Ի���
	public void dialog01(View v){
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		builder.setTitle("Լ���...");
		builder.setMessage("�����, ��Ը���� ?");
		
		builder.setPositiveButton("Ը��,gogogo", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "��Ҳ����, ˵���� ���� ������...", 0).show();
			}
		});
		
		builder.setNegativeButton("��Ը��", null );
		builder.show();
	}
	
	//������ѡ�Ի���
	public void dialog02(View v){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("��ѡ�Ի��� ");
		final String[] items = {"С��","С��","С��"};
		builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				Toast.makeText(MainActivity.this, " ������� : " + items[which] +",λ��: " +which, 0	).show();
				
			}
		});
		builder.show();
	}
	
	//������ѡ�Ի���
	public void dialog03(View v){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("��ѡ");
		// ���ﲻҪ���� message 
//		builder.setMessage("����,����� ѡ ��� ����Ȥȥѧϰ�� �� ???");
		
		final String[] items ={"android","ios","javaee","php","C++"};
		boolean[] checkedItems = {true,true,false,false,false};
		
		builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which,
					boolean isChecked) {
				Toast.makeText(MainActivity.this, " ������� : " + items[which] +",λ��: " +which+", ֵ��: "+ isChecked, 0	).show();
			}
		});
		
		builder.show();
		
	}
	
	//�������Ȼ���
	public void dialog04(View v){
		
		// �ܶ� �ط� , ���� �ȽϺ�ʱ���¶� ʱ ��ʹ�õ��� 
		ProgressDialog dialog = new ProgressDialog(this);
		dialog.setMessage("����ƴ��������....");
		dialog.show();
//		
//		try {
//			Thread.sleep(3000);
//			dialog.dismiss();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		
		// ���� ���� ���� ���� ��ʾ, �鿴Դ���� , ʵ�����ǵ�����  �������Щ���� 
		//ProgressDialog.show(this, "��Ϣ", "����ƴ��������....").show();
		
		
	}
	
	//�������Ȼ���-����������
	public void dialog05(View v){
		
		ProgressDialog dialog = new ProgressDialog(this);
		dialog.setMax(100);
		
//		dialog.set
		
		for (int i = 0; i < 100; i++) {
			dialog.setProgress(i);
		}
		dialog.show();
		
		// �� ������ ȥ ��ʧ 
	}

}

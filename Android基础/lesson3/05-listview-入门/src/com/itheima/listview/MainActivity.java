package com.itheima.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// view
		lv = (ListView) findViewById(R.id.lv);

		lv.setAdapter(new MyAdapter());

		// mvc

		// m : ������Ҫ�󶨵���Ļ�ϵ�����
		// v : ����listview
		// c : ���� MyAdapter
	}

	// ListAdapter--- Simplexxx, Basexxx.
	// ListAdapter
	class MyAdapter extends BaseAdapter {

		// ������� ���ʼ �� ���õ�, ���� ���� ���� �ж��ٸ� item ��Ҫ��ʾ�� lv (ListView )��
		@Override
		public int getCount() {
			 System.out.println(" getCount ������ �� ");
			return 100;
		}

		// ÿ�� item Ҫ��ʾ�� lv �ϵ�ʱ��, �ᱻ���õ��ķ���
		// ˭���� �� ? ----- ���� android ϵͳȥ����, ��������õ�
		// position : ��ǰ�� item �� ���ڵڼ���λ�� �����ݽ�����.

		// convertView:��������������Ż���
		// parent:����ǰ�ġ��� �� �ؼ�

		// �ο�����ʵ ���� ���� , ���ж��� �� ....
		// convertView -- ʵ���� ���� ���� getView ���ص� textView���� , ����ͬһ�� ���͵Ķ��� , ����
		// ��ᷢ�� convertView ����
		// ֮ǰ�� textView
		// �ڴ��о� ֻ�� ��Ҫ ��ʾ�� ��Ļ�ϵ�textView ��
		// ʵ���� �ڴ�� �Ż�,

		// ��� ���� �Ż� ?

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView != null) {
				System.out.println("cv :" + convertView.toString());
			}

			View v;
			if (convertView == null) {
				v =  new TextView(MainActivity.this);
			} else {
				v = convertView;
			}

			System.out.println("getView ��������  : " + position);
			TextView tv = new TextView(MainActivity.this);
			tv.setText("���� �� " + position + "�� item  ========");
			tv.setHeight(40);
			System.out.println("tv: " + tv.toString());
			return tv;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

}

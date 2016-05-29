package com.itheima.news;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import com.itheima.news.domain.NewsItem;
import com.itheima.news.domain.NewsService;
import com.itheima.news.utils.StreamTool;
import com.loopj.android.image.SmartImageView;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Xml;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
						//http://192.168.1.100:8080/news.xml
	private String path ="http://192.168.1.100:8080/news.xml";
	private List<NewsItem> items  =null;
	private ListView lv;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lv = (ListView) findViewById(R.id.lv);
        
        //��ȥ ���� ������ , �� ���� �� ������ 
       
        items = NewsService.getAllNewsItem(path);
        
        // ��item�е����� �󶨵���Ļ��ʾ
        
        loadData();
        
    }

    //����adapter 
    private MyAdapter myadapter;
    
	private void loadData() {
		
		if(myadapter==null){
			
			myadapter = new MyAdapter();
			lv.setAdapter(myadapter);
		}else{
			//֪ͨ ���� �ı�
			myadapter.notifyDataSetChanged();
		}
	}

	private class MyAdapter extends BaseAdapter{

		//ָ�� ������ ���ٸ�item Ҫ��ʾ�� lv ��
		@Override
		public int getCount() {
			return items.size();
		}

		//�����������ÿ�� ��ʾһ��item ʱ �ᱻ���õ��� 
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v ;
			if(convertView==null){
				v=View.inflate(MainActivity.this, R.layout.item, null);
			}else{
				v = convertView;
			}
			
			//�õ� ��ǰλ�� newsItem����
			NewsItem newsItem = items.get(position);
			
			
			
			//�ҵ� item �� ÿ�� �ؼ� 
			SmartImageView siv = (SmartImageView) v.findViewById(R.id.item_iv);
			TextView title= (TextView) v.findViewById(R.id.item_title);
			TextView desc = (TextView) v.findViewById(R.id.item_desc);
			TextView type = (TextView) v.findViewById(R.id.item_type);
			
			title.setText(newsItem.getTitle());
			desc.setText(newsItem.getDescription());
			
			String tp = newsItem.getType();
			if("1".equals(tp)){
				//��������
				type.setText("����: "+ newsItem.getComment());
				type.setTextColor(Color.YELLOW);
				
			}else if("2".equals(tp)){
				
				//������Ƶ
				type.setText("��Ƶ");
				type.setTextColor(Color.RED);
				
			}else if("3".equals(tp)){
				
				// ����ֱ�� 
				type.setText("Liveֱ�� ");
				type.setTextColor(Color.BLUE);
			}
			
			System.out.println(newsItem.getImage());
			
			//���� ��ʾ�������ϵ�ͼƬ��һ���ǳ������Ĳ���.  ����  �ͺܺ��ֵ� �Ѿ�ʵ�ֺ����ֳɵ� ���, ���� ֻ��Ҫ�ù�����һ�¾Ϳ����� ...
			// github  :  
			//ȫ�� ���� ��Դ��Ŀ �й���վ 
//			iv.setI
			
			siv.setImageUrl(newsItem.getImage());
			
			return v;
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

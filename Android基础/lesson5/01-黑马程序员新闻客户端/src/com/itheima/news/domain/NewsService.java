package com.itheima.news.domain;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public class NewsService {
	
	public static List<NewsItem> getAllNewsItem(final String path){
		
		final List<NewsItem> items = new ArrayList<NewsItem>();
		
		 new Thread(){
	        	
	        	public void run() {
	        		
	        		try {
						URL url = new URL(path);
						
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						
						//���ó�ʱʱ��
						conn.setConnectTimeout(5000);
						conn.setRequestMethod("GET");
						
						int code = conn.getResponseCode();
						
						if(code==200){
							
							InputStream in = conn.getInputStream();
							
							//�� xml ��ʽ������ת��Ϊ �ַ������� 
//							String data = StreamTool.decodeStream(in);
//							
//							// ��Ҫ���� ��  xml ��ʽ������ ���� ���� 
//							System.out.println(data);
							
							XmlPullParser parser = Xml.newPullParser();
							parser.setInput(in, "utf-8");
	/*

	<item>
	  <title>��������ź�</title> 
	  <description>�����˲��� ��������ͣ��֧�֣����䣬������ϣ���ˡ�</description>
	  <image>http://192.168.1.100:8080/img/a.jpg</image>
	  <type>1</type>
	  <comment>163</comment>
	</item>

	��������˼��, �Ὣ���� ��װ��  javabean �� --- newsItem

	 * 						
	 */
							
							//��ʼ����
							int type = parser.getEventType();
							NewsItem item=null;
							while(type!=XmlPullParser.END_DOCUMENT){
								
								if(type==XmlPullParser.START_TAG){
									if("item".equals(parser.getName())){
										item = new NewsItem();
									}else if("title".equals(parser.getName())){
										item.setTitle(parser.nextText());
									}else if("description".equals(parser.getName())){
										item.setDescription(parser.nextText());
									}else if("image".equals(parser.getName())){
										item.setImage(parser.nextText());
									}else if("type".equals(parser.getName())){
										item.setType(parser.nextText());
									}else if("comment".equals(parser.getName())){
										item.setComment(parser.nextText());
									}
								}else if(type==XmlPullParser.END_TAG){
									
									//�� item ��ӵ�һ�� list������
									if(item!=null){
										items.add(item);
									}
								}
								type = parser.next();
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	};
	        }.start();
	        
	        return items;
	        
	}
}

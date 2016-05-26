package com.itheima.pullparser;

import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.itheima.pullparser.domain.Product;

import android.os.Bundle;
import android.app.Activity;
import android.util.Xml;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //ʹ�� xml  pull ������ ȥ ���� xml �ļ�������
        
        // Xml
        XmlPullParser pullParser = Xml.newPullParser();
        
        try {
			InputStream in = getAssets().open("result.xml");
			
			// ������Դ ��ʲô ???  --- result.xml
			pullParser.setInput(in, "gbk");
			
			//��� һ�� �¼��� ���� 
			int eventType = pullParser.getEventType();
/*
<?xml version="1.0" encoding="gbk"?>
<smartresult>
  <product type="mobile">
	<phonenum>13512345678</phonenum>
	<location>�����ƶ������п�</location>
	<phoneJx>�е���ʧ��������ʵ������ٲƣ�ʼ��ƽ�� ������</phoneJx>
 </product>
</smartresult>
 * 			
 */
			Product p=null;
			while(eventType!=XmlPullParser.END_DOCUMENT){
				
				if(eventType==XmlPullParser.START_TAG){
					
					//�ж��Ƿ��� Ԫ�صĿ�ʼ , ֻҪ��ĳ�� Ԫ�صĿ�ʼλ��, ��ô�ͻ�������� 
					//��� ��ǰ��������Ԫ�ص�����
					if("product".equals(pullParser.getName())){
						p = new Product();
						// sax ���� 
						
						//׼�� product ���һ��ʵ�� , ȥ ��װ����
						String type = pullParser.getAttributeValue(0);
						p.setType(type);
					}else if("phonenum".equals(pullParser.getName())){
						
						//���   13512345678
						
						// <phonenum>13512345678</phonenum>
						String phonenum = pullParser.nextText();
						p.setPhonenum(phonenum);
					}else if("location".equals(pullParser.getName())){
						
						//<location>�����ƶ������п�</location>
						String location = pullParser.nextText();
						p.setLocation(location);
					}else if("phoneJx".equals(pullParser.getName())){
						
//						<phoneJx>�е���ʧ��������ʵ������ٲƣ�ʼ��ƽ�� ������</phoneJx>
						String phoneJx = pullParser.nextText();
						pullParser.getText();
						p.setPhoneJx(phoneJx);
					}
				}
				//�ֶ� Ų�� "ָ�� "
				eventType = pullParser.next();
			}
			
			if(p!=null){
				System.out.println(p.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
    }

}

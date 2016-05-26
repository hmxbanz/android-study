package com.itheima;

import java.io.StringReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/*
 *    ��Ҫ���� ������ jar �� 
 * 		
 * 		����ȥ pull �������Ĺٷ��ĵ��� �� , Ҳ���� �� �ȸ� ����  ������api ��ȥ�� , ������ �� ���Լ����ص�
 * 		�ĵ���ȥ�� 
 * 
 * 	PullParser		
 * 
 * 
 * 
 */
public class Demo {
	
	
	public static void main(String[] args) throws Exception {
		
		//�õ� һ������ �� 
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		
		//  �Ƿ�֧�� ���� �ռ� �Ľ��� 
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();

        xpp.setInput ( new StringReader ( "<foo>Hello World!</foo>" ) );
        
        // �¼��� ���� 
        int eventType = xpp.getEventType();
        
        // while --true��ѭ�� 
        while (eventType != xpp.END_DOCUMENT) {
         if(eventType == xpp.START_DOCUMENT) {
             System.out.println("Start document");
         } else if(eventType == xpp.END_DOCUMENT) {
             System.out.println("End document");
         } else if(eventType == xpp.START_TAG) {
             System.out.println("Start tag "+xpp.getName());
         } else if(eventType == xpp.END_TAG) {
             System.out.println("End tag "+xpp.getName());
         } else if(eventType == xpp.TEXT) {
             System.out.println("Text "+xpp.getText());
         }
         
         //�ֶ� �ƶ��� �Ǹ� ָ�� 
         eventType = xpp.next();
        }
	}
	
}

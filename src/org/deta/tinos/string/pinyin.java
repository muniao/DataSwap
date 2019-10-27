package org.deta.tinos.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.tinos.view.stable.StableData;

public class pinyin{
	public static void main(String argv[]) throws IOException {
		//init
		InputStream inputStreamc= new pinyin().getClass().getResourceAsStream(StableData.WORDS_SOURSE_LINK_POS_CN_TO_CN);
		BufferedReader cReaderc= new BufferedReader(new InputStreamReader(inputStreamc, StableData.UTF8_STRING));	
		InputStream inputStreamp= new pinyin().getClass().getResourceAsStream(StableData.WORDS_SOURSE_LINK_POS_CN_TO_PY);
		BufferedReader cReaderp= new BufferedReader(new InputStreamReader(inputStreamp, StableData.UTF8_STRING));
		//index
		String cInputStringc;
		String cInputStringp;
		Map<String,String> map= new HashMap<>();
		while ((cInputStringp= cReaderp.readLine())!= null) {
			cInputStringc= cReaderc.readLine();	
			String[] words= cInputStringp.split("/")[0].split(" ");
			for(int i=0; i<words.length; i++) {
				if(!map.containsKey(""+ cInputStringc.charAt(i))) {
					if(!cInputStringc.contains("��ĸ")&&!cInputStringc.contains("���")&&!cInputStringc.contains("����")) {
						map.put(""+ cInputStringc.charAt(i), words[i]);
					}
				}
			}
		}
			String testValue[]= new String[10];
			testValue[0]= "������b";//lyg
			testValue[1]= "������a";
			testValue[2]= "������A";//lyl
			testValue[3]= "����1a";
			testValue[4]= "��a��1a";
			testValue[5]= "��A��1a";
			testValue[6]= "������b";//lzx
			testValue[7]= "������";//lzx
			testValue[8]= "������";//ltt
			testValue[9]= "����Aǿ";//lzq
//					testValue[3]= "������a";//lyg
//					testValue[4]= "������";//lzx
//					testValue[5]= "������";//lzx
//					testValue[6]= "������";//ltt
//			//		

//					String testValue[]= new String[11];
//					testValue[0]= "������a";//lyg
//					testValue[2]= "������A";//lyl
//					testValue[1]= "������a";//lyg
//					testValue[3]= "������b";//lzx
//					testValue[6]= "������";//lzx
//					testValue[5]= "������";//ltt
//					testValue[4]= "����Aǿ";//lzq
//					testValue[7]= "��A��";//lyg
//					testValue[8]= "����A��";//lzc
//					testValue[9]= "��C��A��";//lzc
//					testValue[10]= "������";//lzx
			new QuickLuoyaoguang4DWithChinese().quick4DChineseStringArray(testValue, 0, testValue.length- 1, 5, map);
			//		for(int i=testValue.length-1;i>=0;i--) {
			//			System.out.println(testValue[i]);
			//		}
			for(int i= 0; i< testValue.length; i++) {
				System.out.println(testValue[i]);
			}
		}
	}
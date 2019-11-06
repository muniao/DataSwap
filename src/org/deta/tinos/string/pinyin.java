package org.deta.tinos.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
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
					if(!cInputStringc.contains("��ĸ")&&!cInputStringc.contains("���")
							&&!cInputStringc.contains("����")&&!cInputStringc.contains("����")) {
						map.put(""+ cInputStringc.charAt(i), words[i]);
					}
				}
			}
		}
//		String testValue[]= new String[5];
////		testValue[0]= "��";//lyg
////		testValue[1]= "2";
////		testValue[2]= "1";//lyl
////		testValue[3]= "��";
////		testValue[4]= "��3��2";
		
			String testValue[]= new String[10000];
			testValue[0]= "����c";//lyg
			testValue[1]= "����a";
			testValue[2]= "����A";//lyl
			testValue[3]= "��1a";
			testValue[4]= "b��1a3";
			testValue[5]= "A��1a";
			testValue[6]= "����b";//lzx
			testValue[7]= "��2��";//lzx
			testValue[8]= "����";//ltt
			testValue[9]= "��Aǿ";//lzq
			testValue[10]= "��3��";
			testValue[11]= "����";
			testValue[12]= "��ǿ";
			testValue[13]= "����";
			testValue[14]= "��Ԫ";
			testValue[15]= "����";
			testValue[16]= "��2��7314";
			testValue[17]= "a��1a5";
			testValue[18]= "��2��7";
			testValue[19]= "��2��";
			testValue[20]= "��ǿ3";
			testValue[21]= "��1��";
			testValue[22]= "��2Ԫ";
			testValue[23]= "��2��1";
			testValue[24]= "��2��5566";
			testValue[25]= "a��1a5";
			testValue[26]= "hello world";
			testValue[27]= "hollo worl";
			testValue[28]= "hello werld";	
			for(int i=29;i<10000;i++) {
				testValue[i]= testValue[i%25];
			}	
			Map<String, Object> input =new HashMap<>();
			for(int i=0;i<10000;i++) {
				if(input.containsKey(testValue[i])) {
					input.put(testValue[i]+i, testValue[i]);//��ͬ key �������֡�
				}else {
					input.put(testValue[i], testValue[i]);
				}
			}	
			TimeCheck timeCheck=new TimeCheck();
			timeCheck.begin();
		//	new LYG4DWithChineseMixStringSort7D().quick4DChineseStringArray(testValue, 0, testValue.length- 1, 12, map, 6);
			//List<Object> list= new LYG4DWithMixObjectSort7D().sortMapToList(input, 0, input.size()- 1, 12, map, 6);
			List<Object> list= new LYG4DWithMixObjectSort7D().sortMapToList(input, 0, input.size()- 1, 12, map, 6);
			timeCheck.end();;
			timeCheck.duration();
//			timeCheck.begin();
//			new LYG4DWithChineseMixStringSort2D().quick4DChineseStringArray(testValue, 0, testValue.length- 1,5, map);
//			timeCheck.end();;
//			timeCheck.duration();
//				for(int i=testValue.length-1;i>=0;i--) {
//						System.out.println(testValue[i]);
//					}
			for(int i= 0; i< testValue.length; i++) {
		//		System.out.println(list.get(i));
			}
		}
	}
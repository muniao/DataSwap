package org.deta.tinos.date;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
//refer www.bjtime.com �� 16��17��18�� ������
//ע�����bjtime ��վ�ر���������ܣ��ú�������Ч�����ٻ��������������ṩʱ��У�����ַ��
public class DateValidation{
	public static boolean currentSystemTimeCheck(long offsetUTC8) throws IOException {
		URL url= new URL("http://www.bjtime.cn");
		URLConnection uRLConnection= url.openConnection();
		uRLConnection.connect();
		long bjtime= uRLConnection.getDate();
		long system= currentSystemTimeToUTC(offsetUTC8);
		if(60000< Math.abs(bjtime- system)) {
			return false;
		}
		return true;	
	}

	public static long currentSystemTimeToUTC(long offsetUTC8) {
		return new Date().getTime()+ offsetUTC8;
	}
}
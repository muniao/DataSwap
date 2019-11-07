package org.deta.tinos.string;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.deta.tinos.array.LYG4DWithDoubleQuickSort4D;
public class sortListObjectByDoubleKeyDemo{
	public static void main(String argv[]) throws IOException {
		//��ʼ��һ����Ҫ����Ķ��� ���飬 ���ǲο� ���顾0��������
		List<Object[]> list= new ArrayList<>();
		for(double i= 0; i< 10000; i++) {
			Object[] object= new Object[2];
			object[0]= 10000-i;
			object[1]= ""+ i;
			list.add(object);
		}
		//��ʼ���ʼģ�����򣬲���double ������ת������ ����map���洢��ͬ object key�����顣
		Map<Double, ArrayList<Object[]>> map= new HashMap<>();	
		Iterator<Object[]> iterator= list.iterator();
		while(iterator.hasNext()) {
			Object[] objects= iterator.next();
			ArrayList<Object[]> lists= new ArrayList<>();
			if(map.containsKey(objects[0])) {
				lists= map.get(objects[0]);
				lists.add(objects);
			}else {
				lists= new ArrayList<>(); 
				lists.add(objects);
			}
			map.put((Double) objects[0], lists);
		}
		//�����ں�
		Iterator<Double> iteratorMap= map.keySet().iterator();
		double[] doubles= new double[map.size()];
		int i= 0;
		while(iteratorMap.hasNext()) {
			doubles[i++]= iteratorMap.next();
		}	
		new LYG4DWithDoubleQuickSort4D().sort(doubles, 7);
		//������������
		List<Object[]> output= new ArrayList<>();
		for(double set: doubles) {
			List<Object[]> lists= map.get(set);
			Iterator<Object[]> iterators= lists.iterator();
			while(iterators.hasNext()) {
				output.add(iterators.next());
			}
			map.remove(set);
		}
		//��� ���ԣ�
		for(i= 0; i< output.size(); i++) {
			System.out.println(output.get(i)[0]+ ":" + output.get(i)[1]);
		}
	}
}
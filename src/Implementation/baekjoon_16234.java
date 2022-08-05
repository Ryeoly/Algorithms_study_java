package algo_test;
import java.util.*;
import java.io.*;

public class baekjoon_16234 {

	public static void main(String[] args) throws Exception{
		HashMap<Integer, String> dic = new HashMap<Integer, String>();
		PriorityQueue<HashMap> pq = new PriorityQueue<>();
		dic.put(2, "hi2");
		dic.put(5, "hi5");
		dic.put(1, "hi9");
		dic.put(9, "hi9");
		pq.add(dic);
		System.out.println(pq.peek());
		
	}

}

package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main6 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int count = Integer.parseInt(input.split(" ")[1]);
		StringTokenizer st;
		int time = 0;
		String color = "";
		HashMap<String, LinkedList<Integer>> map = new HashMap<>();
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			time = Integer.parseInt(st.nextToken());
			color = st.nextToken();
			if(!map.containsKey(color)) map.put(color, new LinkedList<>());
			map.get(color).add(time);
		}
		
		for(String key : map.keySet()) {
			Collections.sort(map.get(key));
			System.out.println("색깔 : " + key + " 옷들 : " +map.get(key));
		}
		int answer = 0;
		for(String key : map.keySet()) {
			while(true) {
				if(map.get(key).size() == 1) {
					answer += map.get(key).get(0);
					break;
				}
				else if(map.get(key).size() == 0) {
					break;
				}
				answer += map.get(key).get(map.get(key).size()-1);
				map.get(key).remove(map.get(key).size()-1);
				map.get(key).remove(map.get(key).size()-1);
			}
		}
		System.out.println(answer);
		br.close();
	}

}

package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		String parent = input[0];
		String child = input[1];
		
		ArrayList<Character> list = new ArrayList<>();
		for(int i = 0; i < parent.length(); i++) {
			list.add(parent.charAt(i));
		}
		String answer = "YES";
		for(int i = 0; i < child.length(); i++) {
			if(!list.contains(child.charAt(i))) {
				answer = "NO";
				break;
			}
		}
		
		System.out.println(answer);
		
	}
}

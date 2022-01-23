package BV;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


class Result{
	public static boolean isRight(String s) {
		
		ArrayList<Character> list = new ArrayList<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
				list.add(s.charAt(i));
			}
			else {
				if(s.charAt(i) == '}' && list.size() > 0 && list.get(list.size()-1) == '{') {
					list.remove(list.size()-1);
				}
				else if(s.charAt(i) == ']' && list.size() > 0 && list.get(list.size()-1) == '[') {
					list.remove(list.size()-1);				
				}
				else if(s.charAt(i) == ')' && list.size() > 0 && list.get(list.size()-1) == '('){
					list.remove(list.size()-1);
				}
				else if(list.size() == 0) {
					list.add(s.charAt(i));
				}
			}
		}
		if(list.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static List<String> matchingBraces(List<String> braces) {
		ArrayList<String> list = new ArrayList<>();
		for(String s : braces) {
			if(isRight(s)) {
				list.add("YES");
			}
			else {
				list.add("NO");
			}
		}
	    return list;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int bracesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> braces = IntStream.range(0, bracesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.matchingBraces(braces);
        
        System.out.println(result);

        bufferedReader.close();
    }
}

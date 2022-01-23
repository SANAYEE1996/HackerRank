package BV;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result3{
	
	public static long fact(int n) {
		long ans = 1;
		for(int i = 1; i <= n; i++) {
			ans *= i;
		}
		return ans;
	}
	
	public static int permu(int n, int r) {
		return (int)(fact(n)/(fact(n-r)*fact(r)));
	}
	
	
	public static int countTeams(List<Integer> skills, int minPlayers, int minLevel, int maxLevel) {
	    
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i : skills) {
			if(minLevel <= i && i <= maxLevel) {
				list.add(i);
			}
		}
		int sum = 0;
		int n = list.size();
		System.out.println(minPlayers);
		System.out.println(list);
		for(int i = minPlayers; i <= n; i++) {
			System.out.println(permu(n, i));
			sum += permu(n,i);
		}
		return sum;
	}
}

public class Solution3 {
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       
        int skillsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> skills = IntStream.range(0, skillsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int minPlayers = Integer.parseInt(bufferedReader.readLine().trim());

        int minLevel = Integer.parseInt(bufferedReader.readLine().trim());

        int maxLevel = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result3.countTeams(skills, minPlayers, minLevel, maxLevel);
        
        System.out.println(result);

        bufferedReader.close();
    }
}

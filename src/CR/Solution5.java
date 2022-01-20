package CR;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result5 {


    public static List<Long> bitwiseEquations(List<Long> a, List<Long> b) {
    	List<Long> list = new ArrayList<>();
    	long x = 0, y = 0;
    	for(int i = 0; i < a.size(); i++) {
    		x = a.get(i) + b.get(i);
    		y = a.get(i) - b.get(i);
    		if(x % 2 != 0 || y < 0) {
    			list.add((long)0);
    			continue;
    		}
    		x /= 2;
    		y /= 2;
    		if((x^y) == b.get(i)) {
    			list.add(Math.max(2*x + 3*y, 2*y + 3*x));
    		}
    		else {
    			list.add((long) 0);
    		}
    	}
    	
    	return list;
    }

}


public class Solution5 {
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Long::parseLong)
            .collect(toList());

        int bCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> b = IntStream.range(0, bCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Long::parseLong)
            .collect(toList());

        List<Long> result = Result5.bitwiseEquations(a, b);
        System.out.println(result);

        bufferedReader.close();
    }
}

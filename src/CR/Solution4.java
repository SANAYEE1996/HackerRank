package CR;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result4 {

	

    public static int fountainActivation(List<Integer> locations) {
    	int answer = 1;
    	int start = 0;
    	int end = 0;
    	int realMax = 0;
    	int realMin = 99999;
    	int beforeMax = 0;
    	int n = locations.size();
    	int point = 0;
    	HashMap<Integer, int[]> map = new HashMap<>();
    	for (int i = 0; i < n; i++) {
			start = Math.max(i+1 - locations.get(i), 1);
			end = Math.min(i+1 + locations.get(i), n);
			if(start == end && start > realMax) {
				realMax = start;
				realMin = start;
				map.put(i+1, new int[] {end,end});
				continue;
			}
			if(realMax < end) {
				beforeMax = realMax;
				realMax = end;
				if(realMin < start) {
					map.put(point, new int[] {realMin,beforeMax});
					realMin = start;
					point = i+1;
				}
				else if(realMin == start) {
					point = i+1;
					map.put(point, new int[] {start,realMax});
				}
			}
			if(realMin > start) {
				realMin = start;
				point = i+1;
				map.put(point, new int[] {realMin,realMax});
			}
		}
    	Object[] mapKey = map.keySet().toArray();
    	Arrays.sort(mapKey);
    	
    	int beforeStart = 1;
    	int beforeEnd = 0;
    	realMin = 0;
    	start = 0;
    	end = 0;
    	
    	for(Object key : mapKey) {
    		start = map.get(key)[0];
    		end = map.get(key)[1];
    		if(start > beforeStart && start > realMin) {
    			realMin = beforeEnd;
    			answer++;
    		}
    		beforeStart = start;
    		beforeEnd = end;
    	}
    	return answer;
    }

}


public class Solution4 {

	public static void main(String[] args) throws IOException {
		
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int locationsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> locations = IntStream.range(0, locationsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result4.fountainActivation(locations);
        System.out.println(result);

        bufferedReader.close();
    }

}

/*
 *  1  2  6 11 12
 *  2  1  3
 *  3  2
 *  4  5  6 
 *  5  4
 *  6  4  7  1
 *  7  6
 *  8 12
 *  9 12
 * 10 11
 * 11  1 10
 * 12  1  8  9
 * 
 * 
 * System.out.println("index : "+(i+1)+
							" range : "+start +" to " +end + 
							" 최대 값 : "+realMax + " 최소 값 : " +realMin
							+" 이 값이 있는 인덱스 : " +point);
 * 
 * //System.out.println("키 값 : "+key + " 범위 : " +Arrays.toString(map.get(key)));
 * 
 * 
 * 
 * */

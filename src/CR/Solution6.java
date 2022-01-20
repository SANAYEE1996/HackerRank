package CR;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result6 {

    public static int hospital(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo) {
        int a = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int key = 0;
        for(int i = 0; i < cityFrom.size(); i++) {
        	key = cityFrom.get(i);
        	if(!map.containsKey(key)) {
        		map.put(key, new ArrayList<Integer>());
        	}
        	map.get(key).add(cityTo.get(i));
        }
        for (int j : map.keySet()) {
			System.out.println("key : " + j + " // list : " +map.get(j));
		}
        
        return a;
    }

}

public class Solution6 {
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] cityNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int cityNodes = Integer.parseInt(cityNodesEdges[0]);
        int cityEdges = Integer.parseInt(cityNodesEdges[1]);

        List<Integer> cityFrom = new ArrayList<>();
        List<Integer> cityTo = new ArrayList<>();

        IntStream.range(0, cityEdges).forEach(i -> {
            try {
                String[] cityFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                cityFrom.add(Integer.parseInt(cityFromTo[0]));
                cityTo.add(Integer.parseInt(cityFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result6.hospital(cityNodes, cityFrom, cityTo);
        System.out.println("the answer is : " +result);
        
        
        bufferedReader.close();
    }
}

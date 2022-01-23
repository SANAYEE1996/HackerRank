package BV;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result6{
	public static int connectedSum(int graphNodes, List<Integer> graphFrom, List<Integer> graphTo) {
		
		boolean[] visited = new boolean[graphFrom.size()];
		
		for(int i = 0; i < graphFrom.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
			}
		}
		
		
		return 0;
    }
	
	public static void gogo(List<Integer> graphFrom, 
							List<Integer> graphTo, 
							boolean[] visited, 
							int target) {
		
	}
	
	
	
}

public class Solution6 {
	public static void main(String[] args) throws IOException {
		
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] graphNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int graphNodes = Integer.parseInt(graphNodesEdges[0]);
        int graphEdges = Integer.parseInt(graphNodesEdges[1]);

        List<Integer> graphFrom = new ArrayList<>();
        List<Integer> graphTo = new ArrayList<>();

        IntStream.range(0, graphEdges).forEach(i -> {
            try {
                String[] graphFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                graphFrom.add(Integer.parseInt(graphFromTo[0]));
                graphTo.add(Integer.parseInt(graphFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result6.connectedSum(graphNodes, graphFrom, graphTo);

        System.out.println("the answer is : " +result);
        bufferedReader.close();
    }
}

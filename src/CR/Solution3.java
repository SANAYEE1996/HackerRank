package CR;

import static java.util.stream.Collectors.toList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Result3 {

    
    public static int countMatches(List<String> grid1, List<String> grid2, int n) {
    	int answer = 0;
    	int[][] map = new int[n][n];
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = Character.getNumericValue(grid1.get(i).charAt(j)) 
							+Character.getNumericValue(grid2.get(i).charAt(j));
			}
		}
    	
    	for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
    	boolean[] match = {true};
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				match[0] = true;
				if(map[i][j] == 2) {
					gogo(map, i, j, n, match);
					if(match[0]) {
						answer++;
					}
				}
			}
		}
    	return answer;
    	
    }
    
    public static void gogo(int[][] map, int i, int j, 
    						int n, boolean[] match) {
    	map[i][j] = 0;
    	if(i < n-1 && map[i+1][j] != 0) {
    		if(map[i+1][j] == 1) {
    			match[0] = false;
    		}
    		gogo(map, i+1, j, n, match);
    	}
		if(j < n-1 && map[i][j+1] != 0) {
			if(map[i][j+1] == 1) {
    			match[0] = false;
    		}
			gogo(map, i, j+1, n, match);
    	}
		if(i > 0 && map[i-1][j] != 0) {
			if(map[i-1][j] == 1) {
    			match[0] = false;
    		}
			gogo(map, i-1, j, n, match);
		}
		if(j > 0 && map[i][j-1] != 0) {
			if(map[i][j-1] == 1) {
    			match[0] = false;
    		}
			gogo(map, i, j-1, n, match);
		}
    }

}


public class Solution3 {

	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int grid1Count = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid1 = IntStream.range(0, grid1Count).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int grid2Count = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid2 = IntStream.range(0, grid2Count).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int result = Result3.countMatches(grid1, grid2, grid2Count);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}

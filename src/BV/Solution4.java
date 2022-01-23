package BV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Result4{
	public static int getMax(int [][]board)    {
        int max = 0;
        if(board.length > 1 && board[0].length > 1) {
	        for (int i = 1; i < board.length; i++) {
				for (int j = 1; j < board[i].length; j++) {
					if(board[i][j] == 1) {
						board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]),board[i-1][j-1])+1;
					}
					max = Math.max(max, board[i][j]);
				}
			}
        }
        else {
        	for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if(board[i][j] == 1) {
						max = 1;
						break;
					}
				}
			}
        }
        
        return max*max;
    }
	public static int largestArea(List<List<Integer>> samples) {
		int[][] board = new int[samples.size()][samples.get(0).size()];
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = samples.get(i).get(j);
			}
		}
		
		return getMax(board);
	}
}

public class Solution4 {
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        List<List<Integer>> samples = new ArrayList<>();


        int result = Result4.largestArea(samples);

        System.out.println("the answer is : " +result);
        bufferedReader.close();
    }
}

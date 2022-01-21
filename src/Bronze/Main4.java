package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] arr = new int[size];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		int right = arr[0];
		int left = arr[size-1];
		int rightCount = 1;
		int leftCount = 1;
		
		for(int i = 1; i < size; i++) {
			if(right <= arr[i]) {
				right = arr[i];
				rightCount++;
			}
		}
		
		for(int i = size-2; i >= 0; i --) {
			if(left <= arr[i]) {
				left = arr[i];
				leftCount++;
			}
		}
		
		System.out.println(rightCount + " " +leftCount);
		
	}

}

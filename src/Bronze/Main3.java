package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		String[] ran = br.readLine().split(" ");
		int[] arr = new int[size];
		int[] range = {Integer.parseInt(ran[0]), Integer.parseInt(ran[1])};
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		int sum = 0;
		for(int i = range[0]-1; i < range[1]; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
		
	}

}

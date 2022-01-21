package Bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		String wonju = "3.14 1592 653 589 793 238 46264 33832 79502 884197169399375105820974944";
		System.out.println(wonju.substring(0,2+input));
	}

}

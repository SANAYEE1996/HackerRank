package CR;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Result {
	public static String[] month = {"Jan","Feb","Mar","Apr","May","Jun",
									"Jul","Aug","Sep","Oct","Nov","Dec"};

    public static List<String> preprocessDate(List<String> dates) {
    	
    	List<String> answer = new ArrayList<>();
    	StringBuilder sb = new StringBuilder();
    	for(String s : dates) {
    		sb.setLength(0);
    		String[] str = s.split(" ");
    		sb.append(str[2]);
    		sb.append("-");
    		sb.append(mon(str[1]));
    		sb.append("-");
    		sb.append(day(str[0]));
    		answer.add(sb.toString());
    	}
    	
    	
    	return answer;
    }
    public static String day(String m) {
    	int index = 0;
    	for (int i = 0; i < m.length(); i++) {
			if(!Character.isDigit(m.charAt(i))) {
				index = i;
				break;
			}
		}
    	String answer = m.substring(0, index);
    	if(answer.length() < 2) return "0" + answer;
    	else return answer;
    }
    
    public static String mon(String m) {
    	int answer = 0;
    	for (int i = 0; i < month.length; i++) {
			if(m.equals(month[i])) {
				answer =  i;
				break;
			}
		}
    	if(answer < 10) {
    		return "0"+String.valueOf(answer);
    	}
    	else {
    		return String.valueOf(answer);
    	}
    }

}

public class Solution {

	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH.txt")));

        int datesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> dates = IntStream.range(0, datesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());

        List<String> result = Result.preprocessDate(dates);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );
        
        bufferedReader.close();
        bufferedWriter.close();
    }

}

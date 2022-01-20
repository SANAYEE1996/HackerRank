package CR;

import java.util.*;


class Result2 {
	public static int getOriginSize(int num) {
		int size = 1;
		int value = 10;
		while(num >= value) {
			value *= 10;
			size++;
		}
		return size;		
	}
	
	public static int getSize(long num) {
		int size = 1;
		long value = 10;
		while(num >= value) {
			value *= 10;
			size++;
		}
		return size;		
	}
	

    public static long findRange(int num) {
    	int orginSize = getOriginSize(num);
    	String s = String.valueOf(num);
    	ArrayList<Long> list = new ArrayList<>();
    	System.out.println(s);
    	long max = (long) num;
    	int maxIndex = 0;
    	long min = (long) num; 
    	long minIndex = 0;
    	long val = 0;
    	for (int i = 0; i <= 9; i++) {
    		if(s.contains(String.valueOf(i))) {
    			list.clear();
    			for(int j = 0; j <= 9; j++) {
        			if(i != j) {
        				val = Long.parseLong(s.replaceAll(
    				    						String.valueOf(i), 
    				    						String.valueOf(j)));
        				list.add(val);
        			}
        		}
    			if(max < Collections.max(list)) {
    				maxIndex = i;
    				max = Collections.max(list);
    			}
    		}
		}
    	
    	System.out.println(maxIndex + " 를 바꾼 것이 제일 크다 : " + max);
    	ArrayList<Integer> number = new ArrayList<>();
    	for(int i = 0; i <= 9; i++) {
    		if(i != maxIndex) number.add(i);
    	}
    	for (int i : number) {
    		if(s.contains(String.valueOf(i))) {
    			list.clear();
    			for(int j = 0; j <= 9; j++) {
    				if(i != j) {
    					val = Long.parseLong(s.replaceAll(
	    						String.valueOf(i), 
	    						String.valueOf(j)));
    					if(orginSize == getSize(val)) {
    						list.add(val);
    					}
    				}
    			}
    			if(list.size() > 1 && min > Collections.min(list)) {
    				minIndex = i;
    				min = Collections.min(list);
    			}
    		}
		}
    	if(min == 99999999999L) return 0;
    	System.out.println(minIndex + " 를 바꾼 것이 제일 작다 : " + min);
    	
    	
    	return max - min;
    }

}


public class Solution2 {

	public static void main(String[] args){
		System.out.println("The answer is : "+Result2.findRange(222222)+"\n");
		System.out.println("The answer is : "+Result2.findRange(654321)+"\n");
		System.out.println("The answer is : "+Result2.findRange(7560884)+"\n");
		System.out.println("The answer is : "+Result2.findRange(35993387)+"\n");
		System.out.println("The answer is : "+Result2.findRange(111111111)+"\n");
		System.out.println("The answer is : "+Result2.findRange(100000000)+"\n");
		System.out.println("The answer is : "+Result2.findRange(1000000000)+"\n");
		
    }

}

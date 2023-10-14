package com.example.demo;

public class Solution1 {
	public int solution(String s) {

		  int count_As=0;
	        int count_others=0;
	        int s_len=s.length();
	        for (int i=0;i<s_len;i++){
	            if(s.charAt(i) == 'a') {
	            	count_As++;
	            	
	            }else {
	            	count_others++;
	            	count_As=0;
	            }
	            
	            if(count_As==3) {
	            	return -1;
	            }
	        }
	        return 2* (count_others+1) - (s_len - count_others);
	        

	}

	public static void main(String args[]) {
		Solution1 s = new Solution1();
		//System.out.println(s.solution("aababcae"));

		System.out.println(s.solution("dog"));

		//System.out.println(s.solution("aa"));

		//System.out.println(s.solution("baaa"));

	}
}

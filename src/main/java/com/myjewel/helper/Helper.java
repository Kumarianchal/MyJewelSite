package com.myjewel.helper;

public class Helper {
	public static String getNWords(String content, int n) {
		String[] words = content.trim().split(" ");
		if(words .length < n) {
			return content;
		} else {
			String ans="";
			for(int i=0;i<n;i++) {
				ans=ans+words[i]+" ";
			}
			return ans+"...";
		}
	}
}

package com.dheeraj.backtracking;

public class StringPermutation {

	public static void main(String[] args) {
		String string="ABC";
		char[] st=string.toCharArray();
			printPermutation(st,0,st.length-1);
	}

	private static void printPermutation(char[] st,int j, int index){
	//	for (int i = j; i < st.length; i++) {
			if(index>=0){		
				System.out.println(new String(st));
				swap(st, j, index);
				printPermutation(st,j+1, index-1);
				//System.out.println(new String(st));

		//	}
		}
	}
	
	
	
	private static void swap(char[] st, int index, int swapIndex) {
		if(index!=swapIndex){
		char temp = st[index];
		st[index]=st[swapIndex];
		st[swapIndex]=temp;
	}
	}
}

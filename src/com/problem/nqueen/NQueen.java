package com.problem.nqueen;

public class NQueen {

	public static void main(String[] args) {
	
		int[][] qStep= new int[8][8]; 
		for (int[] is : qStep) {
			for(int i=0; i<is.length;i++){
				is[i]=0;
			}
		}
		
		getNQueen(qStep,0);
		
		for (int[] is : qStep) {
			for(int i: is){
				System.out.print(i);
			}		System.out.println();

		}

	}

	
	private static boolean getNQueen(int[][] qStep,int n) {
		boolean isSafe =false;
		if(n<qStep.length){			
			for (int j = 0; j < qStep[n].length; j++) {
				if(isSafe(n, j, qStep)){
					qStep[n][j]=1;	 
					if(getNQueen(qStep, n+1))
					return true;
					else
						qStep[n][j]=0;
				}
				
			}

		}
		else{
			isSafe=true;
		}
		return isSafe;
	}
	
	
	
	
	
	
	private static boolean isSafe(int x,int y,int[][] qStep){
		boolean isSafe=true;
		for (int i = 0; i < qStep.length; i++) {
			if(qStep[i][y]==1){
				isSafe=false;
				break;
			}
		}
		if(isSafe){
			for (int i = 0; i < qStep[0].length; i++) {
				if(qStep[x][i]==1){
					isSafe=false;
				}

			}
		}
		if(isSafe){
			int diagonal1=x+y;
			int diagonal2=x-y;
			for(int i=0; i<qStep.length; i++) {
				for(int j=0; j<qStep[i].length; j++) {
					if((i+j==diagonal1 && qStep[i][j]==1)|| (i-j==diagonal2 && qStep[i][j]==1)){
						isSafe=false;
						break;
					}
				}
			}
		}
		return isSafe;
	}

	
}

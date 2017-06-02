package com.problem.knighttour;

public class KinghtTour {

	private static int[] stepX = {-2,-2,2,2,-1,-1,1,1};
	private static int[] stepY = {1,-1,1,-1,2,-2,2,-2};
	private static int MAX_COUNT=1000;
	private static int kingX=5;
	private static int kingY=7;	

	public static void main(String[] args) {
		int knightX=2;
		int knightY=1;

		int [][]kStep = new int[8][8];
		getTour(kStep,knightX,knightY,1);
		System.out.println(MAX_COUNT);
		
	}

	private static boolean isValidMove(int x, int y, int i,int[]stepX,int[]stepY,int[][]kStep){
		return	(x+stepX[i]<8 && y+stepY[i]<8 && x+stepX[i]>=0 && y+stepY[i]>=0 && kStep[x+stepX[i]][y+stepY[i]]==0);
	}


	public static boolean getTour(int[][] kStep,int x,int y, int count){
		if(count> MAX_COUNT){
			//System.out.println(count);
			//initializeArray(kStep);
			return false;
		}
		else if(x==kingX && y==kingY){
			for (int[] is : kStep) {
				for (int i : is) {
					System.out.print(i+"|");
				}System.out.println();
			}
System.out.println("-------------------------------");
			MAX_COUNT=count;
	//		initializeArray(kStep);
			return true;
		}
		for (int i = 0; i < stepX.length; i++) {
			if(isValidMove(x,y,i,stepX,stepY,kStep)){
				kStep[x+stepX[i]][y+stepY[i]]=count;
				if(!getTour(kStep, x+stepX[i], y+stepY[i],count+1)){
					kStep[x+stepX[i]][y+stepY[i]]=0;
				}
			}
		}
		return false;
	}

	private static void initializeArray(int[][] kStep) {
		for (int[] is : kStep) {
			for (int i = 0; i < is.length; i++) {
				is[i]=0;
			}
		}
	}
}

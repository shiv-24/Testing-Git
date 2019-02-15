package com.coding.sort;

public class RatInTheMaze {

	
	public static boolean ifSafeBlock(int maze[][], int x, int y,int n) {
		
		return (x>=0 && x<n && y>=0 && y<n &&maze[x][y]==1);
				
	}
	
	public static boolean solution(int sol[][], int x, int y, int maze[][],int n) {
		if(x==n-1 && y==n-1) {
			sol[x][y]=1;
			return true;
		}
		
		if(ifSafeBlock(maze, x, y, n)) {
			sol[x][y]=1;
			
			if(solution(sol, x+1, y, maze, n)) {
				return true;
			}
			if(solution(sol, x, y+1, maze, n)) {
				return true;
			}
			
			sol[x][y]=0;
			return false;
		}
		return false;
	}
	
	public static void printSol(int sol[][],int x,int y) {
		
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				System.out.print(sol[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int maze[][]= {{1, 0, 0, 0}, 
	            {1, 1, 0, 1}, 
	            {0, 1, 0, 0}, 
	            {1, 1, 1, 1}} ;
		int n=4;
		int sol[][]	=	new int[n][n];
		
		solution(sol, 0, 0, maze, n);
		printSol(sol, 4, 4);
	}
}

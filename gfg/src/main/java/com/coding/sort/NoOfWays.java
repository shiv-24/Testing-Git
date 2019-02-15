package com.coding.sort;

public class NoOfWays {

	public static int ways(int [][] maze, int n) {
		
		for(int i=0;i<n;i++) {
			if(maze[i][0]==-1)
				break;
			else
				maze[i][0]=1;
		}
		
		for(int i=0;i<n;i++) {
			if(maze[0][i]==-1)
				break;
			else
				maze[0][i]=1;
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<n;j++) {
				
				if(maze[i][j]==-1)
					continue;
				
				if(maze[i-1][j]>0) {
					maze[i][j]	=	maze[i][j]+maze[i-1][j];
				}
				
				if(maze[i][j-1]>0) {
					maze[i][j]	=	maze[i][j]+maze[i][j-1];
				}
			}
		}
		
		return maze[n-1][n-1]>0 ? maze[n-1][n-1]:0;
	}
	
	public static void main(String[] args) {
		int grid[][]=  {{0, 0, 0, 0}, 
                {0, -1, 0, 0}, 
                {-1, 0, 0, 0}, 
                {0, 0, 0, 0}};
		System.out.println(ways(grid, 4));
	}
}

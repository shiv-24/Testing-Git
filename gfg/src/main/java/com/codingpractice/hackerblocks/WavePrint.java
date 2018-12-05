package com.codingpractice.hackerblocks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WavePrint {

	public static void main(String[] args) throws Exception{
		BufferedReader br	=	new  BufferedReader(new InputStreamReader(System.in));
		
		String sizeString[]	=	br.readLine().split(" ");
		int row	=	Integer.parseInt(sizeString[0]);
		int col	=	Integer.parseInt(sizeString[1]);
		
		int inputArr[][]	=	new  int[row][col];
		
		for(int i=0;i<row;i++) {
			String perRow[]	=	br.readLine().split(" ");
			for(int j=0;j<col;j++) {
				inputArr[i][j]	=	Integer.parseInt(perRow[j]);
			}
		}
	}
	
	private void printWave(int[][]inputArr, int row, int col) {
		
		for(int i=0;i<row;i++) {
			
		}
	}
}

package com.pct.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Basic3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] numberOfLines = input.split(" ");
		int vLines = Integer.parseInt(numberOfLines[0]);
		int hLines = Integer.parseInt(numberOfLines[1]);

		List<Pair> vLineList = new ArrayList<>();
		List<Pair> hLineList = new ArrayList<>();

		Set<List<Pair>> answer = new HashSet<>();
		for (int i = 0; i < vLines; i++) {
			String vInput = br.readLine();
			String[] vPoints = vInput.split(" ");
			int yPoint = Integer.parseInt(vPoints[0]);
			int xPoint1 = Integer.parseInt(vPoints[1]);
			int xPoint2 = Integer.parseInt(vPoints[2]);
			vLineList.add(new Pair(xPoint1, yPoint));
			vLineList.add(new Pair(xPoint2, yPoint));
		}

		for (int i = 0; i < hLines; i++) {
			String hInput = br.readLine();
			String[] hPoints = hInput.split(" ");
			int xPoint = Integer.parseInt(hPoints[0]);
			int yPoint1 = Integer.parseInt(hPoints[1]);
			int yPoint2 = Integer.parseInt(hPoints[2]);
			hLineList.add(new Pair(xPoint, yPoint1));
			hLineList.add(new Pair(xPoint, yPoint2));
		}

		for (int i = 0; i < vLineList.size(); i += 2) {
			Pair vP1 = vLineList.get(i);
			Pair vP2 = vLineList.get(i + 1);

			for (int j = 0; j < hLineList.size(); j += 2) {
				Pair hP1 = hLineList.get(j);
				Pair hP2 = hLineList.get(j + 1);
				if (ifIntersect(vP1, vP2, hP1, hP2)) {
					List<Pair> intersectingLines = new ArrayList<>();
					intersectingLines.add(vP1);
					intersectingLines.add(vP2);
					intersectingLines.add(hP1);
					intersectingLines.add(hP2);
					answer.add(intersectingLines);
				}
			}

		}

		System.out.println(answer.size());
	}

	public static boolean ifIntersect(Pair p1, Pair p2, Pair p3, Pair p4) {
		int p1X = p1.getX();
		int p2X = p2.getX();
		int p3X = p3.getX();
		int p4X = p4.getX();

		if (p1X <= p3X && p3X <= p2X && p1X <= p4X && p4X <= p2X) {
			return true;
		} else {
			return false;
		}
	}
}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}

package com.googlecodejam2008;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SavingTheUniverse {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		Map<String, Integer> browerMapping = null;

		for (int i = 1; i <=testCase; i++) {
			browerMapping = new LinkedHashMap<>();
			int noOfBrowers = Integer.parseInt(br.readLine());
			while (noOfBrowers != 0) {
				String browerName = br.readLine();
				browerMapping.put(browerName.trim(), 0);
				noOfBrowers--;
			}
			int queries = Integer.parseInt(br.readLine());
			while (queries != 0) {
				String browserName = br.readLine();
				browerMapping.put(browserName.trim(), browerMapping.get(browserName.trim()) + 1);
				queries--;
			}
			int max = Integer.MAX_VALUE;
			Iterator<String> ite = browerMapping.keySet().iterator();
			while (ite.hasNext()) {
				String browser = ite.next();
				int browserCount = browerMapping.get(browser);
				if (max > browserCount) {
					max = browserCount;
				}
			}
			System.out.println("Case #" + i + ": " + max);
		}
	}
}

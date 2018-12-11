package codingPractice.gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FrequencyOfAlphabets {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		int[] alpha = new int[26];

		for (int i = 0; i < name.length(); i++) {
			if(name.charAt(i)!=' ')
			alpha[name.charAt(i) - 97]++;

		}
		
		

		Map<Integer, List<Character>> finalMap = new TreeMap<Integer, List<Character>>();
		List<Character> list;
		for (int i = 0; i < 26; i++) {
			if (alpha[i] != 0 && finalMap.get(alpha[i]) == null) {
				list = new ArrayList<>();
				list.add((char) (i + 97));
				finalMap.put(alpha[i], list);

			} else if (alpha[i] != 0) {
				list = finalMap.get(alpha[i]);
				list.add((char) (i + 97));
				finalMap.put(alpha[i], list);
			}
		}

		Iterator<Integer> ite = finalMap.keySet().iterator();
		list = new ArrayList<>();

		while (ite.hasNext()) {
			Integer frequency = ite.next();
			List<Character> innerList = finalMap.get(frequency);

			for (int i = innerList.size() - 1; i >= 0; i--) {
				char charInF = innerList.get(i);
				for (int j = 0; j < frequency; j++) {
					list.add(charInF);
				}
			}
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i) + " ");
		}
	}
}

package DS1;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharInStr {
	public static void main(String[] args) {
		System.out.println(firstUniqChar("aabbc"));
	}
	public static int firstUniqChar(String s) {
		int count = 0;
		Map<Character, Integer> charFreqMap = new LinkedHashMap<>();		
		for(char c: s.toCharArray()) {
			charFreqMap.put(c, charFreqMap.getOrDefault(c, 0)+1);
		}
		Character r = charFreqMap.entrySet().stream()
				.filter(a -> a.getValue()==1)
				.map(Map.Entry::getKey)
				.findFirst()
				.orElse(null);
		return (r==null) ? -1 : s.indexOf(r);
	}
}

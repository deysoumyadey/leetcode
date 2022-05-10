package DS1;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	public static boolean isAnagram(String s, String t) {
		Map<Character, Integer> charFreq = new HashMap<>();
		for(Character c: s.toCharArray()) {
			charFreq.put(c, charFreq.getOrDefault(c, 0)+1);
		}
		for(char c: t.toCharArray()) {
			if(charFreq.containsKey(c)) {
				if(charFreq.get(c)==1)
					charFreq.remove(c);
				else
					charFreq.put(c, charFreq.get(c)-1);
			} else
				return false;
		}
		if(charFreq.isEmpty())
			return true;
		else 
			return false;
	}
	public static boolean isAnagram2(String s, String t) {
        int[] alphabet = new int[Integer.MAX_VALUE];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
	public static void main(String[] args) {
		System.out.println('b'-'a');
		System.out.println(isAnagram2("anagra1m","nagram1a"));
	}
}

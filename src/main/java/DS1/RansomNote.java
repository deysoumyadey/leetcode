package DS1;

public class RansomNote {
	public static void main(String[] args) {
		System.out.print(canConstruct2("aa", "aab"));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		StringBuilder magazine1 = new StringBuilder(magazine);
		for (char c : ransomNote.toCharArray()) {
			int count = 0;
			for (int j = 0; j < magazine1.length(); j++) {
				if (c == magazine1.charAt(j)) {
					magazine1.setCharAt(j, '0');
					count++;
					break;
				}
			}
			if (count == 0)
				return false;
		}
		return true;
	}

	public static boolean canConstruct2(String ransomNote, String magazine) {
		int[] arr = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			arr[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}
}

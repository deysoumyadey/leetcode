package toptal;

public class question2 {
	public static String solution(String message, int K) {
		if(message.length()<=K)
			return message;
		int endIndex = K;
		if(String.valueOf(message.charAt(K)).matches("^[ a-zA-Z]$")) {
			while(message.charAt(endIndex--)!= ' ');			
		}
		return message.substring(0, endIndex+1);
	}
	public static void main(String[] args) {
		System.out.println(solution("why not", 3));
		System.out.println(solution("The quick brown fox jumps over the lazy dog", 39));
		System.out.println(solution("why not", 6) + solution("why not", 8).length());
		System.out.println(solution("why not", 100));
		System.out.println(solution("Codility We test coders", 100));
		System.out.println(solution("Codility We test coders", 21));
		System.out.println(solution("Codility We test coders", 0));
		String ans = solution("a ", 100);
		System.out.println(ans + "length:"+ ans.length());
		System.out.println(solution("a ", 100) + "length:"+ solution(" ", 100).length());
		
	}
}

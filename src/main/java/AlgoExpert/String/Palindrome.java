package AlgoExpert.String;

public class Palindrome {
    public static boolean isPalindromeLoop(String s){
        if(s.isEmpty() || s=="")
            return false;
        int len = s.length();
        for(int i=0; i<=len/2; i++){
            if(s.charAt(i) != s.charAt(len-i-1))
                return false;
        }
        return true;
    }
    public static boolean isPalindromeRecursion(String s){
        if(s.isEmpty() || s.length() == 1){
            return true;
        } else if(s.charAt(0)==s.charAt(s.length()-1)){
            if(1<s.length()-2)
                return isPalindrome(s.substring(1, s.length()-1));
            else
                return true;
        } else {
            return false;
        }
    }

    public static boolean isPalindrome(String s){
        int leftIdx = 0;
        int rightIdx = s.length()-1;
        while(leftIdx<rightIdx){
            if(s.charAt(leftIdx)!=s.charAt(rightIdx))
                return false;
            leftIdx++;
            rightIdx--;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome("abcdcba"));
        System.out.println(isPalindrome("abcddcba"));
        System.out.println(isPalindrome("abddcba"));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("a"));
    }
}
public class Palindrome{
    public static void main(String[] args) {
        System.out.println(isPalindromeStr(333));
    }
    public static boolean isPalindrome(int x){
        int reverse = 0;
        if(x<0 || (x%10==0 && x!=0))
            return false;
        while(x>reverse){
            reverse = (reverse * 10) + x%10; 
            System.out.println(reverse);
            x/=10;
        }
        return (x==reverse || x==reverse/10);
    }
    //faster than above
    public static boolean isPalindromeStr(int x){
        String str = String.valueOf(x);
        if(str.length()==1)
            return true;
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i))
                return false;
        }
        return true;
    }
}
public class RomanToInt {
    public static void main(String[] args){
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("V"));
        System.out.println(romanToInt("VIII"));
        System.out.println(romanToInt("XVI"));
        System.out.println(romanToInt("XXI"));
    }
    public static int romanToInt(String s) {
        int result=0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)=='I' && i+1<=s.length()-1 && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X')){
                result-=1;
            } else if(s.charAt(i)=='I'){
                result+=1;
            } else if(s.charAt(i)=='V'){
                result+=5;
            } else if(s.charAt(i)=='X' && i+1<=s.length()-1 && (s.charAt(i+1)=='L' || s.charAt(i+1)=='C')){
                result-=10;
            } else if(s.charAt(i)=='X'){
                result+=10;
            } else if(s.charAt(i)== 'L'){
                result+=50;
            } else if(s.charAt(i)== 'C'){
                result+=100;
            }
        }
        return result;
    }
}

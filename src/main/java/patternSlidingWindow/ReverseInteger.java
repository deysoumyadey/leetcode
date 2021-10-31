package patternSlidingWindow;

public class ReverseInteger {
    public static int reverse(int x){
        int result=0;
        while(x/10>Math.pow(-2,31)){
            result=(result*10)+(x%10);
            x=x/10;
            System.out.println(x/10);
            System.out.println(x%10);
            System.out.println();
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(reverse(112301));
    }
}

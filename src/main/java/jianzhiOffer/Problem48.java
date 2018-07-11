package jianzhiOffer;

public class Problem48 {

    public static int solution(String str) {
        int sum = 0;
        int carry = 1;
//        int zero_count = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c > 57 || c < 48) {
                System.out.println("error");
                return 0;
            }
            sum = sum + (c - '0') * carry;
            carry = carry * 10;

        }

        return sum;

    }
    
    public static void main(String[] args) {        
        int sum = solution("0012034500");        
        System.out.println(sum);
    }

}

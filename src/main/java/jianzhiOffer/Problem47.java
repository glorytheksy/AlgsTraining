package jianzhiOffer;

public class Problem47 {

    public static int Add(int num1,int num2) {
        // 总和
        int sum = 0;
        // 进位
        int carry = 0;
        
        do {
            sum = num1 ^ num2;
            carry = (num1&num2) <<1;
            num1 = sum;
            num2 = carry;
        } while(num2!=0);

        return num1;
    }

}

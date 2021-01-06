package dynamic_programming;


public class DecodeWays {
    
    public int numDecodings(String s) {
        if (1 == s.length()) {
            if (Integer.valueOf(String.valueOf(s.charAt(0))) == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        // dp[i]代表前i+1个字母有几个解码方式
        int dp[] = new int [s.length()];
        if (this.isZero(s.charAt(0))) {
            dp[0] = 0;
            dp[1] = 0;
        } else {
            dp[0] = 1;
            if (this.isZero(s.charAt(1))) {
                if (this.intNum(s.charAt(0), s.charAt(1)) > 20) {
                    dp[1] = 0;
                } else {
                    dp[1] = 1;
                }
            } else {
                if (this.isBiggerThan26(s.charAt(0), s.charAt(1))) {
                    dp[1] = 1; 
                } else {
                    dp[1] = 2;
                }
            }
        }

        for (int i = 2; i < s.length(); i++) {
            if (Integer.valueOf(String.valueOf(s.charAt(i))) == 0) {
                if (this.isBiggerThan26(s.charAt(i-1), s.charAt(i)) || Integer.valueOf(String.valueOf(s.charAt(i-1))) == 0) {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i - 2];
                }
            } else {
                if (this.isBiggerThan26(s.charAt(i-1), s.charAt(i))) {
                    dp[i] = dp[i-1];
                } else {
                    if (this.isZero(s.charAt(i-1))) {
                        dp[i] = dp[i - 1];
                    } else {
                        dp[i] = dp[i-1] + dp[i-2];
                    }          
                }                
            }
        }
        return dp[s.length() - 1];
    }
    
    public boolean isBiggerThan26(char c1, char c2) {
        String s = String.valueOf(c1) + String.valueOf(c2);
        if (Integer.valueOf(s) > 26) {
            return true;
        } else {
            return false;
        }
    }
    
    public int intNum(char c1, char c2) {
        return Integer.valueOf(String.valueOf(c1) + String.valueOf(c2));
    }
    
    public boolean isZero(char c) {
        return (0 == Integer.valueOf(String.valueOf(c)));
    }
        
    
    
    public static void main(String[] args) {
        char ch = '9';
        if (Character.isDigit(ch)){  // 判断是否是数字
            int num = Integer.parseInt(String.valueOf(ch));
//            System.out.println(num);
        }  
        
        DecodeWays solution = new DecodeWays();
//        System.out.println(solution.isBiggerThan26('2', '5'));
        System.out.println(solution.numDecodings("2101"));
        
    }
    
    
}

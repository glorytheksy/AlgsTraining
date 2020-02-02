package jianzhiOffer_third_time;

/*
 * 注意边界条件，很复杂
 */
public class Problem43 {
    
    public double solution_1(int n, int s) {
        return dice_num_showup_cnt(n,s)/Math.pow(Double.valueOf(6), n);
    }
    
    public int dice_num_showup_cnt(int n, int s) {
        if (n <= 0) {
            System.out.println(n);
            System.out.println(s);
            throw new RuntimeException("param error");
        }
                
        if (1 == n) {
            return 1;
        }
        if (s < n || s > 6*n) {
            return 0;
        }

        return dice_num_showup_cnt(n - 1, s - 1) + dice_num_showup_cnt(n - 1, s - 2) + dice_num_showup_cnt(n - 1, s - 3) +
                dice_num_showup_cnt(n - 1, s - 4) + dice_num_showup_cnt(n - 1, s - 5) + + dice_num_showup_cnt(n - 1, s - 6);        
    }
        
    public int dice_num_showup_cnt_2(int n, int s) {
        if (n <= 0) {
            System.out.println(n);
            System.out.println(s);
            throw new RuntimeException("param error");
        }
        if (s < n || s > 6*n) {
            return 0;
        }
           
        int [][] mat = new int [n+1][6*n + 1]; 
        
        for (int i = 1; i <= 6; i++) {
            mat[1][i] = 1;                        
        }
        
        int y = 2;
        int x = 1;
        while (y <= n) {
            
            while (x <= 6*n) {
                if (x > 6 * y || x < n) {
                    mat[y][x] = 0;
                    x++;
                } else {
                    
                    mat[y][x] = (x-1>=0?mat[y-1][x-1]:0) +
                            (x-2>=0?mat[y-1][x-2]:0) +
                            (x-3>=0?mat[y-1][x-3]:0) +
                            (x-4>=0?mat[y-1][x-4]:0) +
                            (x-5>=0?mat[y-1][x-5]:0) +
                            (x-6>=0?mat[y-1][x-6]:0);                         
                    x++;
                }
            }
            
            y++;
            x=1;
            
        }        
        return mat[n][s];
    }
    
    
    
    
    public static void main(String[] args) {
        Problem43 p = new Problem43();

        System.out.println(p.dice_num_showup_cnt_2(3, 13));
    }

}

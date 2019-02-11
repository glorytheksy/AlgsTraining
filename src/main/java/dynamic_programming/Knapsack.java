package dynamic_programming;

/**
 * 
 * @ClassName Knapsack
 * @Description 原始背包问题
 * @author yxmfight
 * @Date 2019年1月16日 上午10:11:22
 * @version 1.0.0
 */
public class Knapsack {
    
    private int[] cost;
    
    private int[] price;
    
    private int volume;

    /**
     * @Description 解法1，直接运用状态方程递归，空间复杂度较高
     * @param cost
     * @param price
     * @param volume
     * @return
     */
    public int solution_1(int[] cost, int[] price, int volume) {
        if (cost.length != price.length) {
            throw new RuntimeException();
        }
        this.cost = cost;
        this.price = price;
        this.volume = volume;  
        
        return f(cost.length - 1, this.volume);
    }
    
    private int f(int i, int curVol) {
        if (-1 == i) {
            return 0;
        }   
        
        if (this.cost[i] > curVol) {
            return f(i-1, curVol);
        } else {
            return max(f(i-1, curVol), f(i-1, curVol - cost[i]) + this.price[i]); 
        }
                
    }
    
    
    private int max(int a , int b) {
        if (a > b) {
            return a;            
        } else {
            return b;
        }
    }
    
    public static void main(String[] args) {
        int[] cost = new int[] {2,2,6,5,4};        
        int [] price = new int [] {6,3,5,4,6};        
        int volume = 10;
        
        Knapsack sack = new Knapsack();
        
        System.out.println(sack.solution_1(cost, price, volume));                
    }
}

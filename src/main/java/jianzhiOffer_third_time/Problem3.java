package jianzhiOffer_third_time;

/*
 * trick: O(n)时间复杂度内解决问题
 *
 */
public class Problem3 {
    
    public void solution(int[][] arr, int val) {
        if (null == arr) {
            throw new RuntimeException("null arr");
        }
        
        find(arr, 0, arr[0].length - 1, val);                
    }
    
    private void find(int[][] arr, int top_pos, int right_pos, int val) {
        if (top_pos >= arr.length || right_pos < 0) {
            System.out.println("cant find val");
            return;
        }
        
        if (val == arr[top_pos][right_pos]) {
            System.out.println("val found at pos: " + top_pos + "," + right_pos);
            return;
        } else if (val < arr[top_pos][right_pos]) {
            find(arr, top_pos, right_pos - 1, val);
            return;
        } else {
            find(arr, top_pos + 1, right_pos, val);
            return;
        }
                 
    }
    
    
    public static void main(String[] args) {
        Problem3 p = new Problem3();
        int arr[][]={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        int arr[][]= null;
        
        p.solution(arr, 4);
        
        
    }
    

}

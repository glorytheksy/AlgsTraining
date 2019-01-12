package jianzhiOffer_second_time;

/**
 * @ClassName Problem20
 * @Description 顺时针打印矩阵
 * @author yxmfi
 * @Date 2018年7月16日 下午2:51:38
 * @version 1.0.0
 */
public class Problem20 {
    
    public static void solution(int [][] a) {
        int row_len = a.length;
        int col_len = a[0].length;
        
        int row = 0;
        int col = 0;
        
        while (col_len > col * 2 && row_len > row * 2 ) {
            printInner(a, row, col);
            row++;
            col++;
        }
        
    }
    
    private static void  printInner(int [][] a, int row, int col) {
        int row_len = a.length;
        int col_len = a[0].length;
        
        for (int i = col; i <= col_len - col; i++) {
            System.out.print(a[row][i] + " ");
        }
        System.out.println();
        
        for (int i = row + 1; i <= row_len - row; i++) {
            System.out.print(a[i][col_len - col] + " ");
        }
        System.out.println();
        
        for (int i = col_len - col; i >= col; i--) {
            System.out.print(a[row_len - row][i] + " ");
        }
        System.out.println();
        
        for (int i = row_len - row - 1; i >= row; i--) {
            System.out.print(a[i][col] + " ");
        }
        System.out.println();
    }
    
}

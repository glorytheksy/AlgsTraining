package jianzhiOffer_first_time;

/** 
 * @ClassName PrintMatrix
 * @Description 顺时针打印矩阵
 * @author 叶晓蒙
 * @Date 2018年3月22日 上午9:23:24
 * @version 1.0.0
 */
public class PrintMatrix {
    public void printMatrix(int [][] matrix) {
        if (null == matrix) {
            return;
        }
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (rows <= 0 || columns <= 0) {
            return;
        }
        
        // 每次轮循的起始下标
        int start = 0;
        // 终止条件, 起始下标的两倍不能超过长宽限制
        while (rows > 2 * start && columns > 2 * start) {
            this.printLoop(matrix, rows, columns, start);
            start++;
        }
    }
    
    public void printLoop(int [][] matrix, int rows, int columns, int start) {
        int len = columns - 2 * start; 
        int wid = rows - 2 * start;
        
        if (1 == len) {
            for (int i = 0; i < wid; i++) {
                System.out.println(matrix[rows - start + i][columns - start]);
            }
            return;
        }
        if (1 == wid) {
            for (int i = 0; i < len; i++) {
                System.out.println(matrix[rows - start][columns - start + i]);
            }
            return;
        }
        
        for (int i = 0; i < len; i++) {
            System.out.println(matrix[rows - start][columns - start + i]);
        }
        for (int i = 1; i < wid; i++) {
            System.out.println(matrix[rows - start + i][columns - start + len - 1]);
        }
        for (int i = 0; i < len - 1; i++) {
            System.out.println(matrix[rows - start + wid - 1][columns - start + len - 1 - i]);
        }
        
        if (2 < wid) {
            for (int i = 0; i < wid - 1; i++) {
                System.out.println(matrix[rows - start + wid - 1 - i][columns - start]);
            }
        }
        
    }
    
    
    public static void main(String[] args) {        
        PrintMatrix pm = new PrintMatrix();
    }
    
    
}

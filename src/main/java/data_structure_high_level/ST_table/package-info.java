
/**
 * @ClassName package-info
 * @Description ST表
 * @author yxmfi
 * @Date 2021年5月22日 下午1:19:11
 * @version 1.0.0
 */
package data_structure_high_level.ST_table;

/**
 * ST表（Sparse Table，稀疏表）是一种简单的数据结构，
 * 主要用来解决RMQ（Range Maximum/Minimum Query，区间最大/最小值查询）问题。
 * 
 * 它的方法是用矩阵存储数组的区间最值(row, col对应区间上下界)，求的最值直接取值，所以复杂度O(1)
 * 预处理也就是ST表的构造，可以使用动态规划，时间复杂度O(nlogn)，空间复杂度O(n^2)
 * 
 * 缺点：修改复杂度也不低，空间复杂度过高，这点比线段树差
 * 
 */




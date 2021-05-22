/**
 * @ClassName package-info
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author yxmfi
 * @Date 2021年5月22日 下午1:51:53
 * @version 1.0.0
 */
package data_structure_high_level.segment_tree;

/**
 * 线段树就是把一列数据分解为二叉树的形式，每个节点都是一个区间。 
 * 只要是数列上区间上的统计，且满足自下向上的结合的规律（就是可以通过左右子树的统计，推出父节点的统计），就可以使用线段树。
 * 
 * 修改复杂度O(logN)，查询复杂度O(logN)，空间复杂度O(N)
 * 
 * 
 */

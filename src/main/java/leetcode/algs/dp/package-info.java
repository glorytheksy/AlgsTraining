package leetcode.algs.dp;

/**
 * 动态规划
 * 
 * 通用步骤：
 * (1) 确定状态（锁定问题的最后一步，子问题化;当然有的题目像扔鸡蛋就是从第一步分析的）
 * (2) 写出转移方程
 * (3) 确定初始化和边界情况
 * (4) 确定计算顺序（bottom up）
 * 
 * 需要注意的点：
 * 在第(1)和(2)步中，注意子问题是要有最优子结构的
 * 在第(3)步中，初始化数组时通常要多出 1 维用做边界条件，
 * 在第(3)步中，通常需要借助 Integer.MAX_VALUE 等来定义边界情况，注意这个值不是真正的正无穷，所以要加上溢出判断等等
 * 
 * 常见题型：
 * 1. 计数
 * 	有多少种方式到怎么怎么样
 * 
 * 2. 求最大最小值
 * 最长上升序列长度
 * 左上角到右下角路径和的最大值
 * 
 * 3. 求存在性
 */




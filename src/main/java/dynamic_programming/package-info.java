/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     dynamic_programming
 *
 *    Filename:    package-info.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     Digital Telemedia Co.,Ltd
 *
 *    @author:     yxmfi
 *
 *    @version:    1.0.0
 *
 *    Create at:   2019年1月15日 上午11:51:34
 *
 *    Revision:
 *
 *    2019年1月15日 上午11:51:34
 *        - first revision
 *
 *****************************************************************/
/**
 * @ClassName package-info
 * @Description 动态规划相关
 * @author yxmfi
 * @Date 2019年1月15日 上午11:51:34
 * @version 1.0.0
 */
package dynamic_programming;

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
 *  有多少种方式到怎么怎么样
 * 
 * 2. 求最大最小值
 * 最长上升序列长度
 * 左上角到右下角路径和的最大值
 * 
 * 3. 求存在性
 * 
 * 
 * 构建状态方程的方法：
 * (1) f(n)是最终解
 * (2) f(n)不确定是最终解，这样的题目往往最终解形式为 max{f(1), f(2), ... , f(n)} 
 *     或者类似的，f(i,j)不是最终解，max{f(i,j)}或者类似的形式是最优解，比如回文子串
 * (3) 一个f(i)不足以解决问题，往往需要给f(i)构建若干状态，比如每个f(i)有对应的f(i)[0],f(i)[1]，f(i)[2]三个状态，而他们之间有交互
 *     类似的题目比如带冷静期的股票买卖
 *   
 * trick:
 * 如果逻辑太过于复杂，考虑是否忘记使用max和min
 * 有的题目会使用两个dp列表（其实就是带状态的f(i)的特殊版本）
 * 
 * 固定题型：
 * 给一个序列【a1,a2,...】, 给一个限制，求最值等。这样的题型是典型的被包类题目。
 * dp可以构造为dp[i][v], v表示体积，i表示前i个元素
 * 求最值就用max，求总数就用sum，求是否存在就用or或者and
 * 
 * 当然也有变种(比如lc377这种要求排列组合的，用一维的dp反而更简单)
 * 
 * 正则表达式.*?，dp[i][j]分别代表s和p分别从第i和第j个位置匹配
 * 
 * 
 */







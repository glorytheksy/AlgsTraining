package leetcode.algs.binary_search;

/*
* 1. java中除法是向下取整
* 
* 2. 求中间值，老老实实 mid = low + (high - low) / 2，mid = (low + high) / 2 有时候会溢出
*    另外，不管是哪一个，取的都是偏左的值，low到high是奇数，取的恰巧就是中间
* 
* 3. 终结条件应该选 low >= high， 这样不会漏
* 
* 4. low = mid + 1, high = mid - 1
* 
* 5. 对于有重复元素的， nums[mid]==target时，不能return，比如要左边第一个，那就 right = mid - 1 往左边缩（缩过头了也不用怕，low会最终越界刚好到左边第一个）
*    最后返回low
*    返回low之前，要判断一下，low是否越界（因为有可能target根本不在nums中）， low <= nums.length - 1 以及 nums[low] == target
*    
*    如果是右边第一个，对应的，最后要返回high，当然之前也得做一下越界判断，high < 0以及 nums[high] == target
*    
* 
* 6. 二分法的细节比较多，尤其在边界，具体问题具体分析 
*    特别tricky的题目： 寻找重复数，抽屉原理
* 
* 
* 
* */


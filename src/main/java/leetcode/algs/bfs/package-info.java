package leetcode.algs.bfs;

/*
* 注意点：
* 
* 1. bfs遍历判断层尾的方法： 
*     类似于普通层次遍历
*    不同的是，需要知道当前层的轮询数目，可以在while中以整层的方式for轮询当前层元素，并同时计数下一层数目。
*    每层for循环结束， 更新当前层数目，以及下一层数目（比如leetcode 102）
* 
* 2. bfs不仅可以用于遍历，还可以用来求最短路径，这一点有些题目会用到(比如leetcode 1091)，千万别忘了
* 
* */




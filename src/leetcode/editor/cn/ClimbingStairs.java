//ClimbingStairs
package  leetcode.editor.cn;
//2021-06-16 16:50:23
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1697 👎 0

public class ClimbingStairs {
    public static void main(String[] args) {
        //创建该题目的对象方便调用
        Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        int p=0,q=0,sum=1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = sum;
            sum = p + q;
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
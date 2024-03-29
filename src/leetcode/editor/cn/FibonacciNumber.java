//FibonacciNumber
package  leetcode.editor.cn;
//2021-10-11 15:00:00
//斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给你 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 递归 记忆化搜索 数学 动态规划 
// 👍 329 👎 0

public class FibonacciNumber {
    public static void main(String[] args) {
        //创建该题目的对象方便调用
        Solution solution = new FibonacciNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int q = 0, p = 0, r = 1;
        for (int i = 0; i < n - 1; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
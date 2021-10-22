//MinimumCostToMergeStones
package  leetcode.editor.cn;
//2021-06-20 21:11:19
//有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。 
//
// 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。 
//
// 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：stones = [3,2,4,1], K = 2
//输出：20
//解释：
//从 [3, 2, 4, 1] 开始。
//合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
//合并 [4, 1]，成本为 5，剩下 [5, 5]。
//合并 [5, 5]，成本为 10，剩下 [10]。
//总成本 20，这是可能的最小值。
// 
//
// 示例 2： 
//
// 输入：stones = [3,2,4,1], K = 3
//输出：-1
//解释：任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.
// 
//
// 示例 3： 
//
// 输入：stones = [3,5,1,2,6], K = 3
//输出：25
//解释：
//从 [3, 5, 1, 2, 6] 开始。
//合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。
//合并 [3, 8, 6]，成本为 17，剩下 [17]。
//总成本 25，这是可能的最小值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 2 <= K <= 30 
// 1 <= stones[i] <= 100 
// 
// Related Topics 动态规划 
// 👍 139 👎 0

public class MinimumCostToMergeStones {
    public static void main(String[] args) {
        //创建该题目的对象方便调用
        Solution solution = new MinimumCostToMergeStones().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int INF = 0x3f3f3f3f;
        private int K;
        private int[] preSum;
        private int[][][] dp;

        public int mergeStones(int[] stones, int K) {
            if (stones.length == 1) {
                return 0;
            } else if (stones.length < K) {
                return -1;
            }

            int n = stones.length;
            this.K = K;
            preSum = new int[n];
            preSum[0] = stones[0];
            for (int i = 1; i < n; i++) {
                preSum[i] = preSum[i - 1] + stones[i];
            }
            dp = new int[n][n][K + 1];

            int res = memoSearch(0, n - 1, 1);
            return res < INF ? res : -1;
        }

        private int sum(int i, int j) {
            return i == 0 ? preSum[j] : preSum[j] - preSum[i - 1];
        }

        private int memoSearch(int i, int j, int k) {
            if (dp[i][j][k] != 0) {
                return dp[i][j][k];
            }
            if (j - i + 1 == k) {
                return 0;
            } else if (j - i + 1 < k) {
                return INF;
            }
            if (k == 1) {
                dp[i][j][k] = memoSearch(i, j, K) + sum(i, j);
                return dp[i][j][k];
            }

            dp[i][j][k] = INF;
            for (int jj = i; jj < j; jj++) {
                dp[i][j][k] = Math.min(dp[i][j][k],
                        memoSearch(i, jj, 1) + memoSearch(jj + 1, j, k - 1));
            }

            return dp[i][j][k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//LongestPalindromicSubstring
package  leetcode.editor.cn;
//2021-06-17 18:15:03
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3732 👎 0

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        //创建该题目的对象方便调用
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String sd = solution.longestPalindrome("ac");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n<2){
            return s;
        }
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int begin = 0;
        int maxLen = 1;
        char[] charArray = s.toCharArray();
        for (int L = 2; L <= n; L++){
            for (int i = 0;i<n;i++){
                int j = i + L - 1;
                if (j > n-1) break;
                if (charArray[i]!=charArray[j]){
                    dp[i][j] = false;
                }else {
                    if (L == 2){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];

                    }
                }
                if (dp[i][j]&&L>maxLen){
                    begin = i;
                    maxLen = L;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
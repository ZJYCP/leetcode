//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 583 👎 0

  
package leetcode.editor.cn;
public class SpiralMatrixIi{
    public static void main(String[] args) {
         Solution solution = new SpiralMatrixIi().new Solution();
         solution.generateMatrix(4);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = n -1;
        int count = 1;
        while (left <= right && top <= bottom){
            for (int col = left; col <= right; col++){
                res[top][col] = count++;
            }
            for (int row = top+1; row <= bottom; row++){
                res[row][right] = count++;
            }

            if (left < right && top<bottom){
                for (int col=right-1; col > left; col--){
                    res[bottom][col] = count++;
                }
                for (int row = bottom; row > top; row--){
                    res[row][left] = count++;
                }
            }
            right--;
            left++;
            top++;
            bottom--;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
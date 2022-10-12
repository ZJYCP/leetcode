//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 562 👎 0

  
package leetcode.editor.cn;
public class SortAnArray{
    public static void main(String[] args) {
         Solution solution = new SortAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        /**
//         选择排序
//         时间复杂度 O(N2)
//         空间复杂度 O(1)

        for(int i = 0; i < len - 1; i++){
            int minInd = i;
            for(int j = i + 1; j < len; j++){
                if (nums[j] < nums[minInd]){
                    minInd = j;
                }
            }
            int temp = nums[minInd];
            nums[minInd] = nums[i];
            nums[i] = temp;
        }
        return nums;
         **/
        /**
         * 插入排序
         * 时间复杂度 O(N2)
         * 空间复杂度 O(1)
         */
        for (int i = 1; i < len; i++){
            int j = i;
            int temp = nums[i];

            while (j > 0 && nums[j-1] > temp){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
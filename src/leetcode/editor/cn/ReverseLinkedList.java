//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2239 👎 0

  
package leetcode.editor.cn;

import java.util.*;

public class ReverseLinkedList{
    public static void main(String[] args) {
         Solution solution = new ReverseLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {

        List<Integer> res = new ArrayList<>();

        int maxScore = -1;
        int size = nums.length;
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }

        HashMap<Integer, Integer> scoreMapLeft = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> scoreMapRight = new HashMap<Integer, Integer>();
        HashMap<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();


        for(int i =0;i<size; i++){
            if (i==0){
                scoreMapLeft.put(i, 0);
            }else{
                if (nums[i-1] == 0){
                    scoreMapLeft.put(i,scoreMapLeft.getOrDefault(i-1,0)+1);
                }else{
                    scoreMapLeft.put(i,scoreMapLeft.getOrDefault(i-1,0));
                }
            }
            scoreMapRight.put(i,sum - (i - scoreMapLeft.get(i)));
        }
        Iterator<Map.Entry<Integer, Integer>> iter = scoreMapLeft.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) iter.next();
            int index = entry.getKey();

            int leftScore = entry.getValue();
            int rightScore = scoreMapRight.get(index);

            if (leftScore + rightScore > maxScore){
                result.clear();
                res.clear();
                maxScore = leftScore +rightScore;
                res.add(index);
                result.put(maxScore,res);
            }else if(leftScore + rightScore == maxScore){
                res.add(index);
            }
        }
        return result.get(maxScore);



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
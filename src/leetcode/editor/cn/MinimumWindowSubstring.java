//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1590 👎 0

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring{
    public static void main(String[] args) {
         Solution solution = new MinimumWindowSubstring().new Solution();
         solution.minWindow("ADOBECODEBANC","ABC");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Character, Integer> mapT = new HashMap<>();
    HashMap<Character, Integer> mapS = new HashMap<>();
    public String minWindow(String s, String t) {
        int targetSize = t.length();
        int l = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < targetSize; i++) {
            char c = t.charAt(i);
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int leftIndex=0, rightIndex;
        for (rightIndex = 0; rightIndex < s.length(); rightIndex++) {
            char cIndex = s.charAt(rightIndex);
            mapS.put(cIndex, mapS.getOrDefault(cIndex, 0) + 1);

            while (check()){
                mapS.put(s.charAt(leftIndex),mapS.get(s.charAt(leftIndex))-1);
                if (rightIndex - leftIndex + 1 < result){
                    result = rightIndex - leftIndex + 1;
                    l = leftIndex;
                }
                leftIndex++;
            }

        }
        return result==Integer.MAX_VALUE?"":s.substring(l,l+result);

    }
    private boolean check(){
        for (Map.Entry<Character, Integer> entry :
                mapT.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (mapS.getOrDefault(key,0) < val){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
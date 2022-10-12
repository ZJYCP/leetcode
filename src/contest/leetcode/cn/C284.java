package contest.leetcode.cn;

import java.util.ArrayList;
import java.util.List;

public class C284 {
    public static void main(String[] args) {
        int [] nums = new int[]{3,4,9,1,3,9,5};
        int key = 9;
        int k = 1;

        List<Integer> target = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                target.add(i);
            }
        }

        for (int i = 0; i < nums.length; i++){
            for (int target_k : target){
                if (Math.abs(i-target_k) <= k){
                    result.add(i);
                }
            }
        }
        System.out.println(result);
    }
}

package contest.leetcode.cn;

import java.util.Arrays;

public class BC74 {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,4};
        Arrays.sort(num);
        int size = num.length;

        for (int i = 0; i < size / 2; i++){
            if(num[2*i] != num[2*i+1]){
//                return false;
            }
        }
//        return true;
    }
}

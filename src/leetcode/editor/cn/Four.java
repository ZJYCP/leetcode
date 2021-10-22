package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        while (cin.hasNext()){
            int[] nums = new int[5];
            for (int i = 0;i<5;i++){
                nums[i] = cin.nextInt();
            }

            int[] dp = new int[nums.length];
            dp[0] = 1;
            int maxans = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxans = Math.max(maxans, dp[i]);
            }

            int minans = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] < nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                minans = Math.max(minans, dp[i]);
            }

            System.out.println(Math.max(minans,maxans));


        }
    }
}

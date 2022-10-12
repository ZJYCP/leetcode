package contest.leetcode.cn;

import java.util.Arrays;
import java.util.Scanner;

public class BD01 {
    public static void main(String[] args) {
        int result = 0;
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++){
            int num = input.nextInt();
            nums[i] = num;
        }
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++){
            dp[i][i] = nums[i];
            if(i > 0){
                dp[0][i] = dp[0][i-1] * nums[i];
            }
        }
        for (int i=0; i < size; i++){
            for(int j = i+1; j < size; j++){
                dp[i][j] = dp[i][j-1] * nums[j];
            }
        }
        for(int i = 0; i < size; i++){
            for(int j = i; j < size; j++){
                if (dp[i][j] > 0){
                    result += 1;
                }
            }
        }
        System.out.println(result);

    }

}

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()){
            int amount = cin.nextInt();
            int max = amount + 1;
            int[] coins = new int[]{1,5,10,25,50,100};
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            System.out.println(dp[amount] > amount ? -1 : dp[amount]);
        }
    }
}

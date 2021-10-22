package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Scanner;

public class Five {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()){
            int flag = 0;
            int m = cin.nextInt();
            int n = cin.nextInt();
            int[][] obstacleGrid = new int[m][n];
            for (int i = 0;i<m;i++){
                for (int j = 0; j < n; j++) {
                    obstacleGrid[i][j] = cin.nextInt();
                }
            }
            int[][] dp = new int[m][n];
            int[][] acc = new int[m][n];
            dp[0][0] = obstacleGrid[0][0] == -1?-1:obstacleGrid[0][0];
            acc[0][0] = obstacleGrid[0][0] == -1?0:1;
            for (int i = 1; i < m; i++) {
                if (dp[i-1][0] == -1){
                    dp[i][0] = -1;
                }else {
                    dp[i][0] = obstacleGrid[i][0] == -1?-1:dp[i-1][0]+obstacleGrid[i][0];
                }
                acc[i][0] = obstacleGrid[i][0] == -1?0:acc[i-1][0];

            }
            for (int j = 1; j < n; j++) {
                if (dp[0][j-1] == -1){
                    dp[0][j] = -1;
                }else {
                    dp[0][j] = obstacleGrid[0][j] == -1?-1:dp[0][j-1]+obstacleGrid[0][j];
                }
                acc[0][j] = obstacleGrid[0][j] == -1?0:acc[0][j-1];
            }
            for (int i = 1; i<m;i++){
                for (int j = 1;j<n;j++){
                    if (obstacleGrid[i][j]!=-1){
                        acc[i][j] = acc[i-1][j] + acc[i][j-1];
                    }else {
                        acc[i][j] = 0;
                    }
                    if (obstacleGrid[i][j] == -1){
                        dp[i][j] = -1;
                        continue;
                    }
                    if (dp[i][j-1]==-1&&dp[i-1][j]==-1){
                        continue;
                    }
                    if (dp[i][j-1] == -1){
                        dp[i][j] = dp[i-1][j] + obstacleGrid[i][j];
                    }else if (dp[i-1][j] == -1){
                        dp[i][j] = dp[i][j-1] + obstacleGrid[i][j];
                    }else {
                        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]) + obstacleGrid[i][j];
                    }
                }
            }
            if (acc[m-1][n-1] ==0){
                System.out.println("Impossible");
            }else {
                System.out.println(dp[m-1][n-1]);

            }
        }
    }
}

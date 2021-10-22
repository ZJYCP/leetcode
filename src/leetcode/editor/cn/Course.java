package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Course {
    public static void main(String[] args) {
        //创建该题目的对象方便调用
        Scanner cin = new Scanner(System.in);
//        int sum,total;
//        while (cin.hasNext()){
//            int n = cin.nextInt();
//            int[] arrayInput = new int[n];
//            for (int i = 0;i<n;i++){
//                arrayInput[i] = cin.nextInt();
//            }
//            Arrays.sort(arrayInput);
//            sum = arrayInput[0];
//            total = sum;
//            for (int i = 1; i < n-1; i++) {
//                sum += arrayInput[i];
//                total += sum;
//            }
//            System.out.println(total);
//        }
//    }
        int m,n,k,count=0;
        LinkedList<Integer> queue = new LinkedList();
        while (cin.hasNext()){
            m = cin.nextInt();
            n = cin.nextInt();
            k = cin.nextInt();
            int[][] arrays = new int[m][n];
            int [][] result = new int [m][n-k+1];
            int[][] res = new int[m-k+1][n-k+1];
            for (int i = 0;i<m;i++){
                for (int j = 0;j < n;j++){
                    arrays[i][j] = cin.nextInt();
                }
            }
            for (int i = 0;i < m;i++){
                for (int j = 0; j < n; j++) {
                    while (!queue.isEmpty() && arrays[i][queue.peekLast()] <= arrays[i][j]){
                        queue.pollLast();
                    }
                    queue.addLast(j);
                    if (queue.peek() <= j-k){
                        queue.pollFirst();
                    }
                    if (j+1>=k){
                        result[i][j-k+1] = arrays[i][queue.peek()];
                    }
                }
                queue.clear();
            }

            for (int i = 0; i < n - k + 1; i++) {
                for (int j = 0; j < m; j++) {
                    while (!queue.isEmpty() && result[queue.peekLast()][i] <= result[j][i]){
                        queue.pollLast();
                    }
                    queue.addLast(j);
                    if (queue.peek() <= j-k){
                        queue.pollFirst();
                    }
                    if (j+1>=k){
                        res[j-k+1][i] = result[queue.peek()][i];
                    }
                }
                queue.clear();
            }
            System.out.println("Case "+count++);
            for (int[] r : res) {
                for (int s :
                        r) {
                    System.out.print(s+" ");
                }
                System.out.println();
            }
        }
    }
}
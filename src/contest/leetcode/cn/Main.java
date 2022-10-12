package contest.leetcode.cn;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long result = 0;
        long need_k = a / b;
        if (a % b == 0){
            System.out.println(0);
        }else{

            if(a<b){
                result = b-a;
            }else{
                long next_add = a % b;
                long avg_add = next_add / need_k;

                if(next_add % need_k ==0){
                    result = Math.min(avg_add, b-next_add);
                }else{
                    result = Math.min(avg_add+1, b-next_add);
                }

            }
            System.out.println(result);
        }


    }
}
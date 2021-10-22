package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Scanner;

public class Easy {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int a,b,p;
        while (cin.hasNext()){
            a = cin.nextInt();
            b = cin.nextInt();
            p = cin.nextInt();
            int res = forTimes(a, b, p);
            if(res != -1){
                System.out.println(res);
            }else {
                System.out.println("Infinite");
            }
        }
    }
    public static int forTimes(int a, int b, int p) {
        for (int i = 1; i < p; i++){
            if ((a * i) % (b + p) == 0){
                return i;
            }
        }
        return -1;
    }
}

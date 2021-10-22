package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);


        while (cin.hasNext()){
            int a0=1;
            int a1=1;
            int rs = 0;
            long n = cin.nextLong();
            for (int i =2;i<n;i++){
                rs = (3*a1+a0)%100000007;
                a0=a1;
                a1=rs;
            }
            System.out.println(rs);
        }
    }
}

package contest.leetcode.cn;

import java.util.*;

public class MIng {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] result = new int[n];
        Set<Integer> collect = new HashSet<>();
        for (int i = 0; i < n; i++){
            collect.add(cin.nextInt());
            Iterator iterator = collect.iterator();
            while (iterator.hasNext()){
                int key = (int)iterator.next();
                if((key > 1 && key <= i+1 && result[key-2]!=0) || key==1){
                    result[key-1] = i+1;
                    iterator.remove();
                }
            }
        }
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
}

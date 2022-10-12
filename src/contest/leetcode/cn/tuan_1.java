package contest.leetcode.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class tuan_1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t =  cin.nextInt();
        cin.nextLine();
        Map<Integer, Integer> map = new HashMap<>();
        while (t > 0){
            int mina_one = 0;
            int count = 0;
            String[] weight= cin.nextLine().trim().split(" ");
            for(int i = 0; i < weight.length; i++){
                map.put(i, Integer.parseInt(weight[i]));
            }
            char[] input_s = cin.nextLine().toCharArray();
            for (char c : input_s) {
                if(map.get(c-'a') == 0){
                    count++;
                }
            }
            System.out.println(input_s.length - count);
            t--;
        }
    }
}

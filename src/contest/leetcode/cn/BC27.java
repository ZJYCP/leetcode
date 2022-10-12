package contest.leetcode.cn;

import java.util.*;

public class BC27 {
    public static void main(String[] args) {
        String s= "cczazcc";
        int repeatLimit = 3;
        int[] mapping = new int[26];
        StringBuilder sb = new StringBuilder();

        List<Character> charList = new ArrayList<>();
        for(char c : s.toCharArray()){
            mapping[c-'a'] += 1;
            charList.add(c);
        }
        Collections.sort(charList);
        System.out.println(charList);
        int size = charList.size();
//        for(int i = size-1;i>=0;i--){
//            int showed = mapping[charSet - 'a'];
//        }
    }
}

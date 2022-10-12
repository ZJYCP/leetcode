package contest.leetcode.cn;

import java.util.*;

public class C280 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        Map<Integer, Integer> mapEven = new HashMap<>();
        Map<Integer, Integer> mapOdd = new HashMap<>();

        int size = nums.length;
        int even = 0;
        int odd = 0;
        int res = 0;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0){
                even += 1;
                mapEven.put(nums[i], mapEven.getOrDefault(nums[i],0)+1);
            }else{
                odd += 1;
                mapOdd.put(nums[i], mapOdd.getOrDefault(nums[i],0)+1);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(mapEven.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
            //升序排序
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });
        List<Map.Entry<Integer,Integer>> list2 = new ArrayList<>(mapOdd.entrySet());
        Collections.sort(list2,new Comparator<Map.Entry<Integer,Integer>>() {
            //升序排序
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });

        if (list.get(0).getKey() == list2.get(0).getKey()){
            int methodOne = list2.size() == 1 ? 0: list2.get(1).getValue() + list.get(0).getValue();
            int methodTwo = list.size() == 1 ? 0: list.get(1).getValue() + list2.get(0).getValue();
            res = size - Math.max(methodOne, methodTwo);
            System.out.println(res);
        }else {
            res = even - list.get(0).getValue() + odd - list2.get(0).getValue();
            System.out.println(res);
        }


    }
}

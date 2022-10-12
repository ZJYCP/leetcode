import java.util.*;
public class MeiTuan3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        for (int i= 0; i< n; i++){
            String s = input.next();
            int s_len = s.length();
            char[] nums = s.toCharArray();
            int result = 0;
            int left_index = 0;
            int right_index = s_len-1;
            while (left_index<right_index){
                if (nums[left_index]==nums[right_index]){
                    left_index++;
                    right_index--;
                }else if(nums[left_index]=='0' && nums[right_index]=='1'){
                    right_index--;
                    result+=1;
                }else {
                    left_index++;
                    result+=1;
                }
            }
            System.out.println(result);
        }
    }
}

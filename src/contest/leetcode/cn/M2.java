import java.util.*;
public class M2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt();
        int b = cin.nextInt();
        int c = cin.nextInt();
        int result = 0;
        int day = 1;
        while(a > 0 || b > 0 || c > 0){
            if(day == 1 || day == 5 || day == 7){
                if(a>=8){
                    a -= 8;
                }else {
                    break;
                }
            }else if(day ==2 ||day==7){
                if(b>=5){
                    b -= 5;
                }else {
                    break;
                }
            }else {
                if(c>=7){
                    c -= 7;
                }else {
                    break;
                }
            }
            day = day==7 ? 1:day+1;
            result += 1;
        }
        System.out.println(result);
    }
}

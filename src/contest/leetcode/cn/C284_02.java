package contest.leetcode.cn;

public class C284_02 {
    public static void main(String[] args) {
        int n = 2;
        int[][] artifacts = new int[][]{{0,0,0,0},{0,1,1,1}};
        int[][] dig = new int[][]{{0,0},{0,1}};

        boolean[][] map = new boolean[n][n];
        int result = 0;
        for (int[] dig_point : dig){
            int x = dig_point[0];
            int y = dig_point[1];
            map[x][y] = true;
        }

        for(int[] artifact : artifacts){
            if (check(artifact, map)){
                result += 1;
            }
        }
        System.out.println(result);
    }
    public static boolean check(int[] artifact, boolean[][] map){
        for (int x = artifact[0]; x <= artifact[2]; x++){
            for (int y = artifact[1]; y <= artifact[3]; y++){
                if (!map[x][y]){
                    return false;
                }
            }
        }
        return true;
    }

}

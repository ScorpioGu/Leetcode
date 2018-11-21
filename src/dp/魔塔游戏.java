package dp;

/**
 * @Desc https://leetcode.com/problems/dungeon-game/description/
 * @Author gcc
 * @Date 18-11-21 下午12:39
 **/
public class 魔塔游戏 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 0;
        }
        //health[i][j] 表示到达当前位置所需要的最小的血量
        int m = dungeon.length, n = dungeon[0].length;
        int[][] health = new int[m][n];
        for (int i = m - 1; i >=0 ; i--) {
            for (int j = n - 1; j >=0 ; j--) {
                if (i == m - 1 && j == n - 1) {
                    //当血包比较多的时候,所欲要的血量可能是负的,但是负的不可取.至少是1
                    health[i][j] = Math.max(1 - dungeon[i][j], 1);
                } else if (i == m - 1) {
                    health[i][j] = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                } else if (j == n - 1) {
                    health[i][j] = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                } else {
                    int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                    int left = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                    health[i][j] = Math.min(right, left);
                }
            }
        }
        return health[0][0];
    }

    /**
     * 用每一行覆盖下一行来减少时间复杂度
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP2(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 0;
        }
        //health[i][j] 表示到达当前位置所需要的最小的血量
        int m = dungeon.length, n = dungeon[0].length;
        int[] health = new int[n];
        for (int i = m - 1; i >=0 ; i--) {
            for (int j = n - 1; j >=0 ; j--) {
                if (i == m - 1 && j == n - 1) {
                    //当血包比较多的时候,所欲要的血量可能是负的,但是负的不可取.至少是1
                    health[j] = Math.max(1 - dungeon[i][j], 1);
                } else if (i == m - 1) {
                    health[j] = Math.max(health[j + 1] - dungeon[i][j], 1);
                } else if (j == n - 1) {
                    health[j] = Math.max(health[j] - dungeon[i][j], 1);
                } else {
                    int right = Math.max(health[j + 1] - dungeon[i][j], 1);
                    int left = Math.max(health[j] - dungeon[i][j], 1);
                    health[j] = Math.min(right, left);
                }
            }
        }
        return health[0];
    }
    public static void main(String[] args) {
        int[][] in = {{-2,-3,4},{-5,-10,1},{10,30,-5}};
        System.out.println(new 魔塔游戏().calculateMinimumHP(in));
    }
}

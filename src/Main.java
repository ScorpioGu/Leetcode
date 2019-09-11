import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Service> list = new ArrayList<>();
        int[] disks = {5, 2, 5, 10};
        int[] memes = {1, 3, 2, 4};
        int[] values = {1000, 3000, 15000, 16000};
        for (int i = 0; i < 4; i++) {
            list.add(new Service(disks[i], memes[i], values[i]));
        }
        System.out.println(solution(15, 10, list));
    }

    private static int solution(int totalDisk, int totalMemory, List<Service> services) {
        int size = services.size();
        int[] mems = new int[size];
        int[] disks = new int[size];
        int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            mems[i] = services.get(i).memory;
            disks[i] = services.get(i).disk;
            values[i] = services.get(i).user;
        }

        int[][] dp = new int[totalDisk + 1][totalMemory + 1];
        for(int i = 0 ; i < size ; i++)
        {
            for(int u = totalDisk ; u >= disks[i] ;u--) //必须全部从V递减到0
            {
                for(int v = totalMemory ; v >= mems[i] ;v--)
                    dp[u][v] = Math.max(dp[u-disks[i]][v-mems[i]] + values[i] , dp[u][v])  ; //此f[v]实质上是表示的是i-1次之前的值。
            }
        }
        return dp[totalDisk][totalMemory] ;

    }


    private static class Service {
        int disk;
        int memory;
        int user;

        public Service(int disk, int memory, int user) {
            this.disk = disk;
            this.memory = memory;
            this.user = user;
        }

        public int getDisk() {

            return disk;
        }

        public void setDisk(int disk) {
            this.disk = disk;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public int getUser() {
            return user;
        }

        public void setUser(int user) {
            this.user = user;
        }
    }

}


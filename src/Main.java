import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 2, 7, 6}));
    }

    public static int solution(int[] arr) {
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        int count = 0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        List<Integer> B = new ArrayList<>(A);
        Collections.sort(B);
        for(int i = 0; i < B.size();i++){
            map.put(B.get(i), i);
        }
        //DFS
        ArrayList<Integer> C = new ArrayList<>(A);
        ArrayList<Integer> D = new ArrayList<>();
        for(int i = 0; i < C.size();i++){
            if(D.contains(C.get(i)))continue;
            int cycleSize = 1;
            if(C.get(i)!=B.get(i)){
                D.add(C.get(i));
                int a = C.get(i);
                while(true){
                    int curA = map.get(a);//当前元素的正确位置
                    int num = C.get(curA);//当前元素的正确位置上实际的元素
                    int curNum = map.get(num);//当前元素的正确位置上的实际元素的正确位置(是否能形成cycle)
                    cycleSize++;
                    D.add(num);
                    if(curNum==i){
                        break;
                    }
                    a=num;
                }
                count+=(cycleSize-1);
            }
        }
        return count;

    }
}


import java.util.*;

/**
 * Created by Administrator on 2017/10/19.
 */
public class SubSet {

    public static HashMap<ArrayList<Integer>, Integer> map = new HashMap<ArrayList<Integer>, Integer>();

    public static void main(String[] args) {
        SubSet test = new SubSet();
        int[] A = {-2, -1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        boolean[] visited = new boolean[A.length];
        for (int i = 0; i < A.length; i++) {
            visited[i] = false;
        }

        test.getSubSet(visited, A, 8, 0);

        int max = test.getLongestList(map);
        for (ArrayList<Integer> key : map.keySet())
            if (map.get(key).equals(max))
                System.out.println("最长的解:"+key);

    }

    public int getSum(boolean[] visited, int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (visited[i])
                sum += A[i];
        }
        return sum;
    }

    public void getSubSet(boolean[] visited, int[] A, int m, int step) {
        if (step == A.length) {
            if (getSum(visited, A) == m) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = 0; i < A.length; i++) {
                    if (visited[i]) {
                        list.add(A[i]);
                    }
                }
//                System.out.println(list);
                map.put(list, list.size());
            }
            return;
        }

        visited[step] = true;
        getSubSet(visited, A, m, step + 1);
        visited[step] = false;
        getSubSet(visited, A, m, step + 1);

    }

    public int getLongestList(HashMap<ArrayList<Integer>, Integer> map) {
        int max = 0;
        for (Map.Entry<ArrayList<Integer>, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

}

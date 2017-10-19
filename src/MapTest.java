import java.util.*;

/**
 * Created by Administrator on 2017/10/11.
 */
public class MapTest {
    public static void main(String[] args) {
        int[] data = {1, 5, 9, -1, 4, 6, -2, 3, -8, 10, 15, -7, 5, 9};
        int[] result = test(data, 14);
        System.out.println("最优解：" + "[" + data[result[0]] + "," + data[result[1]] + "]");
        System.out.println("所有解如下：");
        testAll(data, 14);
        System.out.println("**********");
        System.out.println("数组优化后的所有解如下：");
        mapAll(data, 14);
        System.out.println("**********");
        System.out.println("list优化后的所有解如下：");
        listAll(data, 14);
    }

    public static int[] test(int[] data, int sum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < data.length; i++) {
            map.put(data[i], i);
        }
        for (int i = 0; i < data.length; i++) {
            int value = sum - data[i];
            if (map.containsKey(value) && map.get(value) != i) {
                int index = map.get(value);
                if (i < index) {
                    return new int[]{i, index};
                } else {
                    return new int[]{index, i};
                }
            }
        }
        return new int[0];
    }

    public static void testAll(int[] data, int sum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < data.length; i++) {
            map.put(data[i], i);
        }
        for (int i = 0; i < data.length; i++) {
            int value = sum - data[i];
            if (map.containsKey(value) && map.get(value) != i) {
                int index = map.get(value);
//                System.out.println("["+data[i] + "," + data[index] + "]");
                if (i < index) {
                    System.out.println("[" + i + "," + index + " ] ");
//                    return new int[]{i , index};
                }
            }
        }

    }


    public static void mapAll(int[] data, int sum) {
        HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
        for (Integer i = 0; i < data.length; i++) {
//            ArrayList<Integer> list=new ArrayList<Integer>();
            if (!map.containsKey(data[i])) {
                Integer[] a = new Integer[1];
                a[0] = i;
                map.put(data[i], a);
            } else {
                Integer b[] = map.get(data[i]);
                Integer[] newNum = new Integer[b.length];
                for (int j = 0; j < b.length; j++) {
                    newNum[j] = b[j];
                }
                List<Integer> list = new ArrayList<Integer>();
                for (int n = 0; n < newNum.length; n++) {
                    list.add(newNum[n]);
                }
                list.add(i);
                Integer[] c = new Integer[list.size()];
                c = list.toArray(c);
//                Integer[] c = (Integer[])list.toArray();
                map.put(data[i], c);
            }

        }

        Set<Integer> k = map.keySet();
        Iterator<Integer> it = k.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            int a = sum - key;
            if (key < a) {
                if (map.containsKey(a)) {
                    System.out.println("[" + key + "," + a + "]");
                }
            }
        }

        //        for (int i = 0; i < data.length; i++) {
//            Integer[] one=map.get(data[i]);
//            int value = sum - data[i];
////            Integer[] m=map.get(value);
//
//            if (map.containsKey(value) ) {  //&& map.get(value)[0]!=i
//                Integer[] another = map.get(value);
//                if(another!=null) {
//                    if(one[0]<another[0])
//                    System.out.println("[" + one[0] + "," + another[0] + "]");
//                }
//            }
//        }
    }

    public static void listAll(int[] data, int sum) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (Integer i = 0; i < data.length; i++) {
            if (!map.containsKey(data[i])) {
//                List<Integer> list=new ArrayList<>();
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(data[i], list);
            } else {
                map.get(data[i]).add(i);
                map.put(data[i], map.get(data[i]));
            }
        }

        Set<Integer> k = map.keySet();
//        Iterator<Integer> it = k.iterator();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer key1 = entry.getKey();
            int a = sum - key1;
            if (key1 < a) {
                if (map.containsKey(a))
                    System.out.println("[" + key1 + "," + a + "]");
            }
        }


//        while (it.hasNext()) {
//            Integer key = it.next();
//            List v =map.get(key);
//            int a = sum - key;
//            if (key < a) {
//                if (map.containsKey(a)) {
//                    System.out.println("[" + key + "," + a + "]");
//                }
//            }
////            System.out.println(key+","+v);
//        }
    }

}

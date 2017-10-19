import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Administrator on 2017/10/11.
 */
public class SetAll {
    public static void main(String[] args) {
        int data[]={1, 5, 9, -1, 4, 6, -2, 3, -8,10,15,-7,7};
//        HashSet result=test(data,10);
//        System.out.println("最优解："+"["+data[result[0]]+","+data[result[1]]+"]");
        System.out.println("所有解如下:");
        testAll(data,10);
    }

//    public static HashSet test(int data[],int sum){
//        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
//        HashSet<int[]> set=new HashSet<int[]>();
//        for (int i = 0; i <data.length ; i++) {
//            map.put(data[i],i);
//        }
//        for (int i = 0; i <data.length ; i++) {
//            int value=sum-data[i];
//            if(map.containsKey(value) && map.get(value)!=i){
//                int index=map.get(value);
//                if(i < index) {
//                    set.add(new int[]{i,index});
////                    return new int[]{i , index};
//                }else {
//                    set.add(new int[]{i,index});
////                    return new int[]{index, i};
//                }
//            }
//        }
//        return set;
//    }

    public static void testAll(int data[],int sum)
    {
        HashSet<Integer> intSets = new HashSet<Integer>(data.length);
        int another;
        for (int i : data)
        {
            another = sum - i;
            if(!intSets.contains(another)){
                intSets.add(i);
            }else{
                System.out.println("["+i + "," + another + " ] " );
            }
        }
    }
}

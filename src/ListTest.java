import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/10/11.
 */
public class ListTest {
    public static void main(String[] args) {
        int data[] = {1, 5, 9, -1, 4, 6, -2, 3, -8};
        Arrays.sort(data);
        test(data,data.length,10);
        System.out.println();
        System.out.println("所有解如下:");
        testAll(data,10);
    }

    public static void test(int data[], int size, int sum)
    {
        int first = 0;
        int last = size -1;
        int s = 0;
        int a=0,b=0;
        while (first < last)
        {
            s = data[first] + data[last];
            if (s == sum)
            {
                a=data[first];
                b=data[last];
                break;
            }
            else if (s < sum)
            {
                first++;
            }
            else
            {
                last--;
            }
        }
        System.out.printf("最优解："+"["+a+","+b+"]");
    }

    public static void testAll(int[] arr, int Sum)
    {
        if(arr == null || arr.length == 0)
            return;
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;

        while(left < right)
        {
            if(arr[left] + arr[right] > Sum)
                right--;
            else if(arr[left] + arr[right] < Sum)
                left++;
            else
            {
                System.out.println("["+arr[left] + "," + arr[right] + "]");
                left++;
                right--;
            }
        }
    }
}

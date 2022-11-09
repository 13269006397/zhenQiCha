package com.xinqiu.user.test;

import org.apache.commons.io.input.ReversedLinesFileReader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Test {


    /**
     * 循环版二分查找
     *
     * @param nums  数组
     * @param n     数组长度
     * @param value 要查找的值
     * @return
     */
    @org.junit.Test
    private static int bserach(int[] nums, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            // 找出中间下标
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > value) {
                high = mid - 1;
            } else if (nums[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * 读文件的最后几行
     * @param file
     * @param lineNum
     * @return
     */
    private static List<String> readLastLines(File file, int lineNum) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("122", "233");

        List<String> result = new ArrayList<>();
        try (ReversedLinesFileReader reader = new ReversedLinesFileReader(file)) {
            String line = "";
            while ((line = reader.readLine()) != null && result.size() < lineNum) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * 归并排序
     */

    public static void main(String[] args) {
        int arr[]= {8,4,5,7,1,3,6,2};

        //假设已经到最后一步
        int arrys[]= {4 ,5 ,7 ,8,1 ,2, 3, 6};
        int[] add=new int[8];
        //第一个参数表示传入数组{4 ,5 ,7 ,8,1 ,2, 3, 6}
        //第二个参数表示这个数组的第一个位置 即是0
        //第三个参数表示这个数组的中间位置  （0+7）/2=3
        //第四个参数 存放临时数组的
        merge(arrys,0,3,7,add);

    }

    public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
        int i=left;  //初始i,左边有序序列的初始索引
        int j=mid+1;  //初始j,右边有序序列的初始索引
        int t=0;       //指向temp数组的当前索引

        //1.
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列,有一边处理完毕为止
        while(i<=mid&&j<=right) {
            if(arr[i]<arr[j]) {
                temp[t]=arr[i++];
                /**
                 * 这里我们这里是：temp[t]=arr[i++];
                 * 如果不好理解，你可以写成这样：
                 * temp[t]=arr[i];i++;
                 */
            }
            else {
                temp[t]=arr[j++];
            }
            //因为无论执行if里面的语句还是else里面的语句,t都要加1,所以把t移出来.
            t++;
        }

        //2.
        //把有剩余数据的一边的的数据依次全部填充到temp
        //由上述循环条件：i<=mid&&j<=right 可知
        //此时要么要么j>right i>mid
        while(i<=mid) {
            temp[t]=arr[i];
            t++;
            i++;

        }
        while(j<=right) {
            temp[t]=arr[j];
            t++;
            j++;

        }

        //3.
        //把temp的数组转移到arr上
        int n=0;
        while(n<arr.length){
            arr[n]=temp[n];
            n++;

        }
        System.out.println(Arrays.toString(arr));

    }

    public void test2(){
        String flag = "false";
        String name = "jack";
        boolean equals = flag.equals(name);

        switch (flag) {
            case "false":
                System.out.println(1);
                break;
            case "true":
                System.out.println(2);
                break;
            case "null":
                System.out.println(3);
                break;
            case "":
                System.out.println(4);
                break;
        }

    }

}

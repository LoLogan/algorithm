/**
 * 数组中出现次数超过一半的数字
 *  思路：
 *      如果将这个数组排序，那么排序后出现在数组中间的数字就是那个出现次数超过一半的数字，这个数字在统计学上被称为中位数
 *      在快排算法中，我们先在数组中随机选择一个数字（基准数）然后调整数组中数字的位置。使得比选中的数字小的数字排在该数字的左边，
 *      选中的大的数字排在该数字的右边，如果这个选中的数字的下标刚好是n/2,则这个数字就是中位数
 */
public class OverHalfInArray2 {

    public int partition(int[] arr, int low, int high){
        //基准数
        int temp = arr[low];

        while(low < high){
            while(arr[high] >= temp && low < high){
                high--;
            }
            if(low < high){
                arr[low] = arr[high];
                low++;
            }
            while(arr[low] <= temp && low < high){
                low++;
            }
            if(low < high){
                arr[high] = arr[low];
                high--;
            }
        }
        arr[low] = temp;
        return low;
    }

    public int overHalfNum(int[] arr){
        if(arr == null || arr.length == 0){
            throw new RuntimeException("输入参数有误！");
        }
        if(arr.length == 1){
            return arr[0];
        }
        int mid = arr.length / 2;       //中间下标

        int low = 0;
        int high = arr.length - 1;
        int index = partition(arr, low, high);
        while(index != mid){
            if(index >mid){
                high = index - 1;
                index = partition(arr, low, high);
            }else{
                low = index + 1;
                index = partition(arr, low, high);
            }
        }

        int result = arr[index];

        //判断中间数有没有超过数组长度的一半
        int count = 0;
        for(int i =0;i<arr.length;i++){
            if(arr[i] == result){
                count++;
            }
        }
        if(count <= mid){
            throw new RuntimeException("出现次数没有超过一半的数字");
        }
        return result;
    }

    public static void main(String[] args) {
        OverHalfInArray2 test = new OverHalfInArray2();
        int[] arr = {1,2,1,2,2};
        int result = test.overHalfNum(arr);
        System.out.println(result);
    }

}
/**
 * 查找数组中最小的k个数,使用快速排序的思想
 */
public class LeastNumbersInArray {

    public int[] getLeastNumbers(int[] arr, int k){
        if(arr == null || arr.length == 0)
            return null;

        int[] result = new int[k];
        int low = 0;
        int high = arr.length - 1;
        int index = partition(arr, low, high);
        while(index != k-1){
            if(index > k-1){
                high = index - 1;
                index = partition(arr, low, high);
            }
            else{
                low = index + 1;
                index = partition(arr, low, high);
            }
        }

        for(int i = 0; i <= k-1; i++){
            result[i] = arr[i];
        }
        return result;
    }

    public int partition(int[] arr, int low, int high){
        //基准数
        int base = arr[low];
        while(low < high){
            while(arr[high] >= base && low < high){
                high--;
            }
            if(low < high){
                arr[low] = arr[high];
                low++;
            }
            while(arr[low] <= base && low < high){
                low++;
            }
            if(low < high){
                arr[high] = arr[low];
                high--;
            }
        }
        arr[low] = base;
        return low;
    }

    public static void main(String[] args) {
        LeastNumbersInArray test = new LeastNumbersInArray();
        int[] arr = {4,21,4,6,7,3,11,6,3,5,2,1};
        int[] result = test.getLeastNumbers(arr, 4);
        for(int num : result){
            System.out.print(num + "  ");
        }
    }
}
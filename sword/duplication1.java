/*
    在一个长度为n+1的数组里的所有数字都在1~n的范围内，所以数组中至少有一个数字是重复的。
    请找出数组中任意一个重复的数字，但是不能修改输入的数组。
    例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字2或者3。
 */
public class duplication1 {

    public static int getDuplication(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] >= arr.length) {
                return -1;
            }
        }

        int start = 1;
        int end = arr.length - 1;
        int mid = 0;
        int count = 0;
        while (start <= end) {
            if (start == end) {
                count = countRange(arr, start, end);
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            mid = (start + end) / 2;
            count = countRange(arr, start, mid);
            if (count > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int countRange(int[] arr, int start, int end) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 4, 2, 5, 6, 7 };
        int result = duplication1.getDuplication(numbers);
        System.out.println(result);
    }
}
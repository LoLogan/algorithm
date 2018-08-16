/**
 * 字符串的排列 前提：字符串中的每个字符都是不相同的
 */
public class StringPermutation {

    public static void main(String[] args) {
        String str = "abcd";
        char[] arr = str.toCharArray();
        permutation(arr, 0);

    }

    public static void permutation(char[] arr, int begin) {
        if (begin == arr.length - 1) {
            String result = new String(arr);
            System.out.println(result);
        } else {
            for (int i = begin; i < arr.length; i++) {
                swap(arr, begin, i);
                permutation(arr, begin + 1);
                swap(arr, begin, i);
            }
        }
    }

    public static void swap(char[] arr, int index1, int index2) {
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
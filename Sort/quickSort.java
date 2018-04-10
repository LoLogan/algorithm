import java.util.Scanner;

/***
 * 快速排序
 */
public class quickSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++){
            a[i] =sc.nextInt();
        }
        quickSort(a);
        for (int i = 0;i<n;i++){
            System.out.println(a[i]);
        }
    }
    static void quickSort(int[] a){
        sort(a,0,a.length-1);

    }
    public static void sort(int[] numbers,int low,int high) {
        if(low < high) {
            int middle = p(numbers,low,high);
            sort(numbers, low, middle-1);
            sort(numbers, middle+1, high);
        }
    }

    public static int p(int[] numbers,int low, int high){
        int temp = numbers[low];
        while (low<high){
            while (low<high && temp<numbers[high])high--;
            numbers[low]=numbers[high];
            while (low<high && temp>numbers[low])low++;
            numbers[high] = numbers[low];
        }
        numbers[low] = temp;
        return low;
    }
}

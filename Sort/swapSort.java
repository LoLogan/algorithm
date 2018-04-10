import java.util.Scanner;

/***
 * 选择排序
 */
public class swapSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++){
            a[i] =sc.nextInt();
        }
        swapSort(a);
        for (int i = 0;i<n;i++){
            System.out.println(a[i]);
        }
    }

    static void swapSort(int[] a){
        int size = a.length;
        int temp = 0;
        for (int i = 0;i<size;i++){
            int k = i;  //最小位数的下标
            for (int j = size-1;j>i;j--){
                if (a[j]<a[k])
                    k=j;
            }
            temp = a[k];
            a[k]=a[i];
            a[i]=temp;
        }
    }
}

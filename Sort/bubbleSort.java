import java.util.Scanner;

/***
 * 冒泡排序
 */
public class bubbleSort {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++){
            a[i] =sc.nextInt();
        }
        bubbleSort(a);
        for (int i = 0;i<n;i++){
            System.out.println(a[i]);
        }
    }
    static void bubbleSort(int[] a){
        int size = a.length;
        int temp = 0;
        for (int i = 0; i<size-1; i++)
            for (int j =0; j<size-1-i; j++){
                if (a[j]>a[j+1]){
                    temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
    }

}

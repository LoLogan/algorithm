import java.util.Scanner;

/***
 * 插入排序
 */
public class insertSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++){
            a[i] =sc.nextInt();
        }
        insertSort(a);
        for (int i = 0;i<n;i++){
            System.out.println(a[i]);
        }
    }
    static void insertSort(int[] a){
        int size = a.length;
        int temp=0;
        int j = 0;
        for (int i = 0;i<size;i++){
            temp = a[i];
            for (j=i;j>0 && a[j-1]>temp;j--){
                a[j]=a[j-1];
            }
            a[j]=temp;
        }
    }
}

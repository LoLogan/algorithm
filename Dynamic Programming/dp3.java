import java.util.Scanner;

/***
 * 给定一个序列 An = a1 ,a2 ,  ... , an ，找出最长的子序列使得对所有 i < j ，ai < aj 。
 */
public class dp3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        int max=0;
        for (int i = 0; i < n; i++) {
            numbers[i] =sc.nextInt();
        }
        int[] result =new int[n];
        for (int i = 0; i<n; i++){
            result[i]=1;
            for (int j = 0; j<i; j++) {
                //状态转移方程
                result[i] = (numbers[i] > numbers[j] && result[i]<=result[j]) ? result[j] + 1 : result[i];
            }
            if (i==0)max = result[i];
            else if (max < result[i]) max = result[i];
        }
        System.out.println(max);

    }

}

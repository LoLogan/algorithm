import java.util.Scanner;

/*
   数塔问题：要求从顶层走到底层，若每一步只能走到相邻的结点，则经过的结点的数字之和最大是多少？
                 9
              12  15
            10   6  8
           2  18   9  5
         19  7  10  4  16
 */
public class test2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] number = new int[n][n];
        for (int i = 0; i<n; i++)
            for (int j = 0; j<i+1; j++){
            number[i][j] = sc.nextInt();
        }

        for (int i = n-1; i>0; i--)
            for (int j = 0; j<i ;j++){
            //状态转移方程：sum[i] = max(a[左孩子] , a[右孩子]) + a[i]
            number[i-1][j] = number[i][j]>number[i][j+1]?number[i-1][j]+number[i][j]:number[i-1][j]+number[i][j+1];
        }
        System.out.println(number[0][0]);

    }
}

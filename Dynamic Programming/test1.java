import java.util.Scanner;

/*
最大连续子序列之和
给定K个整数的序列{ N1, N2, ..., NK }，其任意连续子序列可表示为{ Ni, Ni+1, ..., Nj }，
其中 1 <= i <= j <= K。最大连续子序列是所有连续子序中元素和最大的一个， 例如给定序列
{ -2, 11, -4, 13, -5, -2 }，其最大连续子序列为{ 11, -4, 13 }，最大和为20。

*/
public class test1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] number = new int[n];
        for (int i = 0; i<n; i++){
            number[i] = sc.nextInt();
        }
        System.out.println(getSumMax(number));
    }


    /***
     * 动态规划很清晰，但是遍历了两次数组，感觉效率略低
     * @param number
     * @return
     */
    public static int getSumMax(int[] number){

        int n = number.length;
        int[] sum = new int[n];
        int max = 0;


        for (int i =0; i<number.length; i++){
            if (i==0) {
                max = number[i];
                sum[i] = number[i];
            }
            else sum[i] = max(sum[i-1]+number[i],number[i]);   //状态转移方程

            if (max < sum[i]) max = sum[i];
        }

        return max;
    }

    public static int max(int x,int y){
        return x>y?x:y;
    }
}

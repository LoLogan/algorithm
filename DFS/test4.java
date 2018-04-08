import java.util.Scanner;

/**
 *  使用二维矩阵中的0和1模拟水和岛，岛是1组成的区域(上下左右相邻的1是同一片岛屿)，岛屿四周被水环绕。
    比如：
    11110
    11010
    11000
    00000
    其中岛屿有1个
    11000
    11000
    00100
    00011
    其中岛屿有3个

    输入：
    第一行输入一个数m代表行数,第二行输入一个数n列数，(0<m,n<10)，接下来的m行输入矩阵内容，
    4
    5
    11000
    11000
    00100
    00011

    输出：
    岛屿数
    3
 */
public class test4 {
    static int m;
    static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
         m = sc.nextInt();
         n = sc.nextInt();
        int count = 0;
        int[][] num = new int[m][n];
        for (int i = 0; i<m; i++)
            for (int j = 0; j<n; j++)
                num[i][j]=sc.nextInt();

        for (int i = 0; i<m; i++)
            for (int j = 0; j<n; j++)
                if (num[i][j]==1){
                    count++;
                   dfs(num,i,j);
                }
        System.out.println(count);
    }
    static void dfs(int[][]num, int i, int j){
        if (i<0||j<0||i>m-1||j>n-1) return;
        if (num[i][j]==0)return;
        num[i][j]=0;
        dfs(num,i-1,j);
        dfs(num,i+1,j);
        dfs(num,i,j+1);
        dfs(num,i,j-1);
    }
}

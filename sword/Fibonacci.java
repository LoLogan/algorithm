/**
 * 求斐波那契数列的第n项：循环实现
 */
public class Fibonacci {


    /**
     * 递归实现 效率差
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if(n==0) return 0;
        else if(n==1) return 1;
        else  return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public static int fabonacci(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        int temp1 = 0;      //第n-2项的值
        int temp2 = 1;      //第n-1项的值
        int result = 0;
        for(int i = 2; i <= n; i++){
            result = temp1 + temp2;
            temp1 = temp2;
            temp2 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fabonacci(10));
    }

}
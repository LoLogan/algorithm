/**
 * 数值的整数次方
 */
public class powerWithExponet {

    boolean invalidInput = false;       //使用全局变量处理错误

    public double power(double base, int exponent) {
        int n = Math.abs(exponent);
        if(n==0) return 1.0;
        if(n==1) return base;
        double result = power(base, exponent/2);
        result *= result;
        if(n%2==1)
            result *=base;
        if (exponent < 0) // 如果指数为负数，则应该求result的倒数
            result = 1 / result;
        return result;
    }

    public double powerWithExponet(double base, int exponent){
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }

    //比较两个小数是否相等
    public boolean equal(double num1, double num2){
        double tmp = num1 - num2;
        if(tmp > -0.0000001 && tmp < 0.0000001)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        powerWithExponet test = new powerWithExponet();
        double result = test.power(2.0, 4);
        System.out.println("是否是非法输入：" + test.invalidInput);
        System.out.println("结果是：" + result);
    }

}
public class NumberOf1 {
    public int NumberOf1(int n) {
        int number = 0;
        while(n!=0){
            number++;
            n = n&(n-1);
        }
        return number;
    }
}
import java.util.Scanner;

/**
 *   返回回文子串
     Given a string s, partition s such that every substring of the partition is a palindrome.

     Return the minimum cuts needed for a palindrome partitioning of s.

     For example, given s ="aab",
     Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 */
public class dp4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] number = new int[s.length()];
        for (int i = 0; i<s.length(); i++){
            number[i]=i;
            if (judge(s.substring(0,i+1))) number[i] = 0;
            if (number[i]==0) continue;
            for (int j = 1; j<=i; j++){
                if (judge(s.substring(j,i+1)))
                    number[i] = Math.min(number[i],number[j-1]+1);      //状态转移方程
            }
        }
        System.out.println(number[s.length()-1]);
//        System.out.println(judge(s));

    }
    public static boolean judge(String s){
        boolean flag = true;
        int length = s.length();
        for (int i=0,j=length-1;i<j;i++,j--)
            if (s.charAt(i)!=s.charAt(j)){
                flag = false;
                break;
            }
        return flag;
    }
}

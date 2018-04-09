import java.util.ArrayList;
import java.util.Scanner;

/**
     Given a string s, partition s such that every substring of the partition is a palindrome.

     Return all possible palindrome partitioning of s.

     For example, given s ="aab",
     Return

     [
     ["aa","b"],
     ["a","a","b"]
     ]
 */
public class dfs2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        partition(s);
    }

    /***
     * 回文问题，采用深度遍历 回溯
     * @param s
     * @return
     */
    public static ArrayList<ArrayList<String>> partition(String s) {
        return null;
    }

}

/**
 * 二叉搜索树的后序遍历序列
 */
public class verifySquenceOfBST {

    public static boolean verifySquenceOfBST(int[] arr, int start, int end) {

        if (start >= end) {
            return true;
        }

        //根节点
        int rootValue = arr[end];

        // 在二叉搜索树中左子树节点的值小于根节点的值
        int index = start;
        for (; index <= end-1; index++) {
            if (arr[index] > rootValue)
                break;
        }

        int end1 = index - 1;
        int start2 = index;

        // 在二叉搜索树中右子树节点的值大于根节点的值
        index = start2;
        while (index <= end-1) {
            if (arr[index] < rootValue) {
                return false;
            }
            index++;
        }

        /**
         * 判断左右子树是不是二叉搜索树
         */
        if (verifySquenceOfBST(arr, start, end1) && verifySquenceOfBST(arr, start2, end - 1))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int[] arr = { 5,7,6,10,9,11,8 };
        System.out.println(verifySquenceOfBST(arr, 0, arr.length - 1));
    }

}
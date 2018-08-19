import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用循环实现二叉树的镜像
 */
public class MirrorTree {

    //递归
    public void mirrorRecursively(TreeNode root) {
        if (root == null) {
            return ;
        }
        if (root.left == null && root.right == null) {
            return ;
        }
        // 交换根节点的左右子树
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        if(root.left != null){
            mirrorRecursively(root.left);
        }
        if(root.right != null){
            mirrorRecursively(root.right);
        }
    }

    //非递归
    public static TreeNode mirror(TreeNode root){
        if(root == null){
            return null;
        }
        //使用队列来实现
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode tmpNode = queue.poll();
            if(tmpNode.left != null || tmpNode.right != null){
                swap(tmpNode);
                if(tmpNode.left != null){
                    queue.add(tmpNode.left);
                }
                if(tmpNode.right != null){
                    queue.add(tmpNode.right);
                }
            }
        }
        return root;
    }

    public static void swap(TreeNode root){
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
    }
}
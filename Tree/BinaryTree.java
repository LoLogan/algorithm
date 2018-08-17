import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 二叉树遍历
 前序遍历
 中序遍历
 后序遍历
 层次遍历
 */
public class BinaryTree {

    public static void main(String[] args){
        BinaryNode binaryTree4 = new BinaryNode(4);
        BinaryNode binaryTree2 = new BinaryNode(2);
        BinaryNode binaryTree6 = new BinaryNode(6);
        BinaryNode binaryTree1 = new BinaryNode(1);
        BinaryNode binaryTree3 = new BinaryNode(3);
        BinaryNode binaryTree5 = new BinaryNode(5);
        BinaryNode binaryTree7 = new BinaryNode(7);
        BinaryNode binaryTree8 = new BinaryNode(8);
        BinaryNode binaryTree9 = new BinaryNode(9);

//                5
//            3          7
//          1    4     6    8
        binaryTree5.left = binaryTree3;
        binaryTree3.left = binaryTree1;
        binaryTree3.right = binaryTree4;
        binaryTree5.right = binaryTree7;
        binaryTree7.left = binaryTree6;
        binaryTree7.right = binaryTree8;

//        postOrder(binaryTree5);
//        postOrderByStack(binaryTree5);
        levelOrder(binaryTree5);
    }

    //前序遍历 递归
    public static void preOrder(BinaryNode node){
        if (node != null) {
            System.out.println(node.element);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //前序遍历 非递归
    public static void preOrderByStack(BinaryNode node){
        Stack<BinaryNode> stack = new Stack<BinaryNode>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                System.out.println(node.element);
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()){
                BinaryNode node1 = stack.pop();
                node = node1.right;
            }
        }
    }

    //中序遍历 递归
    public static void midOrder(BinaryNode node){
        if (node != null) {
            midOrder(node.left);
            System.out.println(node.element);
            midOrder(node.right);
        }
    }

    //中序遍历 非递归
    public static void midOrderByStack(BinaryNode node){
        Stack<BinaryNode> stack = new Stack<BinaryNode>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()){
                BinaryNode node1 = stack.pop();
                System.out.println(node1.element);
                node = node1.right;
            }
        }
    }

    //后续遍历 递归
    public static void postOrder(BinaryNode node){
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.element);
        }
    }

    //后续遍历 非递归
    public static void postOrderByStack(BinaryNode node){
        Stack<BinaryNode> stack1 = new Stack<BinaryNode>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while (node != null || !stack1.empty()){
            while(node!=null){
                stack1.push(node);
                stack2.push(0);
                node = node.left;
            }
            while (!stack1.empty() && stack2.peek()==1){
                stack2.pop();
                System.out.println(stack1.pop().element);
            }
            if (!stack1.empty()){
                stack2.pop();
                stack2.push(1);
                BinaryNode node1 = stack1.peek();
                node = node1.right;
            }
        }
    }

    //层次遍历
    public static void levelOrder(BinaryNode node){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        if(node == null) return;
        queue.add(node);
        while(queue.size()!=0){
            BinaryNode node1 = queue.poll();
            System.out.println(node1.element);
            if (node1.left!=null)
                queue.add(node1.left);
            if (node1.right!=null)
                queue.add(node1.right);
        }
    }



    //数的深度 递归
    public int TreeDepth(BinaryNode pRoot) {
        if(pRoot == null){
            return 0;
        }
        int left = TreeDepth(pRoot.left);
        int right = TreeDepth(pRoot.right);
        return Math.max(left, right) + 1;
    }


    //树的深度 非递归
    public int TreeDepth1(BinaryNode pRoot)
    {
        if(pRoot == null){
            return 0;
        }
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(pRoot);
        int depth = 0, count = 0, nextCount = 1;
        while(queue.size()!=0){
            BinaryNode top = queue.poll();
            count++;
            if(top.left != null){
                queue.add(top.left);
            }
            if(top.right != null){
                queue.add(top.right);
            }
            if(count == nextCount){
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }


}
//二叉树 数据结构
class BinaryNode
{
    int element;
    BinaryNode left;
    BinaryNode right;
    BinaryNode(int element)
    {
        this(element, null, null);
    }

    BinaryNode(int element, BinaryNode lt, BinaryNode rt)
    {
        this.element = element;
        left = lt;
        right = rt;
    }

}

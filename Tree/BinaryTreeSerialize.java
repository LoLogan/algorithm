import javax.sound.midi.Soundbank;

/**
 * 序列化二叉树和反序列化
 *      前提：
 *          节点都是0-9之间的数字，且不重复
 */

public class BinaryTreeSerialize {


    static int index = -1;   //计数变量

    static String Serialize(BinaryNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.element + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    static BinaryNode Deserialize(String str) {
        index++;
        //int len = str.length();
        //if(index >= len){
        //    return null;
        // }
        String[] strr = str.split(",");
        BinaryNode node = null;
        if(!strr[index].equals("#")){
            node = new BinaryNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

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


        String s = Serialize(binaryTree5);
        System.out.println(s);


        BinaryNode binaryTreeTest = Deserialize(s);
        System.out.println(binaryTreeTest.element+","+binaryTreeTest.right.element);
    }
}


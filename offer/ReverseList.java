/**
 * 反转链表
 * 题目：定义一个函数，输入一个链表的头节点，反转该链表并输入反转后该链表的头节点
 */
public class ReverseList {

    public ListNode reverse(ListNode head){
        //如果输入的链表为空，就直接返回空
        if(head == null){
            return null;
        }

        //如果输入的链表只有一个节点，即：头节点。则直接返回该节点
        if(head.next == null){
            return head;
        }

        //定义反转后链表的头节点
        ListNode revHead = null;
        //当前节点
        ListNode curNode = head;

        while(curNode != null){
            ListNode tmpNode = curNode.next;        //记录下当前节点的下一个节点
            curNode.next = revHead;             //将当前节点的下一个节点反转指向反转链表的头节点
            revHead = curNode;
            curNode = tmpNode;
        }

        return revHead;
    }

    public static void main(String[] args) {
        ReverseList test = new ReverseList();

        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        ListNode temp5 = new ListNode();

        head.value = 1;
        temp1.value = 2;
        temp2.value = 3;
        temp3.value = 4;
        temp4.value = 5;
        temp5.value = 6;
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = null;

        System.out.println("反转前：");
        test.printList(head);
        System.out.println();
        //执行反转操作
        ListNode reverseHead = test.reverse(head);
        test.printList(reverseHead);

    }

    //打印列表
    public void printList(ListNode head){
        while(head != null){
            System.out.print(head.value + "  ");
            head = head.next;
        }
    }
}
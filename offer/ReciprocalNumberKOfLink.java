/**
 * 链表中倒数第k个节点
 */
public class ReciprocalNumberKOfLink {

    public static ListNode findKthToTail(ListNode listHead, int k){
        //参数校验(判断链表是否存在、k是否大于0)
        if(listHead == null || k <= 0){
            return null;
        }

        ListNode ahead = listHead;          //前面的指针

        //先让ahead向前走k-1步
        for(int i = 1; i <= k-1; i++){
            if(ahead.next != null){
                ahead = ahead.next;
            }else{                          //当链表的长度小于k时，则返回null
                return null;
            }
        }
        ListNode behind = listHead;         //后面的指针

        while(ahead.next != null){
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        ListNode temp5 = new ListNode();
        ListNode temp6 = new ListNode();

        head.value=1;
        temp1.value=2;
        temp2.value=3;
        temp3.value=4;
        temp4.value=5;
        temp5.value=6;
        temp6.value=7;
        head.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
        temp3.next=temp4;
        temp4.next=temp5;
        temp5.next=temp6;
        temp6.next=null;

        ListNode resultNode = findKthToTail(head, 2);
        if(resultNode != null){
            System.out.println(resultNode.value);
        }else{
            System.out.println("您输入的参数有误！");
        }
    }
}


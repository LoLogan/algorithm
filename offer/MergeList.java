/**
 * 合并两个排序的链表
 */
public class MergeList {

    // 使用递归的方式实现
    public ListNode merge(ListNode list1, ListNode list2) {
        /**
         * 如果输入的链表中只要有一个为null，就返回另一个
         */
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        // 合并后链表的头节点
        ListNode mergeHead = null;
        if (list1.value < list2.value) {
            mergeHead = list1;
            mergeHead.next = merge(list1.next, list2);
        } else {
            mergeHead = list2;
            mergeHead.next = merge(list1, list2.next);
        }
        return mergeHead;
    }

    // 使用循环实现
    public ListNode merge2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode mergeHead = null;
        if (list1.value < list2.value) {
            mergeHead = list1;
            list1 = list1.next;
        }
        else {
            mergeHead = list2;
            list2 = list2.next;
        }
        ListNode tmpNode = mergeHead;
        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                tmpNode.next = list1;
                list1 = list1.next;
            } else {
                tmpNode.next = list2;
                list2 = list2.next;
            }
            tmpNode = tmpNode.next;
        }

        if (list1 == null) {
            tmpNode.next = list2;
        } else {
            tmpNode.next = list1;
        }
        return mergeHead;
    }

}


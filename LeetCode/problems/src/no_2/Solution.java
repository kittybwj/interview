package no_2;

import java.util.Arrays;

/**
 * Created by kitty on 2019/1/25.
 * 两个链表相加
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int v1,v2,sum,value;
        int next = 0;
        ListNode newNode = null;//返回的最新链表的头节点
        ListNode curNode = null;//链表最后节点
        while(l1 != null || l2 != null){
            if(l1 == null && l2 != null){
                v1 = 0;
                v2 = l2.val;
                l2 = l2.next;
            }else if (l1 != null && l2 == null){
                v1 = l1.val;
                v2 = 0;
                l1 = l1.next;
            }else {
                v1 = l1.val;
                v2 = l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            sum = v1 + v2 + next;
            value = sum % 10 ;
            next = sum / 10;
            ListNode node = new ListNode(value);
            if(curNode != null){
                curNode.next = node;
            }else{
                newNode = node;
            }
            curNode = node;
        }
        if (next ==1){
            ListNode n = new ListNode(1);
            curNode.next = n;
        }
        return newNode;
    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        ListNode l1 = creator.creatListNode(Arrays.asList(2,4,5));
        creator.printLinkedList(l1);
        System.out.println();
        ListNode l2 = creator.creatListNode(Arrays.asList(5,6,5));
        creator.printLinkedList(l2);
        System.out.println();
        Solution solution = new Solution();
        ListNode res1 = solution.addTwoNumbers(l1,l2);
        creator.printLinkedList(res1);
        System.out.println();
        ListNode l3 = creator.creatListNode(Arrays.asList(1));
        creator.printLinkedList(l3);
        System.out.println();
        ListNode l4 = creator.creatListNode(Arrays.asList(9,9));
        creator.printLinkedList(l4);
        System.out.println();
        ListNode res2 = solution.addTwoNumbers(l3,l4);
        creator.printLinkedList(res2);
        System.out.println();
    }
}

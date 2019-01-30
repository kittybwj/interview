package no_2;

import java.util.List;

/**
 * Created by kitty on 2019/1/25.
 */
public class LinkedListCreator {
    public ListNode creatListNode(List<Integer> data){
        ListNode newHead = null;
        ListNode curHead = null;
        for (int i = 0; i < data.size(); i++) {
            ListNode node = new ListNode(data.get(i));
            if (curHead == null){
                newHead = node;
            }else {
                curHead.next = node;
            }
            curHead = node;
        }
        return newHead;
    }

    public void printLinkedList(ListNode listNode){
        while (listNode != null){
            System.out.print(listNode.val+" ");
            listNode = listNode.next;
        }
    }
}

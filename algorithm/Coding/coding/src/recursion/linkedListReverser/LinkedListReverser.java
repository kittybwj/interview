package recursion.linkedListReverser;

import recursion.linkedListCreator.LinkedListCreator;
import common.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 链表反转
 */
public class LinkedListReverser {
    public Node reverseLinkedList(Node head){
        //size == 0 or size == 1
        if (head == null || head.getNext() == null){
            return head;
        }
        Node newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    public static void main(String[] args) {
        LinkedListCreator linkedListCreator = new LinkedListCreator();
        LinkedListReverser linkedListReverser = new LinkedListReverser();
        //data为空
        Node.printLinkedList(linkedListReverser.reverseLinkedList(linkedListCreator.creatLinkedList(new ArrayList<>())));
        //data只有一个元素
        Node.printLinkedList(linkedListReverser.reverseLinkedList(linkedListCreator.creatLinkedList(Arrays.asList(1))));
        //data为普通情况
        Node.printLinkedList(linkedListReverser.reverseLinkedList(linkedListCreator.creatLinkedList(Arrays.asList(1,2,3,4,5))));

        //元素为1000000个(会Stack Overflow)
        linkedListReverser.reverseLinkedList(linkedListCreator.creatLargeLinkedList(1000000));
        System.out.println("done");
    }
}

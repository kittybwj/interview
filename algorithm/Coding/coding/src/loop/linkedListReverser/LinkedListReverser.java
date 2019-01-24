package loop.linkedListReverser;

import common.Node;
import recursion.linkedListCreator.LinkedListCreator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 用循环的方式实现链表反转
 */
public class LinkedListReverser {

    public Node reverserLinkedList(Node head){
        Node newHead = null;//已经反转的链表
        Node curHead = head;//未反转的链表
        while (curHead != null){
            Node next = curHead.getNext();
            curHead.setNext(newHead);
            newHead = curHead;
            curHead = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        LinkedListCreator linkedListCreator = new LinkedListCreator();
        LinkedListReverser linkedListReverser = new LinkedListReverser();
        //data为空
        Node.printLinkedList(linkedListReverser.reverserLinkedList(linkedListCreator.creatLinkedList(new ArrayList<>())));
        //data只有一个元素
        Node.printLinkedList(linkedListReverser.reverserLinkedList(linkedListCreator.creatLinkedList(Arrays.asList(1))));
        //data为普通情况
        Node.printLinkedList(linkedListReverser.reverserLinkedList(linkedListCreator.creatLinkedList(Arrays.asList(1,2,3,4,5))));

        //元素为1000000个
        linkedListReverser.reverserLinkedList(linkedListCreator.creatLargeLinkedList(1000000));
        System.out.println("done");
    }

}
